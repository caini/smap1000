package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.RemoteAclDao;
import org.wekit.web.db.model.RemoteAcl;

/**
 * 远程系统调用类实现
 * 
 * @author HuangWeili
 * 
 */
@Repository("remoteAclDao")
public class RemoteAclDaoImpl extends HibernateBaseDao<RemoteAcl, Long> implements RemoteAclDao {

	@Override
	public List<RemoteAcl> getAllRemoteAcls() {
		return getAll();
	}

	@Override
	public List<RemoteAcl> getRemoteAclsWithPagination(IPaginable paginable) {
		return getObjectsWithPagination(paginable);
	}

	@Override
	public RemoteAcl getRemoteAclByUserName(String username) {
		List<RemoteAcl> remoteAcls = queryByProperty("username", username);
		if (remoteAcls != null)
			return remoteAcls.get(0);
		return null;
	}

	@Override
	public RemoteAcl addRemoteAcl(RemoteAcl remoteAcl) {
		return this.save(remoteAcl);
	}

	@Override
	public boolean deleteRemoteAcl(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteRemoteAcl(RemoteAcl remoteAcl) {
		try {
			this.delete(remoteAcl);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public RemoteAcl updateRemoteAcl(RemoteAcl remoteAcl) {
		return this.update(remoteAcl);
	}

	@Override
	protected Class<RemoteAcl> getEntityClass() {
		return RemoteAcl.class;
	}

}
