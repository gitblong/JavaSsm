package cn.yxxrui.dto;

public class AccountInformation {

	private int id;
	private String userName;
	private String roleName;
	
	public AccountInformation() {
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "AccountInformation [id=" + id + ", userName=" + userName + ", roleName=" + roleName + "]";
	}
	
	
	
}
