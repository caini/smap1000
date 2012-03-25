package org.wekit.web;

/**
 * 简单分页实现类
 * 
 * @author HuangWeili
 * 
 */
public class SimplePagination implements IPaginable {

	private static final long	serialVersionUID	= 4134672797636631007L;

	private int					totleCount;								// 获取总条目数量

	private int					pageSize;									// 当前每页展示的数目

	private int					currentPage;								// 当前页码

	private boolean				isCount;									// 是否进行统计处理

	public SimplePagination() {
		totleCount = 0;
		pageSize = 0;
		currentPage = 0;
		isCount = false;
	}

	public SimplePagination(int currentPage, int pageSize, boolean isCount, int totleCount) {
		this.totleCount = totleCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.isCount = isCount;
	}

	@Override
	public int getTotleCount() {
		return this.totleCount;
	}

	@Override
	public int getTotlePage() {
		if (this.pageSize > 0) {
			return (this.totleCount % this.pageSize > 0 ? this.totleCount / this.pageSize + 1 : this.totleCount / this.pageSize); // 计算出总的页数
		} else {
			return 1;
		}
	}

	@Override
	public int getPageSize() {
		return this.pageSize;
	}

	@Override
	public int getCurrentPage() {
		return this.currentPage;
	}

	@Override
	public boolean isFirstPage() {
		return getCurrentPage() == 1;
	}

	@Override
	public boolean isLastPage() {
		// TODO Auto-generated method stub
		return getCurrentPage() >= getTotlePage();
	}

	@Override
	public int getPrePage() {
		return getCurrentPage() > 1 ? getCurrentPage() - 1 : 1;
	}

	@Override
	public int getNextPage() {
		return getCurrentPage() >= getTotlePage() ? getTotlePage() : getCurrentPage() + 1;
	}

	public void setTotleCount(int totleCount) {
		this.totleCount = totleCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isCount() {
		return isCount;
	}

	public void setCount(boolean isCount) {
		this.isCount = isCount;
	}

}
