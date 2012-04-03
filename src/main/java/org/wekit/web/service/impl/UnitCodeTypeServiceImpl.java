package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.UnitCodeTypeDao;
import org.wekit.web.db.model.UnitCodeType;
import org.wekit.web.service.UnitCodeTypeService;

@Service("unitCodeTypeService")
public class UnitCodeTypeServiceImpl implements UnitCodeTypeService {

	@Autowired
	@Qualifier("unitCodeTypeDao")
	private UnitCodeTypeDao unitCodeTypeDao;
	
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
	
}
