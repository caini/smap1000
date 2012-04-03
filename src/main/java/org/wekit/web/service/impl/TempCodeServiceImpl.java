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
public class TempCodeServiceImpl  implements TempCodeService{

	@Autowired
	@Qualifier
	private TempCodeDao tempCodeDao;
	
	
	
	public TempCodeDao getTempCodeDao() {
		return tempCodeDao;
	}

	public void setTempCodeDao(TempCodeDao tempCodeDao) {
		this.tempCodeDao = tempCodeDao;
	}

	@Override
	public TempCode getTempCode(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTempCode(TempCode tempCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TempCode addTempCode(TempCode tempCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean updateTempCode(TempCode tempCode){
		//TODO
		return false;
	}

	@Override
	public List<TempCode> queryTempCodes(String rule, String unitcode, String locationCode, String doccode, IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

}
