package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.ExtendCodeDao;
import org.wekit.web.db.model.ExtendCode;
import org.wekit.web.service.ExtendCodeService;

@Service("extendCodeService")
public class ExtendCodeServiceImpl implements ExtendCodeService {

	@Autowired
	@Qualifier("extendCodeDao")
	private ExtendCodeDao	extendCodeDao;

	public ExtendCodeDao getExtendCodeDao() {
		return extendCodeDao;
	}

	public void setExtendCodeDao(ExtendCodeDao extendCodeDao) {
		this.extendCodeDao = extendCodeDao;
	}

	@Override
	public boolean deleteExtendCode(Long id) {
		return extendCodeDao.deleteExtendCode(id);
	}

	@Override
	public boolean updateExtendCode(ExtendCode code) {
		return extendCodeDao.updateExtendCode(code);
	}

	@Override
	public List<ExtendCode> getAllExtendCodes() {
		return this.extendCodeDao.getAllExtendCodes();
	}

	@Override
	public List<ExtendCode> getExtendCodesWithPagination(IPaginable paginable) {
		if(paginable==null)
			return extendCodeDao.getAllExtendCodes();
		else
			return extendCodeDao.getExtendCodesWithPagination(paginable);
	}

	@Override
	public ExtendCode addExtendCode(ExtendCode code) {
		return this.extendCodeDao.addExtendCode(code);
	}

	@Override
	public List<ExtendCode> queryExtendCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
