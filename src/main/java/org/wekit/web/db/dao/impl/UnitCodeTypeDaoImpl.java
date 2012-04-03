package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
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

	private static Logger	logger	= Logger.getLogger(UnitCodeTypeDaoImpl.class);

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
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUnitCodeType(UnitCodeType unitCodeType) {
		try {
			this.delete(unitCodeType);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
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
		if (paginable != null)
			return this.getObjectsWithPagination(paginable);
		else
			return this.getAll();
	}

	@SuppressWarnings("unchecked")
	public List<UnitCodeType> queryUnitCodeTypes(String key, int state, IPaginable paginable) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from UnitCodeType bean where 1=1");
		if (StringUtils.isNotEmpty(key)) {
			buffer.append(" and (bean.name like '%").append(key + "%' or bean.code like '%" + key + "%' )");
		}
		if (state > 0) {
			buffer.append(" and bean.state=" + state);
		}
		Query query = createrQuery(buffer.toString());
		if (paginable != null) {
			this.paginationParam(query, paginable);
		}
		return query.list();
	}

	@Override
	public boolean updateUnitCodeType(UnitCodeType unitCodeType) {
		try {
			this.update(unitCodeType);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}
}
