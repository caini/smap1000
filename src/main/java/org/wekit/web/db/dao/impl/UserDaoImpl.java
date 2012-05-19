package org.wekit.web.db.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.WekitException;
import org.wekit.web.db.dao.UserDao;
import org.wekit.web.db.model.User;

/**
 * 
 * @author HuangWeili
 *
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateBaseDao<User,String>  implements UserDao{

	public User getByID(String userid){
		return this.get(userid);
	}
	
	@Override
	public User getByID(String userid,int status) {
	   Query query=createrQuery("from User where loginName=:userid and status=:status");
	   query.setString("userid", userid);
	   query.setInteger("status", status);
	   List<User> users=query.list();
	   if(users==null)
		   return null;
	   if(users.size()>1){
		   throw new WekitException("用户ID对应的用户不是唯一的！");
	   }
	   return users.get(0);
	}

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

}
