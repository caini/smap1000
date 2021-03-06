package org.wekit.web.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.WekitException;
import org.wekit.web.db.Pagination;
import org.wekit.web.db.dao.CodeRuleDao;
import org.wekit.web.db.model.CodeRule;
import org.wekit.web.service.RuleService;
import org.wekit.web.util.DataWrapUtil;

/**
 * 编码规则逻辑服务实现
 * 
 * @author huangweili
 * 
 */
@Service("ruleService")
public class RuleServiceImpl implements RuleService {

	private static Logger	logger	= Logger.getLogger(RuleServiceImpl.class);

	@Autowired
	@Qualifier("codeRuleDao")
	private CodeRuleDao		codeRuleDao;

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
	public CodeRule getCodeRule(String ruleName,String coderule) {
		return this.codeRuleDao.getCodeRule(ruleName,coderule);
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

	@Transactional(readOnly = true)
	@Override
	public List<CodeRule> queryCodeRules(String key, int state, IPaginable paginable) {
		return this.codeRuleDao.queryCodeRules(key, state, paginable);
	}

	@Transactional(readOnly = true)
	@Override
	public List<String> queryCodeRuleNames(IPaginable paginable) {
		return this.codeRuleDao.queryCodeRuleNames(paginable);
	}

	@Transactional(readOnly = true)
	@Override
	public List<CodeRule> queryCodeRulesByName(String name, int state, IPaginable paginable) {
		return this.codeRuleDao.queryCodeRulesByName(name, state, paginable);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Override
	public boolean deleteCodeRule(long id, String creater, String createrid, String ip) throws Exception {
		CodeRule codeRule = codeRuleDao.getCodeRule(id);
		if (codeRuleDao.deleteCodeRule(codeRule)) {
			logger.info(creater + "(" + createrid + ")删除了编码规则 " + DataWrapUtil.ObjectToJson(codeRule));
			return true;
		}
		return false;
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public CodeRule addCodeRule(String ruleName, String creater, String createrid, long createTime, String rule, String face, int state, int minSequence, int maxSequence,long fileType,String fileTypeName,String mask) {
		CodeRule codeRule = new CodeRule(ruleName, creater, createrid, createTime, rule, face, state, minSequence, maxSequence,fileType,fileTypeName,mask);
		return this.codeRuleDao.addCodeRule(codeRule);
	}

	
	/**
	 * 更新
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public CodeRule updateCodeRule(long id, String rulename, String face, int state, int minSequence, int maxSequence) {
		CodeRule codeRule = this.codeRuleDao.getCodeRule(id);
		if (codeRule != null) {
			if (StringUtils.isNotEmpty(rulename))
				codeRule.setRuleName(rulename);
			if (StringUtils.isNotEmpty(face))
				codeRule.setFace(face);
			if (state != -1)
				codeRule.setState(state);
			if (minSequence != -1)
				codeRule.setMinSequence(minSequence);
			if (maxSequence != -1)
				codeRule.setMaxSequence(maxSequence);
			if (this.codeRuleDao.updateCodeRule(codeRule))
				return codeRule;
			else
				throw new WekitException("更新");
		}
		return null;
	}

}
