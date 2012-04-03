package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
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

	@Override
	public LocationCode getLocationCode(String code) {
		List<LocationCode> list = queryByProperty("code", code);
		if (list != null) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LocationCode> queryLocationCodes(String key, long typeId, int state, IPaginable paginable) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from LocationCode bean where 1=1 ");
		if (StringUtils.isNotEmpty(key)) {
			buffer.append(" and (bean.code like '%" + key + "%' or bean.name like '%" + key + "%') ");
		}
		if (typeId >= 0) {
			buffer.append(" and bean.typeId=" + typeId);
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

}
