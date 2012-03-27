package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.UnitCode;

public interface UnitCodeDao {

	
	public UnitCode addUnitCode(UnitCode unitCode);
	
	public UnitCode getUnitCode(long id);
	
	public boolean updateUnitCode(UnitCode unitCode);
	
	public boolean deleteUnitCode(long id);
	
	public boolean deleteUnitCode(UnitCode unitCode);
	
	public List<UnitCode> getAllCodes();
	
	public List<UnitCode> getCodesWithPagination(IPaginable paginable);
	
}
