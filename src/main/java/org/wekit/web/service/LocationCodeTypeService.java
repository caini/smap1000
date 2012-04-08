package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.LocationCodeType;

public interface LocationCodeTypeService {

	/**
	 * 根据分页信息获取LocationCodeType，当分页信息为空的时候返回全部
	 * @param paginable
	 * @return
	 */
	public List<LocationCodeType> queryLocationCodeTypes(IPaginable paginable);
	
	/**
	 * 返回所有的编码类型信息
	 * @return
	 */
	public List<LocationCodeType> getAllCodeTypes();
	
	/**
	 * 根据Id获取定位码编码类型信息
	 * @param id
	 * @return
	 */
	public LocationCodeType getCodeType(long id);
	
	/**
	 * 根据关键字和编码类型信息获取编码相关的内容信息
	 * @param key
	 * @param state
	 * @param paginable
	 * @return
	 */
	public List<LocationCodeType> queryLocationCodeTypes(String key,int state,IPaginable paginable);
	
	
	/**
	 * 根据删除定位码的类型
	 * @param id
	 * @param createrName
	 * @param createrId
	 * @param ip
	 * @return
	 */
	public boolean deleteLocationType(long id,String createrName,String createrId,String ip);
}
