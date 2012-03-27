package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.DocCodeDao;
import org.wekit.web.db.model.DocCode;
/**
 * 
 * @author huangweili
 *
 */
@Repository("docCodeDao")
public class DocCodeDaoImpl extends HibernateBaseDao<DocCode, Long> implements DocCodeDao{

	@Override
	protected Class<DocCode> getEntityClass() {
		// TODO Auto-generated method stub
		return DocCode.class;
	}

	@Override
	public DocCode addDocCode(DocCode docCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocCode getDocCode(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDocCode(DocCode docCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDocCode(DocCode docCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDocCdoe(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DocCode> getAllDocCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocCode> getDocCodesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
