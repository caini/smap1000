package org.wekit.web;

import java.io.Serializable;

/**
 * 分页接口定义
 * @author HuangWeili
 *
 */
public interface IPaginable extends Serializable {

	/**
	 * 获取查询总页数
	 * @return
	 */
	int getTotleCount();
	
	/**
	 * 获取总页数
	 * @return
	 */
	int getTotlePage();
	
	/**
	 * 获取每页的数目
	 * @return
	 */
	int getPageSize();
	
	/**
	 * 获取当前页的页码
	 * @return
	 */
	int getCurrentPage();
	
	/**
	 * 是否是第一页
	 * @return
	 */
	boolean  isFirstPage();
	
	/**
	 * 是否是最后一页
	 * @return
	 */
	boolean isLastPage();
	
	/**
	 * 获取上一页
	 * @return
	 */
	int  getPrePage();
	
	/**
	 * 获取下一页
	 * @return
	 */
	int getNextPage();
	
	/**
	 * 是否进行总数统计
	 * @return
	 */
	boolean isCount();
	
	/**
	 * 设置提交查询的总数
	 * @param count
	 */
	void setTotleCount(int count);
}
