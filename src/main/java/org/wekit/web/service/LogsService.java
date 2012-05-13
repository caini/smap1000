package org.wekit.web.service;

import org.wekit.web.db.model.CodeApplyLog;
import org.wekit.web.db.model.OptLog;
import org.wekit.web.db.model.RemoteLog;


public interface LogsService {

   /**
    * 添加代码申请日志
    * @param userid
    * @param username
    * @param deptId
    * @param deptname
    * @param fileType
    * @param code
    * @param content
    * @param operateType
    * @param createTime
    * @return
    */
   public CodeApplyLog addCodeApplyLog(String userid,  int fileType, String code, String content, String operateType);

   /**
    * 添加接口访问信息
    * @param remoteId
    * @param remotename
    * @param createTime
    * @param operateType
    * @param content
    * @return
    */
   public RemoteLog  addRemoteLog(long remoteId,String remotename,String operateType,String content);
	
   /**
    * 根据参数添加通用日志功能
    * @param systemId
    * @param systemName
    * @param userid
    * @param username
    * @param content
    * @param operatorTime
    * @param ip
    * @param operate
    * @return
    */
   public OptLog addOptLog(String systemId,String systemName,String userid,String username,String content,String ip,String operate,String deptName);
}
