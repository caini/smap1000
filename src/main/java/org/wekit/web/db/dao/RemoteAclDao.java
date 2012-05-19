package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.RemoteAcl;

/**
 * 远程访问对象类
 * @author HuangWeili
 *
 */
public interface RemoteAclDao {

	/**
	 * 获取所有的访问对象
	 * @return
	 */
	public List<RemoteAcl> getAllRemoteAcls();
	
	
	/**
	 * 分页获取访问对象
	 * @param paginable
	 * @return
	 */
	public List<RemoteAcl> getRemoteAclsWithPagination(IPaginable paginable);
	
	/**
	 * 根据远程访问的用户名获取访问信息
	 * @param username
	 * @return
	 */
	public RemoteAcl getRemoteAclByUserName(String username,int state);
	
	/**
	 * 添加远程访问对象
	 * @param remoteAcl
	 * @return
	 */
	public RemoteAcl addRemoteAcl(RemoteAcl remoteAcl);
	
	/**
	 * 根据Id删除对象
	 * @param id
	 * @return
	 */
	public boolean deleteRemoteAcl(long id);
	
	/**
	 * 删除远程访问对象
	 * @param remoteAcl
	 * @return
	 */
	public boolean deleteRemoteAcl(RemoteAcl remoteAcl);
	
	/**
	 * 更新访问对象
	 * @param remoteAcl
	 * @return
	 */
	public boolean updateRemoteAcl(RemoteAcl remoteAcl);
	
	/**
	 * 根据Id查找对象
	 * @param id
	 * @return
	 */
	public RemoteAcl getRemoteAcl(long id);
}
