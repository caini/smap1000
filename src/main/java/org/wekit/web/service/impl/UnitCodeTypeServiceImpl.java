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
import org.wekit.web.db.dao.UnitCodeTypeDao;
import org.wekit.web.db.model.UnitCodeType;
import org.wekit.web.service.UnitCodeTypeService;
import org.wekit.web.util.DataWrapUtil;

@Service("unitCodeTypeService")
public class UnitCodeTypeServiceImpl implements UnitCodeTypeService {

	@Autowired
	@Qualifier("unitCodeTypeDao")
	private UnitCodeTypeDao unitCodeTypeDao;
	
	private static Logger logger=Logger.getLogger(UnitCodeTypeServiceImpl.class);
	
	
	public UnitCodeTypeDao getUnitCodeTypeDao() {
		return unitCodeTypeDao;
	}

	public void setUnitCodeTypeDao(UnitCodeTypeDao unitCodeTypeDao) {
		this.unitCodeTypeDao = unitCodeTypeDao;
	}


	@Transactional(readOnly=true)
	@Override
	public List<UnitCodeType> getAllUnitCodeTypes(IPaginable paginable) {
		if(paginable==null)
			return this.unitCodeTypeDao.getAllUnitCodeTypes();
		else
			return this.unitCodeTypeDao.getUnitCodeTypesWithPagination(paginable);
	}

	@Transactional(readOnly=true)
	@Override
	public List<UnitCodeType> queryUnitCodeTypes(String key, int state, IPaginable paginable) {
		List<UnitCodeType> list= this.unitCodeTypeDao.queryUnitCodeTypes(key, state, paginable);
		return list;
	}
	

	@Transactional(readOnly=true)
	@Override
	public UnitCodeType getUnitCodeType(long id) {
		return this.unitCodeTypeDao.getUnitCodeType(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean deleteUnitCodeType(long id, String creatername, String createrId, String ip) throws Exception {
		UnitCodeType unitCodeType=this.unitCodeTypeDao.getUnitCodeType(id);
		if(unitCodeType!=null){
			if(this.unitCodeTypeDao.deleteUnitCodeType(unitCodeType)){
				logger.info(creatername+"("+createrId+"-- ip:"+ip+") 删除机组码的分类信息:"+DataWrapUtil.ObjectToJson(unitCodeType));
			}else
			{
				throw new WekitException("删除机组码分类信息失败!");
			}
		}
		return true;
	}
	
	
}
