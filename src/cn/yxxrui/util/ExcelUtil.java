package cn.yxxrui.util;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import cn.yxxrui.dto.LandLordInfo;

public class ExcelUtil {

	public static void fillExcelData(ResultSet rs,Workbook wb,String[] headers)throws Exception{
		int rowIndex=0;
		Sheet sheet=wb.createSheet();
		Row row=sheet.createRow(rowIndex++);
		for(int i=0;i<headers.length;i++){
			row.createCell(i).setCellValue(headers[i]);
		}
		while(rs.next()){
			row=sheet.createRow(rowIndex++);
			for(int i=0;i<headers.length;i++){
				row.createCell(i).setCellValue(rs.getObject(i+1).toString());
			}
		}
	}
	
	public static Workbook fillExcelDataWithTemplate(List<LandLordInfo> landLordInfoList,String templateFileName)throws Exception{
		InputStream inp=ExcelUtil.class.getResourceAsStream("/cn/yxxrui/template/"+templateFileName);
		POIFSFileSystem fs=new POIFSFileSystem(inp);
		Workbook wb=new HSSFWorkbook(fs);
		Sheet sheet=wb.getSheetAt(0);
		// 获取列数
		int cellNums=sheet.getRow(0).getLastCellNum();
		int rowIndex=1;
		for (int j = 0; j < landLordInfoList.size(); j++) {
			Row row=sheet.createRow(rowIndex++);
			row.createCell(0).setCellValue(landLordInfoList.get(j).getLandlordName());
			row.createCell(1).setCellValue(landLordInfoList.get(j).getTelephone());
			row.createCell(2).setCellValue(landLordInfoList.get(j).getIdentity());
			row.createCell(3).setCellValue(landLordInfoList.get(j).getAddress());
			row.createCell(4).setCellValue(landLordInfoList.get(j).getZoneName());
		}
		return wb;
	}
	
	public static String formatCell(HSSFCell hssfCell){
		if(hssfCell==null){
			return "";
		}else{
			if(hssfCell.getCellType()==HSSFCell.CELL_TYPE_BOOLEAN){
				return String.valueOf(hssfCell.getBooleanCellValue());
			}else if(hssfCell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
				return String.valueOf(hssfCell.getNumericCellValue());
			}else{
				return String.valueOf(hssfCell.getStringCellValue());
			}
		}
	}
}
