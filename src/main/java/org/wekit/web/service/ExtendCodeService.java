package org.wekit.web.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.ExtendCode;
import org.wekit.web.imports.ExtendCodeWrap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface ExtendCodeService {

	/**
	 * 更新无规则编码
	 * @param code
	 * @return
	 */
	public boolean updateExtendCode(ExtendCode code);
	
	/**
	 * 获取所有的无规则编码
	 * @return
	 */
	public List<ExtendCode> getAllExtendCodes();
	
	/**
	 * 根据分页信息获取无规则编码
	 * @param paginable
	 * @return
	 */
	public List<ExtendCode> getExtendCodesWithPagination(IPaginable paginable);
	
	/**
	 * 添加无规则编码
	 * @param code
	 * @return
	 */
	public ExtendCode addExtendCode(ExtendCode code);
	
	
	/**
	 * 添加无规则编码
	 * @param createrid
	 * @param createtime
	 * @param note
	 * @param applyTitle
	 * @param applyid
	 * @param docCode
	 * @param unitCode
	 * @param locationCode
	 * @param state
	 * @param applyedid
	 * @param applyedname
	 * @param result
	 * @param filename
	 * @param mask
	 * @param fileType
	 * @param fileTypeName
	 * @return
	 */
	public ExtendCode addExtendCode(String createrid,String note,long applyid,String applyTitle, String docCode, String unitCode, String locationCode, int state,  String result, String filename,String mask,long filetype)throws JsonGenerationException, JsonMappingException, IOException;
	
	
	/**
	 * 查询无规则编码
	 * @return
	 */
	public List<ExtendCode> queryExtendCode(Map<String, String> param,IPaginable iPaginable);
	
	
	/**
	 * 根据Id删除规则外的编码
	 * @param id
	 * @param creatername
	 * @param createrid
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public boolean deleteExtendCode(long id,String createrid,String ip) throws Exception;
	
	/**
	 * 无规则编码导入功能
	 * @param json
	 */
	public ExtendCodeWrap[] importCodes(String json);
}
