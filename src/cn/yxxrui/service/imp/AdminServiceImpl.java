package cn.yxxrui.service.imp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.yxxrui.dao.AdminDao;
import cn.yxxrui.dto.Exposer;
import cn.yxxrui.model.User;
import cn.yxxrui.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	// 注入Service依赖
	@Resource // 自动装配 其它的注解@Resource @Inject追求意义规范的注解
	private AdminDao adminDao;

	@Override
	public User checkLogin(String userName, String password, HttpServletRequest request) {

		User user = adminDao.findUserByName(userName);
		if (user != null && password.equals(user.getPassword())) {
			return user;

		}
		if (user == null) {
			request.setAttribute("userNull", "用户名不存在,请重新输入");
		} else if (!password.equals(user.getPassword())) {
			request.setAttribute("pswFail", "密码错误,请重新输入");
		}

		return null;

	}

	@Override
	public int checkChangePassword(User user, Exposer exposer, HttpServletRequest request) {
		String originalPassword = exposer.getOriginalPassword();
		String newPassword = exposer.getNewPassword();
		String comfirmPassword = exposer.getConfirmPassword();
		System.out.println("----1-----checkChangePassword-------" + "初始密码输入错误");
		System.out.println("user=" + user);
		if (originalPassword.equals(user.getPassword())) {
			System.out.println("----2-----checkChangePassword-------");
			if (newPassword.equals(comfirmPassword)) {
				System.out.println("----3-----checkChangePassword-------新密码与确认密码错误");
				int update = adminDao.changePassword(user.getUserName(), newPassword);
				return update;
			} else {
				request.setAttribute("comPswFail", "新密码与确认密码错误");
			}
		} else {
			request.setAttribute("oriPswFail", "初始密码输入错误");
		}
		System.out.println("----4-----checkChangePassword-------");
		return 0;
	}

	@Override
	public String selectRoleAuthByUserName(String userName) {
		String role_authoritys = adminDao.selectRoleAuthByUserName(userName);
		return role_authoritys;
	}

}
