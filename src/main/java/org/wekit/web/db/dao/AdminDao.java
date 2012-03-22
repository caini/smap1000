package org.wekit.web.db.dao;

import org.wekit.web.db.model.Admin;

public interface AdminDao {

	/**
	 * 根据系统管理员ID获取管理
	 * @param id
	 * @return
	 */
	Admin getAdmin(long id);
	
}
