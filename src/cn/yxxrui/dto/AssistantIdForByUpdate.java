package cn.yxxrui.dto;

public class AssistantIdForByUpdate {

	private int assistantId;
	private String assistantName;
	private int zoneId;
	private String zoneName;
	public String getZoneName() {
		return zoneName;
	}


	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}


	public AssistantIdForByUpdate(){
		
	}
	
	
	public AssistantIdForByUpdate(int assistantId, String assistantName) {
		super();
		this.assistantId = assistantId;
		this.assistantName = assistantName;
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
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}


	@Override
	public String toString() {
		return "AssistantIdForByUpdate [assistantId=" + assistantId + ", assistantName=" + assistantName + ", zoneId="
				+ zoneId + ", zoneName=" + zoneName + "]";
	}
	
}
