package org.wekit.web.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.WekitException;
import org.wekit.web.db.dao.ExtendCodeDao;
import org.wekit.web.db.model.ExtendCode;
import org.wekit.web.service.ExtendCodeService;
import org.wekit.web.util.DataWrapUtil;

@Service("extendCodeService")
public class ExtendCodeServiceImpl implements ExtendCodeService {

	@Autowired
	@Qualifier("extendCodeDao")
	private ExtendCodeDao	extendCodeDao;

	private static Logger	logger	= Logger.getLogger(ExtendCodeServiceImpl.class);

	public ExtendCodeDao getExtendCodeDao() {
		return extendCodeDao;
	}

	public void setExtendCodeDao(ExtendCodeDao extendCodeDao) {
		this.extendCodeDao = extendCodeDao;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean deleteExtendCode(Long id) {
		return extendCodeDao.deleteExtendCode(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean updateExtendCode(ExtendCode code) {
		return extendCodeDao.updateExtendCode(code);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ExtendCode> getAllExtendCodes() {
		return this.extendCodeDao.getAllExtendCodes();
	}

	@Transactional(readOnly = true)
	@Override
	public List<ExtendCode> getExtendCodesWithPagination(IPaginable paginable) {
		if (paginable == null)
			return extendCodeDao.getAllExtendCodes();
		else
			return extendCodeDao.getExtendCodesWithPagination(paginable);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public ExtendCode addExtendCode(ExtendCode code) {
		
		return this.extendCodeDao.addExtendCode(code);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public ExtendCode addExtendCode(long codeapplyid,String code ,String note){
		return null;
	}
	
	
	
	@Transactional(readOnly = true)
	@Override
	public List<ExtendCode> queryExtendCode(Map<String, String> param, IPaginable iPaginable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean deleteExtendCode(long id, String creatername, String createrid, String ip) throws Exception {
		ExtendCode code = this.extendCodeDao.getExtendCode(id);
		if (code != null) {
			if (this.extendCodeDao.deleteExtendCode(code)) {
				logger.info(creatername+"("+createrid+"-- ip:"+ip+") 删除无规则编码:"+DataWrapUtil.ObjectToJson(code));
			} else {
				throw new WekitException("删除无规则编码时发生错误!");
			}
		}
		return true;
	}

}
