package cn.yxxrui.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.yxxrui.model.Assistant;
import cn.yxxrui.model.User;

public interface AdminDao {
	//接口方法，通过用户名得到User对象
	public User findUserByName(String userName);
	
	//接口方法，通过用户名和新密码，更改密码
	public int changePassword(@Param("userName")String userName,@Param("password")String password);
	
	public String selectRoleAuthByUserName(String userName);
	
	public List<Assistant> selectAssistant(Map<String, Object> map);
}
