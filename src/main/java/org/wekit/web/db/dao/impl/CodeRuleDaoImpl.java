package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.WekitException;
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
	public CodeRule getCodeRule(String ruleName,String codeRule) {
		if(StringUtils.isEmpty(ruleName)||StringUtils.isEmpty(codeRule)){
			throw new WekitException("ruleName和coderule都不能为空!");
		}
		StringBuffer buffer=new StringBuffer("from CodeRule bean where 1=1");
		buffer.append(" and bean.ruleName=:ruleName");
		buffer.append(" and bean.rule=:rule");
		Query query=this.createrQuery(buffer.toString());
		query.setString("ruleName",ruleName);
		query.setString("rule", codeRule);
		@SuppressWarnings("unchecked")
		List<CodeRule> codeRules = query.list();
		if(codeRules != null&&codeRules.size()>1){
			throw new WekitException("编码规则名称和编码规则不能确定唯一对应值!");
		}
		if (codeRules != null&&codeRules.size()>0) {
			return codeRules.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeRule> queryCodeRules(String key, int state, IPaginable paginable) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from CodeRule bean where 1=1 ");
		if (StringUtils.isNotEmpty(key)) {
			buffer.append(" and bean.rule like '%" + key + "%' ");
		}
		if (state >= 0) {
			buffer.append(" and bean.state=" + state);
		}
		Query query = createrQuery(buffer.toString());
		if (paginable != null) {
			this.paginationParam(query, paginable);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeRule> queryCodeRulesByName(String name, int state, IPaginable paginable) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from CodeRule bean where 1=1 ");
		if (StringUtils.isNotEmpty(name)) {
			buffer.append(" and bean.ruleName like '%" + name + "%' ");
		}
		if (state >= 0) {
			buffer.append(" and bean.state=" + state);
		}
		Query query = createrQuery(buffer.toString());
		if (paginable != null) {
			this.paginationParam(query, paginable);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryCodeRuleNames(IPaginable paginable) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select distinct bean.ruleName from CodeRule bean");
		Query query = createrQuery(buffer.toString());
		if (paginable != null) {
			this.paginationParam(query, paginable);
		}
		return query.list();
	}

}
