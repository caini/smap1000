package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.Code;

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
	public List<Code> addCodes(List<String>codes,String rule,String unitCode,String locationCode,String docCode,String creater,String createId,String note);
	

}
