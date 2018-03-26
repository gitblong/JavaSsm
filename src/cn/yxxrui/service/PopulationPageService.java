package cn.yxxrui.service;

import java.util.List;
import java.util.Map;

import cn.yxxrui.dto.AssistantInfo;
import cn.yxxrui.dto.LandLordInfo;
import cn.yxxrui.dto.TenantInfo;
import cn.yxxrui.model.Assistant;
import cn.yxxrui.model.Zone;

public interface PopulationPageService {
	

	List<Assistant> getAssistantInfo(Map<String, Object> map);
	Long getAssistantTotal();
	
	List<Zone> getZoneInfo();
	List<Zone> getZonePageInfo(Map<String, Object> map);
	Long getZoneTotal();
	
	List<LandLordInfo> getLandlordPageInfo(Map<String, Object> map);
	Long getPageLandlordTotal(Map<String, Object> map);
	
	List<TenantInfo> getTenantPageInfo(Map<String, Object> map);
	Long getPageTenantPageTotal(Map<String, Object> map);
	
}
