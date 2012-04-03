package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.UnitCodeDao;
import org.wekit.web.db.model.UnitCode;
import org.wekit.web.service.UnitCodeService;

/**
 * 
 * @author HuangWeili
 *
 */
@Service("unitCodeService")
public class UnitCodeServiceImpl implements UnitCodeService {

	@Autowired
	@Qualifier("unitCodeDao")
	private UnitCodeDao	unitCodeDao;

	public UnitCodeDao getUnitCodeDao() {
		return unitCodeDao;
	}

	public void setUnitCodeDao(UnitCodeDao unitCodeDao) {
		this.unitCodeDao = unitCodeDao;
	}

	@Transactional(readOnly=true)
	@Override
	public List<UnitCode> queryUnitCodes(String key, int state, IPaginable paginable) {
		return queryUnitCodes(key, -1, state, paginable);
	}

	@Transactional(readOnly=true)
	@Override
	public List<UnitCode> queryUnitCodes(String key, long typeId, int state, IPaginable paginable) {
		return this.unitCodeDao.queryUnitCodes(key, typeId, state, paginable);
	}

	@Transactional(readOnly=true)
	@Override
	public UnitCode getUnitCode(long id) {
		return this.unitCodeDao.getUnitCode(id);
	}

	@Override
	public UnitCode getUnitCode(String code) {
		return this.unitCodeDao.getUnitCode(code);
	}

}
