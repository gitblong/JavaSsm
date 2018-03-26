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
<meta charset="utf-8" />
<title>Login</title>
<link href="../css/01.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="container">
		<div id="login">
			<div class="loginBox">
				<h1>登录</h1>
				<form method="post">
					<div class="login_cont">
						<input type="username" required="required" placeholder="用户名"
							name="u" /> <input type="password" required="required"
							placeholder="密码" name="p" />
						<div class="login_btn">
							<button class="button" type="submit">登录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
  