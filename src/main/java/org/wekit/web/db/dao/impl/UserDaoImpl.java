package org.wekit.web.db.dao.impl;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.UserDao;
import org.wekit.web.db.model.User;

/**
 * 
 * @author HuangWeili
 *
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateBaseDao<User,String>  implements UserDao{

	@Override
	public User getByID(String userid) {
		return this.get(userid);
	}

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	
}
