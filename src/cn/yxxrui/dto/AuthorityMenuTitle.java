package cn.yxxrui.dto;

import java.util.List;

public class AuthorityMenuTitle {

	private String menuName;
	private List<AuthorityMessage> authMsgList;
	
	
	public AuthorityMenuTitle() {
	}
	public AuthorityMenuTitle(String menuName, List<AuthorityMessage> authMsgList) {
		this.menuName = menuName;
		this.authMsgList = authMsgList;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public List<AuthorityMessage> getAuthMsgList() {
		return authMsgList;
	}
	public void setAuthMsgList(List<AuthorityMessage> authMsgList) {
		this.authMsgList = authMsgList;
	}
	@Override
	public String toString() {
		return "AuthorityMenuTitle [menuName=" + menuName + ", authMsgList=" + authMsgList + "]";
	}
	
	
	
	
}
