package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.DocCodeType;

public interface DocCodeTypeDao {

	/**
	 * 添加编码
	 * @param docCodeType
	 * @return
	 */
	public DocCodeType addDocCodeType(DocCodeType docCodeType);
	
	/**
	 * 根据编码获取详细情况
	 * @param code
	 * @return
	 */
	public DocCodeType getDocCodeType(String code);
	
	
	/**
	 * 根据Id获取编码信息
	 * @param id
	 * @return
	 */
	public DocCodeType getDocCodeType(long id);
	
	/**
	 * 删除编码类型信息
	 * @param id
	 * @return
	 */
	public boolean deleteDocCodeType(long id);
	
	/**
	 * 删除编码类型信息
	 * @param docCodeType
	 * @return
	 */
	public boolean deleteDocCodeType(DocCodeType docCodeType);
	
	/**
	 * 更新编码类型悉信息
	 * @param docCodeType
	 * @return
	 */
	public boolean updateDocCodeType(DocCodeType docCodeType);
	
	/**
	 * 获取所有编码类型信息
	 * @return
	 */
	public List<DocCodeType> getAllDocCodeTypes();
	
	/**
	 * 根据分页信息获取所有编码类型信息
	 * @param paginable
	 * @return
	 */
	public List<DocCodeType> getDocCodeTypesWithPagination(IPaginable paginable);
	
	/**
	 * 根据关键字，状态，分页信息查询编码类型信息
	 * @param key
	 * @param state
	 * @param paginable
	 * @return
	 */
	public List<DocCodeType> queryDocCodeTypes(String key, int state, IPaginable paginable);
}
