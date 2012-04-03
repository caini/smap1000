package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.RemoteAclDao;
import org.wekit.web.db.model.RemoteAcl;
import org.wekit.web.service.RemoteAclService;

@Service("remoteAclService")
public class RemoteAclServiceImpl implements RemoteAclService {

	@Autowired
	@Qualifier("remoteAclDao")
	private RemoteAclDao	remoteAclDao;

	public RemoteAclDao getRemoteAclDao() {
		return remoteAclDao;
	}

	public void setRemoteAclDao(RemoteAclDao remoteAclDao) {
		this.remoteAclDao = remoteAclDao;
	}

	@Override
	public RemoteAcl getRemoteAclByUserName(String userName) {
		return remoteAclDao.getRemoteAclByUserName(userName);
	}

	@Override
	public List<RemoteAcl> getAllRemoteAcls() {
		return remoteAclDao.getAllRemoteAcls();
	}

	@Override
	public List<RemoteAcl> getRemoteAclsWithPagination(IPaginable paginable) {
		return this.remoteAclDao.getRemoteAclsWithPagination(paginable);
	}

	@Override
	public boolean updateRemoteAcl(RemoteAcl remoteAcl) {
		return this.remoteAclDao.updateRemoteAcl(remoteAcl);
	}

	@Override
	public boolean deleteRemoteAcl(RemoteAcl remoteAcl) {
		return this.remoteAclDao.deleteRemoteAcl(remoteAcl);
	}

	@Override
	public boolean deleteRemoteAclById(Long id) {
		return this.remoteAclDao.deleteRemoteAcl(id);
	}

	@Override
	public RemoteAcl getRemoteAcl(long id) {
		return this.remoteAclDao.getRemoteAcl(id);
	}
}
