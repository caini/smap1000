package org.wekit.web.service;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.UnitCodeType;

public interface UnitCodeTypeService {
	/**
	 * 获取所有的电厂编码类型
	 * 
	 * @return
	 */
	public List<UnitCodeType> getAllUnitCodeTypes(IPaginable paginable);

	/**
	 * 根据关键字和状态查找电厂编码分类
	 * 
	 * @param key
	 * @param state
	 * @param paginable
	 * @return
	 */
	public List<UnitCodeType> queryUnitCodeTypes(String key, int state, IPaginable paginable);

	/**
	 * 根据Id获得机组编码分类的详细信息
	 * @param id
	 * @return
	 */
	public UnitCodeType getUnitCodeType(long id);
}
