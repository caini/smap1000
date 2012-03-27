package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
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

	@Override
	public CodeApply addCodeApply() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCodeApply(CodeApply codeApply) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCodeApply(CodeApply codeApply) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCodeApply(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CodeApply getCodeApply(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CodeApply> getAllCodeApplies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CodeApply> getCodeAppliesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
