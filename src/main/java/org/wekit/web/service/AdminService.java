package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.Pagination;
import org.wekit.web.db.model.Admin;

public interface AdminService {
	
	/**
	 * 添加系统管理员
	 * @param admin
	 * @return
	 */
	public Admin saveAdmin(Admin admin);
	
	
	/**
	 * 根据ID获取系统管理员
	 * @param id
	 * @return
	 */
	public Admin getAdminById(long id);
	
	/**
	 * 获取所有的系统管理员
	 * @return
	 */
	public List<Admin> getAllAdmins();
	
	/**
	 * 根据分页信息获取系统管理员
	 * @param paginable
	 * @return
	 */
	public Pagination<Admin> getAdminsWithPaginable(IPaginable paginable);
	

	/**
	 * 根据ID删除系统管理员
	 * @param id
	 * @return
	 */
	public boolean deleteAdmin(Long id,String creatername,String createrid,String ip)throws Exception;
	
	/**
	 * 更新系统管理员
	 * @param admin
	 * @return
	 */
	public boolean updateAdmin(Admin admin,String creatername,String createrid,String ip) throws Exception;
	
	/**
	 * 添加系统管理员
	 * @param username
	 * @param displayname
	 * @param password
	 * @param ip
	 * @return
	 */
	public Admin saveAdmin(String username,String displayname,String password,String ip);
	
	/**
	 * 更新系统管理员信息
	 * @param id
	 * @param display
	 * @param password
	 * @return
	 */
	public Admin updateAdmin(long id,String display,String password);
}
