package cn.yxxrui.dao;

import java.util.List;
import java.util.Map;

import cn.yxxrui.dto.TenantInfo;
import cn.yxxrui.model.Tenant;

public interface TenantDao {
	public List<Tenant> getTenantPageInfo(Map<String, Object> map);
	public Long getTenantTotal(Map<String, Object> map);
	
	public List<Tenant> getTenantInfoByLandlordId(int landlordId);
	public int addTenant(Tenant tenant);
	public int updateTenant(TenantInfo tenant);
	public int deleteTenant(int id);
	
	public Tenant getTenantInfoByTenantId(int tenantId);
}
