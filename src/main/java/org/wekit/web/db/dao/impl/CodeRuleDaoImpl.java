package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.CodeRuleDao;
import org.wekit.web.db.model.CodeRule;

/**
 * 编码规则存储访问类
 * 
 * @author huangweili
 * 
 */
@Repository("codeRuleDao")
public class CodeRuleDaoImpl extends HibernateBaseDao<CodeRule, Long> implements CodeRuleDao {

	private static Logger	logger	= Logger.getLogger(CodeRuleDaoImpl.class);

	@Override
	protected Class<CodeRule> getEntityClass() {
		return CodeRule.class;
	}

	@Override
	public CodeRule getCodeRule(long id) {
		return this.get(id);
	}

	@Override
	public CodeRule addCodeRule(CodeRule codeRule) {
		return this.save(codeRule);
	}

	@Override
	public boolean updateCodeRule(CodeRule codeRule) {
		try {
			this.update(codeRule);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCodeRule(CodeRule codeRule) {
		try {
			this.delete(codeRule);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCodeRule(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<CodeRule> getAllCodeRules() {
		return this.getAll();
	}

	@Override
	public List<CodeRule> getCodeRulesWidthPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

	@Override
	public CodeRule getCodeRule(String codeRule) {
		List<CodeRule> codeRules = this.queryByProperty("rule", codeRule);
		if (codeRule != null) {
			return codeRules.get(0);
		}
		return null;
	}

}
