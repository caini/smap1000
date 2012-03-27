package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.DocCodeType;

public interface DocCodeTypeDao {

	public DocCodeType addDocCodeType(DocCodeType docCodeType);
	
	public DocCodeType getDocCodeType(long id);
	
	public boolean deleteDocCodeType(long id);
	
	public boolean deleteDocCodeType(DocCodeType docCodeType);
	
	public boolean updateDocCodeType(DocCodeType docCodeType);
	
	public List<DocCodeType> getAllDocCodeTypes();
	
	public List<DocCodeType> getDocCodeTypesWithPagination(IPaginable paginable);
}
