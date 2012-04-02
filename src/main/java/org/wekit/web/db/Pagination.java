package org.wekit.web.db;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.SimplePagination;

/**
 * 分页包装类,最终采用的类
 * 
 * @author HuangWeili
 * 
 */
public class Pagination<T> extends SimplePagination implements IPaginable {

	private static final long	serialVersionUID	= 6243247831967930435L;

	private List<T>				datas;

	public Pagination() {
		super();
		datas = null;
	}

	public Pagination(IPaginable paginable) {
		super(paginable);
		datas = null;
	}

	public Pagination(int currentPage, int pageSize) {
		this(currentPage, pageSize, false);
	}

	public Pagination(int currentPage, int PageSize, boolean isCount) {
		super(currentPage, PageSize, isCount);
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

}
