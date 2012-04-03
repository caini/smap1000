package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.UnitCodeDao;
import org.wekit.web.db.model.UnitCode;

/**
 * 机组码访问类
 * 
 * @author HuangWeili
 * 
 */
@Repository("unitCodeDao")
public class UnitCodeDaoImpl extends HibernateBaseDao<UnitCode, Long> implements UnitCodeDao {

	private static Logger logger=Logger.getLogger(UnitCodeDaoImpl.class);
	
	@Override
	protected Class<UnitCode> getEntityClass() {
		return UnitCode.class;
	}

	@Override
	public UnitCode addUnitCode(UnitCode unitCode) {
		return this.save(unitCode);
	}

	@Override
	public UnitCode getUnitCode(long id) {
		return this.get(id);
	}

	@Override
	public boolean updateUnitCode(UnitCode unitCode) {
		try {
			this.update(unitCode);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;

	}

	@Override
	public boolean deleteUnitCode(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUnitCode(UnitCode unitCode) {
		try {
			this.delete(unitCode);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<UnitCode> getAllCodes() {
		return this.getAll();
	}

	@Override
	public List<UnitCode> getCodesWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnitCode> queryUnitCodes(String key, long typeId, int state, IPaginable paginable) {
		StringBuffer buffer=new StringBuffer();
		buffer.append("from UnitCode bean where 1=1 ");
		if(StringUtils.isNotEmpty(key)){
			buffer.append(" and (bean.name like '%"+key+"%' or bean.ename like '%"+key+"%' or bean.code like '%"+key+"%') ");
		}
		if(typeId>=0){
			buffer.append(" and bean.typeId="+typeId);
		}
		if(state>-1){
			buffer.append(" and bean.state="+state);
		}
		Query query=createrQuery(buffer.toString());
		if(paginable!=null){
			this.paginationParam(query, paginable);
		}
		return query.list();
	}

}
