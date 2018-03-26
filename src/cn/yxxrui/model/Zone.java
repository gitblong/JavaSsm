package cn.yxxrui.model;

public class Zone {

	private int id;
	private String zoneName;
	private String area;
	
	public Zone() {
	}

	public Zone(int id, String zoneName, String area) {
		this.id = id;
		this.zoneName = zoneName;
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Zone [id=" + id + ", zoneName=" + zoneName + ", area=" + area + "]";
	}
	
	
}
