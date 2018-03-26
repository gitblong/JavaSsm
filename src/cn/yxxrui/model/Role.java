package cn.yxxrui.model;

public class Role {

	private int id;
	private String roleName;
	private String roleAuthority;
	
	public Role() {
	}
	
	public Role(String roleName,String roleAuthority){
		this.roleName = roleName;
		this.roleAuthority = roleAuthority;
	}
	
	public Role(int id, String roleName, String roleAuthority) {
		this.id = id;
		this.roleName = roleName;
		this.roleAuthority = roleAuthority;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleAuthority() {
		return roleAuthority;
	}
	public void setRoleAuthority(String roleAuthority) {
		this.roleAuthority = roleAuthority;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", roleAuthority=" + roleAuthority + "]";
	}
	
	
	
}
