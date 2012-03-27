package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.LocationCode;

/**
 * 区域定位码访问信息
 * 
 * @author HuangWeili
 * 
 */
public interface LocationCodeDao {

	/**
	 * 添加区域访问码
	 * 
	 * @param locationCode
	 * @return
	 */
	public LocationCode addLocationCode(LocationCode locationCode);

	/**
	 * 根据Id获取区域定位码
	 * 
	 * @param id
	 * @return
	 */
	public LocationCode getLocationCode(long id);

	/**
	 * 根据Id删除区域定位码
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteLocationCode(long id);

	/**
	 * 删除区域定位码
	 * 
	 * @param locationCode
	 * @return
	 */
	public boolean deleteLocationCode(LocationCode locationCode);

	/**
	 * 更新区域定位码
	 * 
	 * @param locationCode
	 * @return
	 */
	public boolean updateLocationCode(LocationCode locationCode);

	/**
	 * 获取所有的区域定位码
	 * 
	 * @return
	 */
	public List<LocationCode> getAllLocationCodes();

	/**
	 * 根据分页信息获取区域定位码
	 * 
	 * @param paginable
	 * @return
	 */
	public List<LocationCode> getLocationCodesWithPagination(IPaginable paginable);

}
