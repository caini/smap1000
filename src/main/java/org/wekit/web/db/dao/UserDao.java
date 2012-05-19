package org.wekit.web.db.dao;

import org.wekit.web.db.model.User;
/**
 * 
 * @author HuangWeili
 *
 */
public interface UserDao {

	public User getByID(String userid,int status);
	
}
