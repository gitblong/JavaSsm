<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
 	String ids = (String)request.getSession().getAttribute("ids");
	if(ids!=null){
		if(!ids.contains("6")){
			response.sendRedirect(basePath);
			return;
		}
	}else{
			response.sendRedirect(basePath);
			return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="zh">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>/js/jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>/js/jquery-easyui-1.2.6/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>/js/jquery-easyui-1.2.6/demo/demo.css">
	<link rel="stylesheet" type="text/css"
	href="<%=basePath %>/css/04.css">	
</head>
<body>
	<table id="distinct-main"></table>
<div id="distinct-dlg"  class="easyui-dialog"  style="width: 400px; height: 200px; padding: 10px 20px;"
        closed="true" buttons="#distinct-dlg-buttons"> 
       <form id="distinct-fm" method="post"> 
       <fieldset > 
       <legend>分区</legend>
           <div class="fitem" > 
           <label>分区名称 </label> 
           <input name="zoneName" id="addZoneName"class="easyui-text" required="false" /> 
       </div> 
       <br/>
        <div class="fitem" > 
           <label>所属地 </label> 
           <input name="area" id="addArea" class="easyui-text" required="false" /> 
       </div> 
       <br/>
       </fieldset>         
       <input type="hidden" name="action" id="hidtype" /> 
       </form> 
   </div> 

<div id="distinct-dlg-buttons"> 
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveuser()" iconcls="icon-ok">添加</a> 
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#distinct-dlg').dialog('close')"
          iconcls="icon-cancel"  >取消</a> 
    </div> 
    
    <div id="editdistinct-dlg"  class="easyui-dialog"  style="width: 400px; height: 250px; padding: 10px 20px;"
        closed="true" buttons="#editdistinct-dlg-buttons"> 
        <div class="ftitle">分区管理</div>
       <form id="editdistinct-fm" method="post"> 
            <div class="fitem">
			<label>分区名称</label>
			 <input id="editZoneName" name="zoneName" class="easyui-text" required="false" />
			</div>
			 <br />  
			 <div class="fitem">   
			 <label>所属地 </label>
			 <input id="editArea" name="area" class="easyui-text" required="false" />
			</div>
			<br />    
       <input type="hidden" name="zoneId" id="zoneId" /> 
       </form> 
   </div> 
   
   <div id="editdistinct-dlg-buttons"> 
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateuser()" iconcls="icon-ok">更新</a> 
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#editdistinct-dlg').dialog('close')"
          iconcls="icon-cancel"  >取消</a> 
    </div> 
<script type="text/javascript"
	src="<%=basePath %>/js/jquery-easyui-1.2.6/jquery-1.7.2.min.js">
	</script>
<script type="text/javascript"
	src="<%=basePath %>/js/jquery-easyui-1.2.6/jquery.easyui.min.js">
	 </script>
 <script type="text/javascript"
	src="<%=basePath %>/js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js">
	 </script>
<script type="text/javascript">
function fixWidth(percent) {
			return document.body.clientWidth * percent; //这里你可以自己做调整    
		}
      window.onresize = function() {
			$('#distinct-main').datagrid('resize', {
				width : $(window).width() - 40,
				height : 800
			})
		}
      $(function() {
			$('#distinct-main').datagrid({
				iconCls : 'icon-save',
				/* 	width:700,
					height:350, */
				width : $(window).width() - 40,
				height : $(window).height() - 40,
				fitColumns: true,
				nowrap : false,
				striped : true,
				collapsible : true,
				url : '<%=basePath%>population/zoneInfo',
				sortOrder : 'desc',
				remoteSort : false,
				frozenColumns : [ [
					{
						field : 'zoneName',
						title : '分区名称',
						width : fixWidth(0.1),
						sortable : true
					},
					{
						field : 'area',
						title : '所属地',
						width : fixWidth(0.1),
						align : 'left'
					}
				] ],
				columns : [ [
					
					{
						field : 'opt',
						title : '操作',
						width : fixWidth(0.2),
						align : 'left',
						formatter : formatOper
					}
	
				] ],
				pagination : true,
				rownumbers : true,
				toolbar : [ {
					id : 'btnadd',
					text : '添加',
					iconCls : 'icon-add', //弹出框图标
					handler : function() {
						newuser();
					}
				} ]
			});
			var p = $('#distinct-main').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh : function() {
					/* alert('before refresh'); */
				}
			});
		});
		function formatOper(value, row, index) {
			var e = '<a href="#" onclick="editrow(' + index + ')">编辑 |</a> ';
			var d = '<a href="#" onclick="deleterow(' + index + ')">删除</a>';
			return e + d;
		}
        var url;
        var type;
        function newuser() {
            $("#distinct-dlg").dialog("open").dialog('setTitle', '添加'); ;
            $("#distinct-fm").form("clear");
            //document.getElementById("hidtype").value="submit";
        }   
        function saveuser() {
            $("#distinct-fm").form("submit", {
                url: '<%=basePath%>population/addZone',
                onsubmit: function () {
                    return $(this).form("validate");
                },
                success: function (result) {
                    if (result == "1") {
                        $.messager.alert("提示信息", "操作成功");
                        $("#distinct-dlg").dialog("close");
                        $("#distinct-main").datagrid("load");
                    }
                    else {
                        $.messager.alert("提示信息", "操作失败");
                    }
                }
            });
        }
        function deleterow(index) {
            var row = $('#distinct-main').datagrid('getSelected');
                $.messager.confirm('确认', '确认删除?', function (row) {
                   if (row) {
					var selectedRow = $('#distinct-main').datagrid('getSelected'); //获取选中行
					$.ajax({
						url : '<%=basePath%>population/deleteZone?id=' + selectedRow.id + '&type=stu',
						//加了个type，作用是以后不管什么删除，都可以转到这个ashx中处理
						success : function() {
							alert('删除成功');
							$('#distinct-main').datagrid('reload');
						}
					});
					$('#distinct-main').datagrid('deleteRow', index);
				 }
                });
            } 

       function editrow(index) {
            $('#distinct-main').datagrid('selectRow', index);
            var row = $("#distinct-main").datagrid("getSelected");
            document.getElementById('zoneId').value = row.id;
            
            if (row) {
                $("#editdistinct-fm").form("clear");
                $("#editdistinct-dlg").dialog("open").dialog('setTitle', '分区');
             $.ajax({
					url : '<%=basePath%>population/updateGetZone?id=' + row.id + '&type=stu',
					//加了个type，作用是以后不管什么删除，都可以转到这个ashx中处理
					dataType : 'json',
					success : function(zone) {
						//返回的数据在assistant中  
						  document.getElementById("editZoneName").value=zone.zoneName;
						  document.getElementById("editArea").value=zone.area;
						  document.getElementById('zoneId').value = zone.zoneId;
					}
				});
             }
         }
         function updateuser(){
         $("#editdistinct-fm").form("submit", {
				url : '<%=basePath%>population/updateZone',
				onsubmit : function() {
					return $(this).form("validate");
				},
				success : function(result) {
					if (result == "1") {
						$.messager.alert("提示信息", "操作成功");
						$("#editdistinct-dlg").dialog("close");
						$('#distinct-main').datagrid('reload');
					}
					else {
						$.messager.alert("提示信息", "操作失败");
					}
				}
			});
         }


    </script>

</body>
</html>