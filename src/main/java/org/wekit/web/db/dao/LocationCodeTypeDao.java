package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.LocationCodeType;

/**
 * 定位码类型访问层
 * @author HuangWeili
 *
 */
public interface LocationCodeTypeDao {

	/**
	 * 添加区域定位码类型
	 * @param locationCodeType
	 * @return
	 */
	public LocationCodeType addLocationCodeType(LocationCodeType locationCodeType);

	/**
	 * 根据Id获取区域定位码类型
	 * @param id
	 * @return
	 */
	public LocationCodeType getLocationCodeType(long id);

	/**
	 * 根据Id删除区域定位码类型
	 * @param id
	 * @return
	 */
	public boolean deleteLocationCodeType(long id);

	/**
	 * 删除区域定位码类型
	 * @param locationCodeType
	 * @return
	 */
	public boolean deleteLocationCodeType(LocationCodeType locationCodeType);

	/**
	 * 更新区域定位码
	 * @param locationCodeType
	 * @return
	 */
	public boolean updateLocationCodeType(LocationCodeType locationCodeType);

	/**
	 * 获取所有的区域定位码
	 * @return
	 */
	public List<LocationCodeType> getAllLocationCodeTypes();

	/**
	 * 根据分页信息获取区域定位码
	 * @param paginable
	 * @return
	 */
	public List<LocationCodeType> getLocationCodeTypesWithPagination(IPaginable paginable);

}
