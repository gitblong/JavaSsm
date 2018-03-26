package cn.yxxrui.service;

import javax.servlet.http.HttpServletRequest;

import cn.yxxrui.dto.Exposer;
import cn.yxxrui.model.User;

public interface AdminService {
	// 通过用户名及密码核查用户登录
    public User checkLogin(String userName, String password, HttpServletRequest request);
    
    //通过用户名，密码，确认密码检测是否修改密码成功
    public int checkChangePassword(User user,Exposer exposer, HttpServletRequest request);

	//int checkChangePassword(User user, String originalPassword, String newPassword, String comfirmPassword);
    
    public String selectRoleAuthByUserName(String userName);
}
