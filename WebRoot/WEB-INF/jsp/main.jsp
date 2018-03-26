<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("UTF-8");
%>
<%-- <%
	if(session.getAttribute("currentUser")==null){
		response.sendRedirect("login.jsp");
		return;
	}
%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/js/tree_themes/SimpleTree.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/main.css" />	
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/noContextMenu.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/tabs.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/SimpleTree.js"></script>

<script type="text/javascript">

	$(function() {
		//初始化树形菜单
		$(".st_tree").SimpleTree({
			click : function(a) {
				if (!$(a).attr("hasChild")) {
					var title = $(a).text();
					var url = $(a).attr("rel");
					var icon = $(a).attr("icon");
					parent.OpenTab(title, url, icon);
				}
			}
		});
	});
	$(function() {
		/*为选项卡绑定右键*/
		$(".tabs li").live('contextmenu', function(e) {

			/* 选中当前触发事件的选项卡 */
			var subtitle = $(this).text();
			$('#tabs').tabs('select', subtitle);

			//显示快捷菜单
			$('#menu').menu('show', {
				left : e.pageX,
				top : e.pageY
			});

			return false;
		});
	});
</script>
</head>

<body class="easyui-layout">
	<div region="north" style="height:80px;background-color:#E0EEEE">
		<h1 class="title-top">人口流动管理系统</h1>
		<div class="logout">
            你好，${user.userName}  | <a href="<%=basePath%>">退出</a>  
            </div>
	</div>

	<div region="west" split="true" title="菜单导航" style="width:200px;">
		<div class="easyui-accordion" style="width:193px;height:300px;">
			<!-- <div class="st_tree" title="系统设置">
					<ul>
						<li><a href="#" 
						rel="role">角色权限</a></li>
						<li><a href="#"
							rel="accountManger">账户管理</a></li>
						<li><a href="#" 
						rel="password">修改密码</a></li>
					</ul>
				</div>
				<div class="st_tree" title="流动人口">
					<ul>
						<li><a href="#" 
						rel="landlord">房东账号管理</a></li>
						<li><a href="#"
							rel="tenant">房客信息</a></li>
						<li><a href="#" 
						rel="distinctManager">分区管理</a></li>
						<li><a href="#" 
						rel="assistantManager">协管员账号</a></li>
					</ul>
				</div>
				<div class="st_tree" title="申报统计">
					<ul>
						<li><a href="#" 
						rel="apply">申报统计</a></li>						
					</ul>
				</div> -->
			
		<c:forEach var="authorityMenuTitle" items="${authMenuList}">
			<div class="st_tree" title="${authorityMenuTitle.menuName }">
				<ul>
					<c:forEach var="authorityMessage" items="${authorityMenuTitle.authMsgList}">
						<li><a href="#" rel="${authorityMessage.authorityUrl}">${authorityMessage.authorityName}</a></li>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>
			</div>
		</div>


	<div region="center">		
	<div id="menu" class="easyui-menu" style="width:150px;">
		<div id="m-refresh">刷新</div>
		<div class="menu-sep"></div>
		<div id="m-closeall">全部关闭</div>
		<div id="m-closeother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="m-close">关闭</div>
	</div>
	<div id="tabs" class="easyui-tabs" fit="true" border="false">
		</div>
	</div>
 	<div region="south" style="height:20px;background-color:#E0EEEE">
 	    <h1 class="title-bottom">  浙江省金华市婺城区人口流动系统</h1>
		</div>

</body>
</html>
