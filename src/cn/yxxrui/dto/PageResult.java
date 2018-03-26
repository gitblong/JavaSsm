package cn.yxxrui.dto;

import java.util.List;

import cn.yxxrui.dto.AccountInformation;

public class PageResult {
	private List<AccountInformation> rows;
	private Long total;
	
	
	
	public PageResult() {
		super();
	}
	public PageResult(List<AccountInformation> rows, Long total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public List<AccountInformation> getUserList() {
		return rows;
	}
	public void setUserList(List<AccountInformation> rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "PageResult [rows=" + rows + ", total=" + total + "]";
	}
	
	
}
