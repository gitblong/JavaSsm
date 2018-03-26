package cn.yxxrui.dto;

public class LandlordIdForByUpdate {

	private int landlordId;
	private String landlordName;
	private String telephone;
	private String address;
	
	
	public LandlordIdForByUpdate() {
	}


	public LandlordIdForByUpdate(int landlordId, String landlordName, String telephone, String address) {
		this.landlordId = landlordId;
		this.landlordName = landlordName;
		this.telephone = telephone;
		this.address = address;
	}


	public int getLandlordId() {
		return landlordId;
	}


	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "LandlordIdForByUpdate [landlordId=" + landlordId + ", landlordName=" + landlordName + ", telephone="
				+ telephone + ", address=" + address + "]";
	}
	
	
}
