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
import org.wekit.web.db.dao.LocationCodeDao;
import org.wekit.web.db.model.LocationCode;
import org.wekit.web.service.LocationCodeService;
import org.wekit.web.util.DataWrapUtil;

@Service("locationCodeService")
public class LocationCodeServiceImpl implements LocationCodeService{

	private static Logger logger=Logger.getLogger(LocationCodeServiceImpl.class);
	
	@Autowired
	@Qualifier("locationCodeDao")
	private LocationCodeDao locationCodeDao;

	public LocationCodeDao getLocationCodeDao() {
		return locationCodeDao;
	}

	public void setLocationCodeDao(LocationCodeDao locationCodeDao) {
		this.locationCodeDao = locationCodeDao;
	}

	@Transactional(readOnly=true)
	@Override
	public LocationCode getLocationCode(long id) {
		return this.locationCodeDao.getLocationCode(id);
	}

	@Transactional(readOnly=true)
	@Override
	public LocationCode getLocationCode(String code) {
		return this.locationCodeDao.getLocationCode(code);
	}

	@Transactional(readOnly=true)
	@Override
	public List<LocationCode> getAllLocationCodes() {
		return this.locationCodeDao.getAllLocationCodes();
	}

	@Transactional(readOnly=true)
	@Override
	public List<LocationCode> queryLocationCodes(IPaginable paginable) {
		if(paginable==null)
			return this.locationCodeDao.getAllLocationCodes();
		else
			return this.locationCodeDao.getLocationCodesWithPagination(paginable);
	}

	@Transactional(readOnly=true)
	@Override
	public List<LocationCode> queryLocationCodes(String key, long typeId, int state, IPaginable paginable) {
		return this.locationCodeDao.queryLocationCodes(key, typeId, state, paginable);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean deleteLocationCode(Long key, String creatername, String createrId, String ip) throws Exception {
		LocationCode code=this.locationCodeDao.getLocationCode(key);
		if(code!=null){
			if(locationCodeDao.deleteLocationCode(code)){
				logger.info(creatername+"("+createrId+"-- ip:"+ip+") 删除定位码信息:"+DataWrapUtil.ObjectToJson(code));
			}else{
				throw new WekitException("删除定位码信息失败!");
			}
		}
		return true;
	}
}
