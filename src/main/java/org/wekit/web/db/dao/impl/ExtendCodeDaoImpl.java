package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.ExtendCodeDao;
import org.wekit.web.db.model.ExtendCode;

/**
 * 无规则编码申请
 * @author HuangWeili
 *
 */
@Repository("extendCodeDao")
public class ExtendCodeDaoImpl extends HibernateBaseDao<ExtendCode,Long> implements ExtendCodeDao {

	@Override
	protected Class<ExtendCode> getEntityClass() {
		return ExtendCode.class;
	}

	@Override
	public ExtendCode addExtendCode(ExtendCode extendCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtendCode getExtendCode(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteExtendCode(ExtendCode extendCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteExtendCode(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateExtendCode(ExtendCode extendCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ExtendCode> getAllExtendCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExtendCode> getExtendCodesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
