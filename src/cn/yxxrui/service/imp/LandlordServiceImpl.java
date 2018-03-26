package cn.yxxrui.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yxxrui.dao.LandlordDao;
import cn.yxxrui.dao.ZoneDao;
import cn.yxxrui.dto.LandLordInfo;
import cn.yxxrui.dto.LandlordIdForByUpdate;
import cn.yxxrui.model.Landlord;
import cn.yxxrui.service.LandlordService;
@Service
public class LandlordServiceImpl implements LandlordService{
	@Resource
	LandlordDao landlordDao;
	@Resource
	ZoneDao zoneDao;
	@Override
	public int addLandlord(Landlord landlord) {
		return landlordDao.addLandlord(landlord);
	}

	@Override
	public List<LandLordInfo> selectLandlord(Map<String, Object> map) {
		List<Landlord> landlordList = landlordDao.selectLandlord(map);
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
	public int addAddress(LandlordIdForByUpdate landlord) {
		return landlordDao.addAddress(landlord);
	}

	@Override
	public int updateLandlord(LandlordIdForByUpdate landlord) {
		return landlordDao.updateLandlord(landlord);
	}

	@Override
	public int deleteLandlord(int id) {
		return landlordDao.deleteLandlord(id);
	}

	@Override
	public LandlordIdForByUpdate selectLandlordById(int landlordId) {
		
		return landlordDao.getLandlordById(landlordId);
	}

	@Override
	public void addLandlordForExcel(Landlord landlord) {
		landlordDao.addLandlordForExcel(landlord);
	}

	@Override
	public void batchRemove(Map<String, Object> map) {
		landlordDao.batchRemove(map);
	}

	@Override
	public Long getSelectLandlordTotal(Map<String, Object> map) {
		return landlordDao.getSelectLandlordTotal(map);
	}


}
