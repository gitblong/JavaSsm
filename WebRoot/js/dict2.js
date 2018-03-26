/**
 * jQuery EasyUI 1.3.2
 * 
 *翻译：qq 1364386878
 */
(function ($) {
    //创建工具条
    function buildToolbar(target) {
        var pagination = $.data(target, "pagination");
        var opts = pagination.options;
        var bb = pagination.bb = {};
        var tb = $(target).addClass("pagination").html("<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tr></tr></table>");
        var tr = tb.find("tr");

        function getpaginationbar(name) {
            var pagination = opts.nav[name];//获取按钮组
            
            var a = $("<a href=\"javascript:void(0)\"></a>").appendTo(tr);
            a.wrap("<td></td>");
            a.linkbutton({
                iconCls: pagination.iconCls,
                plain: true
            }).unbind(".pagination").bind("click.pagination", function () {
                pagination.handler.call(target);
            });
            return a;
        };
        if (opts.showPageList) {
            var ps = $("<select class=\"pagination-page-list\"></select>");
            ps.bind("change", function () {
                opts.pageSize = parseInt($(this).val());
                opts.onChangePageSize.call(target, opts.pageSize);
                _select(target, opts.pageNumber);
            });
            for (var i = 0; i < opts.pageList.length; i++) {
                $("<option></option>").text(opts.pageList[i]).appendTo(ps);
            }
            $("<td></td>").append(ps).appendTo(tr);
            $("<td><div class=\"pagination-btn-separator\"></div></td>").appendTo(tr);
        }
        bb.first = getpaginationbar("first");
        bb.prev = getpaginationbar("prev");
        $("<td><div class=\"pagination-btn-separator\"></div></td>").appendTo(tr);
        $("<span style=\"padding-left:6px;\"></span>").html(opts.beforePageText).appendTo(tr).wrap("<td></td>");
        bb.num = $("<input class=\"pagination-num\" type=\"text\" value=\"1\" size=\"2\">").appendTo(tr).wrap("<td></td>");
        bb.num.unbind(".pagination").bind("keydown.pagination",
           function (e) {
            if (e.keyCode == 13) {
                var page = parseInt($(this).val()) || 1;              
                _select(target, page);//选择一个新页面 page索引
                return false;
            }
        });
        bb.after = $("<span style=\"padding-right:6px;\"></span>").appendTo(tr).wrap("<td></td>");
        $("<td><div class=\"pagination-btn-separator\"></div></td>").appendTo(tr);
        bb.next = getpaginationbar("next");
        bb.last = getpaginationbar("last");
        if (opts.showRefresh) {
            $("<td><div class=\"pagination-btn-separator\"></div></td>").appendTo(tr);
            bb.refresh = getpaginationbar("refresh");
        }
        if (opts.buttons) {
            $("<td><div class=\"pagination-btn-separator\"></div></td>").appendTo(tr);
            for (var i = 0; i < opts.buttons.length; i++) {
                var btnopts = opts.buttons[i];
               
                if (btnopts == "-") {
                    $("<td><div class=\"pagination-btn-separator\"></div></td>").appendTo(tr);
                } else {
                    var td = $("<td></td>").appendTo(tr);
                    $("<a href=\"javascript:void(0)\"></a>").appendTo(td).linkbutton($.extend(btnopts, { plain: true })).bind("click", eval(btnopts.handler || function () {
                    }));
                }
            }
        }
        $("<div class=\"pagination-info\"></div>").appendTo(tb);
        $("<div style=\"clear:both;\"></div>").appendTo(tb);
    };
    //选择一个新页面
    function _select(target, page) {
        var opts = $.data(target, "pagination").options;
        var pageCount = Math.ceil(opts.total / opts.pageSize) || 1;
        opts.pageNumber = page;
        if (opts.pageNumber < 1) {
            opts.pageNumber = 1;
        }
        if (opts.pageNumber > pageCount) {
            opts.pageNumber = pageCount;
        }
        _refresh(target, { pageNumber: opts.pageNumber });
        opts.onSelectPage.call(target, opts.pageNumber, opts.pageSize);
    };
    //刷新并显示分页栏信息
    function _refresh(target, options) {
        var opts = $.data(target, "pagination").options;
        var bb = $.data(target, "pagination").bb;
       
        $.extend(opts, options || {});
        var ps = $(target).find("select.pagination-page-list");
        if (ps.length) {
            ps.val(opts.pageSize + "");
            opts.pageSize = parseInt(ps.val());
        }
        var pageCount = Math.ceil(opts.total / opts.pageSize) || 1;
        bb.num.val(opts.pageNumber);
        bb.after.html(opts.afterPageText.replace(/{pages}/, pageCount));
        var pinfo = opts.displayMsg;
        pinfo = pinfo.replace(/{from}/, opts.total == 0 ? 0 : opts.pageSize * (opts.pageNumber - 1) + 1);
        pinfo = pinfo.replace(/{to}/, Math.min(opts.pageSize * (opts.pageNumber), opts.total));
        pinfo = pinfo.replace(/{total}/, opts.total);
        $(target).find("div.pagination-info").html(pinfo);
        bb.first.add(bb.prev).linkbutton({ disabled: (opts.pageNumber == 1) });
        bb.next.add(bb.last).linkbutton({ disabled: (opts.pageNumber == pageCount) });
        _loading(target, opts.loading);
    };
    //提醒分页控件正在加载中
    function _loading(target, Msg) {
        var opts = $.data(target, "pagination").options;
        var bb = $.data(target, "pagination").bb;
        opts.loading = Msg;
        if (opts.showRefresh) {
            if (opts.loading) {
                bb.refresh.linkbutton({ iconCls: "pagination-loading" });
            } else {
                bb.refresh.linkbutton({ iconCls: "pagination-load" });
            }
        }
    };
    //实例化
    $.fn.pagination = function (options, param) {
        if (typeof options == "string") {
            return $.fn.pagination.methods[options](this, param);
        }
        options = options || {};
        return this.each(function () {
            var opts;
            var state = $.data(this, "pagination");
            if (state) {
                opts = $.extend(state.options, options);
            } else {
                opts = $.extend({}, $.fn.pagination.defaults, $.fn.pagination.parseOptions(this), options);
                $.data(this, "pagination", { options: opts });
            }
            buildToolbar(this);
            _refresh(this);
        });
    };
    //默认方法
    $.fn.pagination.methods = {
        //返回参数对象
        options: function (jq) {
            return $.data(jq[0], "pagination").options;
        },
        //提醒分页控件正在加载中
        loading: function (jq) {
            return jq.each(function () {
                _loading(this, true);
            });
        },
        //提醒分页控件加载完成
        loaded: function (jq) {
            return jq.each(function () {
                _loading(this, false);
            });
        },
        //刷新并显示分页栏信息
        refresh: function (jq, options) {
            return jq.each(function () {
                _refresh(this, options);
            });
        },
        //选择一个新页面，页面索引从1开始
        select: function (jq, page) {
            return jq.each(function () {
                _select(this, page);
            });
        }
    };
    //解析器配置
    $.fn.pagination.parseOptions = function (target) {
        var t = $(target);
        return $.extend({}, $.parser.parseOptions(target, [{ total: "number", pageSize: "number", pageNumber: "number" },
            { loading: "boolean", showPageList: "boolean", showRefresh: "boolean" }]),
            { pageList: (t.attr("pageList") ? eval(t.attr("pageList")) : undefined) });
    };
    //默认属性 事件
    $.fn.pagination.defaults = {
        total: 1,//总记录数，在分页控件创建时初始的值
        pageSize: 10,//页面大小
        pageNumber: 1,//在分页控件创建的时候显示的页数
        pageList: [10, 20, 30, 50],//用户可以改变页面大小。pageList属性定义了页面导航展示的页码
        loading: false,//定义数据是否正在载入
        //自定义按钮，每个按钮都有2个属性：
        //iconCls：显示背景图片的CSS类ID  handler：当按钮被点击时调用的一个句柄函数
        buttons: null,        
        showPageList: true,//定义是否显示页面导航列表
        showRefresh: true,//定义是否显示刷新按钮
        //用户选择一个新页面的时候触发。回调函数包含2个参数：
        //pageNumber：新的页数。      pageSize: 页面大小（每页显示的条数）。 
        onSelectPage: function (pageNumber, pageSize) {
        },
        //在点击刷新按钮刷新之前触发，返回false可以取消刷新动作
        onBeforeRefresh: function (pageNumber, pageSize) {
        },
        //刷新之后触发
        onRefresh: function (pageNumber, pageSize) {
        },
        //在页面更改页面大小的时候触发
        onChangePageSize: function (pageSize) {
        },
        //定义是否显示刷新按钮
        beforePageText: "Page",
        //定义是否显示刷新按钮
        afterPageText: "of {pages}",
        //显示页面信息
        displayMsg: "Displaying {from} to {to} of {total} items", nav: {
            first: {
                iconCls: "pagination-first", handler: function () {
                    var opts = $(this).pagination("options");
                    if (opts.pageNumber > 1) {
                        $(this).pagination("select", 1);
                    }
                }
            },

            prev: {
                iconCls: "pagination-prev", handler: function () {
                    var opts = $(this).pagination("options");
                    if (opts.pageNumber > 1) {
                        $(this).pagination("select", opts.pageNumber - 1);
                    }
                }
            },

            next: {
                iconCls: "pagination-next", handler: function () {
                    var opts = $(this).pagination("options");
                    var pageCount = Math.ceil(opts.total / opts.pageSize);
                    if (opts.pageNumber < pageCount) {
                        $(this).pagination("select", opts.pageNumber + 1);
                    }
                }
            },

            last: {
                iconCls: "pagination-last", handler: function () {
                    var opts = $(this).pagination("options");
                    var pageCount = Math.ceil(opts.total / opts.pageSize);
                    if (opts.pageNumber < pageCount) {
                        $(this).pagination("select", pageCount);
                    }
                }
            },

            refresh: {
                iconCls: "pagination-refresh", handler: function () {
                    var opts = $(this).pagination("options");
                    if (opts.onBeforeRefresh.call(this, opts.pageNumber, opts.pageSize) != false) {
                        $(this).pagination("select", opts.pageNumber);
                        opts.onRefresh.call(this, opts.pageNumber, opts.pageSize);
                    }
                }
            }
        }
    };
})(jQuery);