package cn.yxxrui.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yxxrui.dao.RoleAuthorityDao;
import cn.yxxrui.dto.RoleAuthorityInfomation;
import cn.yxxrui.model.Role;
import cn.yxxrui.service.RoleAuthorityService;

@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService{

	@Resource
	RoleAuthorityDao roleAuthorityDao;
	
	@Override
	public List<RoleAuthorityInfomation> getAllRoleAndAuthority(Map<String,Object> map) {
		List<Role> roleList = roleAuthorityDao.getAllRole(map);
		List<RoleAuthorityInfomation> roleAuthInfoList = new ArrayList<RoleAuthorityInfomation>();
		for(Role role: roleList){
			int roleId = role.getId();
			String roleName = role.getRoleName();
			String authority = role.getRoleAuthority();
			String stringList = getRoleAuthority(authority);
			RoleAuthorityInfomation roleAuthInfo = new RoleAuthorityInfomation(roleId,roleName,stringList);
			roleAuthInfoList.add(roleAuthInfo);
			System.out.println("stringList----------"+stringList);
		}
		
		System.out.println("RoleAuthorityInfomation----list" +roleAuthInfoList);
		System.out.println("roleList---"+roleList);
		
		return roleAuthInfoList;
	}
	@Override
	public Long getTotal(Map<String, Object> map) {
		
		return roleAuthorityDao.getTotal(map);
	}
	//将权限由数字串转为字符串组
	public String getRoleAuthority(String roleAuthority){
		String[] authorityId = roleAuthority.split(",");
		String authorityName = "";
		for(int i = 0;i<authorityId.length;i++){
			String authority = authorityId[i];
			switch(authority){
				case "1":
					authorityName+="角色权限,";
					break;
				case "2":
					authorityName+="账号管理,";
					break;
				case "3":
					authorityName+="修改密码,";
					break;
				case "4":
					authorityName+="房东账户管理,";
					break;
				case "5":
					authorityName+="房客信息,";
					break;
				case "6":
					authorityName+="分区管理,";
					break;
				case "7":
					authorityName+="协管员账号,";
					break;
				
			}
		}
		return authorityName;
	}

	@Override
	public int delRoleById(int id) {
		int delId = roleAuthorityDao.delRoleById(id);
		return delId;
	}

	@Override
	public int addRole(Role role) {
		int addRole = roleAuthorityDao.addRole(role);
		return addRole;
	}

	@Override
	public int updateRoleById(Role role) {
		int updateRole = roleAuthorityDao.updateRole(role);
		return updateRole;
	}

	@Override
	public Role selectRoleById(int id) {
		Role role = roleAuthorityDao.selectRoleById(id);
		return role;
	}

	

	

}
