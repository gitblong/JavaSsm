package cn.yxxrui.dto;

public class TenantInfo {
	private int tenantId;
	private String tenantName;
	private String address;
	private String roomNumber;
	public TenantInfo() {
	}
	public TenantInfo(int tenantId,String tenantName, String address, String roomNumber) {
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.address = address;
		this.roomNumber = roomNumber;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	@Override
	public String toString() {
		return "TenantInfo [tenantId=" + tenantId + ", tenantName=" + tenantName + ", address=" + address
				+ ", roomNumber=" + roomNumber + "]";
	}
	
	
}
