package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.TempCodeDao;
import org.wekit.web.db.model.TempCode;

/**
 * 临时数据操作表
 * @author HuangWeili
 *
 */
@Repository("tempCodeDao")
public class TempCodeDaoImpl extends HibernateBaseDao<TempCode,Long>  implements TempCodeDao{

	@Override
	protected Class<TempCode> getEntityClass() {
		return TempCode.class;
	}

	@Override
	public TempCode addTempCode(TempCode tempCode) {
		// TODO Auto-generated method stub
		return null;
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
	public boolean deleteTempCode(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTempCode(TempCode tempCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TempCode> getAllTempCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TempCode> getTempCodesWithPagination() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
