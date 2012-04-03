package org.wekit.web.outservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.web.BaseController;
import org.wekit.web.db.model.DocCode;

@Controller("docCodeServiceController")
public class DocCodeServiceController extends BaseController<DocCode> {

	/**
	 * 查询文档类型编码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/query.{extend}", method = RequestMethod.GET)
	public String queryDocCode(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		//TODO
		return null;
	}

	/**
	 * 更新文旦类型编码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/update.{extend}", method = RequestMethod.POST)
	public String updateDocCode(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		//TODO
		return null;
	}

	/**
	 * 添加文件类型编码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/add.{extend}", method = RequestMethod.POST)
	public String addDocCode(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		//TODO
		return null;
	}

	/**
	 * 获取编码详细状态
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/find.{extend}", method = RequestMethod.GET)
	public String findDocCode(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		//TODO
		return null;
	}

	@RequestMapping(value = "/doccode/delete.{extend}", method = RequestMethod.POST)
	public String deleteDocCode(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		//TODO
		return null;
	}

	
}
