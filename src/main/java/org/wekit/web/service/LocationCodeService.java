package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.LocationCode;

public interface LocationCodeService {

	/**
	 * 根据Id获取定位码
	 * @param id
	 * @return
	 */
	public LocationCode getLocationCode(long id);
	
	/**
	 * 根据编码获取编码详细信息
	 * @param code
	 * @return
	 */
	public LocationCode getLocationCode(String code);
	
	/**
	 * 获取所有定位码
	 * @return
	 */
	public List<LocationCode > getAllLocationCodes();
	
	/**
	 * 根据分页信息查询定位码
	 * @param paginable
	 * @return
	 */
	public List<LocationCode> queryLocationCodes(IPaginable paginable);
	
	
	/**
	 * 根据关键字和类型ID，状态，分页信息获取编码
	 * @param key
	 * @param typeId
	 * @param state
	 * @param paginable
	 * @return
	 */
	public List<LocationCode> queryLocationCodes(String key,long typeId,int state,IPaginable paginable);
	
	/**
	 * 根据参数删除指定的定位码
	 * @param key
	 * @param creatername
	 * @param createrId
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public boolean deleteLocationCode(Long key,String creatername,String createrId,String ip) throws Exception;
}
