

var ExportHandler = function ExportExcel(formId, tableId, toolbar) {
	var isvalid = $('#' + formId).form('validate');
	if (!isvalid) {
		return false;
	}
	//取得表格所有列   
	var cols = $('#' + tableId).datagrid('options').columns;
	//取得表格的url属性，该属性不能为空，因为通用导出将调用该方法进行查询  
	var reqUrl = $('#' + tableId).datagrid('options').url;
	if (reqUrl == null) {
		alert('表格必须要有url属性才能导出！');
		return false;
	}
	var toolbarName = '导出';
	if (toolbar) {
		toolbarName = $(toolbar).text();
		$(toolbar).linktoolbar("disable");
		$(toolbar).linktoolbar({
			text : '导出中...'
		});
	}
	var searchParamArray = $('#' + formId).serializeArray();
	var searchParams = $.jqexer.formToJson(searchParamArray);
	//将页面的当前页设置为1、每页查询10000条，是为了调用查询方法进行导出时不分页，导出所有查询数据    
	searchParams.page = 1;
	searchParams.rows = 10000;
	$.ajax({
		url : reqUrl,
		type : 'POST',
		data : searchParams,
		dataType : "json",
		contentType : '',
		success : function(data) {
			for (var i in cols[0]) {
				var col = cols[0][i];
				if (col.formatter) {
					var formatter_func;
					var formatter_string = col.formatter.toString();
					formatter_func = (new Function('return' + formatter_string))();
				}
				else {
					formatter_func = col.formatter;
				}
				for (var j in data.rows) {
					var row = data.rows[j];
					var rs = formatter_func(eval('row.' + col.field), row, j);
					eval('row.' + col.field + "='" + rs + "'");
				}
			}
		}
	});
	var data1 = JSON.stringify(data.rows);
	var data2 = JSON.stringify(cols[0]);
	var formlandord = $("<form>");
	formlandord.attr('style', 'display:none');
	formlandord.attr('target', '');
	formlandord.attr('enctype', 'multipart/form-data');
	formlandord.attr('method', 'post');
	//form提交路径    
	formlandord.attr('action', ctx + '/manager/export/exp');
	var input1 = $('<input>');
	input1.attr('type', 'hidden');
	input1.attr('name', 'cols');
	input1.attr('value', data2);
	var input2 = $('<input>');
	input2.attr('type', 'hidden');
	input2.attr('name', 'rows');
	input2.attr('value', data1);
	$('body').append(formlandord);
	formlandord.append(input1);
	formlandord.append(input2);
	formlandord.submit();
	formlandord.remove();
	if (toolbar) {
		$(toolbar).linktoolbar("enable");
		$(toolbar).linktoolbar({
			text : toolbarName
		});
	}
}