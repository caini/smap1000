package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.UnitCodeType;
/**
 * 机组编码leixing 访问接口
 * @author HuangWeili
 *
 */
public interface UnitCodeTypeDao {

	/**
	 * 添加机组编码类型
	 * @param unitCodeType
	 * @return
	 */
	public UnitCodeType addUnitCodeType(UnitCodeType unitCodeType);
	
	/**
	 * 根据Id获取机组编码类型
	 * @param id
	 * @return
	 */
	public UnitCodeType getUnitCodeType(long id);
	
	/**
	 * 根据编码ID删除机组编码类型
	 * @param id
	 * @return
	 */
	public boolean deleteUnitCodeType(long id);
	
	
	/**
	 * 更新机组编码信息
	 * @param unitCodeType
	 * @return
	 */
	public boolean updateUnitCodeType(UnitCodeType unitCodeType);
	
	/**
	 * 删除机组编码类型
	 * @param unitCodeType
	 * @return
	 */
	public boolean deleteUnitCodeType(UnitCodeType unitCodeType);
	
	/**
	 * 获取所有的机组编码类型
	 * @return
	 */
	public List<UnitCodeType> getAllUnitCodeTypes();
	
	/**
	 * 根据分页信息获取机组编码类型
	 * @param paginable
	 * @return
	 */
	public List<UnitCodeType> getUnitCodeTypesWithPagination(IPaginable paginable);
}
