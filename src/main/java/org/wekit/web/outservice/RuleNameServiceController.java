package org.wekit.web.outservice;

import java.util.List;

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
import org.wekit.web.service.RuleService;

/**
 * 获取所有编码规则的名称的类
 * @author HuangWeili
 *
 */
@Controller("ruleNamesServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class RuleNameServiceController extends BaseController<String> {

	private static Logger	logger	= Logger.getLogger(RuleNameServiceController.class);

	@Autowired
	@Qualifier
	private RuleService		ruleService;

	public RuleService getRuleService() {
		return ruleService;
	}

	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}

	/**
	 * 获取所有的规则的名称
	 * 
	 * @param extend
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/coderule/names.{extend}", method = RequestMethod.POST)
	public String ruleNames(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request,"查询编码规则名称");
			List<String> ruleNames = ruleService.queryCodeRuleNames(this.pagination);
			setDatas(ruleNames);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	
}
