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
		if(!ids.contains("2")){
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
	href="<%=basePath%>/js/jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/js/jquery-easyui-1.2.6/themes/icon.css">
<link rel="stylesheet" type="text/css"
	ref="<%=basePath%>/js/jquery-easyui-1.2.6/demo/demo.css">
<link href="<%=basePath%>/css/04.css" rel="stylesheet" type="text/css" />


</head>
<body style="margin:20px;">
	<table id="account-main" style="width:100%;"></table>
	<div id="account-dlg" class="easyui-dialog"
		style="width: 400px; height: 300px; padding: 10px 20px;" closed="true"
		buttons="#account-dlg-buttons">
		<div class="ftitle">添加账户</div>
		<form id="account-fm" method="post">
			<div class="fitem">
				<label>账号 </label> <input name="userName" class="easyui-text"
					required="false" />
			</div>
			<br />
			<div class="fitem">
				<label>密码 </label> <input type="password" name="password" class="easyui-text"
					required="false" />
			</div>
			<br />

			<div class="fitem">
				<label>角色</label> <select id="cc" name="roleName"
					class="easyui-combobox" style="width:140px;">
					<option>系统管理员</option>
					<option>普通用户</option>
					<option>派出所</option>
					<option>房东</option>
					<option>协管员</option>
				</select>
			</div>
			<input type="hidden" name="action" id="hidtype" />
			 <input type="hidden" name="ID" id="Nameid" />
		</form>
	</div>

	<div id="account-dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="saveuser()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#account-dlg').dialog('close')" iconcls="icon-cancel">取消</a>
	</div>
 <script type="text/javascript"
	src="<%=basePath%>/js/jquery-easyui-1.2.6/jquery-1.7.2.min.js">
	</script>
<script type="text/javascript"
	src="<%=basePath%>/js/jquery-easyui-1.2.6/jquery.easyui.min.js">
		</script>
<script type="text/javascript"
	src="<%=basePath%>/js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js">
	 </script>
	<script type="text/javascript">
	function fixWidth(percent) {
	return document.body.clientWidth * percent; //这里你可以自己做调整    
}
function fixHeight(percent) {
	return document.body.clientHeight * percent; //这里你可以自己做调整    
}
		
window.onresize=function() {
	$('#account-main').datagrid('resize', {
		width : fixWidth(0.98),
		height:	800		
})
} 
	$(function() {
			$('#account-main').datagrid({
				iconCls : 'icon-save',
				/* 	width:700,
					height:350, */
				width : $(window).width() - 30,
				height : $(window).height() - 40,
				fitColumns:true,
				nowrap : false,
				striped : true,
				collapsible : true,
				singleselect:true,
				url : '<%=basePath%>main/pageAccInfoData',
				sortOrder : 'desc',
				remoteSort : false,
				frozenColumns : [ [
					{
						title : '账户',
						field : 'userName',
						width : fixWidth(0.3),
						sortable : true
					}
					]],
				columns:[[
				    {
						title : '角色',
						field : 'roleName',
						width : fixWidth(0.65)
					}			
				] ],
				pagination : true,
				rownumbers : true,
				toolbar : [ 
			 {
				id : 'btnadd',
				text:'添加账户',
				iconCls : 'icon-add', //弹出框图标				
				handler : function() {
				newuser();					
				}
			},
			{
			id:'btndelete',
			text:'删除账户',
			iconCls: 'icon-remove',
            handler: function(){
            destroyUser();
			}
			}]
		});
			var p = $('#account-main').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh : function() {
					/* alert('before refresh'); */
				}
			});
		});
		
		
		var url;
		var type;
		function newuser() {
			$("#account-dlg").dialog("open").dialog('setTitle', '添加账户');
			$("#account-fm").form("clear");
			url = "<%=basePath %>main/addUser";
		document.getElementById("hidtype").value = "submit";
		}
		function saveuser() {
			$("#account-fm").form("submit", {
				url : url,
				onsubmit : function() {
					if ($("#roleName").combobox("getValue") == "") {
						$.messager.alert("系统提示", "请选择用户角色！");
						return false;
					}
					return $(this).form("validate");
				},
				success : function(result) {
					if (result == "1") {
						$.messager.alert("提示信息", "操作成功");
						$("#account-dlg").dialog("close");
						$("#account-main").datagrid("load");
					}
					else {
						$.messager.alert("提示信息", "操作失败");
					}
				}
			});
		}
		function destroyUser() {
			var row = $('#account-main').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认', '你确定删除这个用户吗?', function(r) {
					if (r) {
						$.post('<%=basePath%>main/delUser', {
							id : row.id
						}, function(result) {
							if (result.success) {
	
								/* $.messager.show({ // show error message  
									title : 'Success',
									msg : result.message
								}); */
								$('#account-main').datagrid('reload'); // reload the user data  
							}
							else {
								$.messager.show({ // show error message  
									title : 'Error',
									msg : result.message
								});
							}
						}, 'json');
					}
				});
			}
		}
	</script>

</body>
</html>