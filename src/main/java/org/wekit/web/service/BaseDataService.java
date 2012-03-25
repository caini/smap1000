package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.Admin;

public interface BaseDataService {

	
	public Admin saveAdmin(Admin admin);
	
	public Admin getAdminById(long id);
	
	public List<Admin> getAllAdmin();
	
	/**
	 * 根据分页信息获取系统管理员
	 * @param paginable
	 * @return
	 */
	public List<Admin> getAdminsWithPaginable(IPaginable paginable);
	
}
