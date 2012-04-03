package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.DocCode;

/**
 * 文件类型编码访问规则
 * 
 * @author huangweili
 * 
 */
public interface DocCodeDao {

	/**
	 * 添加编码信息
	 * 
	 * @param docCode
	 * @return
	 */
	public DocCode addDocCode(DocCode docCode);

	/**
	 * 获取编码信息
	 * 
	 * @param id
	 * @return
	 */
	public DocCode getDocCode(long id);

	/**
	 * 更新编码状态
	 * 
	 * @param docCode
	 * @return
	 */
	public boolean updateDocCode(DocCode docCode);

	/**
	 * 根据编码删除数据
	 * 
	 * @param docCode
	 * @return
	 */
	public boolean deleteDocCode(DocCode docCode);

	/**
	 * 根据Id删除编码
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteDocCdoe(long id);

	/**
	 * 获取所有的分页信息
	 * 
	 * @return
	 */
	public List<DocCode> getAllDocCodes();

	/**
	 * 根据分页悉信息获取对象
	 * 
	 * @param paginable
	 * @return
	 */
	public List<DocCode> getDocCodesWithPagination(IPaginable paginable);

	/**
	 * 根据查询条件查找对象
	 * 
	 * @param key
	 * @param typeId
	 * @param state
	 * @param paginable
	 * @return
	 */
	public List<DocCode> queryDocCodes(String key, long typeId, int state, IPaginable paginable);

	/**
	 * 根据编码获取编码详情
	 * 
	 * @param code
	 * @return
	 */
	public DocCode getDocCode(String code);
}
