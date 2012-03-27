package org.wekit.web.db.dao.impl;

import java.util.List;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.LocationCodeDao;
import org.wekit.web.db.model.LocationCode;

public class LocationCodeDaoImpl extends HibernateBaseDao<LocationCode, Long> implements LocationCodeDao {

	@Override
	protected Class<LocationCode> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationCode addLocationCode(LocationCode locationCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationCode getLocationCode(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteLocationCode(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLocationCode(LocationCode locationCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLocationCode(LocationCode locationCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LocationCode> getAllLocationCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocationCode> getLocationCodesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
