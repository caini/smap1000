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
import org.wekit.web.db.dao.UnitCodeDao;
import org.wekit.web.db.model.UnitCode;
import org.wekit.web.service.UnitCodeService;
import org.wekit.web.util.DataWrapUtil;

/**
 * 
 * @author HuangWeili
 * 
 */
@Service("unitCodeService")
public class UnitCodeServiceImpl implements UnitCodeService {

	private static Logger	logger	= Logger.getLogger(UnitCodeServiceImpl.class);

	@Autowired
	@Qualifier("unitCodeDao")
	private UnitCodeDao		unitCodeDao;

	public UnitCodeDao getUnitCodeDao() {
		return unitCodeDao;
	}

	public void setUnitCodeDao(UnitCodeDao unitCodeDao) {
		this.unitCodeDao = unitCodeDao;
	}

	@Transactional(readOnly = true)
	@Override
	public List<UnitCode> queryUnitCodes(String key, int state, IPaginable paginable) {
		return queryUnitCodes(key, -1, state, paginable);
	}

	@Transactional(readOnly = true)
	@Override
	public List<UnitCode> queryUnitCodes(String key, long typeId, int state, IPaginable paginable) {
		return this.unitCodeDao.queryUnitCodes(key, typeId, state, paginable);
	}

	@Transactional(readOnly = true)
	@Override
	public UnitCode getUnitCode(long id) {
		return this.unitCodeDao.getUnitCode(id);
	}

	@Transactional(readOnly = true)
	@Override
	public UnitCode getUnitCode(String code) {
		return this.unitCodeDao.getUnitCode(code);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean deleteUnitCode(long id, String creatername, String createrid, String ip) throws Exception {
		UnitCode code = this.unitCodeDao.getUnitCode(id);
		if (code != null) {
			if (this.unitCodeDao.deleteUnitCode(code)) {
				logger.info(creatername + "(" + createrid + "-- ip:" + ip + ") 删除机组码信息:" + DataWrapUtil.ObjectToJson(code));
			} else {
				throw new WekitException("删除机组编码的时候发生错误!");
			}

		}
		return true;
	}

}
