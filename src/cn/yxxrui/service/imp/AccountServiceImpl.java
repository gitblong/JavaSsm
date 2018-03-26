package cn.yxxrui.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yxxrui.dao.AccountMangerDao;
import cn.yxxrui.dao.AdminDao;
import cn.yxxrui.dto.AccountInformation;
import cn.yxxrui.dto.AddUserMessage;
import cn.yxxrui.model.Role;
import cn.yxxrui.model.User;
import cn.yxxrui.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService{

	@Resource
	AdminDao adminDao;
	
	@Resource
	AccountMangerDao accountMangerDao;
	/**
	 * 将userName，和roleName的集合
	 */
	@Override
	public List<AccountInformation> getAllAccInfo() {
		List<User> userList = accountMangerDao.getAllUser();
		List<AccountInformation> accInfoList = new ArrayList<AccountInformation>();
		for(User user : userList){
			AccountInformation accInfo = new AccountInformation();
			int id = user.getId();
			String userName = user.getUserName();
			int role_id = user.getRoleId();
			Role role = accountMangerDao.getRoleNameById(role_id);
			String roleName = role.getRoleName();
			accInfo.setId(id);
			accInfo.setRoleName(roleName);
			accInfo.setUserName(userName);
			accInfoList.add(accInfo);
		}
		System.out.println(accInfoList);
		return accInfoList;
	}
	
	public int delUserById(int id){
		
		int isDeleteUser = accountMangerDao.delUserById(id);
		if(isDeleteUser>=1){
			return 1;
		}else{
			return 0;
			
		}
	}

	@Override
	public int addUser(AddUserMessage addUser) {
		String roleName = addUser.getRoleName();
		int roleId = getRoleId(roleName);
		String userName = addUser.getUserName();
		String password = addUser.getPassword();
		User user = new User(userName,password,roleId);
		int isAddUser = accountMangerDao.addUser(user);
		if(isAddUser>=1){
			return 1;
		}else{
			return 0;
			
		}
		
	}
	
	public int getRoleId(String roleName){
		int roleId = 0;
		switch (roleName) {
			case "系统管理员":
				roleId = 1;break;
			case "普通用户":
				roleId = 2;break;
			case "派出所":
				roleId = 3;break;
			case "房东":
				roleId = 4;break;
			case "协管员":
				roleId = 5;break;
		}
		return roleId;
	}

	@Override
	public List<AccountInformation> find(Map<String, Object> map) {
		List<User> userList = accountMangerDao.find(map);
		List<AccountInformation> accInfoList = new ArrayList<AccountInformation>();
		for(User user : userList){
			AccountInformation accInfo = new AccountInformation();
			int id = user.getId();
			String userName = user.getUserName();
			int role_id = user.getRoleId();
			Role role = accountMangerDao.getRoleNameById(role_id);
			String roleName = role.getRoleName();
			accInfo.setId(id);
			accInfo.setRoleName(roleName);
			accInfo.setUserName(userName);
			accInfoList.add(accInfo);
		}
		System.out.println(accInfoList);
		return accInfoList;
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return accountMangerDao.getTotal(map);
	}
	
}
