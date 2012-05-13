package org.wekit.web.db.dao;

import java.util.List;
import java.util.Map;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.Code;
import org.wekit.web.db.model.CodeRule;
import org.wekit.web.db.model.User;

public interface CodeDao {

	/**
	 * 添加编码
	 * @return
	 */
	public Code addCode(Code code);
	
	/**
	 * 获取所有的编码
	 * @return
	 */
	public List<Code> getAllCodes();
	
	/**
	 * 根据分页信息获取编码
	 * @param paginable
	 * @return
	 */
	public List<Code> getCodesWithPaginable(IPaginable paginable);
	
	/**
	 * 更新编码
	 * @param code
	 * @return
	 */
	public boolean updateCode(Code code);
	
	/**
	 * 删除编码信息
	 * @param code
	 * @return
	 */
	public boolean deleteCode(Code code);
	
	/**
	 * 删除编码信息
	 * @param id
	 * @return
	 */
	public boolean deleteCode(Long id);
	
	/**
	 * 获取编码信息
	 * @param id
	 * @return
	 */
	public Code getCode(Long id);
	
	/**
	 * 根据code 获取code的详细信息，code为唯一标识
	 * @param code
	 * @return
	 */
	public Code getCode(String code);
	
	/**
	 * 根据生成的编码规则批量的生成相应的编码
	 * @param codes
	 * @param rule
	 * @param unitCode
	 * @param locationCode
	 * @param docCode
	 * @param creater
	 * @param createId
	 * @param note
	 * @return
	 */
	public List<Code> addCodes(List<String>codes,CodeRule codeRule,String unitCode,String locationCode,String docCode,User user,String note,String fileName,String codeName);
	
	/**
	 * 根据查询的数组查询编码
	 * @param map
	 * @return
	 */
	public List<Code> queryCodes(Map<String , String> map,IPaginable paginable);

}
