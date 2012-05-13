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
import org.wekit.web.db.dao.CodeApplyLogDao;
import org.wekit.web.db.dao.CodePoolDao;
import org.wekit.web.db.dao.ExtendCodeDao;
import org.wekit.web.db.dao.UserDao;
import org.wekit.web.db.model.ExtendCode;
import org.wekit.web.db.model.User;
import org.wekit.web.service.ExtendCodeService;
import org.wekit.web.util.DataWrapUtil;

@Service("extendCodeService")
public class ExtendCodeServiceImpl implements ExtendCodeService {

	@Autowired
	@Qualifier("extendCodeDao")
	private ExtendCodeDao	extendCodeDao;

	@Autowired
	@Qualifier("codePoolDao")
	private CodePoolDao codePoolDao;
	
	@Autowired
	@Qualifier("codeApplyLogDao")
	private CodeApplyLogDao codeApplyLogDao;
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	private static Logger	logger	= Logger.getLogger(ExtendCodeServiceImpl.class);

	public ExtendCodeDao getExtendCodeDao() {
		return extendCodeDao;
	}

	public void setExtendCodeDao(ExtendCodeDao extendCodeDao) {
		this.extendCodeDao = extendCodeDao;
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
		String result=code.getResult();
		ExtendCode extendCode=null;
		if(codePoolDao.isExistsed(result)){
			throw new WekitException("编码已经存在请另外选择一个新的编码!");
		}else
		{
		    extendCode= this.extendCodeDao.addExtendCode(code);
			codePoolDao.insertCodePool(result);
			
		}
		return extendCode;
	}

	@Transactional(readOnly = true)
	@Override
	public List<ExtendCode> queryExtendCode(Map<String, String> param, IPaginable iPaginable) {
		// TODO Auto-generated method stub
		return null;
	
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean deleteExtendCode(long id, String createrid, String ip,int filetype) throws Exception {
		ExtendCode code = this.extendCodeDao.getExtendCode(id);
		if(code==null)
			throw new WekitException("要删除的无规则编码不存在!");
		User user=userDao.getByID(createrid);
		if(user==null)
			throw new WekitException("操作用户的信息不存在!");
		if (code != null) {
			if (this.extendCodeDao.deleteExtendCode(code)) {				
				codeApplyLogDao.saveCodeApplyLog(user.getLoginName(), user.getDisplayName(), user.getDeptName(), user.getDeptDisplayName(),filetype, code.getResult(),DataWrapUtil.ObjectToJson(code),CodeApplyLogDao.UCANCELOPERATE, System.currentTimeMillis());
				if(logger.isInfoEnabled()){
				logger.info(user.getDisplayName()+"("+createrid+"-- ip:"+ip+") 删除无规则编码:"+DataWrapUtil.ObjectToJson(code));
				}
			} else {
				throw new WekitException("删除无规则编码时发生错误!");
			}
		}
		return true;
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public ExtendCode addExtendCode(String createrid, long createtime, String note, String applyTitle, String applyid, String docCode, String unitCode, String locationCode, int state, String applyedid, String applyedname, String result, String filename,String mask,int fileType,String fileTypeName) {
		User user=userDao.getByID(createrid);
		if(user==null)
			throw new WekitException("对应的操作用户不存在!");
		ExtendCode extendCode=new ExtendCode(user.getDisplayName(),user.getLoginName(), createtime, note, applyTitle, applyid, docCode, unitCode, locationCode, state, applyedid, applyedname, result, filename,user.getDeptDisplayName(),mask,fileType,fileTypeName);
		return this.addExtendCode(extendCode);
	}

	public CodePoolDao getCodePoolDao() {
		return codePoolDao;
	}

	public void setCodePoolDao(CodePoolDao codePoolDao) {
		this.codePoolDao = codePoolDao;
	}

	public CodeApplyLogDao getCodeApplyLogDao() {
		return codeApplyLogDao;
	}

	public void setCodeApplyLogDao(CodeApplyLogDao codeApplyLogDao) {
		this.codeApplyLogDao = codeApplyLogDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
