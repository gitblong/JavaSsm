 $('#fm').form('submit', {  
            url: 'ShowMember.ashx',//调用的一般处理程序  
            onSubmit: function () {  
  
            },  
            dataType: "json",  
            success: function (data) {//返回的数据在data中  
                var NowLivecountry = eval("(" + data + ")").NowLivecountry//json为接收的后台返回的数据，拿出我存放界面上值得字段；  
  
                var list = NowLivecountry.split('/');//把数据给拆分并放到list里面  
                 
                 
                //获取input所在div的对象  
                var ob = document.getElementById("div1");  
  
                //获取div中所用的IUPUT控件集合  
                var col = div1.getElementsByTagName("INPUT");  
  
                var str = "";  
                var count = 0;  
                //通过页面上的循环获取的值与后台传送过来放到list中的数据一一比对，如果和界面的内容一致的就可以选择，让其打上对勾  
                for (var obj in list) {  
                    for (i = 0; i < col.length; i++) {//界面上input中的值  
  
                        for (j = 0; j <= list.length; j++)//list中的值  
                        {  
  
                            if (col[i].value == list[j])//比较是否内容相等，如果一致就在界面上打上对勾  
                            {  
                                col[i].checked = true//是combox选中，打上对勾  
  
                            }  
                        }  
                    }  
  
  
  
                }  
            }  
        });