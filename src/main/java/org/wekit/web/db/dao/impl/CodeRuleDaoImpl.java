package org.wekit.web.db.dao.impl;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.CodeRuleDao;
import org.wekit.web.db.model.CodeRule;
/**
 * 编码规则存储访问类
 * @author huangweili
 *
 */
public class CodeRuleDaoImpl extends HibernateBaseDao<CodeRule,Long> implements CodeRuleDao{

	@Override
	protected Class<CodeRule> getEntityClass() {
		return CodeRule.class;
	}
	
}
