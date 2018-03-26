package cn.yxxrui.model;

public class User_Role {
	private int id;
	private int roleId;
	private int userId;
	
	
	
	public User_Role() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "User_Role [id=" + id + ", role_id=" + roleId + ", user_id=" + userId + "]";
	}
	
	
}
