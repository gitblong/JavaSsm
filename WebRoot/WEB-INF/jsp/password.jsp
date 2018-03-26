<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("UTF-8");
%>

<%
 	String ids = (String)request.getSession().getAttribute("ids");
	if(ids!=null){
		if(!ids.contains("3")){
			response.sendRedirect(basePath);
			return;
		}
	}else{
			response.sendRedirect(basePath);
			return;
	}
%>
<html lang="zh">
<head>
<title>Login</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.4.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.4.4/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.4.4/demo/demo.css">
	<script type="text/javascript"
	src="../js/jquery-easyui-1.4.4/jquery.min.js">
	</script>
<script type="text/javascript"
	src="../js/jquery-easyui-1.4.4/jquery.easyui.min.js">
	 </script>
<script type="text/javascript"
	src="../js/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>

<script>
	function loadLocal() {
		$('#ff').form('load', {
/* 			name : 'myname',
			email : 'mymail@gmail.com',
			subject : 'subject',
			message : 'message', */
			language : 'zh'
		});
	}
	function loadRemote() {
		$('#ff').form('load', 'form_data1.json');
	}
	function clearForm() {
		$('#changePassowrdForm').form('clear');
	}

	$(function() {
		$("#change").click(function() {
			$("#changePassowrdForm").submit();
		});
		$("#reset").click(function() {
			$("#changePassowrdForm").reset();
		});
	});
</script>
</head>
<body>

	<div class="easyui-panel" title="修改密码"
		style="width:100%;max-width:400px;padding:30px 60px;">
		<form action="<%=basePath%>main/changePassword"
			id="changePassowrdForm" method="post">
			<table cellpadding="5">
				<tr>
					<td>原密码:</td>
					<td><input class="easyui-textbox" type="password"
						name="originalPassword" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td colspan="2"><span color="red">${oriPswFail}</span></td>
				</tr>
				<tr>
					<td>新密码:</td>
					<td><input class="easyui-textbox" type="password"
						name="newPassword" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td>确认新密码:</td>
					<td><input class="easyui-textbox" type="password"
						name="confirmPassword" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td colspan="2"><span color="red">${comPswFail}</span></td>
				</tr>
			</table>
			<div style="padding:5px;text-align:center;">
				<a class="easyui-linkbutton" icon="icon-ok" id="change">保存</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					icon="icon-cancel" onclick="clearForm()">重置</a>
			</div>
		</form>
	</div>

</body>
</html>