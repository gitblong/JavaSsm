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
<title>Login</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.2.6/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.2.6/demo/demo.css">
	<link rel="stylesheet" type="text/css"
	href="../css/04.css">
<script type="text/javascript"
	src="../js/jquery-easyui-1.2.6/jquery-1.7.2.min.js">
	</script>
<script type="text/javascript"
	src="../js/jquery-easyui-1.2.6/jquery.easyui.min.js">
	 </script>
 <script type="text/javascript"
	src="../js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js">
	 </script>
<script type="text/javascript">
        var url;
        var type;
        function newuser() {
            $("#dlg").dialog("open").dialog('setTitle', '修改账户'); ;
            $("#fm").form("clear");
            url = "UserManage.aspx";
            document.getElementById("hidtype").value="submit";
        }
        function edituser() {
            var row = $("#dg").datagrid("getSelected");
            if (row) {
                $("#dlg").dialog("open").dialog('setTitle', '编辑账户');
                $("#fm").form("load", row);
                url = "UserManage.aspx?id=" + row.ID;
            }
        }
        function saveuser() {
            $("#fm").form("submit", {
                url: url,
                onsubmit: function () {
                    return $(this).form("validate");
                },
                success: function (result) {
                    if (result == "1") {
                        $.messager.alert("提示信息", "操作成功");
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("load");
                    }
                    else {
                        $.messager.alert("提示信息", "操作失败");
                    }
                }
            });
        }
        function destroyUser() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('Confirm', 'Are you sure you want to destroy this user?', function (r) {
                    if (r) {
                        $.post('destroy_user.php', { id: row.id }, function (result) {
                            if (result.success) {
                                $('#dg').datagrid('reload');    // reload the user data  
                            } else {
                                $.messager.show({   // show error message  
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        }, 'json');
                    }
                });
            }
        }  
    </script>



</head>
<body>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls:'icon-add'
			 onclick="newuser()" plain="true">添加账户</a>
	</div>
	<table id="dg" title="账户信息"  class="easyui-datagrid"
	  style=" width: $(window).width() - 10;
	  height: $(window).height() - 35"
	   url='../data/datagrid_data3.json'
		toolbar="#toolbar"
		 pagination="true" 
		 rownumbers="true"
		 fitcolumns="true"
		 singleselect="true">		       
		<thead>			           
			<tr>	               
				<th field="code" width="$(window).width() - 340">账户</th>                
				<th field="Role" width="300"> 角色</th>                				
			</tr>
			       
		</thead>
		   
	</table>

<div id="dlg"  class="easyui-dialog"  style="width: 400px; height: 300px; padding: 10px 20px;"
        closed="true" buttons="#dlg-buttons"> 
       <div class="ftitle"> 
           添加账户 
       </div> 
       <form id="fm" method="post"> 
       <div class="fitem" > 
           <label>账号 </label> 
           <input name="userID" class="easyui-text" required="false" /> 
       </div> 
       <br/>
        <div class="fitem" > 
           <label>密码 </label> 
           <input name="userID" class="easyui-text" required="false" /> 
       </div> 
       <br/>
       <div class="fitem"> 
           <label>角色</label> 
           <input name="userRole" class="easyui-text" required="false" /> 
       </div> 
       <input type="hidden" name="action" id="hidtype" /> 
       <input type="hidden" name="ID" id="Nameid" /> 
       </form> 
   </div> 

<div id="dlg-buttons"> 
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveuser()" iconcls="icon-save">保存</a> 
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')"
            iconcls="icon-cancel">取消</a> 
    </div> 

</body>
</html>