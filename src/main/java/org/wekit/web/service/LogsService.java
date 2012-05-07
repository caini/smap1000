package org.wekit.web.service;

import org.wekit.web.db.model.CodeApplyLog;
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
   public CodeApplyLog addCodeApplyLog(String userid,String username,String deptId,String deptname,String fileType,String code,String content,String operateType,long createTime);

   /**
    * 添加接口访问信息
    * @param remoteId
    * @param remotename
    * @param createTime
    * @param operateType
    * @param content
    * @return
    */
   public RemoteLog  addRemoteLog(String remoteId,String remotename,long createTime,String operateType,String content);
	
}
