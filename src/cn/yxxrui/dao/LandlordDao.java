package cn.yxxrui.dao;

import java.util.List;
import java.util.Map;

import cn.yxxrui.dto.LandlordIdForByUpdate;
import cn.yxxrui.model.Landlord;

public interface LandlordDao {

	public List<Landlord> getLandlordPageInfo(Map<String, Object> map);
	public Long getLandlordTotal(Map<String, Object> map);
	
	public String getLandlordAddress(int landlordId);
	public List<Landlord> getLandlordAllLandLordId(Map<String, Object> map);
	
	public int addLandlord(Landlord landlord);
	public List<Landlord> selectLandlord(Map<String, Object> map);
	public Long getSelectLandlordTotal(Map<String, Object> map);
	public int addAddress(LandlordIdForByUpdate landlord);
	public int updateLandlord(LandlordIdForByUpdate landlord);
	public int deleteLandlord(int id);
	public LandlordIdForByUpdate getLandlordById(int landlordId);
	public void addLandlordForExcel(Landlord landlord);
	public void batchRemove(Map<String, Object> map);
}
