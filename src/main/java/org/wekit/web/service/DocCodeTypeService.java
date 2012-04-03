package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.DocCodeType;

/**
 * 文件编码类型
 * 
 * @author HuangWeili
 * 
 */
public interface DocCodeTypeService {

	/**
	 * 根据Id获取编码
	 * 
	 * @param id
	 * @return
	 */
	public DocCodeType getDocCodeType(long id);

	/**
	 * 根据编码获取详情
	 * 
	 * @param code
	 * @return
	 */
	public DocCodeType getDocCodeType(String code);

	/**
	 * 获取所有的编码类型
	 * 
	 * @return
	 */
	public List<DocCodeType> getAllDocCodeTypes();

	/**
	 * 根据分页信息查询编码类型
	 * 
	 * @param paginable
	 * @return
	 */
	public List<DocCodeType> queryDocCodeTypes(IPaginable paginable);

	/**
	 * 根据关键字，状态，分页信息查询
	 * 
	 * @param key
	 * @param state
	 * @param paginable
	 * @return
	 */
	public List<DocCodeType> queryDocCodeTypes(String key, int state, IPaginable paginable);
}
