<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html lang="en">
<head>
<title>登陆</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.4.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.4.4/themes/icon.css">
<script type="text/javascript"
	src="../js/jquery-easyui-1.4.4/jquery.min.js">
	</script>
<script type="text/javascript"
	src="../js/jquery-easyui-1.4.4/jquery.easyui.min.js">
	 </script>
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.4.4/demo/demo.css">
<script>
	function clearForm() {
		$('#ff').form('clear');
	}
</script>
</head>

<body>
		<!-- <div id="win" class="easyui-window" title="登陆" style="width:400px;height:300px;"> -->
		<div class="easyui-panel" title="用户登录" 
			style="padding:15px 50px;height:150px;">
			<form id="ff" method="post">
				<table cellpadding="5">
					<tr>
						<td>账户:</td>
						<td><input class="easyui-textbox" type="text" name="name"
							data-options="required:true"></input></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input class="easyui-textbox" type="password"
							name="email" data-options="required:true,validType:'email'"></input></td>
					</tr>
				</table>
				<div style="padding:5px;text-align:center;">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						icon="icon-ok" onclick="checkLogin()">登录</a> <a
						href="javascript:void(0)" class="easyui-linkbutton"
						icon="icon-cancel" onclick="clearForm()">重置</a>
				</div>
			</form>
		</div>
</body>
</html>