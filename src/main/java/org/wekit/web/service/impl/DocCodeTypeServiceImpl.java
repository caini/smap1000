package org.wekit.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.db.dao.DocCodeTypeDao;
import org.wekit.web.service.DocCodeTypeService;

/**
 * 
 * @author HuangWeili
 *
 */
@Service("docCodeTypeService")
public class DocCodeTypeServiceImpl implements DocCodeTypeService {

	@Autowired
	@Qualifier("docCodeTypeDao")
	private DocCodeTypeDao docCodeTypeDao;

	public DocCodeTypeDao getDocCodeTypeDao() {
		return docCodeTypeDao;
	}

	public void setDocCodeTypeDao(DocCodeTypeDao docCodeTypeDao) {
		this.docCodeTypeDao = docCodeTypeDao;
	}
	
	
	
}
