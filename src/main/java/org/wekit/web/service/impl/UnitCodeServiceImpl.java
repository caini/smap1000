package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.UnitCodeDao;
import org.wekit.web.db.model.UnitCode;
import org.wekit.web.service.UnitCodeService;

@Service("unitCodeService")
public class UnitCodeServiceImpl implements UnitCodeService {

	@Autowired
	@Qualifier("unitCodeDao")
	private UnitCodeDao unitCodeDao;
	
	public UnitCodeDao getUnitCodeDao() {
		return unitCodeDao;
	}

	public void setUnitCodeDao(UnitCodeDao unitCodeDao) {
		this.unitCodeDao = unitCodeDao;
	}

	@Override
	public List<UnitCode> queryUnitCodes(String key, int state, IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UnitCode> queryUnitCodes(String key, long typeId, int state, IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitCode getUnitCode(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
