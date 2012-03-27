package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.UnitCode;

/**
 * 机组编码操作访问层
 * @author HuangWeili
 *
 */
public interface UnitCodeDao {

	/**
	 * 添加机组编码
	 * @param unitCode
	 * @return
	 */
	public UnitCode addUnitCode(UnitCode unitCode);

	/**
	 * 获取机组编码
	 * @param id
	 * @return
	 */
	public UnitCode getUnitCode(long id);

	/**
	 * 更新机组编码信息
	 * @param unitCode
	 * @return
	 */
	public boolean updateUnitCode(UnitCode unitCode);

	/**
	 * 根据Id删除机组编码
	 * @param id
	 * @return
	 */
	public boolean deleteUnitCode(long id);

	/**
	 * 删除机组编码
	 * @param unitCode
	 * @return
	 */
	public boolean deleteUnitCode(UnitCode unitCode);

	/**
	 * 获取所有的机组编码
	 * @return
	 */
	public List<UnitCode> getAllCodes();

	/**
	 * 根据分页信息获取机组编码
	 * @param paginable
	 * @return
	 */
	public List<UnitCode> getCodesWithPagination(IPaginable paginable);

}
