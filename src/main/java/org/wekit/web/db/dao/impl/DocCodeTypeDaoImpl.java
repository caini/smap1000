package org.wekit.web.db.dao.impl;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
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
		return null;
	}

	
}
