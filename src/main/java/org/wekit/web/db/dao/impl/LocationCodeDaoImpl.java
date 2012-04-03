package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.LocationCodeDao;
import org.wekit.web.db.model.LocationCode;

@Repository("locationCodeDao")
public class LocationCodeDaoImpl extends HibernateBaseDao<LocationCode, Long> implements LocationCodeDao {

	private static Logger	logger	= Logger.getLogger(LocationCodeDaoImpl.class);

	@Override
	protected Class<LocationCode> getEntityClass() {
		return LocationCode.class;
	}

	@Override
	public LocationCode addLocationCode(LocationCode locationCode) {
		return this.save(locationCode);
	}

	@Override
	public LocationCode getLocationCode(long id) {
		return this.get(id);
	}

	@Override
	public boolean deleteLocationCode(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteLocationCode(LocationCode locationCode) {
		try {
			this.delete(locationCode);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateLocationCode(LocationCode locationCode) {
		try {
			this.update(locationCode);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<LocationCode> getAllLocationCodes() {
		return this.getAll();
	}

	@Override
	public List<LocationCode> getLocationCodesWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

}
