package cn.yxxrui.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sun.mail.handlers.image_gif;

import cn.yxxrui.dto.ZoneIdForByUpdate;
import cn.yxxrui.model.Zone;

public interface ZoneService {
	
	public List<Zone>getAllZone();
	public int addZone(Zone zone);
	public String getZoneNameById();
	public void Test1(HttpServletRequest request);
	public int updateZone(ZoneIdForByUpdate zone);
	public ZoneIdForByUpdate selectZoneBYId(int zoneId);
}
