package org.wekit.web.service;

import org.wekit.web.db.model.User;
/**
 * 
 * @author HuangWeili
 *
 */
public interface UserService {

	public User queryUserById(String userid,int state);
}
