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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<CodeApplyLog> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}
}
