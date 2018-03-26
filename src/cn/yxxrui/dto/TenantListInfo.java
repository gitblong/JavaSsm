package cn.yxxrui.dto;

import java.util.List;

import cn.yxxrui.model.Tenant;

public class TenantListInfo {

	private List<List<Tenant>> tenantList;

	public TenantListInfo() {
	}

	public TenantListInfo(List<List<Tenant>> tenantList) {
		this.tenantList = tenantList;
	}

	public List<List<Tenant>> getTenantList() {
		return tenantList;
	}

	public void setTenantList(List<List<Tenant>> tenantList) {
		this.tenantList = tenantList;
	}

	@Override
	public String toString() {
		return "TenantListInfo [tenantList=" + tenantList + "]";
	}
	
	
}
