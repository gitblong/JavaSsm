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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/js/jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/js/jquery-easyui-1.2.6/themes/icon.css">
<link rel="stylesheet" type="text/css"
	ref="<%=basePath%>/js/jquery-easyui-1.2.6/demo/demo.css">
<link href="<%=basePath%>/css/06.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<table id="test"></table>
	<!-- 添加和更新用户 -->
	<div id="dlg" class="easyui-dialog" style="width:550px; height: 300px;"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="get">
			<fieldset class="loginBox" >
				<legend>权限</legend>
				<div>
					<label>角色名</label></br>
					<td><input type="text" id="roleName" name="roleName" /></td>
				</div>
				<div id="authority" onclick="getRoleAuthority()" onclick="editCheckBox()">
					<table border="0" cellpadding="1">
						<tr>
							<td><input type="checkbox" onclick="swapCheck()" />全选反选</td>
						</tr>
						<tr>
							<td><label>目录</label></td>
							<td><label>子目录</label></td>
						</tr>
						<tr>
							<td><label>系统设置</label></td>
							<td><input type="checkbox" />角色权限</td>
							<td><input type="checkbox" />账号管理</td>
							<td><input type="checkbox" />修改密码</td>
						</tr>
						<tr>
							<td><label>流动人口</label></td>
							<td><input type="checkbox" />房东账户信息</td>
							<td><input type="checkbox" />房客信息</td>
							<td><input type="checkbox" />分区管理</td>
							<td><input type="checkbox" />协管员信息</td>
						</tr>
					</table>
				</div>
			</fieldset>
			<input type="hidden" name="roleAuthority" id="roleAuthority" />
			<input type="hidden" name="id" id="roleId" />
		</form>
	</div>

	<!-- 查看用户信息 -->
	<div id="check" class="easyui-dialog" title="查看用户信息"
		style="width:550px;height:300px;text-align:center" resizable="true"
		modal="true" closed="true">
		<form id="checkfm" method="get">
			<fieldset class="loginBox">
				<legend>权限</legend>
				<div class="roleName" style="text-align:left">
					<label>角色名</label>
					<td><input type="text" id="selectRoleName" disabled="true" name="roleName"/></td>
				</div>
				<div id="selectAuthority" onclick="selectCheckBox()">
					<table border="0" cellpadding="1">
						<tr>
							<td><label>目录</label></td>
							<td><label>子目录</label></td>
						</tr>
						<tr>
							<td><label>系统设置</label></td>
							<td><input type="checkbox" />角色权限</td>
							<td><input type="checkbox" />账号管理</td>
							<td><input type="checkbox" />修改密码</td>
						</tr>
						<tr>
							<td><label>流动人口</label></td>
							<td><input type="checkbox" />房东账户信息</td>
							<td><input type="checkbox" />房客信息</td>
							<td><input type="checkbox" />分区管理</td>
							<td><input type="checkbox" />协管员信息</td>
						</tr>
					</table>
				</div>
			</fieldset>
		</form> 
	</div>


	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="saveuser()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
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
	
		$(function() {
			$('#test').datagrid({
				iconCls : 'icon-save',
				/* 	width:700,
					height:350, */
				width : $(window).width() - 10,
				height : $(window).height() - 35,
				fit : false,
				nowrap : false,
				striped : true,
				collapsible : true,
				url : '<%=basePath%>main/roleAuthInfoData',
				sortName : 'code',
				sortOrder : 'desc',
				remoteSort : false,
				idField : 'code',
				frozenColumns : [ [
					{
						title : '角色名称',
						field : 'roleName',
						width : $(window).width() - 180,
						sortable : true
					}
				] ],
				columns : [ [
					{
						field : 'opt',
						title : '操作',
						width : 100,
						align : 'center',
						formatter : formatOper
					}
	
				] ],
				pagination : true,
				rownumbers : true,
				toolbar : [ {
					id : 'btnadd',
					text : '添加角色',
					iconCls : 'icon-add', //弹出框图标
					handler : function() {
						newuser();
					}
				} ]
			});
			var p = $('#test').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh : function() {
					/* alert('before refresh'); */
				}
			});
		});
		var url;
		function formatOper(value, row, index) {
			var c = '<a href="#" onclick="checkrow(' + index + ')">查询</a> ';
			var e = '<a href="#" onclick="editrow(' + index + ')">编辑</a> ';
			var d = '<a href="#" onclick="deleterow(' + index + ')">删除</a>';
			return c + e + d;
		}
		function selectCheckBox(list){
			$("input[type='checkbox']").each(function() {
				this.disabled = true;
				this.checked = false;
			});
			//获取input所在div的对象  
			var ob = document.getElementById("selectAuthority");
			//获取div中所用的IUPUT控件集合  
			var col = ob.getElementsByTagName("input");
			//通过页面上的循环获取的值与后台传送过来放到list中的数据一一比对，如果和界面的内容一致的就可以选择，让其打上对勾  
			 for (var obj in list) { 
				for(var i=0;i< list.length;i++){
					for(var j=0;j<col.length;j++){
						col[j].disable = true;
						if(list[i] == j){
							col[j].checked = true; //是combox选中，打上对勾  
						}
					}
				}
			}
		}	
		function checkrow(index) {
			$('#test').datagrid('selectRow', index);
			
			var row = $('#test').datagrid('getSelected');
			if (row) {
				$('#check').dialog('open').dialog('setTitle', '查看信息');
				$.ajax({
					url : '<%=basePath%>main/selectRoleById?id=' + row.roleId + '&type=stu',
					//加了个type，作用是以后不管什么删除，都可以转到这个ashx中处理
					dataType:'json',
					success : function(role) {
						//返回的数据在role中  
						document.getElementById("selectRoleName").value = role.roleName;
						var authorityStr = role.roleAuthority; //json为接收的后台返回的数据，拿出我存放界面上值得字段；  
						var list = authorityStr.split(','); //把数据给拆分并放到list里面  
						selectCheckBox(list);
						
					}
				});
			}
		}
	
		function editCheckBox(list){
			$("input[type='checkbox']").each(function() {
				this.disabled = false;
				this.checked = false;
			});
			
			//获取input所在div的对象  
			var ob = document.getElementById("authority");
			//获取div中所用的IUPUT控件集合  
			var col = ob.getElementsByTagName("input");
			//通过页面上的循环获取的值与后台传送过来放到list中的数据一一比对，如果和界面的内容一致的就可以选择，让其打上对勾  
			 for (var obj in list) { 
				for(var i=0;i< list.length;i++){
					for(var j=1;j<col.length;j++){
						if(list[i] == j){
							col[j].checked = true; //是combox选中，打上对勾  
						}
					}
				}
			}
		}	
	
		function editrow(index) {
			$('#test').datagrid('selectRow', index);
			var row = $('#test').datagrid('getSelected');
			document.getElementById('roleId').value = row.roleId; 
			if (row) {
				$('#dlg').dialog('open').dialog('setTitle', '修改权限');
				$.ajax({
					url : '<%=basePath%>main/selectRoleById?id=' + row.roleId + '&type=stu',
					//加了个type，作用是以后不管什么删除，都可以转到这个ashx中处理
					dataType:'json',
					success : function(role) {
						//返回的数据在role中  
						document.getElementById("roleName").value = role.roleName;
						var authorityStr = role.roleAuthority; //json为接收的后台返回的数据，拿出我存放界面上值得字段；  
						var list = authorityStr.split(','); //把数据给拆分并放到list里面  
						editCheckBox(list);
					}
				});
			}
		/* $("input[type='checkbox']").each(function() {
			this.checked = false;
		}); */
		}
		function deleterow(index) { //删除操作
			$.messager.confirm('确认', '确认删除?', function(row) {
				if (row) {
					var selectedRow = $('#test').datagrid('getSelected'); //获取选中行
					$.ajax({
						url : '<%=basePath%>main/delRoleById?id=' + selectedRow.roleId + '&type=stu',
						//加了个type，作用是以后不管什么删除，都可以转到这个ashx中处理
						success : function() {
							alert('删除成功');
							$('#test').datagrid('reload');
						}
					});
					$('#test').datagrid('deleteRow', index);
				}
			})
		}
	
		$(function() {
			$(window).resize(function() {
				$('#List').datagrid('resize', {
					width : $(window).width() - 10,
					height : $(window).height() - 35
				}).datagrid('resize', {
					width : $(window).width() - 10,
					height : $(window).height() - 35
				});
			});
		});
	
		//checkbox 全选/取消全选
		var isCheckAll = false;
		function swapCheck() {
			clear();
			if (isCheckAll) {
				$("input[type='checkbox']").each(function() {
					this.checked = false;
				});
				isCheckAll = false;
			}
			else {
				$("input[type='checkbox']").each(function() {
					this.checked = true;
				});
				isCheckAll = true;
			}
		}
		function clear() {
			$("input[type='checkbox']").each(function() {
				this.checked = false;
			});
		}
	
		//获得checkbox字符串
		function getRoleAuthority() {
			//获取input所在div的对象  
			var ob = document.getElementById("authority");
	
			//获取div中所用的IUPUT控件集合  
			var col = authority.getElementsByTagName("input");
			//定义一个变量并初始化为空  
			var str = "";
	
			//循环遍历，判断INPUT是否选中  
			for (var i = 1; i < col.length; i++) {
				if (col[i].checked == true) {
					str += i + ","; //多个被选中的时候，需要把选定的值不断的拼接  
				}
			}
			document.getElementById("roleAuthority").value = str; //把选择完后的字符串给一个隐藏空间以便向后台传送  
		}
	
		//新增用戶
		function newuser() {
			$('#dlg').dialog('open').dialog('setTitle', '添加角色');
			$("#fm").form("clear");
			url = "<%=basePath%>main/addOrUpdateToRole";
			/* document.getElementById("roleAuthority").value = "submit"; */
	
		}
		function saveuser() {
			$("#fm").form("submit", {
				url : url,
				onsubmit : function() {
					/* if ($("#roleName").getValue == "") {
						$.messager.alert("系统提示", "角色名不能为空！");
						return false;
					} */
					
					return $(this).form("validate");
				},
				success : function(result) {
					if (result == "1") {
						$.messager.alert("提示信息", "操作成功");
						$("#dlg").dialog("close");
						$('#test').datagrid('reload');
					}
					else {
						$.messager.alert("提示信息", "操作失败");
					}
				}
			});
		}
		
	</script>
</body>
</html>