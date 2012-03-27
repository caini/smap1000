package org.wekit.web.db.dao.impl;

import java.util.List;

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

	@Override
	protected Class<CodeRule> getEntityClass() {
		return CodeRule.class;
	}

	@Override
	public CodeRule getCodeRule(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CodeRule addCodeRule(CodeRule codeRule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCodeRule(CodeRule codeRule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCodeRule(CodeRule codeRule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCodeRule(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CodeRule> getAllCodeRules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CodeRule> getCodeRulesWidthPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

}
