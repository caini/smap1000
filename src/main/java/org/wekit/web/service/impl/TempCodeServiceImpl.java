package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.TempCodeDao;
import org.wekit.web.db.model.TempCode;
import org.wekit.web.service.TempCodeService;

@Service("tempCodeService")
public class TempCodeServiceImpl implements TempCodeService {

	@Autowired
	@Qualifier("tempCodeDao")
	private TempCodeDao	tempCodeDao;

	public TempCodeDao getTempCodeDao() {
		return tempCodeDao;
	}

	public void setTempCodeDao(TempCodeDao tempCodeDao) {
		this.tempCodeDao = tempCodeDao;
	}

	@Override
	public TempCode getTempCode(long id) {
		if (id < 1)
			return null;
		return this.tempCodeDao.getTempCode(id);
	}

	@Override
	public boolean deleteTempCode(TempCode tempCode) {
		return this.tempCodeDao.deleteTempCode(tempCode);
	}

	@Override
	public TempCode addTempCode(TempCode tempCode) {
		return this.tempCodeDao.addTempCode(tempCode);
	}

	public boolean updateTempCode(TempCode tempCode) {
		return this.tempCodeDao.updateTempCode(tempCode);
	}

	@Override
	public List<TempCode> queryTempCodes(String rule, String unitcode, String locationCode, String doccode, IPaginable paginable) {
		return this.tempCodeDao.queryTempCodes(rule, unitcode, locationCode, doccode, paginable);
	}

}
