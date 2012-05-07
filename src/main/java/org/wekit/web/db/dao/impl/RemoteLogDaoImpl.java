package org.wekit.web.db.dao.impl;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.RemoteLogDao;
import org.wekit.web.db.model.RemoteLog;

@Repository("remoteLogDao")
public class RemoteLogDaoImpl extends HibernateBaseDao<RemoteLog, Long> implements RemoteLogDao {

	@Override
	public RemoteLog savelog(RemoteLog remoteLog) {
		return this.save(remoteLog);
	}

	
	
	@Override
	protected Class<RemoteLog> getEntityClass() {
		return RemoteLog.class;
	}

}
