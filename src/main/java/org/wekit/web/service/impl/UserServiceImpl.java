package org.wekit.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.wekit.web.db.dao.UserDao;
import org.wekit.web.db.model.User;
import org.wekit.web.service.UserService;
/**
 * 
 * @author HuangWeili
 *
 */
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Override
	public User queryUserById(String userid) {
		return this.userDao.getByID(userid);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
