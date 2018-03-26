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
<title>Login</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.4.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.4.4/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.4.4/demo/demo.css">
<link href="../css/06.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="../js/jquery-easyui-1.4.4/jquery.min.js">
	</script>
<script type="text/javascript"
	src="../js/jquery-easyui-1.4.4/jquery.easyui.min.js">
		</script>
<script type="text/javascript"
	src="../js/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js">
	 </script>
<script>
	$(function() {
		$('#test').datagrid({
			iconCls : 'icon_save',
			/* 	width:700,
				height:350, */
			width : $(window).width() - 10,
			height : $(window).height() - 35,
			fit : false,
			nowrap : false,
			striped : true,
			collapsible : true,
			url : '../data/datagrid_data7.json',
			sortName : 'code',
			sortOrder : 'desc',
			remoteSort : false,
			idField : 'code',
			frozenColumns : [ [
				{
					title : '姓名',
					field : 'username',
					width : $(window).width() - 880,
					sortable : true
				},
				{
					title : '地址',
					field : 'useraddress',
					width : 300,
					sortable : true
				},
				{
					title : '地址二维码',
					field : 'QRcode',
					width : 310,
					sortable : true
				}
			] ],
			columns : [ [			
				{
					field : 'opt',
					title : '操作',
					width : 180,
					align : 'center',
					formatter : formatOper
				}
				
			] ],
			pagination : true,
			rownumbers : true,
			toolbar : [ 
			{
			text:'姓名：<input type="text" id="username"/>手机号：<input type="text" id="number"/>身份证号：<input type="text" id="userID"/>'
			},
			{
				id : 'btnadd',
				text:'协管员添加房东',
				iconCls : 'icon-add', //弹出框图标				
				handler : function() {
					 $('#btnsave').linkbutton('enable'); 
					/*  inputToobar();   */
					 alert('add'); 
				/*    handler:function(){
								$('#btnsave').linkbutton('enable');	
								$('#btnadd').window({
						title: '添加角色',
						width: 600,
						height: 600,
						modal: true,
						shadow: false,
						closed: false,
					
					});	 */
				}
			},
			{
			id:'search',
			text:'搜索',
			iconCls: 'icon-search',
            handler: function(){
            alert('search'); 
			}
			}]
		});
		var p = $('#test').datagrid('getPager');
		$(p).pagination({
			onBeforeRefresh : function() {
				/* alert('before refresh'); */
			}
		});
	});
	function formatOper(value, row, index) {
		var c = '<a href="#" onclick="houseManager(' + index + ')">房间管理 |</a> ';
		var e = '<a href="#" onclick="editrow(' + index + ')">编辑 |</a> ';
		var d = '<a href="#" onclick="deleterow(' + index + ')">删除</a>';
		return c + e + d;
	}

	/* function resize(){
		$('#test').datagrid('resize', {
			width:700,
			height:400
		});
	} */
	function checkrow(index) {
		$('#test').datagrid('selectRow', index);
		var row = $('#test').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', '查看信息');
			$("#fm").form('load', row);
		}
	}
	function editrow(index) {
		$('#test').datagrid('selectRow', index);
		var row = $('#test').datagrid('getSelected');
		if (row) {
			$('#dlg').dialog('open').dialog('setTitle', '修改权限');
			$("#fm").form('load', row);
			url = '${ctx}updateStudent.do?id=' + row.id;
		}	
		$("input[type='checkbox']").each(function() {
					this.checked = false;
				});
		}	
	function deleterow(index) { //删除操作
		$.messager.confirm('确认', '确认删除?', function(row) {
			if (row) {
				var selectedRow = $('#test').datagrid('getSelected'); //获取选中行
				$.ajax({
					url : 'delHandler.ashx?id=' + selectedRow.xsbh + '&type=stu',
					//加了个type，作用是以后不管什么删除，都可以转到这个ashx中处理
					success : function() {
						alert('删除成功');
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

/* //checkbox 全选/取消全选
		var isCheckAll = false;
		function swapCheck() {
			if (isCheckAll) {
				$("input[type='checkbox']").each(function() {
					this.checked = false;
				});
				isCheckAll = false;
			} else {
				$("input[type='checkbox']").each(function() {
					this.checked = true;
				});
				isCheckAll = true;
			}
		}
 */
	/*       var form = $win.find("form");
	$("#btnadd").clik(function(){
	          $win.window('open');
	          form.form('clear');
	form.url='dictAction.do?action=addDict';
	          });  */
	});
</script>

</head>
<body>
	<table id="test"></table>
	<div id="dlg" class="easyui-dialog"
		 style="width: 400px; height: 200px; padding: 10px 20px;"
        closed="true"	buttons="#dlg-buttons">
		<div id="fm" method="post">
		<table border="0" cellpadding="1" align="center">
		   <tr>
           <td><label>姓名</label> </td>
           <td><input name="userID" class="easyui-text" required="false" /> </td>
           </tr>
           <tr>
           <td><label>地址 </label></td>
           <td><input name="userID" class="easyui-text" required="false" /> </td>
           </tr>
            <tr>
           <td><label>地址二维码</label> </td>
           <td><input name="userID" class="easyui-text" required="false" /> </td>
           </tr>                 
           </table>

	</div>
	</div>


	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="saveuser()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
	</div>


</body>
</html>