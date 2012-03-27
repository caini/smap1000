package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.LocationCodeType;

public interface LocationCodeTypeDao {

	public LocationCodeType addLocationCodeType(LocationCodeType locationCodeType);
	
	public LocationCodeType getLocationCodeType(long id);
	
	public boolean deleteLocationCodeType(long id);
	
	public boolean deleteLocationCodeType(LocationCodeType locationCodeType);
	
	public boolean updateLocationCodeType(LocationCodeType locationCodeType);
	
	public List<LocationCodeType> getAllLocationCodeTypes();
	
	public List<LocationCodeType> getLocationCodeTypesWithPagination(IPaginable paginable);
	
	
}
