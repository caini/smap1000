package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.CodeApply;

/**
 * 
 * @author HuangWeili
 * 
 */
public interface CodeApplyService {

	/**
	 * 删除无规则编码申请
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteCodeApply(Long id);

	/**
	 * 获取所有无规则编码
	 * 
	 * @return
	 */
	public List<CodeApply> getAllCodeApplies();

	/**
	 * 根据分页信息获取无规则编码
	 * 
	 * @param paginable
	 * @return
	 */
	public List<CodeApply> getCodeAppliesWithPagination(IPaginable paginable);

	/**
	 * 添加无规则编码申请
	 * 
	 * @param apply
	 * @return
	 */
	public CodeApply addCodeApply(CodeApply apply);

	/**
	 * 更新无规则编码
	 * 
	 * @param apply
	 * @return
	 */
	public boolean udpateCodeApply(CodeApply apply);
}
