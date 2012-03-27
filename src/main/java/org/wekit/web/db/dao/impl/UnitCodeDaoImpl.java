package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.UnitCodeDao;
import org.wekit.web.db.model.UnitCode;
/**
 * 机组码访问类
 * @author HuangWeili
 *
 */
@Repository("unitCodeDao")
public class UnitCodeDaoImpl extends HibernateBaseDao<UnitCode,Long> implements UnitCodeDao {

	@Override
	protected Class<UnitCode> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitCode addUnitCode(UnitCode unitCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitCode getUnitCode(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUnitCode(UnitCode unitCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUnitCode(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUnitCode(UnitCode unitCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UnitCode> getAllCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UnitCode> getCodesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
