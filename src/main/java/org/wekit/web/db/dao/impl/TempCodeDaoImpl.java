package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.TempCodeDao;
import org.wekit.web.db.model.TempCode;

/**
 * 临时数据操作表
 * 
 * @author HuangWeili
 * 
 */
@Repository("tempCodeDao")
public class TempCodeDaoImpl extends HibernateBaseDao<TempCode, Long> implements TempCodeDao {

	private static Logger	logger	= Logger.getLogger(TempCodeDaoImpl.class);

	@Override
	protected Class<TempCode> getEntityClass() {
		return TempCode.class;
	}

	@Override
	public TempCode addTempCode(TempCode tempCode) {
		return this.save(tempCode);
	}

	@Override
	public TempCode getTempCode(long id) {
		return this.get(id);
	}

	@Override
	public boolean deleteTempCode(TempCode tempCode) {
		try {
			this.delete(tempCode);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteTempCode(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateTempCode(TempCode tempCode) {
		try {
			this.update(tempCode);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<TempCode> getAllTempCodes() {
		return this.getAll();
	}

	@Override
	public List<TempCode> getTempCodesWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TempCode> queryTempCodes(String rule, String unitcode, String locationCode, String doccode, IPaginable paginable) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from TempCode bean where 1=1 ");
		if (StringUtils.isNotEmpty(rule)) {
			buffer.append(" and bean.rule='" + rule + "'");
		}
		if (StringUtils.isNotEmpty(unitcode)) {
			buffer.append(" and bean.unitCode='" + unitcode + "'");
		}
		if (StringUtils.isNotEmpty(locationCode)) {
			buffer.append(" and bean.locationCode='" + locationCode + "'");
		}
		if (StringUtils.isNotEmpty(doccode)) {
			buffer.append(" and bean.docCode='" + doccode + "'");
		}
		
		buffer.append(" order by bean.code asc ");
		Query query = createrQuery(buffer.toString());
		if (paginable != null) {
			paginationParam(query, paginable);
		}
		
		return query.list();
	}

}
