package cn.yxxrui.dto;

public class ZoneIdForByUpdate {
	
	private int zoneId;
	private String zoneName;
	private String area;
	
	
	public ZoneIdForByUpdate() {
		
	}

	public ZoneIdForByUpdate(int zoneId, String zoneName, String area) {
		super();
		this.zoneId = zoneId;
		this.zoneName = zoneName;
		this.area = area;
	}

	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}


	@Override
	public String toString() {
		return "ZoneIdForByUpdate [zoneId=" + zoneId + ", zoneName=" + zoneName + ", area=" + area + "]";
	}
	

}
