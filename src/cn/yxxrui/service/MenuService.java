package cn.yxxrui.service;

import java.util.List;

import cn.yxxrui.dto.AuthorityMenuTitle;

public interface MenuService {

	public List<AuthorityMenuTitle> getMenuMessage(String ids);
}
