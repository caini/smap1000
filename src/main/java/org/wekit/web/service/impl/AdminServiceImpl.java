package org.wekit.web.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.WekitException;
import org.wekit.web.db.Pagination;
import org.wekit.web.db.dao.AdminDao;
import org.wekit.web.db.model.Admin;
import org.wekit.web.service.AdminService;
import org.wekit.web.util.DataWrapUtil;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	private static Logger	logger	= Logger.getLogger(AdminServiceImpl.class);

	@Autowired
	@Qualifier("adminDao")
	private AdminDao		adminDao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}

	@Transactional(readOnly = true)
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

	@Transactional(readOnly = true)
	@Override
	public List<Admin> getAllAdmins() {
		return adminDao.getAllAdmins();
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination<Admin> getAdminsWithPaginable(IPaginable paginable) {
		List<Admin> list = adminDao.getAdminsWithPagination(paginable);
		Pagination<Admin> pagination = new Pagination<Admin>(paginable);
		pagination.setDatas(list);
		return pagination;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean deleteAdmin(Long id, String creatername, String createrid, String ip) throws Exception {
		Admin admin = adminDao.getAdmin(id);
		if (admin != null) {
			if (adminDao.deleteAdmin(admin)) {
				logger.info(creatername+"("+createrid+"-- ip:"+ip+")删除系统管理员:"+DataWrapUtil.ObjectToJson(admin));
			} else {
				throw new WekitException("删除系统管理员操作失败!");
			}
		}
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean updateAdmin(Admin admin, String creatername, String createrid, String ip)throws Exception {
		if(adminDao.updateAdmin(admin)){
		   logger.info(creatername+"("+createrid+"-- ip:"+ip+")更新系统管理员:"+DataWrapUtil.ObjectToJson(admin));
		   return true;
		}
		return false;
	}

}
