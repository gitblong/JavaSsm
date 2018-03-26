package Java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yxxrui.dao.AdminDao;
import cn.yxxrui.dao.AssistantDao;
import cn.yxxrui.dao.LandlordDao;
import cn.yxxrui.dao.TenantDao;
import cn.yxxrui.dao.ZoneDao;
import cn.yxxrui.dto.Pager;
import cn.yxxrui.dto.TenantInfo;
import cn.yxxrui.model.Assistant;
import cn.yxxrui.model.Landlord;
import cn.yxxrui.model.Tenant;
import cn.yxxrui.model.Zone;
import cn.yxxrui.service.PopulationPageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml",
	"classpath:spring-mvc.xml" })
public class PopulationTest {

	@Resource
	LandlordDao landlordDao;
	@Resource
	PopulationPageService populationPageService;
	@Resource
	ZoneDao zoneDao;
	@Resource
	AdminDao adminDao;
	
	
	@Resource
	TenantDao tenantDao;
	
	@Resource
	AssistantDao assistantDao;
	
	
	@Test
	public void getAllLandlordTest() {
		Map<String , Object> map = new HashMap<String, Object>();
		int i = 0;
		map.put("zoneId", i);
		map.put("start", 0);
		map.put("size", 10);
		List<Landlord> landlordList = landlordDao.getLandlordAllLandLordId(map);
		System.out.println(landlordList);
		String landlordString="";
		for (Landlord landlord : landlordList) {
			int landlordId = landlord.getId();
			landlordString+=landlordId+",";
		}
		System.out.println(landlordString);
		String landlordIds[] = landlordString.split(",");
		map.put("landlordIds", landlordIds);
		System.out.println("-------tenantDao----------------"+tenantDao.getTenantPageInfo(map));
		System.out.println(landlordString+"------------------------");
		System.out.println(landlordList);
		System.out.println(landlordDao.getLandlordTotal(map));
//		List<Landlord> landlordList = landlordDao.getAllLandlord();
//		System.out.println(landlordList);
	}
	
	@Test
	public void getAllLandlordServiceTest(){
		
		
	}
	
	@Test
	public void getAllZoneTest() {
//		List<Zone> zoneList = zoneDao.getAllZone();
//		System.out.println(zoneList);
	}
	
	@Test
	public void getAllTenantTest() {
		List<Tenant> tenantList = tenantDao.getTenantInfoByLandlordId(1);
		System.out.println(tenantList);
	}
	
	@Test
	public void getAllAssistantTest() {
//		List<Assistant> assistnatList = assistantDao.getAllAssistant();
//		System.out.println(assistnatList);
	}
	
	@Test
	public void getTenantPageInfoTest(){
		Map<String , Object> map = new HashMap<String, Object>();
		int i = 0;
		map.put("zoneId", i);
		map.put("start", 11);
		map.put("size", 14);
		List<TenantInfo> tenantLists = populationPageService.getTenantPageInfo(map);
		Long count = populationPageService.getPageTenantPageTotal(map);
		System.out.println(tenantLists);
		System.out.println(count+"=====count=========");
	}
	
	@Test
	public void getTenantTotalTest(){
		Map<String , Object> map = new HashMap<String, Object>();
		int i = 0;
		map.put("zoneId", i);
		map.put("start", 0);
		map.put("size", 10);
		List<Landlord> landlordList = landlordDao.getLandlordAllLandLordId(map);
		System.out.println(landlordList);
		String landlordString="";
		for (Landlord landlord : landlordList) {
			int landlordId = landlord.getId();
			landlordString+=landlordId+",";
		}
		System.out.println(landlordString);
		String landlordIds[] = landlordString.split(",");
		map.put("landlordIds", landlordIds);
		System.out.println(tenantDao.getTenantTotal(map));
		
	}
	
	@Test
	public void getLandlordAllLandLordIdTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zoneId", 1);
		landlordDao.getLandlordAllLandLordId(map);
		System.out.println(landlordDao.getLandlordAllLandLordId(map));
	}
	
	@Test
	public void selectAssistant(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 0);
		map.put("size", 10);
		adminDao.selectAssistant(map);
		System.out.println(adminDao.selectAssistant(map));
	}
	
	@Test
	public void addTenantTest(){
		
	System.out.println(tenantDao.getTenantInfoByTenantId(17));
	}
	
	
	
}
