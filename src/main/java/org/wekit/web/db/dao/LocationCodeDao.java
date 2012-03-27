package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.LocationCode;

public interface LocationCodeDao {

	
	public LocationCode addLocationCode(LocationCode locationCode);
	
	public LocationCode getLocationCode(long id);
	
	public boolean deleteLocationCode(long id);
	
	public boolean deleteLocationCode(LocationCode locationCode);
	
	public boolean updateLocationCode(LocationCode locationCode);
	
	public List<LocationCode> getAllLocationCodes();
	
	public List<LocationCode> getLocationCodesWithPagination(IPaginable paginable);
	
	
}
