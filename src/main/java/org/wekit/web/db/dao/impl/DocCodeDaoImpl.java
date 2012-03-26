package org.wekit.web.db.dao.impl;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.DocCodeDao;
import org.wekit.web.db.model.DocCode;

public class DocCodeDaoImpl extends HibernateBaseDao<DocCode, Long> implements DocCodeDao{

	@Override
	protected Class<DocCode> getEntityClass() {
		// TODO Auto-generated method stub
		return DocCode.class;
	}

	
}
