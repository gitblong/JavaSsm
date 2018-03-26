<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta charset="utf-8" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/js/jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/js/jquery-easyui-1.2.6/themes/icon.css">
<script type="text/javascript"
	src="<%=basePath%>/js/jquery-easyui-1.2.6/jquery-1.7.2.min.js">
	</script>
<script type="text/javascript"
	src="<%=basePath%>/js/jquery-easyui-1.2.6/jquery.easyui.min.js">
	 </script>
<base href="<%=basePath%>">
</head>
  
  <body>
    
    <div id="win" class="easyui-window" title="修改失败"
		style="width:300px;height:180px;">
		<h2>登入失败请检查原密码是否正确，新密码和确认密码是否一致 </h2>

	</div>
  </body>
</html>
