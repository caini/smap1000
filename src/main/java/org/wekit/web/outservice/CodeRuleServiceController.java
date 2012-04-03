package org.wekit.web.outservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.web.BaseController;
import org.wekit.web.db.model.CodeRule;
import org.wekit.web.service.RuleService;

/**
 * 编码规则服务接口
 * @author huangweili
 *
 */
@Controller("codeRuleServiceController")
public class CodeRuleServiceController extends BaseController<CodeRule> {

	private static Logger logger=Logger.getLogger(CodeRuleServiceController.class);
	
	@Autowired
	@Qualifier("ruleService")
	private RuleService ruleService;
	
	@RequestMapping(value="/coderule/query.{extend}",method=RequestMethod.GET)
	public String queryCodeRule(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		initParam(request);
		
		return displayAPIClient(extend, model);
	}
	
	
	@RequestMapping(value="/coderule/update.{extend}",method=RequestMethod.POST)
	public String updateCodeRule(@PathVariable("extend")String extend,Model model){
		//TODO
		return null;
	}
	
	@RequestMapping(value="/coderule/delete.{extend}",method=RequestMethod.POST)
	public String deleteCodeRule(@PathVariable("extend")String extend,Model model){
		//TODO
		return null;
	}
	
	@RequestMapping(value="/coderule/find.{extend}",method=RequestMethod.POST)
	public String findCodeRule(@PathVariable("extend")String extend,Model model){
		//TODO
		return null;
	}
	
	@RequestMapping(value="/coderule/add.{extend}",method=RequestMethod.POST)
	public String addCodeRule(@PathVariable("extend")String extend,Model model){
		//TODO
		return null;
	}

	

	public RuleService getRuleService() {
		return ruleService;
	}


	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}

}
