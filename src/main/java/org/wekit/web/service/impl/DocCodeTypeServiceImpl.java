package org.wekit.web.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.DocCodeTypeDao;
import org.wekit.web.db.model.DocCodeType;
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
	private DocCodeTypeDao	docCodeTypeDao;

	public DocCodeTypeDao getDocCodeTypeDao() {
		return docCodeTypeDao;
	}

	public void setDocCodeTypeDao(DocCodeTypeDao docCodeTypeDao) {
		this.docCodeTypeDao = docCodeTypeDao;
	}

	@Transactional(readOnly=true)
	@Override
	public DocCodeType getDocCodeType(long id) {
		if (id < 1)
			return null;
		else
			return this.docCodeTypeDao.getDocCodeType(id);
	}

	@Transactional(readOnly=true)
	@Override
	public DocCodeType getDocCodeType(String code) {
		if (StringUtils.isNotEmpty(code)) {
			return this.docCodeTypeDao.getDocCodeType(code);
		}
		return null;
	}

	@Transactional(readOnly=true)
	@Override
	public List<DocCodeType> getAllDocCodeTypes() {
		return this.docCodeTypeDao.getAllDocCodeTypes();
	}

	@Transactional(readOnly=true)
	@Override
	public List<DocCodeType> queryDocCodeTypes(IPaginable paginable) {
		if (paginable == null)
			return this.docCodeTypeDao.getAllDocCodeTypes();
		return this.docCodeTypeDao.getDocCodeTypesWithPagination(paginable);
	}

	@Transactional(readOnly=true)
	@Override
	public List<DocCodeType> queryDocCodeTypes(String key, int state, IPaginable paginable) {
		return this.docCodeTypeDao.queryDocCodeTypes(key, state, paginable);
	}

}
