package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.OptLogDao;
import org.wekit.web.db.model.OptLog;

/**
 * 操作日志访问类
 * 
 * @author HuangWeili
 * 
 */
@Repository("optLogDao")
public class OptLogDaoImpl extends HibernateBaseDao<OptLog, Long> implements OptLogDao {

	private static Logger	logger	= Logger.getLogger(OptLogDaoImpl.class);

	@Override
	protected Class<OptLog> getEntityClass() {
		return OptLog.class;
	}

	@Override
	public OptLog getOptLog(long id) {
		return this.get(id);
	}

	@Override
	public OptLog addOptLog(OptLog optLog) {
		return this.save(optLog);
	}

	@Override
	public boolean deleteOptLog(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteOptLog(OptLog optLog) {
		try {
			this.delete(optLog);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateOptLog(OptLog optLog) {
		try {
			this.update(optLog);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<OptLog> getAllOptLogs() {
		return this.getAll();
	}

	@Override
	public List<OptLog> getOptLogsWithPagination(IPaginable paginable) {
		return this.getOptLogsWithPagination(paginable);
	}

}
