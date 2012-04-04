package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.Code;

public interface CodeService {

	/**
	 * 根据编码ID获取编码信息
	 * @param id
	 * @return
	 */
	public Code getCode(Long id);
	
	
	/**
	 * 根据编码获取编码信息
	 * @param code
	 * @return
	 */
	public Code getCode(String code);
	
	
	/**
	 * 删除编码
	 * @param code
	 * @return
	 */
	public boolean deleteCode(Code code);
	
	/**
	 * 根据编码Id删除编码
	 * @param codeId
	 * @return
	 */
	public boolean deleteCode(Long codeId);
	
	
	/**
	 * 取消编码，正常的业务规则
	 * @param codeId
	 * @return
	 */
	public boolean cancelCode(Long codeId);
	
	
	/**
	 * 取消编码，正常的业务规则
	 * @param code
	 * @return
	 */
	public boolean cancelCode(String code);
	
	
	/**
	 * 根据传入的ID进行取号操作
	 * @param rule
	 * @param unitCode
	 * @param locationCode
	 * @param docCode
	 * @param creater
	 * @param createId
	 * @param note
	 * @return
	 */
	public Code fetchCode(String rule,String unitCode,String locationCode,String docCode,String creater,String createId,String note);
	
	
	
	
	/**
	 * 更新编码信息
	 * @param code
	 * @return
	 */
	public boolean updateCode(Code code);
	
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
	public List<Code> getCodesWithPagination(IPaginable paginable);
	
	/**
	 * 添加编码
	 * @param code
	 * @return
	 */
	public Code addCode(Code code);
	

	

 }
