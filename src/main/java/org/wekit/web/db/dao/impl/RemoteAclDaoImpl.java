package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
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

	private static Logger logger=Logger.getLogger(RemoteAclDaoImpl.class);
	
	@Override
	public List<RemoteAcl> getAllRemoteAcls() {
		return getAll();
	}

	@Override
	public List<RemoteAcl> getRemoteAclsWithPagination(IPaginable paginable) {
		return getObjectsWithPagination(paginable);
	}

	@Override
	public RemoteAcl getRemoteAclByUserName(String username,int state) {
		Query query= createrQuery("from RemoteAcl where username=:username and state=:state");
		query.setString("username", username);
		query.setInteger("state", state);
		List<RemoteAcl> remoteAcls = query.list();
		if (remoteAcls != null && remoteAcls.size()>=1){
			return remoteAcls.get(0);
		}
			
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
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteRemoteAcl(RemoteAcl remoteAcl) {
		try {
			this.delete(remoteAcl);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateRemoteAcl(RemoteAcl remoteAcl) {
		try{
		this.update(remoteAcl);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	protected Class<RemoteAcl> getEntityClass() {
		return RemoteAcl.class;
	}

	@Override
	public RemoteAcl getRemoteAcl(long id) {
		return this.get(id);
	}

}
