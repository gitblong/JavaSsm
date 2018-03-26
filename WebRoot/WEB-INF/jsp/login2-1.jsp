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
<meta charset="utf-8" />
<link href="<%=basePath%>/css/login.css" rel="stylesheet"
	type="text/css" />
<script src="<%=basePath %>js/jquery-easyui-1.2.6/jquery-1.7.2.min.js">
	</script>
<script src="<%=basePath %>js/jquery-easyui-1.2.6/jquery.easyui.min.js">
	 </script>
<script src="<%=basePath %>/js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js">
	 </script>
<script type="text/javascript">
	$(function() {
		$("#login").click(function() {
			$("#loginForm").submit();
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#reset").click(function() {
			$("#loginForm").submit();
		});
	});
</script>
</head>

<body>
	<div class="main">
		<ul class="container">
			<ul class="login">
				<li class="topA"><span class="title"> <img
						src="<%=basePath%>image/pop-1.png" />
				</span></li>
				<li class="topB"><span class="title"> <img
						src="<%=basePath%>image/pop-4.png" />
				</span></li>
				<li class="topC"><span class="title"> <img
						src="<%=basePath%>image/pop-6.jpg" />
				</span></li>
				<li class="login-main">
					<ul class="loginA">
						<span><img src="<%=basePath%>image/pop-5.png" alt="" /></span>
					</ul>
					<form id="loginForm" action="login" class="loginB2" method="post">
						<ul class="loginB2-top">
							<li><span class="left">用户名：</span> <span style=""> <input
									id="userName" name="userName" type="text" class="txt"/>
							</span></li>							
						</ul>
						<ul class="usernull">${userNull }</ul>
						<ul class="loginB2-bottom">
							<li><span class="left">密&nbsp;码：</span> <span style="">
									<input id="password" name="password" type="password"
									class="txt"  />
							</span></li>							
						</ul>
						<ul class="usernull psfail">${pswFail }</ul>
						<br/>
						<li class="login-btn">
							<button class="btn" type="submit" id="login">登录</button>
							<button class="btn" type="submit" style="margin-left:30px">重置</button>
						</li>
					</form>
				</li>
			</ul>
		</ul>
	</div>
</body>
</html>