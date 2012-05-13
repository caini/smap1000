package org.wekit.web.db.dao.impl;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.CodeApplyLogDao;
import org.wekit.web.db.model.CodeApplyLog;
/**
 * 编码申请日志操作
 * @author HuangWeili
 *
 */
@Repository("codeApplyLogDao")
public class CodeApplyLogDaoImpl extends HibernateBaseDao<CodeApplyLog, Long> implements CodeApplyLogDao {

	@Override
	public CodeApplyLog saveCodeApplyLog(CodeApplyLog codeApplyLog) {
		return this.save(codeApplyLog);
	}

	@Override
	protected Class<CodeApplyLog> getEntityClass() {
		return CodeApplyLog.class;
	}

	@Override
	public CodeApplyLog saveCodeApplyLog(String userid, String username, String deptId, String deptname, int fileType, String code, String content, String operateType, long createTime) {
		CodeApplyLog codeApplyLog=new CodeApplyLog(userid,username,deptId,deptname,createTime,fileType,code,content,operateType);
		return codeApplyLog;
	}
}
