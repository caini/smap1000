package org.wekit.web.db.dao;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.model.CodeApplyLog;

public class CodeApplyLogDaoImpl extends HibernateBaseDao<CodeApplyLog, Long> implements CodeApplyLogDao {

	@Override
	public CodeApplyLog saveCodeApplyLog(CodeApplyLog codeApplyLog) {
		return this.save(codeApplyLog);
	}

	@Override
	protected Class<CodeApplyLog> getEntityClass() {
		return CodeApplyLog.class;
	}

	
}
