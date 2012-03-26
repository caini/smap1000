package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.AdminDao;
import org.wekit.web.db.model.Admin;
import org.wekit.web.service.BaseDataService;
/**
 * 基础数据访问逻辑服务实现
 * @author huangweili
 *
 */
@Service("baseDataService")
public class BaseDataServiceImpl implements BaseDataService {

	@Autowired
	@Qualifier("adminDao")
	private AdminDao adminDao;
	
	
	@Override
	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}

	@Override
	public Admin getAdminById(long id) {
		return adminDao.getAdmin(id);
	}
	
	

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminDao.getAllAdmins();
	}

	@Override
	public List<Admin> getAdminsWithPaginable(IPaginable paginable) {
		// TODO Auto-generated method stub
		return adminDao.getAdminsWithPagination(paginable);
	}
	

}
