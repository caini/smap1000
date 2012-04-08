package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.OptLog;

/**
 * 操作日志访问层
 * @author HuangWeili
 *
 */
public interface OptLogDao {

	/**
	 * 根据Id获取操作日志
	 * @param id
	 * @return
	 */
	public OptLog getOptLog(long id);

	/**
	 * 添加操作日志
	 * @param optLog
	 * @return
	 */
	public OptLog addOptLog(OptLog optLog);

	/**
	 * 根据Id删除操作日志
	 * @param id
	 * @return
	 */
	public boolean deleteOptLog(long id);

	/**
	 * 删除操作日志
	 * @param optLog
	 * @return
	 */
	public boolean deleteOptLog(OptLog optLog);

	/**
	 * 更新操作日志
	 * @param optLog
	 * @return
	 */
	public boolean updateOptLog(OptLog optLog);

	/**
	 * 获取所有的操作日志
	 * @return
	 */
	public List<OptLog> getAllOptLogs();

	/**
	 * 根据分页信息获取操作日志
	 * @param paginable
	 * @return
	 */
	public List<OptLog> getOptLogsWithPagination(IPaginable paginable);
	
	/**
	 * 根据条件增加访问对象信息
	 * @param systemid
	 * @param systemname
	 * @param username
	 * @param userid
	 * @param content
	 * @param operatorTime
	 * @param ip
	 * @param opter
	 * @return
	 */
	public OptLog addOptLog(String systemid,String systemname,String username,String userid,String content,long operatorTime,String ip,String opter);

}
