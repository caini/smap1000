package org.wekit.web.test;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestAction {

	@Resource()
	private SessionFactory sessionFactory;
	
	public String say()
	{
        boolean conned=sessionFactory.getCurrentSession().isConnected();
		return "fdsfdsf";
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
