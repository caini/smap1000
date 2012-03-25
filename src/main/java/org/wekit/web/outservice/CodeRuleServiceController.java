package org.wekit.web.outservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.web.BaseController;

/**
 * 编码规则服务接口
 * @author huangweili
 *
 */
@Controller("codeRuleServiceController")
public class CodeRuleServiceController extends BaseController {

	@RequestMapping(value="/coderule/query.{extend}",method=RequestMethod.GET)
	public String queryCodeRule(@PathVariable("extend")String extend,Model model){
		return null;
	}
	
	
	@RequestMapping(value="/coderule/update.{extend}",method=RequestMethod.POST)
	public String updateCodeRule(@PathVariable("extend")String extend,Model model){
		return null;
	}
	
	@RequestMapping(value="/coderule/delete.{extend}",method=RequestMethod.POST)
	public String deleteCodeRule(@PathVariable("extend")String extend,Model model){
		return null;
	}
	
	@RequestMapping(value="/coderule/find.{extend}",method=RequestMethod.POST)
	public String findCodeRule(@PathVariable("extend")String extend,Model model){
		return null;
	}
	
	@RequestMapping(value="/coderule/add.{extend}",method=RequestMethod.POST)
	public String addCodeRule(@PathVariable("extend")String extend,Model model){
		return null;
	}
}
