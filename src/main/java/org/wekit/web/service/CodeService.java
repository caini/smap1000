package org.wekit.web.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.Code;
import org.wekit.web.imports.CodeWrap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

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
	
	public boolean cancelCode(Long codeId,String createrid,String ip,String note);
	
	
	/**
	 * 取消编码，正常的业务规则
	 * @param code
	 * @return
	 */
	public boolean cancelCode(String code,String createrid,String ip,String note);
	
	
	/**
	 * 根据传入的信息进行取号操作
	 * @param rule
	 * @param unitCode
	 * @param locationCode
	 * @param docCode
	 * @param creater
	 * @param createId
	 * @param note
	 * @return
	 */
	public Code fetchCode(long ruleId, String unitCode, String locationCode, String docCode, String createrId, String note, String filename, String codeName) throws JsonGenerationException, JsonMappingException, IOException;
	
	/**
	 * 根据传入的信息进行批量取号操作
	 * @param rule
	 * @param unitCode
	 * @param locationCode
	 * @param docCode
	 * @param creater
	 * @param createId
	 * @param note
	 * @param batchSize
	 * @return
	 */
	public List<Code> batchCode(long ruleId, String unitCode, String locationCode, String docCode,String createId, String note, int batchSize,String filename,String codeName)throws JsonGenerationException, JsonMappingException, IOException ;
	
	
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
	

	/**
	 * 根据动态参数匹配数据
	 * @param map
	 * @param paginable
	 * @return
	 */
	public List<Code> queryCodes(Map<String, String> map,IPaginable paginable);

	/**
	 * 根据参数删除编码
	 * @param id
	 * @param creater
	 * @param createrid
	 * @param ip
	 * @return
	 */
	public boolean deleteCode(Long id,String creater,String createrid,String ip) throws Exception;
	
	
	/**
	 * 导入数据
	 * @param json
	 */
	public CodeWrap[] importCodes(String json);

 }
