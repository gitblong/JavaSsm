<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="../js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../js/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="../js/tree_themes/SimpleTree.css" />
<link rel="stylesheet" type="text/css"
	href="../css/05.css" />	
<script type="text/javascript" src="../js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="../js/noContextMenu.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/tabs.js"></script>
<script type="text/javascript" src="../js/SimpleTree.js"></script>

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
<style></style>
</head>

<body class="easyui-layout">
	<div region="north" style=height:80px;width:$(window).width() ">
		<h1>人口流动系统</h1>
		<div class="logout">
            你好，@@@  | <a href="login.jsp">退出</a>  
            </div>
	</div>

	<div region="west" split="true" title="菜单导航" style="width:200px;">
		<div class="easyui-accordion" style="width:200px;height:400px;">
			<div class="st_tree" title="系统设置">
					<ul>
						<li><a href="#" 
						rel="http://localhost:8081/EasyUIDemo/jsp/jueshe.jsp">角色权限</a></li>
						<li><a href="#"
							rel="http://localhost:8081/EasyUIDemo/jsp/zhanghu.jsp">账户管理</a></li>
						<li><a href="#" 
						rel="http://localhost:8081/EasyUIDemo/jsp/mima.jsp">修改密码</a></li>
					</ul>
				</div>
				<div class="st_tree" title="系统设置">
					<ul>
						<li><a href="#" 
						rel="http://localhost:8081/EasyUIDemo/jsp/jueshe.jsp">角色权限</a></li>
						<li><a href="#"
							rel="http://localhost:8081/EasyUIDemo/jsp/zhanghu.jsp">账户管理</a></li>
						<li><a href="#" 
						rel="http://localhost:8081/EasyUIDemo/jsp/mima.jsp">修改密码</a></li>
					</ul>
				</div>
				<div class="st_tree" title="系统设置">
					<ul>
						<li><a href="#" 
						rel="http://localhost:8081/EasyUIDemo/jsp/jueshe.jsp">角色权限</a></li>
						<li><a href="#"
							rel="http://localhost:8081/EasyUIDemo/jsp/zhanghu.jsp">账户管理</a></li>
						<li><a href="#" 
						rel="http://localhost:8081/EasyUIDemo/jsp/mima.jsp">修改密码</a></li>
					</ul>
				</div>
			</div>
		</div>


	<div region="center">
		<div id="tabs" class="easyui-tabs" fit="true" border="false"
			style="padding:5px;"></div>
	</div>
	<div id="menu" class="easyui-menu" style="width:150px;">
		<div id="m-refresh">刷新</div>
		<div class="menu-sep"></div>
		<div id="m-closeall">全部关闭</div>
		<div id="m-closeother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="m-close">关闭</div>
	</div>

</body>
</html>
