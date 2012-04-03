package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.LocationCodeTypeDao;
import org.wekit.web.db.model.LocationCodeType;
import org.wekit.web.service.LocationCodeTypeService;

@Service("locationCodeTypeService")
public class LocationCodeTypeServiceImpl implements LocationCodeTypeService {

	@Autowired
	@Qualifier("locationCodeTypeDao")
	private LocationCodeTypeDao	locationCodeTypeDao;

	public LocationCodeTypeDao getLocationCodeTypeDao() {
		return locationCodeTypeDao;
	}

	public void setLocationCodeTypeDao(LocationCodeTypeDao locationCodeTypeDao) {
		this.locationCodeTypeDao = locationCodeTypeDao;
	}

	@Transactional(readOnly = true)
	@Override
	public List<LocationCodeType> queryLocationCodeTypes(IPaginable paginable) {
		if (paginable != null)
			return locationCodeTypeDao.getLocationCodeTypesWithPagination(paginable);
		else
			return locationCodeTypeDao.getAllLocationCodeTypes();
	}

	@Transactional(readOnly = true)
	@Override
	public List<LocationCodeType> getAllCodeTypes() {
		return locationCodeTypeDao.getAllLocationCodeTypes();
	}

	@Transactional(readOnly = true)
	@Override
	public LocationCodeType getCodeType(long id) {
		return this.locationCodeTypeDao.getLocationCodeType(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<LocationCodeType> queryLocationCodeTypes(String key, int state, IPaginable paginable) {
		return this.locationCodeTypeDao.queryLocationCodeTypes(key, state, paginable);
	}

}
