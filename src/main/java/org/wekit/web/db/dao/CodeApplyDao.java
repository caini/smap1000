package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.CodeApply;

public interface CodeApplyDao {

	/**
	 * 添加编码
	 * @return
	 */
	public CodeApply addCodeApply(CodeApply codeApply);
	
	/**
	 * 更新编码状态
	 * @param codeApply
	 * @return
	 */
	public boolean updateCodeApply(CodeApply codeApply);
	
	/**
	 * 删除编码申请
	 * @param codeApply
	 * @return
	 */
	public boolean deleteCodeApply(CodeApply  codeApply);
	
	
	/**
	 * 根据ID删除编码申请
	 * @param id
	 * @return
	 */
	public boolean deleteCodeApply(Long id);
	
	/**
	 * 获取编码的详细系信息
	 * @param id
	 * @return
	 */
	public CodeApply getCodeApply(Long id);
	
	/**
	 * 获取所有的编码
	 * @return
	 */
	public List<CodeApply> getAllCodeApplies();
	
	/**
	 * 分页获取编码申请
	 * @param paginable
	 * @return
	 */
	public List<CodeApply> getCodeAppliesWithPagination(IPaginable paginable);

	
}
