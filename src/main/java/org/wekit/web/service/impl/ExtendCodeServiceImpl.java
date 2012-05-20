package org.wekit.web.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.WekitException;
import org.wekit.web.db.dao.CodeApplyDao;
import org.wekit.web.db.dao.CodeApplyLogDao;
import org.wekit.web.db.dao.CodePoolDao;
import org.wekit.web.db.dao.ExtendCodeDao;
import org.wekit.web.db.dao.RuleTypeDao;
import org.wekit.web.db.dao.UserDao;
import org.wekit.web.db.model.CodeApply;
import org.wekit.web.db.model.ExtendCode;
import org.wekit.web.db.model.RuleType;
import org.wekit.web.db.model.User;
import org.wekit.web.imports.CodeWrap;
import org.wekit.web.imports.ExtendCodeWrap;
import org.wekit.web.service.ExtendCodeService;
import org.wekit.web.util.DataWrapUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service("extendCodeService")
public class ExtendCodeServiceImpl implements ExtendCodeService {

	private static Logger	logger	= Logger.getLogger(ExtendCodeServiceImpl.class);
	
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
	
	@Autowired
	@Qualifier("codeApplyDao")
	private CodeApplyDao codeApplyDao;
	
	@Autowired
	@Qualifier("ruleTypeDao")
	private RuleTypeDao ruleTypeDao;
	
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
	public boolean deleteExtendCode(long id, String createrid, String ip) throws Exception {
		ExtendCode code = this.extendCodeDao.getExtendCode(id);
		if(code==null)
			throw new WekitException("要删除的无规则编码不存在!");
		User user=userDao.getByID(createrid,1);
		if(user==null)
			throw new WekitException("操作用户的信息不存在!");
		if (code != null) {
			if (this.extendCodeDao.deleteExtendCode(code)) {				
				codeApplyLogDao.saveCodeApplyLog(user.getLoginName(), user.getDisplayName(), user.getDeptName(), user.getDeptDisplayName(),code.getFileType(), code.getResult(),DataWrapUtil.ObjectToJson(code),CodeApplyLogDao.UCANCELOPERATE, System.currentTimeMillis());
				codePoolDao.deleteCodePool(code.getResult());
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
	public ExtendCode addExtendCode(String createrid,String note,long applyid,String applyTitle, String docCode, String unitCode, String locationCode, int state,  String result, String filename,String mask,long filetype) throws JsonGenerationException, JsonMappingException, IOException {
		if(codePoolDao.isExistsed(result))
			throw new WekitException("该编码已经存在了，请选择别的编码!");
		User user=userDao.getByID(createrid,1);
		if(user==null)
			throw new WekitException("对应的操作用户不存在!");
		CodeApply codeApply=codeApplyDao.getCodeApply(applyid);
		if(codeApply==null){
			throw new WekitException("对应的编码申请信息不存在!");
		}
		RuleType ruleType=ruleTypeDao.getRuleType(filetype);
		if(ruleType==null)
			throw new WekitException("对应的文件类型不存在!");
		ExtendCode extendCode=new ExtendCode(user.getDisplayName(),user.getLoginName(), System.currentTimeMillis(), note, applyTitle,codeApply.getApplyId(), docCode, unitCode, locationCode, state, codeApply.getApplyedId(), codeApply.getApplyedName(), result, filename,codeApply.getDeptName(),mask,ruleType.getTypeId(),ruleType.getTypeName());
		codeApplyLogDao.saveCodeApplyLog(user.getLoginName(), user.getDisplayName(), user.getDeptName(), user.getDeptDisplayName(), extendCode.getFileType(), extendCode.getResult(),DataWrapUtil.ObjectToJson(extendCode), CodeApplyLogDao.UAPPLAYOPERATE, System.currentTimeMillis());
		return this.addExtendCode(extendCode);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public ExtendCodeWrap[] importCodes(String json) {
	  try {
		ExtendCodeWrap[] wraps=	DataWrapUtil.jsonToExtendCodeWrapList(json);
		for(ExtendCodeWrap wrap:wraps){
			try{
				if(StringUtils.isEmpty(wrap.getCode())){
					wrap.setResult("编码不存在!");
					continue;
				}
				User applyUser= userDao.getByID(wrap.getApplyedId(),1);
				if(applyUser==null){
					wrap.setResult("申请用户信息不存在！");
					continue;
				}
				User user=userDao.getByID(wrap.getUserId(),1);
				if(user==null){
					wrap.setResult("审核用户信息不存在!");
					continue;
				}
				
				String fileTypeName=" ";
				RuleType ruleType=ruleTypeDao.getRuleType(wrap.getFilType());
				if(ruleType!=null)
					fileTypeName=ruleType.getTypeName();
				String[] temp=wrap.getCode().split("-");
				if(!codePoolDao.isExistsed(wrap.getCode())){
					ExtendCode code=new ExtendCode(user.getDisplayName(), user.getLoginName(), System.currentTimeMillis(), wrap.getNote(),wrap.getApplyTitle(), wrap.getApplyId(), temp[2], temp[0], temp[1],1, applyUser.getLoginName(), applyUser.getDisplayName(), wrap.getCode(),wrap.getFileName(), applyUser.getDeptDisplayName(), wrap.getMask(), wrap.getFilType(), fileTypeName);
					extendCodeDao.addExtendCode(code);
					codePoolDao.insertCodePool(wrap.getCode());
				}else{
					wrap.setResult("该编码已经在数据库中存在了！");
				}
			}catch(Exception ex){
				wrap.setResult(ex.getMessage());
			}
		}
		
		return wraps;
		
	} catch (JsonParseException e) {
		logger.error(e.getMessage());
		throw new WekitException(e.getMessage());
	} catch (JsonMappingException e) {
		logger.error(e.getMessage());
		throw new WekitException(e.getMessage());
	} catch (IOException e) {
		logger.error(e.getMessage());
		throw new WekitException(e.getMessage());
	}
		
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

	public CodeApplyDao getCodeApplyDao() {
		return codeApplyDao;
	}

	public void setCodeApplyDao(CodeApplyDao codeApplyDao) {
		this.codeApplyDao = codeApplyDao;
	}

	public RuleTypeDao getRuleTypeDao() {
		return ruleTypeDao;
	}

	public void setRuleTypeDao(RuleTypeDao ruleTypeDao) {
		this.ruleTypeDao = ruleTypeDao;
	}
}
