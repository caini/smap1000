package org.wekit.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.db.dao.RemoteAclDao;
import org.wekit.web.service.RemoteAclService;

@Service("remoteAclService")
public class RemoteAclServiceImpl implements RemoteAclService {

	@Autowired
	@Qualifier("remoteAclDao")
	private RemoteAclDao remoteAclDao;
	
	
	

	public RemoteAclDao getRemoteAclDao() {
		return remoteAclDao;
	}

	public void setRemoteAclDao(RemoteAclDao remoteAclDao) {
		this.remoteAclDao = remoteAclDao;
	}
}
