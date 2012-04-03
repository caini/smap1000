package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.DocCodeDao;
import org.wekit.web.db.model.DocCode;
import org.wekit.web.service.DocCodeService;

/**
 * 
 * @author HuangWeili
 * 
 */
@Service("docCodeService")
public class DocCodeServiceImpl implements DocCodeService {

	@Autowired
	@Qualifier()
	private DocCodeDao	docCodeDao;

	public DocCodeDao getDocCodeDao() {
		return docCodeDao;
	}

	public void setDocCodeDao(DocCodeDao docCodeDao) {
		this.docCodeDao = docCodeDao;
	}

	@Override
	public DocCode getDocCode(long id) {
		return this.docCodeDao.getDocCode(id);
	}

	@Override
	public DocCode getDocCode(String code) {
		return this.docCodeDao.getDocCode(code);
	}

	@Override
	public List<DocCode> getAllDocCodes() {
		return this.docCodeDao.getAllDocCodes();
	}

	@Override
	public List<DocCode> queryDocCodes(IPaginable paginable) {
		if (paginable == null)
			return this.docCodeDao.getAllDocCodes();
		else
			return this.docCodeDao.getDocCodesWithPagination(paginable);
	}

	@Override
	public List<DocCode> queryDocCodes(String key, long typeId, int state, IPaginable paginable) {
		return this.docCodeDao.queryDocCodes(key, typeId, state, paginable);
	}

}
