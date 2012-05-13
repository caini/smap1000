package org.wekit.web.db.dao;

import org.wekit.web.db.model.CodePool;


public interface CodePoolDao {
	
	/**
	 * 判断编码是否存在
	 * @param code
	 * @return
	 */
	boolean isExistsed(String code);
	
	/**
	 * 添加编码
	 * @param code
	 * @return
	 */
	CodePool insertCodePool(String code);
	/**
	 * 删除编码
	 * @param code
	 */
	public void deleteCodePool(String code);
}
