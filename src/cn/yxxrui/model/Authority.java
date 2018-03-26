package cn.yxxrui.model;

public class Authority {

	private int id;
	private String permission;
	private int menuId;
	private String url;
	
	public Authority() {
	}

	public Authority(int id, String permission, int menuId, String url) {
		this.id = id;
		this.permission = permission;
		this.menuId = menuId;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public int getMenu_id() {
		return menuId;
	}

	public void setMenu_id(int menuId) {
		this.menuId = menuId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", permission=" + permission + ", menuId=" + menuId + ", url=" + url + "]";
	}
	
	
}
