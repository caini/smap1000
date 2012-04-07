package org.wekit.web.outservice;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.web.BaseController;
import org.wekit.web.db.model.Admin;
import org.wekit.web.service.AdminService;
/**
 * 
 * @author HuangWeili
 *
 */
@Controller("adminServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class AdminServiceController extends BaseController<Admin> {

	private static Logger logger=Logger.getLogger(AdminServiceController.class);
	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	@RequestMapping(value="/security/admin/query.{extend}",method=RequestMethod.GET)
	public String queryAdmin(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		return null;
	}

	@RequestMapping(value="/security/admin/add.{extend}")
	public String addAdmin(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		initParam(request);
		try{
			String userName=null;
			String displayName=null;
			String password=null;
			if(parameters.containsKey("username")){
				userName=parameters.get("username");
			}
			if(parameters.containsKey("displayname")){
				displayName=parameters.get("displayname");
			}
			if(parameters.containsKey("password")){
				password=parameters.get("password");
			}
			Admin admin=new Admin(userName, displayName, password, System.currentTimeMillis(),0,"127.0.0.1");
			this.adminService.saveAdmin(admin);
			this.addData(admin);
		}catch (Exception e) {
		 logger.error(e.getMessage());
		 pagination.setState(0);
		 pagination.setMessage(e.getMessage());
		}
		
		return this.displayAPIClient(extend, model);
	}

	@RequestMapping(value="/security/admin/delete.{extend}")
	public String deleteAdmin(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
	
		return null;
	}
	
	@RequestMapping(value="/security/admin/update.{extend}")
	public String updateAdmin(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Mode mode){
		return null;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
}
