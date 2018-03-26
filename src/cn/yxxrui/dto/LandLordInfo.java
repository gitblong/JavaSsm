package cn.yxxrui.dto;

public class LandLordInfo {
	private int landlordId;
	private String landlordName;
	private String telephone;
	private String zoneName;
	private String identity;
	private String address;
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LandLordInfo() {
	}

	public LandLordInfo(String landlordName, String telephone, String zoneName) {
		this.landlordName = landlordName;
		this.telephone = telephone;
		this.zoneName = zoneName;
	}

	public String getLandlordName() {
		return landlordName;
	}

	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public int getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Override
	public String toString() {
		return "LandLordInfo [landlordId=" + landlordId + ", landlordName=" + landlordName + ", telephone=" + telephone
				+ ", zoneName=" + zoneName + ", identity=" + identity + ", address=" + address + "]";
	}
	
	
}
