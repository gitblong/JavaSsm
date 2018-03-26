package cn.yxxrui.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.yxxrui.dto.Pager;

public class PageMapUtil {

	public static Map<String, Object> getMapPage(int page,int rows ) {
		
		Pager pager=new Pager(page,rows);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pager.getStart());
        map.put("size", pager.getPageSize());
		return map;
		
	}
	
}
