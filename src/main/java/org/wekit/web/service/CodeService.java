package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.Pagination;
import org.wekit.web.db.model.Code;
import org.wekit.web.db.model.TempCode;

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
	 * 更新编码信息
	 * @param code
	 * @return
	 */
	public Code updateCode(Code code);
	
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
	public Pagination<Code> getCodesWithPagination(IPaginable paginable);
	
	/**
	 * 添加编码
	 * @param code
	 * @return
	 */
	public Code addCode(Code code);
	
	/**
	 * 获取临时编码
	 * @param id
	 * @return
	 */
	public TempCode getTempCode(Long id);
	
	/**
	 * 获取临时编码
	 * @param code
	 * @return
	 */
	public TempCode getTempCode(String code);
	
	/**
	 * 根据Id删除临时编码
	 * @param id
	 * @return
	 */
	public boolean deleteTempCode(Long id);
	
	/**
	 * 根据编码信息删除临时编码
	 * @param code
	 * @return
	 */
	public boolean deleteTempCode(String code);
	
	
	
	
 }
