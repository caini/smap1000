package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.UnitCodeTypeDao;
import org.wekit.web.db.model.UnitCodeType;

/**
 * 机组码分类访问类
 * 
 * @author HuangWeili
 * 
 */
@Repository("unitCodeTypeDao")
public class UnitCodeTypeDaoImpl extends HibernateBaseDao<UnitCodeType, Long> implements UnitCodeTypeDao {

	@Override
	protected Class<UnitCodeType> getEntityClass() {
		return UnitCodeType.class;
	}

	@Override
	public UnitCodeType addUnitCodeType(UnitCodeType unitCodeType) {
		return this.save(unitCodeType);
	}

	@Override
	public UnitCodeType getUnitCodeType(long id) {
		return this.get(id);
	}

	@Override
	public boolean deleteUnitCodeType(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUnitCodeType(UnitCodeType unitCodeType) {
		try {
			this.delete(unitCodeType);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public List<UnitCodeType> getAllUnitCodeTypes() {
		return this.getAll();
	}

	@Override
	public List<UnitCodeType> getUnitCodeTypesWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

	@Override
	public boolean updateUnitCodeType(UnitCodeType unitCodeType) {
		try {
			this.update(unitCodeType);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}
