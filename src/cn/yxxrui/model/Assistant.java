package cn.yxxrui.model;

public class Assistant {

	private int id;
	private String assistantName;
	private String password;
	private int roleId;
	private int zoneId;
	private String zoneName;
	
	public Assistant() {
	}

	public Assistant(int id, String assistantName, String password, int roleId,int zoneId,String zoneName) {
		this.id = id;
		this.assistantName = assistantName;
		this.password = password;
		this.roleId = roleId;
		this.zoneId = zoneId;
		this.zoneName = zoneName;
	}


	public Assistant(String assistantName, String password, int roleId, String zoneName, int zoneId) {
		this.assistantName = assistantName;
		this.password = password;
		this.roleId = roleId;
		this.zoneName = zoneName;
		this.zoneId = zoneId;
	}

	
	
	public Assistant(String assistantName, String password, int roleId, String zoneName) {
		super();
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

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	@Override
	public String toString() {
		return "Assistant [id=" + id + ", assistantName=" + assistantName + ", password=" + password + ", roleId="
				+ roleId + ", zoneId=" + zoneId + ", zoneName=" + zoneName +"]";
	}
	
	
}
