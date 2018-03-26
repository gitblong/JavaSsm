$(function(){
	$("#search").click(function(){
        var queryParams = $('#datagrid').datagrid('options').queryParams;  
        queryParams.search_dictid = search_dictid.value;
        $("#datagrid").datagrid('reload');
    });
    
    $("input",$("#search_dictid").next("span")).keydown(function(event){
	  var val = $(this).val();
	  if(event.keyCode == 13){
	    var queryParams = $('#datagrid').datagrid('options').queryParams;  
        queryParams.search_dictid = val;
        $("#datagrid").datagrid('reload');
	  }
	});
    
    var $win = $('#edit-window').window({
		    title: '字典编辑',
		    width: 380,
		    height: 400,
		    top: ($(window).height() - 330) * 0.5,
		    left: ($(window).width() - 380) * 0.5,
		    shadow: true,
		    modal: true,
		    closed: true,
		    minimizable: false,
		    maximizable: false,
		    collapsible: false
		});
    
    var form = $win.find("form");
    
    $("#edit_value").siblings("span").addClass("texthgt");
	$("#edit_value").siblings("span").children("textarea").addClass("texthgt");
    $("#edit_desc").siblings("span").addClass("texthgt");
	$("#edit_desc").siblings("span").children("textarea").addClass("texthgt");
    
    $("#add").click(function(){
		$win.window('open');
		form.form('clear');
		form.url='dictAction.do?action=addDict';
    });
    
    $("#submitForm").click(function(){
    	form.form('submit', {
	        url: form.url,
	        success: function (data) {
	            data = toJson(data);
	            if(data.flag == 0){
	                $("#datagrid").datagrid('reload');
	                $win.window('close');
	            }else{
	                $.messager.alert('错误', data.flag, 'error');
	            }
	        }
	    });
    });
    
    $("#clearForm").click(function(){
    	form.form("clear");
    });
    
    $("#modify").click(function(){
    	form.form("clear");
    	var rows = $('#datagrid').datagrid('getSelections');
    	if(rows.length == 0 || rows.length > 1){
    		$.messager.alert('警告', '请选择一条记录!', 'warning');
    		return;
    	}
    	var dictid = rows[0].id;
    	$.ajax({
    		url:'dictAction.do?action=getOneDict&search.dictid='+dictid,
    		type:'POST',
    		success:function(data){
    			data = toJson(data);
    			var dictinfo = data.dictInfo;
    			$win.window('open');
    			$("#edit_type").textbox('setValue',dictinfo.type);
    			$("#edit_key").textbox('setValue',dictinfo.key);
    			$("#edit_value").textbox('setValue',dictinfo.value);
    			$("#edit_value2").textbox('setValue',dictinfo.value2);
    			$("#edit_desc").textbox('setValue',dictinfo.desc);
    			form.url='dictAction.do?action=modDict&search.dictid='+dictid;
    		},
    		error:function(){
    			$.messager.alert('错误', '操作失败!', 'error');
    		}
    	});
    });
    
    $("#delete").click(function(){
    	var rows = $('#datagrid').datagrid('getSelections');
    	if(rows.length == 0){
    		$.messager.alert('警告', '请至少选择一条记录!', 'warning');
    		return;
    	}
    	$.messager.confirm("操作提示", "您确定要删除这些字典吗？", function (data) {
            if(data){
            	var dictids='';
		    	for(var i=0;i<rows.length;i++){
		    		if(i>0){
			    		dictids += ",";
		    		}
		    		dictids += rows[i].id;
		    	}
		    	$.ajax({
		    		url:'dictAction.do?action=delDict&search.dictid='+dictids,
		    		type:'POST',
		    		success:function(data){
		    			data = toJson(data);
			            if(data.flag == 0){
			                $("#datagrid").datagrid('reload');
			            }else{
			                $.messager.alert('错误', data.flag, 'error');
			            }
		    		},
		    		error:function(){
		    			$.messager.alert('错误', '操作失败!', 'error');
		    		}
		    	});
            }
        });
    });
})