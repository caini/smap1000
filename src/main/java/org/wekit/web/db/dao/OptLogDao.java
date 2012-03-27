package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.OptLog;

public interface OptLogDao {

	public OptLog getOptLog(long id);
	
	public OptLog addOptLog(OptLog optLog);
	
	public boolean deleteOptLog(long id);
	
	
	public boolean deleteOptLog(OptLog optLog);
	
	public boolean updateOptLog(OptLog optLog);
	
	public List<OptLog> getAllOptLogs();
	
	public List<OptLog> getOptLogsWithPagination(IPaginable paginable);
	
}
