package org.wekit.web.outservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wekit.web.BaseController;
import org.wekit.web.db.model.RemoteAcl;

@Controller("remoteAclServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class RemoteAclServiceController extends BaseController<RemoteAcl> {
	
	private static Logger	logger	= Logger.getLogger(RemoteAclServiceController.class);
	
	/**
	 * 更新无规则编码接口
	 * @param extend
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/remote/update.{extend}")
	public String updateCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try{
		initParam(request,"更新远程用户");
		//TODO
		}catch(Exception ex){
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}
	
	
	@RequestMapping(value = "/remote/add.{extend}")
	public String addCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try{
		initParam(request,"增加远程用户");
		//TODO
		}catch(Exception ex){
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}
	
	@RequestMapping(value = "/remote/delete.{extend}")
	public String deleteCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try{
		initParam(request,"删除远程用户");
		//TODO
		}catch(Exception ex){
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}
	
	
	@RequestMapping(value = "/remote/query.{extend}")
	public String queryCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try{
		initParam(request,"查询远程用户");
		//TODO
		}catch(Exception ex){
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}
}
