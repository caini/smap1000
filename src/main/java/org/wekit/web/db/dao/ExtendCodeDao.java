package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.ExtendCode;

/**
 * 
 * @author huangweili
 *
 */
public interface ExtendCodeDao {

	public ExtendCode addExtendCode(ExtendCode extendCode);
	
	public ExtendCode getExtendCode(long id);
	
	public boolean deleteExtendCode(ExtendCode extendCode);
	
	public boolean deleteExtendCode(long id);
	
	public boolean updateExtendCode(ExtendCode extendCode);
	
	public List<ExtendCode> getAllExtendCodes();
	
	public List<ExtendCode> getExtendCodesWithPagination(IPaginable paginable);
}
