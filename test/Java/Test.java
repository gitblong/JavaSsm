package Java;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.One;
import org.junit.runner.RunWith;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yxxrui.dao.AdminDao;
import cn.yxxrui.dao.AssistantDao;
import cn.yxxrui.dao.LandlordDao;
import cn.yxxrui.dao.ZoneDao;
import cn.yxxrui.dto.AccountInformation;
import cn.yxxrui.model.Assistant;
import cn.yxxrui.model.Landlord;
import cn.yxxrui.model.Zone;
import cn.yxxrui.service.AccountService;
import cn.yxxrui.service.AdminService;
import cn.yxxrui.service.LandlordService;
import cn.yxxrui.service.ZoneService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml",
	"classpath:spring-mvc.xml" })
public class Test {

	@Resource
	private ZoneService zoneService;
	
	@Resource
	private AdminDao adminDao;
//	private UserMapper userMapper;
	
	@Resource
	private ZoneDao zoneDao;
	@Resource
	private AssistantDao assistantDao;
	@Resource
	private LandlordDao landlordDao;
	@Resource
	private AdminService adminService;
	
	@Resource AccountService accountService;
	
	@Resource
	private LandlordService landlordService;
	
	@org.junit.Test
	public void test() {
		
		List<AccountInformation> accInfo = accountService.getAllAccInfo();
//		HttpServletRequest request= 
//		User user = adminDao.findUserByName("admin");
//		List<User> userList = adminDao.getAllUser();
//		User user = userMapper.selectByPrimaryKey(1);
//		Role role = adminDao.getRoleNameById(1);
//		System.out.println("user"+user);
//		System.out.println(userList);
//		System.out.println(role);
//		List<AccountInformation> accInfoList = new ArrayList<AccountInformation>();
//		for(User user : userList){
//			AccountInformation accInfo = new AccountInformation();
//			int id = user.getId();
//			String userName = user.getUserName();
//			int role_id = user.getRoleId();
//			Role role = adminDao.getRoleNameById(role_id);
//			String roleName = role.getRoleName();
//			accInfo.setId(id);
//			accInfo.setRoleName(roleName);
//			accInfo.setUserName(userName);
//			accInfoList.add(accInfo);
//		}
		System.out.println(accInfo);
	}
	@org.junit.Test
	public void testSelectRoleAuthByUserName(){
		System.out.println(adminDao.selectRoleAuthByUserName("admin"));
		
	}
	@org.junit.Test
	public void utilTest(){
		String ids = "1,2,4,5,";
		/*if(ids.contains("1")){
			System.out.println("包含1");
		}else*/ if(ids.contains("6")){
			System.out.println("包含6");
		}else{
			System.out.println("不包含6");
		}
	}
	
	@org.junit.Test
	public void jsonTest(){
		String landlordIds = "80,79,78";
		String [] id = landlordIds.split(",");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		landlordDao.batchRemove(map);
//		List<Zone> allZone = zoneService.getAllZone();
//		System.out.println(allZone);
//		Landlord landlord = new Landlord("testforExcel", "addLandlordForExcel", "addLandlordForExcel", "addLandlordForExcel", 1);
//		landlordDAO.addLandlordForExcel(landlord);	
	}
	@org.junit.Test
	public void selcetLanlordTest(){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("start", 0);
		map.put("size", 8);
//		map.put("telephone", "13516963316");
		map.put("landlordName", "小石");
		map.put("telephone", "135");
		map.put("identity", "330702196412080014B");
		System.out.println("----------------"+landlordDao.selectLandlord(map));
		System.out.println("------------------"+landlordService.selectLandlord(map));
		System.out.println(landlordDao.getSelectLandlordTotal(map));
		
	}
  @org.junit.Test
	public void addLanlord(){
	    Landlord landlord=new Landlord();
	    landlord.setLandlordName("xiao");
	    landlord.setTelephone("18229898483");
	    landlord.setIdentity("411524");
	    landlord.setAddress("浙师大");
	    landlord.setZoneId(1);
	    
		System.out.println(landlordDao.addLandlord(landlord));
	}
  
  @org.junit.Test
  
  public void deletaAssitant(){
	  System.out.println(assistantDao.deleteAssistantById(13));
  }
  
  @org.junit.Test
  public void selectAssistantByid(){
	  System.out.println(assistantDao.selectAssistantById(1));
  }
  
 /* @org.junit.Test
  public void updateAssistantByid(){
	  Assistant assistant=new Assistant();
	  assistant.setId(16);
	  assistant.setAssistantName("quanquan");
	  assistant.setZoneId(2);
	  System.out.println(assistantDao.updateAssistant(assistant));
  }
  */
  
@org.junit.Test
  
  public void deletaDistinct(){
	  System.out.println(zoneDao.deleteDistinctById(10));
  }

@org.junit.Test
public void selectZoneById(){
	  System.out.println(zoneDao.selectZoneById(1));
}

}
