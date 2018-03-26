<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
 	String ids = (String)request.getSession().getAttribute("ids");
	if(ids!=null){
		if(!ids.contains("7")){
			response.sendRedirect(basePath);
			return;
		}
	}else{
			response.sendRedirect(basePath);
			return;
	}
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
			href="<%=basePath%>/js/jquery-easyui-1.2.6/demo/demo.css">
			<link rel="stylesheet" type="text/css"
				href="<%=basePath%>/css/04.css">
</head>
<body>
	<table id="assistant-main"></table>
	<div id="assistant-dlg" class="easyui-dialog"
		style="width: 400px; height: 300px; padding: 10px 20px;" closed="true"
		buttons="#assistant-dlg-buttons">
		<form id="assistant-fm" method="post">
			<fieldset>
				<legend>协管员</legend>
				<div class="fitem">
					<label>协管员账号 </label> <input id="addassistantName"
						name="assistantName" class="easyui-text" required="false" />
				</div>
				<br />
				<div class="fitem">
					<label>密码 </label> <input name="password" class="easyui-text"
						type="password" required="false" />
				</div>
				<br />
				<div class="fitem">
					<label>分区</label> <select id="zoneName" name="zoneName"
						class="easyui-combobox" style="width:140px;">
						<c:forEach var="zone" items="${zoneList}">
							<option>${zone.zoneName}</option>
						</c:forEach>
					</select>
				</div>
			</fieldset>
			<input type="hidden" id="zoneId" name="zoneId" />

		</form>
	</div>

	<div id="assistant-dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="saveuser()" iconcls="icon-ok">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#assistant-dlg').dialog('close')">取消</a>
	</div>


	<div id="editAssistant-dlg" class="easyui-dialog"
		style="width: 400px; height: 200px; padding: 10px 20px;" closed="true"
		buttons="#editAssistant-dlg-buttons">
		<div class="ftitle">编辑账号</div>
		<form id="editAssistant-fm" method="post">
			<div class="fitem">
				<label>姓名 </label> <input id="editassistantName"
					name="assistantName" class="easyui-text" required="false" />
			</div>
			<br />
			<div id="zoneSelect" class="fitem">
				<label>分区</label> 
				<select id="editZoneName" name="zoneName"
					style="width:140px;">
					<c:forEach var="zone" items="${zoneList}">
						<option>${zone.zoneName}</option>
					</c:forEach>
				</select>
			</div>
			<!-- <input type="hidden" name="editzoneId" id="editzoneId"/> -->
			<input type="hidden" name="assistantId" id="assistantId" />
		</form>
	</div>

	<div id="editAssistant-dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveAssistant()">添加</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#editAssistant-dlg').dialog('close')">关闭</a>
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
	function fixWidth(percent) {
			return document.body.clientWidth * percent; //这里你可以自己做调整    
		}
		window.onresize = function() {
			$('#assistant-main').datagrid('resize', {
				width : $(window).width() - 40,
				height : 800
			})
		}
		$(function() {
			$('#assistant-main').datagrid({
				iconCls : 'icon-save',
				/* 	width:700,
					height:350, */
				width : $(window).width() - 40,
				height : $(window).height() - 40,
				fitColumns : true,
				nowrap : false,
				striped : true,
				collapsible : true,
				url : '<%=basePath %>/population/assistantInfo',
				sortOrder : 'desc',
				remoteSort : false,
				frozenColumns : [ [
					{
						field : 'assistantName',
						title : '协管员账号',
						width : fixWidth(0.1),
						sortable : true
					}, {
						field : 'zoneName',
						title : '所属分区',
						width : fixWidth(0.1),
						sortable : true
					},
				] ],
				columns : [ [
					{
						field : 'opt',
						title : '操作',
						width : fixWidth(0.1),
						align : 'left',
						formatter : formatOper
					}
				] ],
				pagination : true,
				rownumbers : true,
				toolbar : [ {
					id : 'btnadd',
					text : '添加',
					iconCls : 'icon-add', //弹出框图标
					handler : function() {
						newuser();
					}
				} ]
			});
			var p = $('#assistant-main').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh : function() {
					/* alert('before refresh'); */
				}
			});
		});
		function formatOper(value, row, index) {
			var e = '<a href="#" onclick="editrow(' + index + ')">编辑 |</a> ';
			var d = '<a href="#" onclick="deleterow(' + index + ')">删除</a>';
			return e + d;
		}
		var url;
		var type;
	
		function editrow(index) {
			url = "<%=basePath%>population/updateAssistant";
			$('#assistant-main').datagrid('selectRow', index);
			var row = $('#assistant-main').datagrid('getSelected');
			document.getElementById('assistantId').value = row.id;
			
			if (row) {
				$("#editAssistant-fm").form("clear");
				$('#editAssistant-dlg').dialog('open').dialog('setTitle', '协管员');
				$.ajax({
					url : '<%=basePath%>population/updateGetAssistant?id=' + row.id + '&type=stu',
					//加了个type，作用是以后不管什么删除，都可以转到这个ashx中处理
					dataType : 'json',
					success : function(assistant) {
						//返回的数据在assistant中  
						document.getElementById("editassistantName").value = assistant.assistantName;
						setSelectZone(assistant);
					}
				});
			}
		}
		function setSelectZone(assistant){
		var assistantZoneName = assistant.zoneName;
			var select = document.getElementById("editZoneName").options;
			for (var i = 0; i < select.length; i++) {
				var selectZoneName = select[i].text;
				if (selectZoneName == assistantZoneName) {
					select[i].selected = true;
				}
			}
		}
		function test() {
			var select = document.getElementById("editZoneName").options;
			select[2].selected = true;
			$('#editAssistant-dlg').dialog('open').dialog('setTitle', '协管员账户管理');
		}
		function saveAssistant() {
			$("#editAssistant-fm").form("submit", {
				url : '<%=basePath%>population/updateAssistant',
				onsubmit : function() {
					return $(this).form("validate");
				},
				success : function(result) {
					if (result == "1") {
						$.messager.alert("提示信息", "操作成功");
						$("#editAssistant-dlg").dialog("close");
						$('#assistant-main').datagrid('reload');
					}
					else {
						$.messager.alert("提示信息", "操作失败");
					}
				}
			});
		}
		function deleterow(index) {
			$.messager.confirm('确认', '确认删除?', function(row) {
				if (row) {
					var selectedRow = $('#assistant-main').datagrid('getSelected'); //获取选中行
					$.ajax({
						url : '<%=basePath%>population/deleteAssistant?id=' + selectedRow.id + '&type=stu',
						//加了个type，作用是以后不管什么删除，都可以转到这个ashx中处理
						success : function() {
							alert('删除成功');
							$('#assistant-main').datagrid('reload');
						}
					});
					$('#assistant-main').datagrid('deleteRow', index);
				}
			})
		}
	
	
		function newuser() {
			$("#assistant-dlg").dialog("open").dialog('setTitle', '添加协管员');
			;
			$("#assistant-fm").form("clear");
			document.getElementById("roleId").value = "5";
			document.getElementById("zoneId").value = "0";
	
		}
		/* function edituser() {
	            var row = $("#assistant-main").datagrid("getSelected");
	            if (row) {
	                $("#assistant-dlg").dialog("open").dialog('setTitle', '编辑账户');
	                $("#assistant-fm").form("load", row);
	                url = "UserManage.aspx?id=" + row.ID;
	            }
		} */
		function saveuser() {
			$("#assistant-fm").form("submit", {
				url : '<%=basePath%>/population/addAssistant',
				onsubmit : function() {
					return $(this).form("validate");
				},
				success : function(result) {
					if (result == "1") {
						$.messager.alert("提示信息", "操作成功");
						$("#assistant-dlg").dialog("close");
						$("#assistant-main").datagrid("reload");
					}
					else {
						$.messager.alert("提示信息", "操作失败");
					}
				}
			});
		}
		function destroyUser() {
			var row = $('#assistant-main').datagrid('getSelected');
			if (row) {
				$.messager.confirm('Confirm', 'Are you sure you want to destroy this user?', function(r) {
					if (r) {
						$.post('destroy_user.php', {
							id : row.id
						}, function(result) {
							if (result.success) {
								$('#assistant-main').datagrid('reload'); // reload the user data  
							}
							else {
								$.messager.show({ // show error message  
									title : 'Error',
									msg : result.errorMsg
								});
							}
						}, 'json');
					}
				});
			}
		}
	</script>
</body>
</html>