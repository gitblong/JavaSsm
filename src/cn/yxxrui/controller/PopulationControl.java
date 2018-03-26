package cn.yxxrui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.yxxrui.dao.ZoneDao;
import cn.yxxrui.dto.AssistantIdForByUpdate;
import cn.yxxrui.dto.AssistantInfo;
import cn.yxxrui.dto.LandLordInfo;
import cn.yxxrui.dto.LandlordIdForByUpdate;
import cn.yxxrui.dto.TenantInfo;
import cn.yxxrui.dto.ZoneIdForByUpdate;
import cn.yxxrui.model.Assistant;
import cn.yxxrui.model.Landlord;
import cn.yxxrui.model.Result;
import cn.yxxrui.model.Role;
import cn.yxxrui.model.Tenant;
import cn.yxxrui.model.User;
import cn.yxxrui.model.Zone;
import cn.yxxrui.service.AssistantService;
import cn.yxxrui.service.LandlordService;
import cn.yxxrui.service.PopulationPageService;
import cn.yxxrui.service.TenantService;
import cn.yxxrui.service.ZoneService;
import cn.yxxrui.util.ExcelUtil;
import cn.yxxrui.util.PageMapUtil;
import cn.yxxrui.util.ResponseUtil;

@Controller
@RequestMapping("/population")
public class PopulationControl {

	@Resource
	PopulationPageService populationService;
	@Resource
	AssistantService assistantService;
	@Resource
	ZoneService zoneService;
	
	@Resource
	TenantService tenantService;
	
	@Resource
	LandlordService landlordService;
	
	@Resource
	ZoneDao zoneDao;
	
	@RequestMapping(value="/assistantInfo")
	@ResponseBody
	public Map<String, Object> assistantInfoData(@RequestParam(value="page",required=false) String page,
			@RequestParam(value="rows",required=false) String rows,
			Assistant assistant,HttpServletRequest request){
		
		Map<String, Object> map = PageMapUtil.getMapPage(Integer.parseInt(page), Integer.parseInt(rows));
//		map.put("zoneId", zoneId);
		System.out.println("到这里了吗？");
		List<Assistant> assistantInfoData = populationService.getAssistantInfo(map); 
		Long total = populationService.getAssistantTotal();
		Map<String,Object> result=new HashMap<String,Object>();
        result.put("rows", assistantInfoData);
        result.put("total", total);
		System.out.println("--------CollerAccountmANGER"+assistantInfoData+"---------");
		return result;
	}
	
	@RequestMapping(value="/zoneInfo")
	@ResponseBody
	public Map<String, Object> zoneInfoData(@RequestParam(value="page",required=false) String page,
			@RequestParam(value="rows",required=false) String rows,
			Zone zone,HttpServletRequest request){
//		User user = (User) request.getSession().getAttribute("user");
//		int zoneId = user.getZoneId();

		Map<String, Object> map = PageMapUtil.getMapPage(Integer.parseInt(page), Integer.parseInt(rows));
//		map.put("zoneId", zoneId);
		System.out.println("到这里了吗？");
		List<Zone> zoneInfoData = populationService.getZonePageInfo(map); 
		Long total = populationService.getZoneTotal();
		Map<String,Object> result=new HashMap<String,Object>();
        result.put("rows", zoneInfoData);
        result.put("total", total);
		System.out.println("--------CollerAccountmANGER"+zoneInfoData+"---------");
		return result;
	}
	
	@RequestMapping(value="/landlordInfo")
	@ResponseBody
	public Map<String, Object> landlordInfoData(@RequestParam(value="page",required=false) String page,
			@RequestParam(value="rows",required=false) String rows,
			Landlord landlord,HttpServletRequest reuqest){
		
		User user = (User) reuqest.getSession().getAttribute("user");
		Map<String, Object> map = PageMapUtil.getMapPage(Integer.parseInt(page), Integer.parseInt(rows));
		int zoneId = user.getZoneId();
		map.put("zoneId", zoneId);
		System.out.println("到这里了吗？zoneId"+zoneId);
		List<LandLordInfo> landlordInfoData = populationService.getLandlordPageInfo(map); 
		Long total = populationService.getPageLandlordTotal(map);
		Map<String,Object> result=new HashMap<String,Object>();
        result.put("rows", landlordInfoData);
        result.put("total", total);
		System.out.println("--------CollerAccountmANGER"+landlordInfoData+"---------");
		return result;
	}
	
	@RequestMapping(value="/tenantInfo")
	@ResponseBody
	public Map<String, Object> tenantInfoData(@RequestParam(value="page",required=false) String page,
			@RequestParam(value="rows",required=false) String rows,
			Landlord landlord,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		Map<String, Object> map = PageMapUtil.getMapPage(Integer.parseInt(page), Integer.parseInt(rows));
		map.put("user", user);
		System.out.println("到这里了吗？");
		List<TenantInfo> tenantInfoData = populationService.getTenantPageInfo(map); 
//		map.put("user", "");
		Long total = populationService.getPageTenantPageTotal(map);
		Map<String,Object> result=new HashMap<String,Object>();
        result.put("rows", tenantInfoData);
        result.put("total", total);
		System.out.println("--------tenantInfoData"+tenantInfoData+"---------");
		return result;
	}
	
	@RequestMapping(value="/addAssistant",method=RequestMethod.POST)
	@ResponseBody
	public int addAssistant(Assistant assistant){
		int result = assistantService.addAssistant(assistant);
		return result;
	}
	
	@RequestMapping(value="/deleteAssistant")
	@ResponseBody
	public void deleteAssistant(HttpServletRequest request){
		
		System.out.println("deleteAssistant-----------");
		int id = Integer.parseInt(request.getParameter("id"));
		assistantService.deleteAssistantById(id);
		System.out.println("id-----" + id);
	}
	
/*	@RequestMapping(value="/selectAssistantById")
	@ResponseBody
	public Assistant selectRoleById(HttpServletRequest request,Model model){
		System.out.println("selectAssistantById----------");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id-------"+ id);
		Assistant assistant = assistantService.selectAssistantById(id);
		model.addAttribute("assistant", assistant);
		return assistant;
		
	}*/
	
	@RequestMapping(value="/updateAssistant")
	@ResponseBody
	public int updateAssistant(AssistantIdForByUpdate assistant,
			                  HttpServletRequest request){
		String zoneName=request.getParameter("zoneName");
		System.out.println("zoneName=-----------------zoneName-"+zoneName);
		String assistantName = request.getParameter("assistantName");
		System.out.println("assistantName=-----------------------"+assistantName);
		int zoneId =getZoneId(zoneName);
		System.out.println("--------------------------------zoneId--"+zoneId);
		assistant.setAssistantName(assistantName);
		assistant.setZoneId(zoneId);
		int result = assistantService.updateAssistant(assistant);
		return result;	
	}
	
	
	@RequestMapping(value="/updateGetAssistant")
	@ResponseBody
	public AssistantIdForByUpdate updateGetAssistant(int id){
		System.out.println("assistantId-----------updateGetAssistant----------" + id);
		AssistantIdForByUpdate assistant = assistantService.selectAssistantBYId(id);
		int zoneId = assistant.getZoneId();
		String zoneName = zoneDao.getZoneNameById(zoneId);
		assistant.setZoneName(zoneName);
		System.out.println(assistant);
		return assistant;
	}
	
	
	@RequestMapping(value="/addZone",method=RequestMethod.POST)
	@ResponseBody
	public int addZone(Zone zone){
		int result = zoneService.addZone(zone);
		return result;
	}
	
	
	@RequestMapping(value="/deleteZone",method=RequestMethod.GET)
	@ResponseBody	
	public int deleteZone(int id) {
		System.out.println("----------------------------ahdakhdfahrarkharkhrak"+id);
		int result=zoneDao.deleteDistinctById(id);
		return result;

	}
	
	@RequestMapping(value="/updateZone")
	@ResponseBody
	public int updateZone(ZoneIdForByUpdate zone,HttpServletRequest request){
		System.out.println("===updateZone==");
		String zoneName= request.getParameter("zoneName");
		System.out.println("zoneName=-----------------zoneName-"+zoneName);
		String area = request.getParameter("area");
		System.out.println("area=-----------------------"+area);
		int zoneId = Integer.parseInt(request.getParameter("zoneId"));
		System.out.println("zoneId=-----------------------"+zoneId);
		/*zone.setZoneId(zoneId);
		zone.setZoneName(zoneName);
		zone.setArea(area);*/
		int result = zoneService.updateZone(zone);
		return result;	
	}
	
	
	@RequestMapping(value="/updateGetZone")
	@ResponseBody
	public ZoneIdForByUpdate updateGetZone(int id){
		System.out.println("zoneId-----------updateGetZone----------" + id);
		ZoneIdForByUpdate zone = zoneService.selectZoneBYId(id);
		int zoneId = zone.getZoneId();
		String zoneName = zone.getZoneName();
		String area=zone.getArea();
		System.out.println("zoneId------------"+zoneId+"zoneName-----------------"+zoneName+"area-----------"+area);
		return zone;
	}
	
	
	@RequestMapping(value="/addOrUpdateToTenant",method=RequestMethod.POST)
	@ResponseBody
	public int addOrUpdateToTenant(Tenant tenant,HttpServletRequest request){
		System.out.println("====tenant=================="+tenant);
		User user = (User) request.getSession().getAttribute("user");
		int landlordId = user.getLandlordId();
		tenant.setLandlordId(landlordId);
		int result = tenantService.addTenant(tenant);
		return result;
	}
	
	@RequestMapping(value="/deleteTenant")
	@ResponseBody
	public int deleteTenant(int id){
		System.out.println("deleteTenant---------------進來");
		System.out.println(id+"id---------------------");
		int result = tenantService.deleteTenant(id);
		return result;
	}
	
	@RequestMapping(value="/updateTenant")
	@ResponseBody
	public int updateTenant(TenantInfo tenant){
		System.out.println("updateTenant--------getTenantId-------進來"+tenant.getTenantId());
		int result = tenantService.updateTenant(tenant);
		return result;
	}
	
	@RequestMapping(value="/updateGetTenant")
	@ResponseBody
	public Tenant updateGetTenant(int tenantId){
		System.out.println("tenantId-----------updateGetTenant----------" + tenantId);
		Tenant tenant = tenantService.getTenantInfoByTenantId(tenantId);
		System.out.println(tenant);
		return tenant;
	}
	
	@RequestMapping(value="/addLandlord",method=RequestMethod.POST)
	@ResponseBody
	public int addLandlord(HttpServletRequest request){
		System.out.println("addLandlord--------------------------------");
		String landlordName=request.getParameter("landlordName");
		String telephone=request.getParameter("telephone");
		String identity=request.getParameter("identity");
		String address=request.getParameter("address");
		String zoneName=request.getParameter("zoneName");
		System.out.println("----------landlordName"+landlordName + "telephone" +telephone+"identity" + identity+"address"+address);
		User user=(User) request.getSession().getAttribute("user");
		int roleId = user.getRoleId();
		int zoneId= -1;
		if (roleId == 5) {
			zoneId=user.getZoneId();
		}else{
			zoneId=getZoneId(zoneName);
		}
		Landlord landlord=new Landlord();
		System.out.println("zoneId-----------"+zoneId);
		landlord.setLandlordName(landlordName);
		landlord.setTelephone(telephone);
		landlord.setIdentity(identity);
		landlord.setAddress(address);
        landlord.setZoneId(zoneId);
		int result = landlordService.addLandlord(landlord);
		return result;
	}
	
	@RequestMapping(value="/deleteLandlord")
	@ResponseBody
	public int deleteLandlord(int id){
		System.out.println("deleteLandlord---------------進來");
		System.out.println(id+"landlordId---------------------");
		int result = landlordService.deleteLandlord(id);
		return result;
	}
	
	@RequestMapping(value="/updateLandlord")
	@ResponseBody
	public int updateLandlord(LandlordIdForByUpdate landlord){
		System.out.println("updateLandlord--------getLandlordId-------進來"+landlord.getLandlordId());
		int result = landlordService.updateLandlord(landlord);
		return result;
	}
	
	@RequestMapping(value="/updateGetLandlord")
	@ResponseBody
	public LandlordIdForByUpdate updateGetLandlord(int landlordId){
		System.out.println("landLordId-----------updateGetTenant----------" + landlordId);
		LandlordIdForByUpdate landlord = landlordService.selectLandlordById(landlordId);
		System.out.println(landlord);
		return landlord;
	}
	
	@RequestMapping(value="/addAddressForLandlord")
	@ResponseBody
	public int addAddressForLandlord(LandlordIdForByUpdate landord){
		System.out.println("landLordId-----------updateGetTenant----------" + landord.getLandlordId());
		int result = landlordService.addAddress(landord);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value="/exprotExcel",method = RequestMethod.POST,consumes = "application/json")
	@ResponseBody
	public int exprotExcel(@RequestBody List<LandLordInfo> landlordList,HttpServletResponse response,HttpServletRequest request) throws Exception{
		System.out.println("landlordExcelInfo--------exprotExcel---"+landlordList.toString());
		int result = 0;
		if (!landlordList.isEmpty()) {
			request.getSession().setAttribute("landlordList", landlordList);
			result = 1;
			
			return result;
		}
		return result;
	}
	
	@RequestMapping(value="/exprot",method = RequestMethod.GET)
	public String exprot(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<LandLordInfo> landlordList = (List<LandLordInfo>) request.getSession().getAttribute("landlordList");
		System.out.println("landlordExcelInfo--------exprot---"+landlordList.toString());
		Workbook wb=ExcelUtil.fillExcelDataWithTemplate(landlordList, "userExporTemplate.xls");
		System.out.println("0------Workbook-----"+wb);
		ResponseUtil.export(response, wb, "房东信息.xls");
		System.out.println("-----ResponseUtil------");
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("landlordIds", landlordIds);
//		List<LandLordInfo> landlordExcelInfo = landlordService.getLandlordExcelInfo(map);
//		System.out.println("landlordExcelInfo-----------exprotExcel----------" +landLordInfoList);
		return null;
	}
	@RequestMapping(value="/upload",method = RequestMethod.POST)
	@ResponseBody
	public int upload(@RequestParam("userUploadFile") CommonsMultipartFile userUploadFile)throws Exception{
		System.out.println("------upload---");
		POIFSFileSystem fs=new POIFSFileSystem(userUploadFile.getInputStream());
		HSSFWorkbook wb=new HSSFWorkbook(fs);
		HSSFSheet hssfSheet=wb.getSheetAt(0);  
		if(hssfSheet!=null){
			for(int rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){
				HSSFRow hssfRow=hssfSheet.getRow(rowNum);
				if(hssfRow==null){
					continue;
				}
				Landlord landlord = new Landlord();
				String zoneName = ExcelUtil.formatCell(hssfRow.getCell(4));
				int zoneId = getZoneId(zoneName);
				System.out.println("================"+zoneId);
				landlord.setLandlordName(ExcelUtil.formatCell(hssfRow.getCell(0)));
				landlord.setTelephone(ExcelUtil.formatCell(hssfRow.getCell(1)));
				landlord.setIdentity(ExcelUtil.formatCell(hssfRow.getCell(2)));
				landlord.setAddress(ExcelUtil.formatCell(hssfRow.getCell(3)));
				landlord.setZoneId(zoneId);
				landlordService.addLandlordForExcel(landlord);
			}
		}
		return 1;
	}
	private int getZoneId(String zoneName) {
		int zoneId = -1;
		List<Zone> allZone = zoneService.getAllZone();
		for (Zone zone : allZone) {
			if (zone.getZoneName().equals(zoneName)) {
				zoneId = zone.getId();
				return zoneId;
			}
		}
		System.out.println(allZone);
		return zoneId;
	}
	@RequestMapping(value="/batchRemove",method = RequestMethod.GET)
	@ResponseBody
	public int batchRemove(String landlordIds,HttpServletResponse response,HttpServletRequest request) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("landlordIds--------landlordIds---"+landlordIds);
		int result = 0;
		if (!landlordIds.isEmpty()) {
			String[] landlordIdArray = landlordIds.split(",");
			map.put("landlordIdArray", landlordIdArray);
			result = 1;
			landlordService.batchRemove(map);
			return result;
		}
		return result;
	}
	
	@RequestMapping(value="/selectLanlord",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectLandlord(Landlord landlord,
			@RequestParam(value="page",required=false) String page,
			@RequestParam(value="rows",required=false) String rows, 
			HttpServletRequest reuqest ){
		
		String landlordName=reuqest.getParameter("landlordName");
		String telephone=reuqest.getParameter("telephone");
		String identity=reuqest.getParameter("identity");
		
		System.out.println("-------selectLanlord------------------");
		System.out.println("landlordName"+landlordName+"telephone"+telephone+"identity"+identity+"------selectLandlord-------selectLanlord-------------="+landlord.toString()+"page="+page+"rows="+rows);
		User user = (User) reuqest.getSession().getAttribute("user");
		Map<String, Object> map = PageMapUtil.getMapPage(Integer.parseInt(page), Integer.parseInt(rows));
		int zoneId = user.getZoneId();
		map.put("zoneId", zoneId);
		map.put("landlordName", landlordName);
		map.put("telephone", telephone);
		map.put("identity", identity);
		System.out.println("到这里了吗？zoneId"+zoneId);
		List<LandLordInfo> landlordInfoData = landlordService.selectLandlord(map); 
		Long total = landlordService.getSelectLandlordTotal(map);
		System.out.println("total---------selectLandlord----"+total);
		Map<String,Object> result=new HashMap<String,Object>();
        result.put("rows", landlordInfoData);
        result.put("total", total);
		System.out.println("--------CollerAccountmANGER"+landlordInfoData+"---------");
		return result;
	}
}
