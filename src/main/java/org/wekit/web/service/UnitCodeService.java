package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.UnitCode;

public interface UnitCodeService {
	

	/**
	 * 根据关键字查找机组信息
	 * @param key
	 * @param state
	 * @param paginable
	 * @return
	 */
	
	public List<UnitCode> queryUnitCodes(String key,int state,IPaginable paginable);
	
	/**
	 * 根据
	 * @param key
	 * @param typeId
	 * @param state
	 * @param paginable
	 * @return
	 */
	public List<UnitCode> queryUnitCodes(String key,long typeId,int state,IPaginable paginable);
	
	/**
	 * 根据Id获取机组信息
	 * @param id
	 * @return
	 */
	public UnitCode getUnitCode(long id);

	
	/**
	 * 根据编码查找详细信息
	 * @param code
	 * @return
	 */
	public UnitCode getUnitCode(String code);
	
	/**
	 * 根据编码ID删除编码信息
	 * @param id
	 * @param creatername
	 * @param createrid
	 * @param ip
	 * @return
	 */
	public boolean deleteUnitCode(long id,String creatername,String createrid,String ip) throws Exception;
}
