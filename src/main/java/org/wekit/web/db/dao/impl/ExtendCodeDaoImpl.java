package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.ExtendCodeDao;
import org.wekit.web.db.model.ExtendCode;

/**
 * 无规则编码申请
 * 
 * @author HuangWeili
 * 
 */
@Repository("extendCodeDao")
public class ExtendCodeDaoImpl extends HibernateBaseDao<ExtendCode, Long> implements ExtendCodeDao {

	private static Logger	logger	= Logger.getLogger(ExtendCodeDaoImpl.class);

	@Override
	protected Class<ExtendCode> getEntityClass() {
		return ExtendCode.class;
	}

	@Override
	public ExtendCode addExtendCode(ExtendCode extendCode) {
		return this.save(extendCode);
	}

	@Override
	public ExtendCode getExtendCode(long id) {
		return this.get(id);
	}

	@Override
	public boolean deleteExtendCode(ExtendCode extendCode) {
		try {
			this.delete(extendCode);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteExtendCode(long id) {
		try{
			this.deleteByPK(id);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateExtendCode(ExtendCode extendCode) {
		try {
			this.update(extendCode);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<ExtendCode> getAllExtendCodes() {
		return getAll();
	}

	@Override
	public List<ExtendCode> getExtendCodesWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

}
