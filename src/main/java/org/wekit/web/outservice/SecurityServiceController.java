package org.wekit.web.outservice;

import java.util.List;

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
import org.wekit.web.service.BaseDataService;

@Controller("securityServiceController")
public class SecurityServiceController extends BaseController {
	
	@Autowired
	@Qualifier("baseDataService")
	private BaseDataService baseDataService;
	
	
	
	
	
	@RequestMapping(value="/security/admin/query.{extend}",method=RequestMethod.GET)
	public String queryAdmin(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		int pageno=0;
		int pagesize=0;
		if(request.getParameter("pageno")!=null)
		{
			pageno=Integer.parseInt(request.getParameter("pageno"));
		}
		if(request.getParameter("pagesize")!=null){
			
		}
	    List<Admin> admins=baseDataService.getAllAdmin();
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
	
	
	

	public BaseDataService getBaseDataService() {
		return baseDataService;
	}


	public void setBaseDataService(BaseDataService baseDataService) {
		this.baseDataService = baseDataService;
	}
	
	
	
}
