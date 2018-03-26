package cn.yxxrui.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yxxrui.dao.AssistantDao;
import cn.yxxrui.dao.LandlordDao;
import cn.yxxrui.dao.TenantDao;
import cn.yxxrui.dao.ZoneDao;
import cn.yxxrui.dto.AssistantInfo;
import cn.yxxrui.dto.LandLordInfo;
import cn.yxxrui.dto.TenantInfo;
import cn.yxxrui.model.Assistant;
import cn.yxxrui.model.Landlord;
import cn.yxxrui.model.Tenant;
import cn.yxxrui.model.User;
import cn.yxxrui.model.Zone;
import cn.yxxrui.service.PopulationPageService;
import freemarker.core.ReturnInstruction.Return;
@Service
public class PopulationPageServiceImpl implements PopulationPageService {

	@Resource
	AssistantDao assistantDao;
		
	@Resource
	ZoneDao zoneDao;
	
	@Resource
	LandlordDao landlordDao;
	
	@Resource 
	TenantDao tenantDao;
	
	
	@Override
	public List<Assistant> getAssistantInfo(Map<String, Object> map) {
		
		List<Assistant> assistantLists = assistantDao.getAllAssistant(map);
		List<Assistant> assistantList = new ArrayList<Assistant>();
		
		for (Assistant assistant : assistantLists) {
			
			int zoneId = assistant.getZoneId();
			String zoneName = zoneDao.getZoneNameById(zoneId);
			assistant.setZoneName(zoneName);
			assistantList.add(assistant);
		}
		return assistantList;
	}

	@Override
	public Long getAssistantTotal() {
		return assistantDao.getTotal();
	}

	@Override
	public List<Zone> getZoneInfo() {
		return zoneDao.getAllZone();
	}

	@Override
	public List<Zone> getZonePageInfo(Map<String, Object> map) {
		
		return zoneDao.getZonePageInfo(map);
	}

	@Override
	public Long getZoneTotal() {
		return zoneDao.getTotal();
	}

	@Override
	public List<LandLordInfo> getLandlordPageInfo(Map<String, Object> map) {
		List<Landlord> landlordList = landlordDao.getLandlordPageInfo(map);
		System.out.println("landlordList-------------------"+landlordList);
		List<LandLordInfo> landLordInfoList = new ArrayList<LandLordInfo>();
		for (Landlord landlord : landlordList) {
			int zoneId = landlord.getZoneId();
			int landlordId = landlord.getId();
			System.out.println(landlordId+"landlordId--------");
 			String landlordName = landlord.getLandlordName();
			String telephone = landlord.getTelephone();
			String zoneName = zoneDao.getZoneNameById(zoneId);
			String address = landlord.getAddress();
			String identity = landlord.getIdentity();
			LandLordInfo landLordInfo = new LandLordInfo();
			landLordInfo.setLandlordId(landlordId);
			landLordInfo.setLandlordName(landlordName);
			landLordInfo.setTelephone(telephone);
			landLordInfo.setZoneName(zoneName);
			landLordInfo.setAddress(address);
			landLordInfo.setIdentity(identity);
			
			landLordInfoList.add(landLordInfo);
		}
		System.out.println("-----landLordInfoList-----"+landLordInfoList+"--------------------");
		return landLordInfoList;
	}

	@Override
	public Long getPageLandlordTotal(Map<String, Object> map) {
		return landlordDao.getLandlordTotal(map);
	}

	@Override
	public List<TenantInfo> getTenantPageInfo(Map<String, Object> map) {
		String[] landlordIds = getLandLordIdArray(map);
		map.put("landlordIds", landlordIds);
		
		List<Tenant> tenantList = tenantDao.getTenantPageInfo(map);
		List<TenantInfo> tenantInfoList = new ArrayList<TenantInfo>();
		for (Tenant tenant : tenantList) {
			int tenantId = tenant.getId();
			int landlordId = tenant.getLandlordId();
			String tenantName = tenant.getTenantName();
			String tenantRoomNumber = tenant.getRoomNumber();
			String address = landlordDao.getLandlordAddress(landlordId);
			TenantInfo tenantInfo = new TenantInfo(tenantId,tenantName,address,tenantRoomNumber);
			tenantInfoList.add(tenantInfo);
		}
		System.out.println("--------tenantInfoList----------------"+tenantInfoList);
		return tenantInfoList;
	}

	public String[] getLandlordIds(Map<String, Object> map){
		List<Landlord> landlordList = landlordDao.getLandlordAllLandLordId(map);
		String landlordString="";
		for (Landlord landlord : landlordList) {
			String landlordId = landlord.getId()+",";
			System.out.println(landlordId);
			landlordString+=landlordId;
		}
		System.out.println("landlordString----getLandlordIds----"+landlordString);
		String landlordIds[] = landlordString.split(",");
		
		return landlordIds;
	}

	public String[] getLandLordIdArray(Map<String, Object> map){
		User user = (User)map.get("user");
		int zoneId = user.getZoneId();
		int landlordIdByUser = user.getLandlordId();
		String landlordIdString = landlordIdByUser+"";
		String landlordIds[] ;
		if (landlordIdByUser !=0) {
			System.out.println("landlordIdByUser--------------"+landlordIdByUser);
			landlordIds = new String[1];
			landlordIds[0]=landlordIdString;
		}else {
			map.put("zoneId", zoneId);
			List<Landlord> landlordList = landlordDao.getLandlordAllLandLordId(map);
			String landlordString="";
			for (Landlord landlord : landlordList) {
				String landlordId = landlord.getId()+",";
				System.out.println(landlordId);
				landlordString+=landlordId;
			}
			System.out.println("landlordString----getLandlordIds----"+landlordString);
			String[] getLandlordIds = landlordIdString.split(",");
			landlordIds = new String[getLandlordIds.length];
			landlordIds = landlordString.split(",");
		}
		return landlordIds;
	}
	@Override
	public Long getPageTenantPageTotal(Map<String, Object> map) {
		String[] landlordIds = getLandLordIdArray(map);
		map.put("landlordIds", landlordIds);
		return tenantDao.getTenantTotal(map);
	}
	
	



}
