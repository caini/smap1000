package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.AdminDao;
import org.wekit.web.db.model.Admin;

@Repository("adminDao")
public class AdminDaoImpl extends HibernateBaseDao<Admin, Long> implements AdminDao {

	@Override
	public Admin getAdmin(long id) {
		// TODO Auto-generated method stub
		return this.get(id);
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return this.save(admin);
	}

	@Override
	protected Class<Admin> getEntityClass() {
		// TODO Auto-generated method stub
		return Admin.class;
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return this.getAll();
	}

	@Override
	public List<Admin> getAdminsWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return getObjectsWithPagination(paginable);
	}

}
