package org.wekit.web.db.dao;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.model.CodeApplyLog;

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
	public CodeApplyLog saveCodeApplyLog(String userid, String username, String deptId, String deptname, String fileType, String code, String content, String operateType, long createTime) {
		CodeApplyLog applyLog=new CodeApplyLog(userid, username, deptId, deptname, createTime, fileType, code, content, operateType);
		return this.save(applyLog);
	}
}
