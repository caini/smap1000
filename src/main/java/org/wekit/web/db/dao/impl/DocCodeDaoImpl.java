package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
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
public class DocCodeDaoImpl extends HibernateBaseDao<DocCode, Long> implements DocCodeDao {

	private static Logger	logger	= Logger.getLogger(DocCodeDaoImpl.class);

	@Override
	protected Class<DocCode> getEntityClass() {
		return DocCode.class;
	}

	@Override
	public DocCode addDocCode(DocCode docCode) {
		return this.save(docCode);
	}

	@Override
	public DocCode getDocCode(long id) {
		return this.get(id);
	}

	@Override
	public boolean updateDocCode(DocCode docCode) {
		try {
			this.update(docCode);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDocCode(DocCode docCode) {
		try {
			this.delete(docCode);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDocCdoe(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<DocCode> getAllDocCodes() {
		return this.getAll();
	}

	@Override
	public List<DocCode> getDocCodesWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

}
