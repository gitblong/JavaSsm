package cn.yxxrui.service;

import java.util.List;
import java.util.Map;

import cn.yxxrui.dto.LandLordInfo;
import cn.yxxrui.dto.LandlordIdForByUpdate;
import cn.yxxrui.model.Landlord;

public interface LandlordService {

	public int addLandlord(Landlord landlord);
	public List<LandLordInfo> selectLandlord(Map<String, Object> map);
	public Long getSelectLandlordTotal(Map<String, Object> map);
	public int addAddress(LandlordIdForByUpdate landlord);
	public int updateLandlord(LandlordIdForByUpdate landlord);
	public int deleteLandlord(int id);
	public LandlordIdForByUpdate selectLandlordById(int landlordId);
	
	public void addLandlordForExcel(Landlord landlord);
	public void batchRemove(Map<String, Object> map);
	
}
