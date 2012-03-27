package org.wekit.web;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory;
import org.hibernate.hql.spi.QueryTranslator;
import org.hibernate.hql.spi.QueryTranslatorFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author huangweili
 * 
 * @param <T>
 *            //泛型d
 */
public abstract class HibernateBaseDao<T, PK extends Serializable> {

	@Autowired
	private SessionFactory	sessionFactory;

	/**
	 * 获取Hibernate的Session会话
	 * 
	 * @return
	 */
	protected Session getSession() {
		try {
			return this.sessionFactory.getCurrentSession();
		} catch (Exception e) {
			return this.sessionFactory.openSession();
		}

	}

	/**
	 * 获取访问的实体类型
	 * 
	 * @return
	 */
	protected abstract Class<T> getEntityClass();

	/**
	 * 获取标准sql的总数统计函数
	 * 
	 * @param nativeSql
	 * @return
	 */
	protected String getCountSql(String nativeSql) {
		String lowcase = nativeSql.toLowerCase();
		int index = lowcase.indexOf("from");
		String countSql = "select count(1) " + nativeSql.substring(index);
		return countSql;
	}

	/**
	 * 
	 * @param query
	 * @param paginable
	 * @return
	 */
	protected Query paginationParam(Query query, IPaginable paginable) {
		if (paginable.isCount()) {
			String nativeSql = this.QueryToNativeSql(query);
			Query nativequery = getSession().createSQLQuery(getCountSql(nativeSql));
			Object object = nativequery.uniqueResult();
			paginable.setTotleCount(Integer.parseInt(object.toString()));
		}
		query.setFirstResult(paginable.getPageSize() * paginable.getCurrentPage() - 1);
		query.setFetchSize(paginable.getPageSize());
		return query;
	}

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 根据对象ID获取对象
	 * 
	 * @param id
	 * @return
	 */
	protected T get(PK id) {
		return get(id, false);
	}

	/**
	 * 采用get获取对象
	 * 
	 * @param id
	 * @param isLock
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected T get(PK id, boolean isLock) {
		if (isLock) {
			return (T) getSession().get(getEntityClass(), id, LockOptions.UPGRADE);
		} else {
			return (T) getSession().get(getEntityClass(), id);
		}
	}

	/**
	 * 加载类型对象
	 * 
	 * @param id
	 * @return
	 */
	protected T load(PK id) {
		return load(id, false);
	}

	/**
	 * 
	 * @param id
	 * @param isBlock
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected T load(PK id, boolean isLock) {
		if (isLock) {
			return (T) getSession().load(getEntityClass(), id, LockOptions.UPGRADE);
		} else {
			return (T) getSession().load(getEntityClass(), id);
		}
	}

	/**
	 * 创建不带参数的查询命令
	 * 
	 * @param hsql
	 * @return
	 */
	protected Query createrQuery(String hsql) {
		return getSession().createQuery(hsql);
	}

	/**
	 * 创建标准的Sql
	 * 
	 * @param sql
	 * @return
	 */
	protected SQLQuery createNativeQuery(String sql) {
		return getSession().createSQLQuery(sql);

	}

	/**
	 * 删除对象
	 * 
	 * @param object
	 */
	protected void delete(T object) {
		getSession().delete(object);
	}

	/**
	 * 根据主键删除对象
	 * 
	 * @param id
	 */
	protected void deleteByPK(PK id) {
		T object = get(id);
		delete(object);
	}

	/**
	 * 根据属性查找对象
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> queryByProperty(String propertyName, Object propertyValeu) {
		Query query= createrQuery("from "+getEntityClass().getName() +"bean where bean."+propertyName+"=:value");
		query.setParameter("value",propertyValeu);
		return query.list();
	}

	/**
	 * 保存对象
	 * 
	 * @param object
	 */
	protected T save(T object) {
		getSession().save(object);
		return object;
	}

	/**
	 * 保存或更新对象
	 * 
	 * @param object
	 */
	protected T saveOrUpdate(T object) {
		getSession().saveOrUpdate(object);
		return object;
	}

	/**
	 * 获取当前的锁定模式
	 * 
	 * @param object
	 * @return
	 */
	protected LockMode getCurrentLockMode(T object) {
		return getSession().getCurrentLockMode(object);
	}

	/**
	 * 批量添加数据
	 * 
	 * @param ojects
	 *            //要添加的数据列表
	 * @param batchSize
	 *            //多少数据刷新一次
	 * @return
	 */
	protected List<T> save(List<T> ojects, int batchSize) {

		return null;
	}

	/**
	 * 更新数据对象
	 * 
	 * @param object
	 * @return
	 */
	protected T update(T object) {
		getSession().update(object);
		return object;
	}

	/**
	 * 获取对象的唯一标识
	 * 
	 * @param object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected PK getIdentifier(T object) {
		return (PK) getSession().getIdentifier(object);
	}

	/**
	 * 获取实体的名称
	 * @param object
	 * @return
	 */
	protected String getEntityName(T object) {
		return getSession().getEntityName(object);
	}

	/**
	 * 刷新当前的session对象
	 */
	public void flush() {
		getSession().flush();
	}

	/**
	 * 把hibernate中的Query转换成标准的sql 语句
	 * 
	 * @return
	 */
	protected String QueryToNativeSql(Query query) {
		QueryTranslatorFactory factory = new ASTQueryTranslatorFactory();
		SessionFactoryImplementor factoryImplementor = (SessionFactoryImplementor) getSessionFactory();
		QueryTranslator translator = factory.createQueryTranslator(query.getQueryString(), query.getQueryString(), Collections.EMPTY_MAP, factoryImplementor);
		translator.compile(Collections.EMPTY_MAP, false);
		return translator.getSQLString();
	}
	
    @SuppressWarnings("unchecked")
	protected List<T> getAll(){
    	Query query=createrQuery("from "+ getEntityClass().getName());
    	return query.list();
    }

    @SuppressWarnings("unchecked")
	protected List<T> getObjectsWithPagination(IPaginable paginable){
    	Query query=createrQuery("from "+ getEntityClass().getName());
    	query =paginationParam(query, paginable);
    	return query.list();
    }
}
