package org.wekit.web.db.dao.impl;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.RuleTypeDao;
import org.wekit.web.db.model.RuleType;

@Repository("ruleTypeDao")
public class RuleTypeDaoImpl extends HibernateBaseDao<RuleType, Long> implements RuleTypeDao {

	@Override
	public RuleType getRuleType(long id) {
		return this.get(id);
	}

	@Override
	protected Class<RuleType> getEntityClass() {
		return RuleType.class;
	}
 
}
