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

	private int state;
	
	private String message;
	
	public Pagination() {
		super();
		init();
		
	}

	public Pagination(IPaginable paginable) {
		super(paginable);
		init();
	}

	public Pagination(int currentPage, int pageSize) {
		this(currentPage, pageSize, false);
		init();
	}

	public Pagination(int currentPage, int PageSize, boolean isCount) {
		super(currentPage, PageSize, isCount);
		init();
	}
	
	private void init()
	{
		this.datas=null;
		this.state=1;
		this.message="调用成功！";
	}
	
	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
