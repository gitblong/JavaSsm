package cn.yxxrui.dto;

import java.util.List;

public class AccountResult {

	private int resultId;
	private List<AccountInformation> accInfoData;
	public AccountResult() {
	}
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	public List<AccountInformation> getAccInfoData() {
		return accInfoData;
	}
	public void setAccInfoData(List<AccountInformation> accInfoData) {
		this.accInfoData = accInfoData;
	}
	
	
}
