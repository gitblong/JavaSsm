<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="zh">
<head>
<title>Login</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.2.6/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.2.6/demo/demo.css"> 
<script type="text/javascript"
	src="../js/jquery-easyui-1.2.6/jquery-1.7.2.min.js">
	</script>
<script type="text/javascript"
	src="../js/jquery-easyui-1.2.6/jquery.easyui.min.js">
		</script>
 <script type="text/javascript"
	src="../js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js">
	 </script>
       <script>
		$(function(){
			$('#test').datagrid({
				iconCls:'icon-save',
			/* 	width:700,
				height:350, */
		     	width: $(window).width() - 10,
				height: $(window).height() - 35, 			
				fit: false,
				nowrap: false,
				striped: true,
				collapsible:true,
				url:'../data/datagrid_data2.json',
				sortName: 'code',
				sortOrder: 'desc',
				remoteSort: false,
				idField:'code',
				frozenColumns:[[
	                {title:'角色名称',field:'code',width:$(window).width() - 180,sortable:true}
				]],
				columns:[[
					{field:'opt',title:'操作',width:100,align:'center',formatter:formatOper }	
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'添加角色',
					iconCls:'icon-add',  //弹出框图标
/* 					onclik:"javascript:$('#btnadd').dialog()",
					onclick:"javascript:alert('Add')", */
 /* 					handler:function(){
						$('#btnsave').linkbutton('enable');
						//  alert('add'); 
						$('#btnadd').dialog({
            title: '添加账户',
            width: 400,
            height: 300,
             toolbar:[{
           text:'text',
           iconCls:'icon-xxx',
           handler:function(){            
          }
       },{

       }],
       onOpen:function()
       {

       }
        });   */
        	handler:function(){
						$('#btnsave').linkbutton('enable');
						  alert('add'); 	
     /*    handler:function(){
						$('#btnsave').linkbutton('enable');	
						$('#btnadd').window({
				title: '添加角色',
				width: 600,
				height: 600,
				modal: true,
				shadow: false,
				closed: false,
			
			});	 */		
					}	 
				}]
			});
			var p = $('#test').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh:function(){
					alert('before refresh');
				}
			});
		});
		function formatOper(value,row,index){
                    var c = '<a href="#" onclick="checkrow('+index+')">查询</a> ';		
                    var e = '<a href="#" onclick="editrow('+index+')">编辑</a> ';
                    var d = '<a href="#" onclick="deleterow('+index+')">删除</a>';
                    return c+e+d;
                }

		/* function resize(){
			$('#test').datagrid('resize', {
				width:700,
				height:400
			});
		} */
 
	  $(function () {
        $(window).resize(function () {
            $('#List').datagrid('resize', {
                width: $(window).width() - 10,
                height: $(window).height() - 35
            }).datagrid('resize', {
                width: $(window).width() - 10,
                height: $(window).height() - 35
            });
        });
  /*       var form = $win.find("form");
		$("#btnadd").clik(function(){
            $win.window('open');
            form.form('clear');
		form.url='dictAction.do?action=addDict';
            });  */
    });
	</script>

</head>
<body>
	<table id="test"></table>
</body>
</html>