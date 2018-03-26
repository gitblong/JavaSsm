<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
<html lang="en">
<head>
<title>Login</title>
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
<!--  <script type="text/javascript"
	src="../js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"> -->
	 </script> 
	 <script>
		function loadLocal(){
			$('#ff').form('load',{
				name:'myname',
				email:'mymail@gmail.com',
				subject:'subject',
				message:'message',
				language:'en'
			});
		}
		function loadRemote(){
			$('#ff').form('load', 'form_data1.json');
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</head>  
<body>  

    <div class="easyui-panel" title="修改密码" style="width:100%;max-width:400px;padding:30px 60px;">
        <form id="ff" method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>原密码:</td>
	    			<td><input class="easyui-textbox" type="password" name="name" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>新密码:</td>
	    			<td><input class="easyui-textbox" type="password" name="email" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>确认新密码:</td>
	    			<td><input class="easyui-textbox" type="password" name="subject" data-options="required:true"></input></td>
	    		</tr>		    		    			    		
	    	</table>
	    	<div style="padding:5px;text-align:center;">
			 <a href="javascript:void(0)" class="easyui-linkbutton"  icon="icon-ok" onclick="saveForm()">保存</a>			
		    <a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-cancel" onclick="clearForm()">重置</a>
	</div>
	    </form>
    </div>
    
 </body>
</html>