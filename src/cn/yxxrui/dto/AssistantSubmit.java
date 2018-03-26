package cn.yxxrui.dto;

public class AssistantSubmit {

	private int id;
	private String assistantName;
	private String password;
	private int roleId;
	private String zoneName;
	
	
	
	public AssistantSubmit() {
	}

	public AssistantSubmit(int id, String assistantName, String password, int roleId, String zoneName) {
		this.id = id;
		this.assistantName = assistantName;
		this.password = password;
		this.roleId = roleId;
		this.zoneName = zoneName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssistantName() {
		return assistantName;
	}

	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
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

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	@Override
	public String toString() {
		return "AssistantSubmit [id=" + id + ", assistantName=" + assistantName + ", password=" + password + ", roleId="
				+ roleId + ", zoneName=" + zoneName + "]";
	}
	
	
	
	
}
