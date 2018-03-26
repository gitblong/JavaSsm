/*package cn.yxxrui.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yxxrui.model.Landlord;
import cn.yxxrui.util.DateUtil;
import cn.yxxrui.util.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ExpController {
	@RequestMapping(value = "/exp", method = RequestMethod.POST)
	@ResponseBody
	public void exp(HttpServletResponse response, HttpServletRequest request) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook(); 
		String _rows = request.getParameter("rows");
		String _cols = request.getParameter("cols");
		// 取得所有行，转为json数组
		JSONArray rows = new JSONArray(_rows);
		// 取得所有列，转为json数组
		JSONArray cols_ = new JSONArray(_cols);
		Sheet sheet = workbook.createSheet("sheet1");
		int rownum = 0;
		Row row1 = sheet.createRow(rownum);
		JSONArray cols = new JSONArray();
		// 过滤掉列中没有title的，例如id等隐藏属性
		for (int i = 0; i < cols_.length(); i++) {
			JSONObject col = cols_.getJSONObject(i);
			if (col.has("title")) {
				cols.put(col);
			}
		} // 循环创建列头

		for (int i = 0; i < cols.length(); i++) {
			JSONObject col = cols.getJSONObject(i);
			Cell cell = row1.createCell(i);
			cell.setCellValue(StringUtils.convertToString(col.get("title")));
		}
		// 循环row并给excel塞值
		for (int j = 0; j < rows.length(); j++) {
			row1 = sheet.createRow(j + 1);
			JSONObject row = rows.getJSONObject(j);
			for (int i = 0; i < cols.length(); i++) {
				JSONObject col = cols.getJSONObject(i);
				Cell cell = row1.createCell(i);
				cell.setCellValue(StringUtils.convertToString(row.get(StringUtils.convertToString(col.get("field")))));
			}
		}
		response.addHeader("Content-Disposition", "attachment;filename=" +
		DateUtil.getCurrentTimeInMillis() + ".xls");
		ServletOutputStream out = null;

		try {
			out = response.getOutputStream();
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}*/