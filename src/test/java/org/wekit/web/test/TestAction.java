package org.wekit.web.test;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.jasypt.util.text.BasicTextEncryptor;
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
	
	
	
	public static void main(String[] test){
		BasicTextEncryptor strongTextEncryptor=new BasicTextEncryptor();
		strongTextEncryptor.setPassword("caini");
		String test2=strongTextEncryptor.encrypt("unit=SM1&codename=&location=GV5&doc=GSR&filename=状态报告1&createrid=gexc&ruleid=1335174996109&note=备注2&t="+System.currentTimeMillis());
		System.out.println(test2);
		
		BasicTextEncryptor basicTextEncryptor=new BasicTextEncryptor();
		basicTextEncryptor.setPassword("caini");
		System.out.println(test2);
		System.out.println(strongTextEncryptor.decrypt("3nfXi9cJ7IaZfWOuQeMLi6XzTZbYCZoQbwJVJGLEzxdXW2l/tNKda97xkYVz8wRpmWKNHbBJrldqUl+gouRzAag4EBmq+d6MLDItEFDei7SJv6jupN6ayDExo2TKHMdUxv6EtntM9v0AJxeEehScIlSW8shAdeMPezLgw+vfez+kTGusR/QRog=="));
	}
	
}
