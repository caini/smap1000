package org.wekit.web.outservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import org.wekit.web.WekitException;
import org.wekit.web.db.model.CodeRule;
import org.wekit.web.service.RuleService;

/**
 * 编码规则服务接口
 * 
 * @author huangweili
 * 
 */
@Controller("codeRuleServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class CodeRuleServiceController extends BaseController<CodeRule> {

	private static Logger	logger	= Logger.getLogger(CodeRuleServiceController.class);

	@Autowired
	@Qualifier("ruleService")
	private RuleService		ruleService;

	/**
	 * 根据传入的关键字信息获取规则编码
	 * 
	 * @param extend
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/coderule/query.{extend}")
	public String queryCodeRule(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key)) {
				throw new WekitException("key参数不能为空!");
			}
			List<CodeRule> codeRules = ruleService.queryCodeRules(key, 1, this.pagination);
			this.pagination.setDatas(codeRules);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			pagination.setState(0);
			pagination.setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/coderule/delete.{extend}")
	public String deleteCodeRule(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key)) {
				throw new WekitException("key参数的值不能为空!");
			}
			this.ruleService.deleteCodeRule(Long.parseLong(key), creatername, createrid, ip);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/coderule/find.{extend}")
	public String findCodeRule(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key)) {
				throw new WekitException("key的参数不能为空!");
			}
			CodeRule codeRule = ruleService.getCodeRule(Long.parseLong(key));
			this.addData(codeRule);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			this.setState(0);
			this.setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	/**
	 * 根据规则的名称获取所有名称下的规则信息
	 * 
	 * @param extend
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/coderule/querybyname.{extend}")
	public String querybyname(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key)) {
				throw new WekitException("key参数不能为空!");
			}

			List<CodeRule> codeRules = this.ruleService.queryCodeRulesByName(key, 1, this.pagination);
			setDatas(codeRules);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}
	
	

	@RequestMapping(value = "/coderule/add.{extend}")
	public String addCodeRule(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try{
		initParam(request);
		//TODO
		}catch(Exception ex){
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}
	
	@RequestMapping(value = "/coderule/update.{extend}")
	public String updateCodeRule(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try{
		initParam(request);
		
		
		}catch(Exception ex){
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	public RuleService getRuleService() {
		return ruleService;
	}

	public void setRuleService(RuleService ruleService) {
		this.ruleService = ruleService;
	}

}
