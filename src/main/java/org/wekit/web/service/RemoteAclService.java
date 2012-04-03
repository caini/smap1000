package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.RemoteAcl;

/**
 * 远程访问服务逻辑接口
 * 
 * @author HuangWeili
 * 
 */
public interface RemoteAclService {

	/**
	 * 根据用户名获取远程访问用户
	 * @param userName
	 * @return
	 */
	public RemoteAcl getRemoteAclByUserName(String userName);

	/**
	 * 获取所有的远程翻个访问用户
	 * @return
	 */
	public List<RemoteAcl> getAllRemoteAcls();

	/**
	 * 分页获取远程用户
	 * @param paginable
	 * @return
	 */
	public List<RemoteAcl> getRemoteAclsWithPagination(IPaginable paginable);

	/**
	 * 更新远程用户
	 * @param remoteAcl
	 * @return
	 */
	public boolean updateRemoteAcl(RemoteAcl remoteAcl);

	/**
	 * 删除远程用户
	 * @param remoteAcl
	 * @return
	 */
	public boolean deleteRemoteAcl(RemoteAcl remoteAcl);

	/**
	 * 根据远程用户Id删除用户
	 * @param id
	 * @return
	 */
	public boolean deleteRemoteAclById(Long id);

	/**
	 * 根据ID查找对象
	 * @param id
	 * @return
	 */
	public RemoteAcl getRemoteAcl(long id);
}
