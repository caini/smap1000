package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.DocCodeTypeDao;
import org.wekit.web.db.model.DocCodeType;

/**
 * 编码的文档类型
 * @author HuangWeili
 *
 */
@Repository("docCodeTypeDao")
public class DocCodeTypeDaoImpl extends HibernateBaseDao<DocCodeType,Long> implements DocCodeTypeDao{

	@Override
	protected Class<DocCodeType> getEntityClass() {
		// TODO Auto-generated method stub
		return DocCodeType.class;
	}

	@Override
	public DocCodeType addDocCodeType(DocCodeType docCodeType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocCodeType getDocCodeType(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteDocCodeType(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDocCodeType(DocCodeType docCodeType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDocCodeType(DocCodeType docCodeType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DocCodeType> getAllDocCodeTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocCodeType> getDocCodeTypesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
