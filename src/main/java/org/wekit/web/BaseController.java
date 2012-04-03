package org.wekit.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.wekit.web.db.Pagination;
import org.wekit.web.db.model.RemoteAcl;
import org.wekit.web.service.RemoteAclService;
import org.wekit.web.util.DataWrapUtil;

/**
 * 动作函数的基础类，定义了一些常用的方法
 * 
 * @author HuangWeili
 * 
 */
public abstract class BaseController<T> {

	@Autowired
	@Qualifier("remoteAclService")
	protected RemoteAclService remoteAclService; //注入远程访问接口
	
	protected Pagination<T> pagination=new Pagination<T>();
	protected Map<String, String> parameters=new HashMap<String, String>();
	/**
	 * 获取分页信息
	 * 
	 * @param request
	 * @return
	 */
	protected  void paserPaginable(HttpServletRequest request) {
		if (request.getParameter("pageno") != null) {
			this.pagination.setCurrentPage(Integer.parseInt(request.getParameter("pageno")));
		}
		if (request.getParameter("pagesize") != null) {
			this.pagination.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		}
	}

	/**
	 * 获取传过来的参数
	 * 
	 * @param request
	 * @return
	 */
	protected void initParam(HttpServletRequest request) {
		if(request.getParameter("userkey")==null)
			return;
		String userkey=request.getParameter("userkey");
		RemoteAcl acl=remoteAclService.getRemoteAclByUserName(userkey);
		if(acl==null){
			return;
		}
		
		if (request.getParameter("param") != null) {
			String param = request.getParameter("param");
			//param=
			String[] params = param.split("&");
			for (String pm : params) {
				String[] keyValue = pm.split("=");
				if (keyValue != null && keyValue.length == 2) {
					parameters.put(keyValue[0], keyValue[1]);
				}
			}
		}
	}
	
	
	
	protected void setState(int state){
		this.pagination.setState(state);
	}
	
	protected void setMessage(String message){
		this.pagination.setMessage(message);
	}
	
	
	protected String displayAPIClient(String extend,Model model){
		try {
			model.addAttribute("content",DataWrapUtil.convertObject(pagination, extend));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ftl/"+extend;
	}
	
}
