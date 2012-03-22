package org.wekit.web;

/**
 * 简单分页实现类
 * 
 * @author HuangWeili
 * 
 */
public class SimplePagination implements IPaginable {

	private static final long serialVersionUID = 3784460458091517678L;

	private long totleCount;  //获取总条目数量

	private long pageSize;	  //当前每页展示的数目

	private long currentPage; // 当前页码

	
	
	@Override
	public long getTotleCount() {
		return this.totleCount;
	}

	@Override
	public long getTotlePage() {
		if (this.pageSize > 0) {
			return this.totleCount % this.pageSize > 0 ? this.totleCount / this.pageSize + 1L : this.totleCount / this.pageSize; // 计算出总的页数
		} else {
			return 1;
		}
	}

	@Override
	public long getPageSize() {
		return this.pageSize;
	}

	@Override
	public long getCurrentPage() {
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
	public long getPrePage() {
		return getCurrentPage() > 1 ? getCurrentPage() - 1 : 1;
	}

	@Override
	public long getNextPage() {
		return getCurrentPage()>=getTotlePage()?getTotlePage():getCurrentPage()+1;
	}

	public void setTotleCount(long totleCount) {
		this.totleCount = totleCount;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

}
