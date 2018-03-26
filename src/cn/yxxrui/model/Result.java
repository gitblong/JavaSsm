package cn.yxxrui.model;

public class Result {

	private boolean success;
	private String messsage;
	public Result() {
	}
	public Result(boolean success, String messsage) {
		super();
		this.success = success;
		this.messsage = messsage;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	
	
	
}
