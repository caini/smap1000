package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.DocCode;

/**
 * 文件类型编码访问规则
 * @author huangweili
 *
 */
public interface DocCodeDao {

	public DocCode addDocCode(DocCode docCode);
	
	public DocCode getDocCode(long id);
	
	public boolean updateDocCode(DocCode docCode);
	
	public boolean deleteDocCode(DocCode docCode);
	
	public boolean deleteDocCdoe(long id);
	
	public List<DocCode> getAllDocCodes();
	
	public List<DocCode> getDocCodesWithPagination(IPaginable paginable);
	
	
}
