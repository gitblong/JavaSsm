package cn.yxxrui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yxxrui.dto.AccountInformation;
import cn.yxxrui.dto.AddUserMessage;
import cn.yxxrui.dto.Exposer;
import cn.yxxrui.dto.PageResult;
import cn.yxxrui.dto.Pager;
import cn.yxxrui.dto.RoleAuthorityInfomation;
import cn.yxxrui.model.Result;
import cn.yxxrui.model.Role;
import cn.yxxrui.model.User;
import cn.yxxrui.service.AccountService;
import cn.yxxrui.service.AdminService;
import cn.yxxrui.service.RoleAuthorityService;

@Controller//放在Spring容器中
@RequestMapping("/main")
public class SystemControl {
	
	@Resource
	AdminService adminService;
	
	@Resource
	AccountService accountService;
	
	@Resource
	RoleAuthorityService roleAuthorityService;
	
	@RequestMapping("changePassword")
	public String changePassword(Model model,User user,Exposer exposer,HttpServletRequest request) throws Exception{
		
		user = (User) request.getSession().getAttribute("user");
		int update = adminService.checkChangePassword(user,exposer,request);
		if(update==1){
			return "success";
		}
		
		return "password";
	}
	
	@RequestMapping(value="/accInfoData")
	@ResponseBody
	public List<AccountInformation> accInfoData(){
		System.out.println("到这里了吗？");
		List<AccountInformation> accInfoData = accountService.getAllAccInfo(); 
		System.out.println("--------CollerAccountmANGER"+accInfoData+"---------");
		return accInfoData;
	}
	
	@RequestMapping(value="/delUser")
	@ResponseBody
	public Result delUser(int id){
		
		Result result;
		System.out.println("进来了？"+id);
		int delUser = accountService.delUserById(id);
		System.out.println("delUser"+delUser);
		if(delUser == 1){
			result = new Result(true,"删除成功");
		}else{
			result = new Result(true,"删除失败");
		}
		
		return result;
	}
	
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	@ResponseBody
	public int addUser(AddUserMessage addUser){
		
		int result;
		System.out.println("addUser进来了？"+addUser);
		int addSuccess = accountService.addUser(addUser);
		System.out.println("addUser"+addUser);
		if(addSuccess == 1){
			result = 1;
		}else{
			result = 0;
		}
		
		return result;
	}
	
	@RequestMapping(value="/roleAuthInfoData")
	@ResponseBody
	public Map<String,Object> roleAuthInfoData(@RequestParam(value="page",required=false) String page,
			@RequestParam(value="rows",required=false) String rows,
			Role role) {
		Pager pager=new Pager(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pager.getStart());
        map.put("size", pager.getPageSize());
		List<RoleAuthorityInfomation> roleAuthInfoList = roleAuthorityService.getAllRoleAndAuthority(map);
		Long total=roleAuthorityService.getTotal(map);
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("rows", roleAuthInfoList);
        result.put("total", total);
		return result;
	}
	
	@RequestMapping(value="/delRoleById")
	@ResponseBody
	public void delRoleById(HttpServletRequest request) {
		System.out.println("delRoleById-----------");
		int id = Integer.parseInt(request.getParameter("id"));
		roleAuthorityService.delRoleById(id);
		System.out.println("id-----" + id);
	}
	
	@RequestMapping(value="/addOrUpdateToRole")
	@ResponseBody
	public int addOrUpdateToRole(Role role){
		String roleName = role.getRoleName();
		String roleAuthority = role.getRoleAuthority();
		System.out.println("addOrUpdateToRole=-----roleName-"+roleName+"--roleAuthority--"+roleAuthority);
		int roleId = role.getId();
		System.out.println("roleId-----addOrUpdateToRole-----"+roleId);
		int result = 0;
		if(roleId == 0){
			System.out.println("roleId==|| roleId == null");
			result = roleAuthorityService.addRole(role);
		} else if(roleId>0){
			System.out.println("roleId ! = null");
			result = roleAuthorityService.updateRoleById(role);
		}
		return result;
	}
	
	@RequestMapping(value="/selectRoleById")
	@ResponseBody
	public Role selectRoleById(HttpServletRequest request,Model model){
		System.out.println("selectRoleById----------");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id-------"+ id);
		Role role = roleAuthorityService.selectRoleById(id);
		model.addAttribute("role", role);
		String result = role.getRoleAuthority();
		return role;
		
	}
	
	/**
     * 用户分页查询
     * @param page
     * @param rows
     * @param s_user
     * @param res
     * @return
     * @throws Exception
     */
    @RequestMapping("/pageAccInfoData")
    @ResponseBody
    public Map<String,Object> pageAccInfoData(@RequestParam(value="page",required=false) String page,
	@RequestParam(value="rows",required=false) String rows,
	User user) throws Exception{
        Pager pager=new Pager(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pager.getStart());
        map.put("size", pager.getPageSize());
        List<AccountInformation> acctInfoList=accountService.find(map);
        Long total=accountService.getTotal(map);
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("rows", acctInfoList);
        result.put("total", total);
        System.out.println("pageAccInfoData---------------------------");
//        JSONObject result=new JSONObject();
//        JSONArray jsonArray=JSONArray.fromObject(userList);
//        result.put("rows", jsonArray);
//        result.put("total", total);
//        ResponseUtil.write(res, result);
        return result;
    }
}
