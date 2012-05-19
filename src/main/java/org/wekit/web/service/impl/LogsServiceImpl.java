package org.wekit.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.WekitException;
import org.wekit.web.db.dao.CodeApplyLogDao;
import org.wekit.web.db.dao.OptLogDao;
import org.wekit.web.db.dao.RemoteLogDao;
import org.wekit.web.db.dao.UserDao;
import org.wekit.web.db.model.CodeApplyLog;
import org.wekit.web.db.model.OptLog;
import org.wekit.web.db.model.RemoteLog;
import org.wekit.web.db.model.User;
import org.wekit.web.service.LogsService;

/***
 * 
 * @author HuangWeili
 *
 */
@Service("logsService")
public class LogsServiceImpl implements LogsService {

	@Autowired
	@Qualifier("codeApplyLogDao")
	private CodeApplyLogDao codeApplyLogDao;
	
	@Autowired
	@Qualifier("remoteLogDao")
	private RemoteLogDao remoteLogDao;
	
	@Autowired
	@Qualifier("optLogDao")
	private OptLogDao optLogDao;
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public CodeApplyLog addCodeApplyLog(String userid,long fileType, String code, String content, String operateType) {
		User user=userDao.getByID(userid,1);
		if(user==null)
			throw new WekitException("操作用户不存在!");
		CodeApplyLog codeApplyLog=new CodeApplyLog(user.getLoginName(), user.getDisplayName(), user.getDeptDisplayName(), user.getDeptDisplayName(),System.currentTimeMillis(), fileType, code, content, operateType);
		return codeApplyLogDao.saveCodeApplyLog(codeApplyLog);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public RemoteLog addRemoteLog(long remoteId, String remotename, String operateType, String content) {
		RemoteLog remoteLog=new RemoteLog(remoteId, remotename, operateType, content, System.currentTimeMillis());
		return this.remoteLogDao.savelog(remoteLog);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public OptLog addOptLog(String systemId,String systemName,String userid,String username,String content,String ip,String operate,String deptName){
		OptLog optLog=new OptLog(systemId,systemName,userid,username,content,System.currentTimeMillis(),ip,operate,deptName);
		return optLogDao.addOptLog(optLog);
	}
	

	public CodeApplyLogDao getCodeApplyLogDao() {
		return codeApplyLogDao;
	}

	public void setCodeApplyLogDao(CodeApplyLogDao codeApplyLogDao) {
		this.codeApplyLogDao = codeApplyLogDao;
	}

	public RemoteLogDao getRemoteLogDao() {
		return remoteLogDao;
	}

	public void setRemoteLogDao(RemoteLogDao remoteLogDao) {
		this.remoteLogDao = remoteLogDao;
	}

	public OptLogDao getOptLogDao() {
		return optLogDao;
	}

	public void setOptLogDao(OptLogDao optLogDao) {
		this.optLogDao = optLogDao;
	}

	
	
}
