package cn.yxxrui.dao;

import java.util.List;
import java.util.Map;

import cn.yxxrui.model.Role;

public interface RoleAuthorityDao {

	//获得所有角色
	public List<Role> getAllRole(Map<String, Object> map);
	public Long getTotal(Map<String, Object> map);
	//删除角色
	public int delRoleById(int id);
	//添加角色
	public int addRole(Role role);
	//更新角色
	public int updateRole(Role role);
	//查找角色
	public Role selectRoleById(int id);
	
	
}
