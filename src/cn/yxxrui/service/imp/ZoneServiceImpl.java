package cn.yxxrui.service.imp;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.yxxrui.dao.ZoneDao;
import cn.yxxrui.dto.ZoneIdForByUpdate;
import cn.yxxrui.model.Zone;
import cn.yxxrui.service.ZoneService;
@Service
public class ZoneServiceImpl implements ZoneService{

	@Resource
	ZoneDao zoneDao;

	@Override
	public List<Zone> getAllZone() {
		List<Zone> zoneList = zoneDao.getAllZone();
		return zoneList;
	}

	@Override
	public int addZone(Zone zone) {
		
		return zoneDao.addZone(zone);
	}

	@Override
	public void Test1(HttpServletRequest request) {
		String zoneName = request.getParameter("zoneName");
		
	}

	@Override
	public String getZoneNameById() {
		
		return null;
	}

	@Override
	public int updateZone(ZoneIdForByUpdate zone) {
		System.out.println("---------------世界12631963163131");
		return zoneDao.updateZone(zone);
	}

	@Override
	public ZoneIdForByUpdate selectZoneBYId(int zoneId) {
		System.out.println("你是谁你是谁你是谁你是谁你是谁你是谁你是谁你是谁");
		return zoneDao.getZoneById(zoneId);
	}



	
	
	
}
