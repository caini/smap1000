package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.TempCode;

/**
 * 临时编码文件目录存储
 * @author HuangWeili
 *
 */
public interface TempCodeService {

	/**
	 * 根据ID获取临时编码
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
	 * 添加临时编码
	 * @param tempCode
	 * @return
	 */
	public TempCode addTempCode(TempCode tempCode);
	
	/**
	 * 更新临时编码信息
	 * @param tempCode
	 * @return
	 */
	public boolean updateTempCode(TempCode tempCode);
	
	/**
	 * 根据编码规则的基础数据查找临时编码
	 * @param rule
	 * @param unitcode
	 * @param locationCode
	 * @param doccode
	 * @return
	 */
	public List<TempCode> queryTempCodes(String rule,String unitcode,String locationCode,String doccode,IPaginable paginable);
	
}
