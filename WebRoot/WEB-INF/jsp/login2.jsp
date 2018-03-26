<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=basePath %>css/login2.css" rel="stylesheet" type="text/css" />
<title>用户登录</title>
<script type="text/javascript">
	$(function() {
		$("#login").click(function() {
			$("#loginForm").submit();
		});
	});

</script>
</head>
<body>
<form id="loginForm" name="form" action="login" method="post">
	<div class="main">
		<ul>
			<li class="topA">
			<ul>
			<li>
			<span class="title">
			<!-- 人口流动管理系统 -->
			<img src="<%=basePath%>images2/login/welcome.png" alt="" style="margin-left:400px;margin-top:40px;"/>
			</span>
			</li>
			</ul>    
			<li class="topB">
			</li>
			<li class="topC">
		    <img src="<%=basePath%>images2/login/liudong.jpg" alt="" style="margin-left:80px;" />
			<li class="topD">
			<li class="topE">
			<ul class="login">
			    <ul>
				<li>
				<span class="left left2">用户名：</span> 
				<span style=""> <input id="userName" name="userName" type="text" class="txt" value="${userName }" /> 
				</span>
				</li>
				</ul>
				<ul class="usernull">${userNull }</ul>
				
				<ul>
				<li>
				<span class="left left2">密&nbsp;码：</span>
				 <span style=""> <input id="password" name="password" type="password" class="txt" value="${password }" onkeydown= "if(event.keyCode==13)form.submit()"/> 
				 </span>
				 </li>
				 </ul>
				 <ul class="usernull psfail">${pswFail }</ul>
				 <br/>
				 
				<li>
				<button class="btn" id="login" type="submit">登录 </button>
				<button class="btn btn-reset" type="reset">重置 </button>				
				</li>
				
			</ul>
			</li>
			<li class="topF">
			<li class="topG">		
		</ul>
	</div>
</form>
</body>
</html>