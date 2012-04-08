package org.wekit.web.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.WekitException;
import org.wekit.web.db.dao.LocationCodeTypeDao;
import org.wekit.web.db.model.LocationCodeType;
import org.wekit.web.service.LocationCodeTypeService;
import org.wekit.web.util.DataWrapUtil;

@Service("locationCodeTypeService")
public class LocationCodeTypeServiceImpl implements LocationCodeTypeService {

	@Autowired
	@Qualifier("locationCodeTypeDao")
	private LocationCodeTypeDao	locationCodeTypeDao;
	
	private static Logger logger=Logger.getLogger(LocationCodeTypeServiceImpl.class);

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

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean deleteLocationType(long id, String createrName, String createrId, String ip) throws Exception{
		LocationCodeType locationCodeType=locationCodeTypeDao.getLocationCodeType(id);
		if(locationCodeType!=null){
			if(this.locationCodeTypeDao.deleteLocationCodeType(locationCodeType)){
				logger.info(createrName+"("+createrId+"-- ip:"+ip+") 删除定位码的类型的信息:"+DataWrapUtil.ObjectToJson(locationCodeType));
			}else{
				throw new WekitException("删除定位码的类型失败!");
			}
		}
		return true;
	}

}
