package cn.yxxrui.dto;

public class AssistantInfo {
	
	private int assistantId;
	private String assistantName;
	private String password;
	private int roleId;
	private int zoneId;
	
	
	public AssistantInfo() {
		
	}
	
	
	public AssistantInfo(int assistantId, String assistantName, String password, int roleId, int zoneId) {
		super();
		this.assistantId = assistantId;
		this.assistantName = assistantName;
		this.password = password;
		this.roleId = roleId;
		this.zoneId = zoneId;
	}


	public int getAssistantId() {
		return assistantId;
	}
	public void setAssistantId(int assistantId) {
		this.assistantId = assistantId;
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
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	
	
	
}