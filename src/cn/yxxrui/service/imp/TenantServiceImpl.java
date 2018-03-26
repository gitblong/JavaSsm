package cn.yxxrui.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yxxrui.dao.TenantDao;
import cn.yxxrui.dto.TenantInfo;
import cn.yxxrui.model.Tenant;
import cn.yxxrui.service.TenantService;

@Service
public class TenantServiceImpl implements TenantService {

	@Resource
	TenantDao tenantDao;
	
	@Override
	public List<Tenant> getTenantInfoByLandlordId(int landlordId) {
		return null;
	}

	@Override
	public int addTenant(Tenant tenant) {
		return tenantDao.addTenant(tenant);
	}

	@Override
	public int updateTenant(TenantInfo tenant) {
		return tenantDao.updateTenant(tenant);
	}

	
	
	@Override
	public int deleteTenant(int id) {
		return tenantDao.deleteTenant(id);
	}

	@Override
	public Tenant getTenantInfoByTenantId(int tenantId) {
		return tenantDao.getTenantInfoByTenantId(tenantId);
	}

}
