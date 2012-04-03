package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.db.Pagination;
import org.wekit.web.db.dao.CodeRuleDao;
import org.wekit.web.db.model.CodeRule;
import org.wekit.web.service.RuleService;

/**
 * 编码规则逻辑服务实现
 * 
 * @author huangweili
 * 
 */
@Service("ruleService")
public class RuleServiceImpl implements RuleService {

	@Autowired
	@Qualifier("codeRuleDao")
	private CodeRuleDao	codeRuleDao;

	public CodeRuleDao getCodeRuleDao() {
		return codeRuleDao;
	}

	public void setCodeRuleDao(CodeRuleDao codeRuleDao) {
		this.codeRuleDao = codeRuleDao;
	}

	@Transactional(readOnly = true)
	@Override
	public CodeRule getCodeRule(long id) {
		return codeRuleDao.getCodeRule(id);
	}

	@Transactional(readOnly = true)
	@Override
	public CodeRule getCodeRule(String coderule) {
		return this.codeRuleDao.getCodeRule(coderule);
	}

	@Transactional(readOnly = true)
	@Override
	public List<CodeRule> getAllCodeRules() {
		return this.codeRuleDao.getAllCodeRules();
	}

	@Transactional(readOnly = true)
	@Override
	public List<CodeRule> queryCodeRules(int currentPage, int pagesize, boolean isCount) {
		Pagination<CodeRule> paginable = new Pagination<CodeRule>(currentPage, pagesize, isCount);
		List<CodeRule> list = this.codeRuleDao.getCodeRulesWidthPagination(paginable);
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<CodeRule> queryCodeRules(IPaginable paginable) {
		if (paginable == null)
			return this.codeRuleDao.getAllCodeRules();
		else
			return this.codeRuleDao.getCodeRulesWidthPagination(paginable);
	}

	@Override
	public List<CodeRule> queryCodeRules(String key, int state, IPaginable paginable) {
		return this.codeRuleDao.queryCodeRules(key, state, paginable);
	}

	@Override
	public List<String> queryCodeRuleNames(IPaginable paginable) {
		return this.codeRuleDao.queryCodeRuleNames(paginable);
	}

	@Override
	public List<CodeRule> queryCodeRulesByName(String name,int state, IPaginable paginable) {
		return this.codeRuleDao.queryCodeRulesByName(name, state, paginable);		
	}

	
}
