package cn.yxxrui.dto;

public class AuthorityMessage {

	private String authorityName;
	private String authorityUrl;
	
	public AuthorityMessage() {
	}
	public AuthorityMessage(String authorityName, String authorityUrl) {
		this.authorityName = authorityName;
		this.authorityUrl = authorityUrl;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public String getAuthorityUrl() {
		return authorityUrl;
	}
	public void setAuthorityUrl(String authorityUrl) {
		this.authorityUrl = authorityUrl;
	}
	@Override
	public String toString() {
		return "AuthorityMessage [authorityName=" + authorityName + ", authorityUrl=" + authorityUrl + "]";
	}
	
	
}
