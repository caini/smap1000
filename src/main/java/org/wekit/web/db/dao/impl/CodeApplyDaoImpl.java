package org.wekit.web.db.dao.impl;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.CodeApplyDao;
import org.wekit.web.db.model.CodeApply;

/**
 * 编码申请的相关Dao操作
 * @author HuangWeili
 *
 */
@Repository("codeApplyDao")
public class CodeApplyDaoImpl extends HibernateBaseDao<CodeApply,Long> implements CodeApplyDao {

	
	
	@Override
	protected Class<CodeApply> getEntityClass() {
		// TODO Auto-generated method stub
		return CodeApply.class;
	}

	
}
