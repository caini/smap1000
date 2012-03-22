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
	long getTotleCount();
	
	/**
	 * 获取总页数
	 * @return
	 */
	long getTotlePage();
	
	/**
	 * 获取每页的数目
	 * @return
	 */
	long getPageSize();
	
	/**
	 * 获取当前页的页码
	 * @return
	 */
	long getCurrentPage();
	
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
	long  getPrePage();
	
	/**
	 * 获取下一页
	 * @return
	 */
	long getNextPage();
}
