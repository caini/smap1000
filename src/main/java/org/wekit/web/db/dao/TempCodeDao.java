package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.TempCode;
/**
 * 临时规则码访问层
 * @author HuangWeili
 *
 */
public interface TempCodeDao {

	/**
	 * 添加临时编码
	 * @param tempCode
	 * @return
	 */
	public TempCode addTempCode(TempCode tempCode);

	/**
	 * 根据Id获取临时编码
	 * @param id
	 * @return
	 */
	public TempCode getTempCode(long id);

	/**
	 * 删除临时编码
	 * @param tempCode
	 * @return
	 */
	public boolean deleteTempCode(TempCode tempCode);

	/**
	 * 根据Id删除临时编码
	 * @param id
	 * @return
	 */
	public boolean deleteTempCode(long id);

	/**
	 * 更新临时编码
	 * @param tempCode
	 * @return
	 */
	public boolean updateTempCode(TempCode tempCode);

	/**
	 * 获取所有的临时编码
	 * @return
	 */
	public List<TempCode> getAllTempCodes();

	/**
	 * 根据分页信息获取临时编码
	 * @return
	 */
	public List<TempCode> getTempCodesWithPagination(IPaginable paginable);
	
	/**
	 * 根据查询条件查找对象
	 * @param rule
	 * @param unitcode
	 * @param locationCode
	 * @param doccode
	 * @param paginable
	 * @return
	 */
	public List<TempCode> queryTempCodes(String rule, String unitcode, String locationCode, String doccode,int minSequence,int maxDequence,int year,int month,int day, IPaginable paginable);

}
