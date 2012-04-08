package org.wekit.web.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.WekitException;
import org.wekit.web.db.dao.RemoteAclDao;
import org.wekit.web.db.model.RemoteAcl;
import org.wekit.web.service.RemoteAclService;
import org.wekit.web.util.DataWrapUtil;

@Service("remoteAclService")
public class RemoteAclServiceImpl implements RemoteAclService {

	@Autowired
	@Qualifier("remoteAclDao")
	private RemoteAclDao	remoteAclDao;

	private static Logger logger=Logger.getLogger(RemoteAclServiceImpl.class);
	
	public RemoteAclDao getRemoteAclDao() {
		return remoteAclDao;
	}

	public void setRemoteAclDao(RemoteAclDao remoteAclDao) {
		this.remoteAclDao = remoteAclDao;
	}

	@Transactional(readOnly=true)
	@Override
	public RemoteAcl getRemoteAclByUserName(String userName) {
		return remoteAclDao.getRemoteAclByUserName(userName);
	}

	@Transactional(readOnly=true)
	@Override
	public List<RemoteAcl> getAllRemoteAcls() {
		return remoteAclDao.getAllRemoteAcls();
	}

	@Transactional(readOnly=true)
	@Override
	public List<RemoteAcl> getRemoteAclsWithPagination(IPaginable paginable) {
		return this.remoteAclDao.getRemoteAclsWithPagination(paginable);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean updateRemoteAcl(RemoteAcl remoteAcl) {
		return this.remoteAclDao.updateRemoteAcl(remoteAcl);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean deleteRemoteAcl(RemoteAcl remoteAcl) {
		return this.remoteAclDao.deleteRemoteAcl(remoteAcl);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean deleteRemoteAclById(Long id) {
		return this.remoteAclDao.deleteRemoteAcl(id);
	}

	@Transactional(readOnly=true)
	@Override
	public RemoteAcl getRemoteAcl(long id) {
		return this.remoteAclDao.getRemoteAcl(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean deleteRemoteAcl(long id, String creatername, String createrid, String ip) throws Exception {
		RemoteAcl remoteAcl=this.remoteAclDao.getRemoteAcl(id);
		if(remoteAcl!=null){
			if(remoteAclDao.deleteRemoteAcl(remoteAcl)){
				logger.info(creatername+"("+createrid+"-- ip:"+ip+") 删除定位码的类型的信息:"+DataWrapUtil.ObjectToJson(remoteAcl));
			}else{
				throw new WekitException("删除远程访问对象失败!");
			}
		}
		return true;
	}
	

}
