package org.wekit.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.db.dao.DocCodeDao;
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

	
}
