package org.wekit.web.db.dao;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.Coercions;
import org.wekit.web.IPaginable;
import org.wekit.web.db.model.CodeRule;

/**
 * 编码规则相关的申请类
 * @author huangweili 
 * 
 */
public interface CodeRuleDao {

	/**
	 * 根据ID获取编码规则
	 * @param id
	 * @return
	 */
	public CodeRule getCodeRule(long id);
	
	/**
	 * 根据编码规则，获取编码规则的详细信息
	 * @param codeRule
	 * @return
	 */
	public CodeRule getCodeRule(String codeRule);
	
	/**
	 * 添加编码规则
	 * @param codeRule
	 * @return
	 */
	public CodeRule addCodeRule(CodeRule codeRule);

	
	/**
	 * 更新编码规则
	 * @param codeRule
	 * @return
	 */
	public boolean updateCodeRule(CodeRule codeRule);
	
	
	/**
	 * 删除编码规则
	 * @param codeRule
	 * @return
	 */
	public boolean deleteCodeRule(CodeRule codeRule);
	
	/**
	 * 删除编码规则
	 * @param id
	 * @return
	 */
	public boolean deleteCodeRule(long id);
	
	/**
	 * 获取所有的编码规则
	 * @return
	 */
	public List<CodeRule> getAllCodeRules();
	
	/**
	 * 根据分页信息获取编码规则
	 * @param paginable
	 * @return
	 */
	public List<CodeRule> getCodeRulesWidthPagination(IPaginable paginable);
	

	
}
