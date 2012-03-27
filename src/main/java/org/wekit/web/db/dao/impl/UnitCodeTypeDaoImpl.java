package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.UnitCodeDao;
import org.wekit.web.db.dao.UnitCodeTypeDao;
import org.wekit.web.db.model.UnitCode;
import org.wekit.web.db.model.UnitCodeType;
/**
 * 机组码分类访问类
 * @author HuangWeili
 *
 */
@Repository("unitCodeTypeDao")
public class UnitCodeTypeDaoImpl extends HibernateBaseDao<UnitCode, Long> implements UnitCodeTypeDao{

	@Override
	protected Class<UnitCode> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitCodeType addUnitCodeType(UnitCodeType unitCodeType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitCodeType getUnitCodeType(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUnitCodeType(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUnitCodeType(UnitCodeType unitCodeType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UnitCodeType> getAllUnitCodeTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UnitCodeType> getUnitCodeTypesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}
}
