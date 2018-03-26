package cn.yxxrui.model;

import java.util.Date;

public class Tenant {

	private int id;
	private String tenantName;
	private String roomNumber;
	private int landlordId;
	private Date checkInTime;
	private Date checkOutTime;
	private String address;
	public Tenant() {
	}

	public Tenant(int id, String tenantName, String roomNumber, int landlordId, Date checkInTime,
			Date checkOutTime) {
		this.id = id;
		this.tenantName = tenantName;
		this.roomNumber = roomNumber;
		this.landlordId = landlordId;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}

	public Tenant(String tenantName, String roomNumber, int landlordId, String address) {
		this.tenantName = tenantName;
		this.roomNumber = roomNumber;
		this.landlordId = landlordId;
		this.address = address;
	}

	public Tenant(int id, String tenantName, String roomNumber, int landlordId,
			String address) {
		this.id = id;
		this.tenantName = tenantName;
		this.roomNumber = roomNumber;
		this.landlordId = landlordId;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Date getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Tenant [id=" + id + ", tenantName=" + tenantName + ", roomNumber=" + roomNumber + ", landlordId="
				+ landlordId + ", checkInTime=" + checkInTime + ", checkOutTime=" + checkOutTime + ", address="
				+ address + "]";
	}

	
	
	
}
