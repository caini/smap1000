package org.wekit.web.db.dao;

import org.wekit.web.db.model.RemoteLog;

public interface RemoteLogDao {
	public final static String APPLYCODE="有规则编码申请";
	
	public final static String APPLYCODES="编码批量申请";
	
	public final static String CANCELCODE="有规则编码撤销";
	
	public final static String UAPPLYCODE="无规则编码申请";
	
	public final static String UCANCELCODE="无规则编码撤销";
	
	public RemoteLog savelog(RemoteLog remoteLog);
}
