package cn.yxxrui.model;

public class Menu {
	private int id;
	private String menuName;
	
	public Menu() {
	}
	public Menu(int id, String menuName) {
		this.id = id;
		this.menuName = menuName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuName=" + menuName + "]";
	}
	
	
	
}
