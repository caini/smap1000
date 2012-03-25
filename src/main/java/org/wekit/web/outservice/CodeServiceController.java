package org.wekit.web.outservice;

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
import org.wekit.web.service.CodeService;

@Controller("codeServiceController")
public class CodeServiceController extends BaseController {
    @Autowired
    @Qualifier("codeService")
	CodeService codeService;
	/**
	 * 查询已有编码
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/code/query.{extend}",method=RequestMethod.GET)
	public String queryCode(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		
		return "ftl/json";
	}
	
	
	/**
	 * 更新编码状态
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/code/update.{extend}",method=RequestMethod.POST)
	public String updateCode(@PathVariable("extned")String extend,Model model){
		return null;
	}
	
	/**
	 * 删除编码
	 * @param extend
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/code/delete.{extend}",method=RequestMethod.POST)
	public String deleteCode(@PathVariable("extend")String extend,Model model){
		return null;
	}
	
    /**
     * 根据编码返回编码信息
     * @param extend
     * @param model
     * @return
     */
    @RequestMapping(value="/code/find.{extend}",method=RequestMethod.GET)
	public String findCode(@PathVariable("extend")String extend,Model model){
		return null;
	}
    
    /**
     * 创建编码
     * @param extend
     * @param model
     * @return
     */
	@RequestMapping(value="/code/add.{extend}",method=RequestMethod.POST)
	public String addCode(@PathVariable("extend")String extend,Model model){
		return null;
	}

}
