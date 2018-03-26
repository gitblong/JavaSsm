package cn.yxxrui.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yxxrui.dto.AccountInformation;
import cn.yxxrui.dto.AuthorityMenuTitle;
import cn.yxxrui.model.User;
import cn.yxxrui.model.Zone;
import cn.yxxrui.service.AccountService;
import cn.yxxrui.service.AdminService;
import cn.yxxrui.service.ZoneService;
import cn.yxxrui.service.imp.MenuService;

@Controller //放入Spring容器中
@RequestMapping("/admin") 
public class AdminControl {
	
	@Resource
	private AdminService adminService;
	
	@Resource 
	AccountService accountService;
	
	@Resource
	MenuService menuService;
	
	@Resource
	ZoneService zoneService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,Model model,HttpServletRequest request) throws Exception{
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		user = adminService.checkLogin(name, password,request);
		System.out.println("user"+user);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			model.addAttribute("user",user);
			String ids = adminService.selectRoleAuthByUserName(name);
			request.getSession().setAttribute("ids", ids);
			List<AuthorityMenuTitle> authMenuList = menuService.getMenuMessage(ids);
			System.out.println("-------authMenuList-----------"+authMenuList);
			model.addAttribute("authMenuList", authMenuList);
			System.out.println("control" + user.getUserName());
			return "main";//路劲 WEB-INF/jsp/login.jsp
		}
		return "login2";
		
	}
	
	@RequestMapping(value="/password")
	public String changePassword(){
		
		return "password";
	}
	
	
	@RequestMapping(value="accountManger")
	public String accountManger(){
		System.out.println("到这里了吗？");
		return "accountManger";
	}
	

	@RequestMapping(value="role")
	public String role(){
		
		return "role";
	}
	@RequestMapping(value="assistantManager")
	public String assistant(Model model){
		List<Zone> zoneList = zoneService.getAllZone();
		System.out.println("-----zoneList----"+zoneList);
		model.addAttribute("zoneList", zoneList);
		return "assistantManager";
	}
	
	@RequestMapping(value="distinctManager")
	public String distinctManager(Model model){
		
		return "distinctManager";
	}
	
	@RequestMapping(value="tenant")
	public String tenant(){
		return "tenant";
	}
	
	@RequestMapping(value="landlord")
	public String landlord(Model model){
		List<Zone> zoneList = zoneService.getAllZone();
		System.out.println("-----zoneList----"+zoneList);
		model.addAttribute("zoneList", zoneList);
		return "landlord";
	}
}
