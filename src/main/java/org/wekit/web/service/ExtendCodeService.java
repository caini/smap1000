package org.wekit.web.service;

import java.util.List;
import java.util.Map;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.ExtendCode;

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
	public ExtendCode addExtendCode(String createrid, long createtime, String note, String applyTitle, String applyid, String docCode, String unitCode, String locationCode, int state, String applyedid, String applyedname, String result, String filename,String mask,int fileType,String fileTypeName);
	
	
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
	public boolean deleteExtendCode(long id,String createrid,String ip,int filetype) throws Exception;
	

	
}
