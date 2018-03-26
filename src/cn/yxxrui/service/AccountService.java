package cn.yxxrui.service;

import java.util.List;
import java.util.Map;

import cn.yxxrui.dto.AccountInformation;
import cn.yxxrui.dto.AddUserMessage;
import cn.yxxrui.model.User;

public interface AccountService {

	//得到用户所有信息未分页
	public List<AccountInformation> getAllAccInfo();
	
	//删除用户
	public int delUserById(int id);
	
	//添加用户
	public int addUser(AddUserMessage user);
	
    /**
     * 用户查询
     * @param map
     * @return
     */
    public List<AccountInformation> find(Map<String, Object> map);
    
    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String, Object> map);
    
}
