package cn.yxxrui.dto;

public class AddUserMessage {

	private String userName;
	private String password;
	private String roleName;
	
	public AddUserMessage(){
		
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "AddUserMessage [userName=" + userName + ", password=" + password + ", roleName=" + roleName + "]";
	}
	
	
}
