package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.Admin;

public interface AdminDao {

	/**
	 * 根据系统管理员ID获取管理
	 * @param id
	 * @return
	 */
	Admin getAdmin(long id);
	
	/**
	 * 保存
	 * @param admin
	 * @return
	 */
	Admin saveAdmin(Admin admin);
	
	/**
	 * 获取所有的系统管理员
	 * @return
	 */
	List<Admin> getAllAdmins();
	
	/**
	 * 根据分页信息查询管理员
	 * @param iPaginable
	 * @return
	 */
	List<Admin> getAdminsWithPagination(IPaginable iPaginable);
	
	/**
	 * 更新系统用户
	 * @param admin
	 * @return
	 */
	boolean updateAdmin(Admin admin);
	
	/**
	 * 删除系统用户
	 * @param admin
	 * @return
	 */
	boolean deleteAdmin(Admin admin);
	
	/**
	 * 根据ID删除系统用户
	 * @param id
	 * @return
	 */
	boolean deleteAdmin(long id);
	
}
