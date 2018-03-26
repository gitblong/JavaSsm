package Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yxxrui.dao.AccountMangerDao;
import cn.yxxrui.dao.AdminDao;
import cn.yxxrui.dao.RoleAuthorityDao;
import cn.yxxrui.dto.AccountInformation;
import cn.yxxrui.dto.RoleAuthorityInfomation;
import cn.yxxrui.model.Role;
import cn.yxxrui.model.User;
import cn.yxxrui.service.AccountService;
import cn.yxxrui.service.RoleAuthorityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml",
	"classpath:spring-mvc.xml" })
public class AccMangerTest {

	@Resource
	AdminDao adminDao;
	
	@Resource
	AccountService accountService;
	
	@Resource
	AccountMangerDao accountMangerDao;
	
	@Resource 
	RoleAuthorityDao roleAuthorityDao;
	
	@Resource
	RoleAuthorityService roleAuthorityService;
	
	@Test
	public void testFindUser_RoleById() {
		List<User> userList = accountMangerDao.getAllUser();
		System.out.println(userList);
	}
	@Test
	public void testgetAllRole(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 1);
		map.put("size", 10);
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
	}
	@Test
	public void testRoleAuthorityService(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 1);
		map.put("size", 10);
		List<RoleAuthorityInfomation> roleAuthInfoList = roleAuthorityService.getAllRoleAndAuthority(map);
		System.out.println(roleAuthInfoList);
	}
	
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
	
	@Test
	public void getTotalTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 1);
		map.put("size", 10);
		Long i = roleAuthorityService.getTotal(map);
		System.out.println(i);
	}
	
	@Test
	public void testDelRoleById(){
		
		int i = roleAuthorityDao.delRoleById(7);
		System.out.println("delRoleById---"+ i);
	}

	@Test
	public void testAddRole(){
		Role role = new Role("testat", "1,2,");
		roleAuthorityDao.addRole(role);
	}
	
	@Test
	public void testUpdateRole(){
		Role role = new Role(17,"tesss","1,2,3,4,");
		int i = roleAuthorityService.updateRoleById(role);
		System.out.println(i);
	}
	
	@Test
	public void testSelectRole(){
		Role role = roleAuthorityDao.selectRoleById(11);
		System.out.println(role);
		
	}
	@Test
	public void testPage(){
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start",11);
		map.put("size", 10);
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
		Long i = accountMangerDao.getTotal(map);
		System.out.println(userList+""+i);
	}
	
	@Test
	public void testServiceFind(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start",11);
		map.put("size", 10);
		System.out.println(accountService.find(map));
		
	}
}
