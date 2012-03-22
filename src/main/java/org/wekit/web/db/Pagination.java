package org.wekit.web.db;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.SimplePagination;

/**
 * 分页包装类
 * @author HuangWeili
 *
 */
public class Pagination<T> extends SimplePagination implements IPaginable {

	private static final long serialVersionUID = 6243247831967930435L;

	private List<T> datas;

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	
	
}
