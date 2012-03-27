package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.db.model.TempCode;

public interface TempCodeDao {

	public TempCode addTempCode(TempCode tempCode);
	
	public TempCode getTempCode(long id);
	
	public boolean deleteTempCode(TempCode tempCode);
	
	public boolean deleteTempCode(long id);
	
	public boolean updateTempCode(TempCode tempCode);
	
	public List<TempCode> getAllTempCodes();
	
	public List<TempCode> getTempCodesWithPagination();
	
	
}
