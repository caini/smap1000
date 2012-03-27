package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
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

	@Override
	public OptLog getOptLog(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OptLog addOptLog(OptLog optLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOptLog(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOptLog(OptLog optLog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOptLog(OptLog optLog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OptLog> getAllOptLogs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OptLog> getOptLogsWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

}
