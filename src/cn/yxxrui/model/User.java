package cn.yxxrui.model;

public class User {
	private int id;
	private String userName;
	private String password;
	private int roleId;
	private int landlordId;
	private int zoneId;
	public User() {
	}

	public User(String userName,String password,int roleId){
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
	}

	
	
	public User(int id, String userName, String password, int roleId, int landlordId) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.landlordId = landlordId;
	}

	
	public User(int id, String userName, String password, int roleId, int landlordId, int zoneId) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.landlordId = landlordId;
		this.zoneId = zoneId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public int getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", roleId=" + roleId
				+ ", landlordId=" + landlordId + ", zoneId=" + zoneId + "]";
	}
	
	

}
