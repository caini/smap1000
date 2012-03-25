package org.wekit.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 动作函数的基础类，定义了一些常用的方法
 * 
 * @author HuangWeili
 * 
 */
public abstract class BaseController {

	/**
	 * 获取分页信息
	 * 
	 * @param request
	 * @return
	 */
	protected static IPaginable paserPaginable(HttpServletRequest request) {
		SimplePagination simplePagination = new SimplePagination();
		if (request.getParameter("pageno") != null) {
			simplePagination.setCurrentPage(Integer.parseInt(request.getParameter("pageno")));
		}
		if (request.getParameter("pagesize") != null) {
			simplePagination.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		}
		return simplePagination;
	}

	/**
	 * 获取传过来的参数
	 * 
	 * @param request
	 * @return
	 */
	protected static Map<String, String> getParam(HttpServletRequest request) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		if (request.getParameter("param") != null) {
			String param = request.getParameter("param");
			String[] params = param.split("&");
			for (String pm : params) {
				String[] keyValue = pm.split("=");
				if (keyValue != null && keyValue.length == 2) {
					hashMap.put(keyValue[0], keyValue[1]);
				}
			}
		}
		return hashMap;
	}
	
	

}
