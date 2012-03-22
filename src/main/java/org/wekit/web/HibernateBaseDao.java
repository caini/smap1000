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
	private SessionFactory sessionFactory;


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
	 * 获取hsql查询的
	 * 
	 * @param query
	 * @param paginable
	 * @return
	 */
	protected String getCountSql(Query query, IPaginable paginable) {
		return null;
	}

	/**
	 * 获取标准sql的总数统计函数
	 * 
	 * @param nativeSql
	 * @return
	 */
	protected String getCountSql(String nativeSql) {
		return null;
	}

	/**
	 * 
	 * @param query
	 * @param paginable
	 * @return
	 */
	protected Query paginationParam(Query query, IPaginable paginable) {
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 根据对象ID获取对象
	 * 
	 * @param id
	 * @return
	 */
	public T get(PK id) {
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
	public T get(PK id, boolean isLock) {
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
	public T load(PK id) {
		return load(id, false);
	}

	/**
	 * 
	 * @param id
	 * @param isBlock
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T load(PK id, boolean isLock) {
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
	public Query createrQuery(String hsql) {
		return getSession().createQuery(hsql);
	}

	/**
	 * 创建标准的Sql
	 * 
	 * @param sql
	 * @return
	 */
	public SQLQuery createNativeQuery(String sql) {
		return getSession().createSQLQuery(sql);

	}

	/**
	 * 删除对象
	 * 
	 * @param object
	 */
	public void delete(T object) {
		getSession().delete(object);
	}

	/**
	 * 根据主键删除对象
	 * 
	 * @param id
	 */
	public void deleteByPK(PK id) {

	}

	/**
	 * 根据属性查找对象
	 * 
	 * @return
	 */
	public List<T> queryByProperty() {
		return null;
	}

	/**
	 * 保存对象
	 * 
	 * @param object
	 */
	public void save(T object) {
		getSession().save(object);
	}

	/**
	 * 保存或更新对象
	 * 
	 * @param object
	 */
	public void saveOrUpdate(T object) {
		getSession().saveOrUpdate(object);
	}

	/**
	 * 获取当前的锁定模式
	 * 
	 * @param object
	 * @return
	 */
	public LockMode getCurrentLockMode(T object) {
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
	public List<T> save(List<T> ojects, int batchSize) {
		return null;
	}

	/**
	 * 更新数据对象
	 * 
	 * @param object
	 * @return
	 */
	public T update(T object) {
		return null;
	}

	/**
	 * 获取对象的唯一标识
	 * 
	 * @param object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PK getIdentifier(T object) {
		return (PK) getSession().getIdentifier(object);
	}

	/**
	 * 获取实体的名称
	 * 
	 * @param object
	 * @return
	 */
	public String getEntityName(T object) {
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

}
