package cn.yxxrui.dao;

import java.util.List;
import java.util.Map;

import cn.yxxrui.model.Role;
import cn.yxxrui.model.User;

public interface AccountMangerDao {
	//获得所有用户的数据
		public List<User> getAllUser();
		
		//通过用户的role_id获得role的rolename
		public Role getRoleNameById(int roleId);
		
		//删除用户
		public int delUserById(int id);
	    //添加用户
		public int addUser(User user);

		/**
	     * 用户查询
	     * @param map
	     * @return用户集合
	     */
	    public List<User> find(Map<String, Object> map);
	    
	    /**
	     * 获取总记录数
	     * @param map
	     * @return获取的total数
	     */
	    public Long getTotal(Map<String, Object> map);
		
}
