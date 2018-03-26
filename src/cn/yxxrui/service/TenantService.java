package cn.yxxrui.service;

import java.util.List;

import cn.yxxrui.dto.TenantInfo;
import cn.yxxrui.model.Tenant;

public interface TenantService {
	
	public List<Tenant> getTenantInfoByLandlordId(int landlordId);
	public int addTenant(Tenant tenant);
	public int updateTenant(TenantInfo tenant);
	public int deleteTenant(int id);
	
	public Tenant getTenantInfoByTenantId(int tenantId);
}
