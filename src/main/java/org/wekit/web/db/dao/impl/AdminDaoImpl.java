package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.AdminDao;
import org.wekit.web.db.model.Admin;

@Repository("adminDao")
public class AdminDaoImpl extends HibernateBaseDao<Admin, Long> implements AdminDao {

	private static Logger	logger	= Logger.getLogger(AdminDaoImpl.class);

	@Override
	public Admin getAdmin(long id) {

		return this.get(id);
	}

	@Override
	public Admin saveAdmin(Admin admin) {

		return this.save(admin);
	}

	@Override
	protected Class<Admin> getEntityClass() {

		return Admin.class;
	}

	@Override
	public List<Admin> getAllAdmins() {

		return this.getAll();
	}

	@Override
	public List<Admin> getAdminsWithPagination(IPaginable paginable) {

		return getObjectsWithPagination(paginable);
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		try {
			this.update(admin);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteAdmin(Admin admin) {
		try {
			this.delete(admin);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteAdmin(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

}
