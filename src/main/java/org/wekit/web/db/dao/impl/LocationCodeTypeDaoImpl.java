package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.LocationCodeTypeDao;
import org.wekit.web.db.model.LocationCodeType;
/**
 * 定位码类型访问实现
 * @author HuangWeili
 *
 */
@Repository("locationCodeTypeDao")
public class LocationCodeTypeDaoImpl  extends HibernateBaseDao<LocationCodeType, Long> implements LocationCodeTypeDao{

	@Override
	protected Class<LocationCodeType> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationCodeType addLocationCodeType(LocationCodeType locationCodeType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationCodeType getLocationCodeType(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteLocationCodeType(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLocationCodeType(LocationCodeType locationCodeType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLocationCodeType(LocationCodeType locationCodeType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LocationCodeType> getAllLocationCodeTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LocationCodeType> getLocationCodeTypesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
