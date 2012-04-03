package org.wekit.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.db.dao.LocationCodeDao;
import org.wekit.web.service.LocationCodeService;

@Service("locationCodeService")
public class LocationCodeServiceImpl implements LocationCodeService{

	@Autowired
	@Qualifier("locationCodeDao")
	private LocationCodeDao locationCodeDao;

	public LocationCodeDao getLocationCodeDao() {
		return locationCodeDao;
	}

	public void setLocationCodeDao(LocationCodeDao locationCodeDao) {
		this.locationCodeDao = locationCodeDao;
	}
	
	
	
}
