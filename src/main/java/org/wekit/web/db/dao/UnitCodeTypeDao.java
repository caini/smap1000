package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.UnitCodeType;

public interface UnitCodeTypeDao {

	public UnitCodeType addUnitCodeType(UnitCodeType unitCodeType);
	
	public UnitCodeType getUnitCodeType(long id);
	
	public boolean deleteUnitCodeType(long id);
	
	public boolean deleteUnitCodeType(UnitCodeType unitCodeType);
	
	public List<UnitCodeType> getAllUnitCodeTypes();
	
	public List<UnitCodeType> getUnitCodeTypesWithPagination(IPaginable paginable);
}
