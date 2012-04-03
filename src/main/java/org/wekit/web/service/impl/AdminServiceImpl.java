package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.IPaginable;
import org.wekit.web.db.Pagination;
import org.wekit.web.db.dao.AdminDao;
import org.wekit.web.db.dao.UnitCodeTypeDao;
import org.wekit.web.db.model.Admin;
import org.wekit.web.db.model.UnitCodeType;
import org.wekit.web.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

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
	public List<Admin> getAllAdmins() {
		return adminDao.getAllAdmins();
	}

	@Override
	public Pagination<Admin> getAdminsWithPaginable(IPaginable paginable) {
		List<Admin> list= adminDao.getAdminsWithPagination(paginable);
		Pagination<Admin> pagination=new Pagination<Admin>(paginable);
		pagination.setDatas(list);
		return pagination;
	}

}
