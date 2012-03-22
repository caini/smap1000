package org.wekit.web.db.dao.impl;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.ExtendCodeDao;
import org.wekit.web.db.model.ExtendCode;

/**
 * 无规则编码申请
 * @author HuangWeili
 *
 */
public class ExtendCodeDaoImpl extends HibernateBaseDao<ExtendCode,Long> implements ExtendCodeDao {

	@Override
	protected Class<ExtendCode> getEntityClass() {
		return ExtendCode.class;
	}

	
	
}
