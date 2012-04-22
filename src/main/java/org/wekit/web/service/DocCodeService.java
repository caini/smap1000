package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.DocCode;

/**
 * 文件类型编码
 * 
 * @author HuangWeili
 * 
 */
public interface DocCodeService {

	/**
	 * 根据文件编码ID获取详细信息
	 * 
	 * @param id
	 * @return
	 */
	public DocCode getDocCode(long id);

	/**
	 * 根据编码获取详细信息
	 * 
	 * @param code
	 * @return
	 */
	public DocCode getDocCode(String code);

	/**
	 * 获取所有的文件类型编码
	 * 
	 * @return
	 */
	public List<DocCode> getAllDocCodes();

	/**
	 * 根据分页信息获取所有的编码信息
	 * 
	 * @param paginable
	 * @return
	 */
	public List<DocCode> queryDocCodes(IPaginable paginable);

	/**
	 * 根据关键字，类型Id，状态，分页信息获取编码信息
	 * 
	 * @param key
	 * @param typeId
	 * @param state
	 * @param paginable
	 * @return
	 */
	public List<DocCode> queryDocCodes(String key, long typeId, int state, IPaginable paginable);
	
	/**
	 * 根据传入的关键字删除文档类型编码
	 * @param key
	 * @return
	 */
	public boolean deleteDocCodes(long docCodeId,String createrName,String createrid,String ip) throws Exception;
	
	/**
	 * 
	 * @return
	 */
	public DocCode saveDocCode();
	
	public DocCode updateDocCode();

}
