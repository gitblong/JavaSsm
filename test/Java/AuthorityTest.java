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

import cn.yxxrui.dao.AuthorityDao;
import cn.yxxrui.dao.MenuDao;
import cn.yxxrui.dto.AuthorityMenuTitle;
import cn.yxxrui.dto.AuthorityMessage;
import cn.yxxrui.model.Authority;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml",
	"classpath:spring-mvc.xml" })
public class AuthorityTest {

	@Resource
	AuthorityDao authorityDao;
	@Resource
	MenuDao menuDao;
	
	@Test
	public void test() {
		Map<String,Object> map = new HashMap<String,Object>();
		String ids = "1,2,3,4,5,6,7";
		String id[] = ids.split(",");
		for(int i=0;i<id.length;i++){
			
			System.out.println(id[i]);
		}
//		map.put("id", id);
//		List<Integer> menuIdList = authorityDao.getMenuId(map);
//		List<AuthorityMenuTitle> authMenuList = new ArrayList<AuthorityMenuTitle>();
//		for(int i=0;i<menuIdList.size();i++){
//			int menuId = menuIdList.get(i);
//			String menuName = menuDao.getMenuNameById(menuId);
//			map.put("menuId", menuId);
//			List<AuthorityMessage> authMsg = authorityDao.getAuthorityMsgByMenuId(map);
//			AuthorityMenuTitle amt = new AuthorityMenuTitle(menuName,authMsg);
//			authMenuList.add(amt);
//		}
//		System.out.println(authMenuList);
	}

}
