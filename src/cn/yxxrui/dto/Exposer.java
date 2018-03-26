package cn.yxxrui.dto;

public class Exposer {

	private String originalPassword;
	private String newPassword;
	private String confirmPassword;
	
	public Exposer(){
		
	}
	
	public Exposer(String originalPassword, String newPassword, String confirmPassword) {
		super();
		this.originalPassword = originalPassword;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}
	public String getOriginalPassword() {
		return originalPassword;
	}
	public void setOriginalPassword(String originalPassword) {
		this.originalPassword = originalPassword;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
