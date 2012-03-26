package org.wekit.web.db.dao.impl;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.OptLogDao;
import org.wekit.web.db.model.OptLog;
/**
 * 操作日志访问类
 * @author HuangWeili
 *
 */
@Repository("optLogDao")
public class OptLogDaoImpl extends HibernateBaseDao<OptLog, Long> implements OptLogDao{

	@Override
	protected Class<OptLog> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
