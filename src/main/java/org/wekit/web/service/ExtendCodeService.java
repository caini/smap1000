package org.wekit.web.service;

import java.util.List;
import java.util.Map;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.ExtendCode;

public interface ExtendCodeService {

	/**
	 * 删除无规则编码
	 * @param id
	 * @return
	 */
	public boolean deleteExtendCode(Long id);
	
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
	public boolean deleteExtendCode(long id,String creatername,String createrid,String ip) throws Exception;
	
	
	/**
	 * 根据参入的参数添加无规则编码 
	 * @param codeapplyid
	 * @param code
	 * @param note
	 * @return
	 */
	public ExtendCode addExtendCode(long codeapplyid,String code ,String note);
	
}
