package org.wekit.web.outservice;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.web.BaseController;
import org.wekit.web.db.model.Admin;
import org.wekit.web.service.AdminService;
import org.wekit.web.service.BaseDataService;

@Controller("adminServiceController")
public class AdminServiceController extends BaseController<Admin> {

	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	@RequestMapping(value="/security/admin/query.{extend}",method=RequestMethod.GET)
	public String queryAdmin(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		return null;
	}

	@RequestMapping(value="/security/admin/add.{extend}")
	public String addAdmin(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		
		return null;
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
