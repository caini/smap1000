package org.wekit.web.db.dao.impl;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.LocationCodeDao;
import org.wekit.web.db.model.LocationCode;

public class LocationCodeDaoImpl extends HibernateBaseDao<LocationCode, Long> implements LocationCodeDao {

	@Override
	protected Class<LocationCode> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
