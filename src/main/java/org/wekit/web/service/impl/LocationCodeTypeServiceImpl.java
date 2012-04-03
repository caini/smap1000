package org.wekit.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.db.dao.LocationCodeTypeDao;
import org.wekit.web.service.LocationCodeTypeService;

@Service("locationCodeTypeService")
public class LocationCodeTypeServiceImpl implements LocationCodeTypeService {

	@Autowired
	@Qualifier("locationCodeTypeDao")
	private LocationCodeTypeDao locationCodeTypeDao;

	public LocationCodeTypeDao getLocationCodeTypeDao() {
		return locationCodeTypeDao;
	}

	public void setLocationCodeTypeDao(LocationCodeTypeDao locationCodeTypeDao) {
		this.locationCodeTypeDao = locationCodeTypeDao;
	}
	
	
	
}
