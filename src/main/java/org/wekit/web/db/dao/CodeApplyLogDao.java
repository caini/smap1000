package org.wekit.web.db.dao;

import org.wekit.web.db.model.CodeApplyLog;

public interface CodeApplyLogDao {
	public final static String APPLYOPERATE="规则编码申请"; //有规则编码申请

	public final static String CANCELOPERATE="规则编码撤销";//取消有规则编码
	
	public final static String UAPPLAYOPERATE="无规则编码申请";//无规则编码申请
	
	public final static String UCANCELOPERATE="无规则编码撤销"; //无规则编码撤销
	
	public CodeApplyLog saveCodeApplyLog(CodeApplyLog codeApplyLog);
	
	/**
	 * 
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
	public CodeApplyLog saveCodeApplyLog(String userid,String username,String deptId,String deptname,long fileType,String code,String content,String operateType,long createTime,String fileTypeName);
}
