package org.wekit.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.db.dao.CodeApplyLogDao;
import org.wekit.web.db.dao.OptLogDao;
import org.wekit.web.db.dao.RemoteLogDao;
import org.wekit.web.db.model.CodeApplyLog;
import org.wekit.web.db.model.OptLog;
import org.wekit.web.db.model.RemoteLog;
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
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public CodeApplyLog addCodeApplyLog(String userid, String username, String deptId, String deptname, String fileType, String code, String content, String operateType) {
		CodeApplyLog codeApplyLog=new CodeApplyLog(userid, username, deptId, deptname,System.currentTimeMillis(), fileType, code, content, operateType);
		return codeApplyLog;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public RemoteLog addRemoteLog(String remoteId, String remotename, String operateType, String content) {
		RemoteLog remoteLog=new RemoteLog(remoteId, remotename, operateType, content, System.currentTimeMillis());
		return remoteLog;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public OptLog addOptLog(String systemId,String systemName,String userid,String username,String content,String ip,String operate){
		OptLog optLog=new OptLog(systemId,systemName,userid,username,content,System.currentTimeMillis(),ip,operate);
		return optLog;
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
