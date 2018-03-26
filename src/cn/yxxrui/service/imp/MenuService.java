package cn.yxxrui.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yxxrui.dao.AuthorityDao;
import cn.yxxrui.dao.MenuDao;
import cn.yxxrui.dto.AuthorityMenuTitle;
import cn.yxxrui.dto.AuthorityMessage;

@Service
public class MenuService implements cn.yxxrui.service.MenuService {

	@Resource
	AuthorityDao authorityDao;
	@Resource
	MenuDao menuDao;
	
	
	@Override
	public List<AuthorityMenuTitle> getMenuMessage(String ids) {
		Map<String,Object> map = new HashMap<String,Object>();
		String id[] = ids.split(",");
		map.put("id", id);
		List<Integer> menuIdList = authorityDao.getMenuId(map);
		List<AuthorityMenuTitle> authMenuList = new ArrayList<AuthorityMenuTitle>();
		for(int i=0;i<menuIdList.size();i++){
			int menuId = menuIdList.get(i);
			String menuName = menuDao.getMenuNameById(menuId);
			map.put("menuId", menuId);
			List<AuthorityMessage> authMsg = authorityDao.getAuthorityMsgByMenuId(map);
			AuthorityMenuTitle amt = new AuthorityMenuTitle(menuName,authMsg);
			authMenuList.add(amt);
		}
		System.out.println("----------getMenuMessage-----------");
		System.out.println(authMenuList);
		return authMenuList;
	}

}
