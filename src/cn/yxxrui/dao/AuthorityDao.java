package cn.yxxrui.dao;

import java.util.List;
import java.util.Map;

import cn.yxxrui.dto.AuthorityMessage;
import cn.yxxrui.model.Authority;

public interface AuthorityDao {

	public List<Authority> getAuthorityInformationByIds(Map<String,Object> map);
	public List<Integer> getMenuId(Map<String,Object> map);
	public List<AuthorityMessage> getAuthorityMsgByMenuId(Map<String,Object> map);
}
