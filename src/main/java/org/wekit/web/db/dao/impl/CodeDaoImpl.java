package org.wekit.web.db.dao.impl;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.CodeDao;
import org.wekit.web.db.model.Code;

public class CodeDaoImpl extends HibernateBaseDao<Code,Long> implements CodeDao {

	@Override
	protected Class<Code> getEntityClass() {
		return Code.class;
	}

	
}
