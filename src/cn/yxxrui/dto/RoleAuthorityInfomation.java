package cn.yxxrui.dto;

public class RoleAuthorityInfomation {

	private int roleId;
	private String roleName;
	private String roleAuthorityName;
	
	public RoleAuthorityInfomation() {
	}

	public RoleAuthorityInfomation(int roleId, String roleName, String roleAuthorityName) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleAuthorityName = roleAuthorityName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleAuthorityName() {
		return roleAuthorityName;
	}

	public void setRoleAuthorityName(String roleAuthorityName) {
		this.roleAuthorityName = roleAuthorityName;
	}

	@Override
	public String toString() {
		return "RoleAuthorityInfomation [roleId=" + roleId + ", roleName=" + roleName + ", roleAuthorityName="
				+ roleAuthorityName + "]";
	}
	
	
		
}
