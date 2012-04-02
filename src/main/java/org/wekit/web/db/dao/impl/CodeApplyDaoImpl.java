package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.CodeApplyDao;
import org.wekit.web.db.model.CodeApply;

/**
 * 编码申请的相关Dao操作
 * 
 * @author HuangWeili
 * 
 */
@Repository("codeApplyDao")
public class CodeApplyDaoImpl extends HibernateBaseDao<CodeApply, Long> implements CodeApplyDao {

	private static Logger	logger	= Logger.getLogger(CodeApplyDaoImpl.class);

	@Override
	protected Class<CodeApply> getEntityClass() {
		return CodeApply.class;
	}

	@Override
	public CodeApply addCodeApply(CodeApply codeApply) {
		return this.save(codeApply);
	}

	@Override
	public boolean updateCodeApply(CodeApply codeApply) {
		try {
			this.update(codeApply);
		} catch (Exception ex) {
			logger.error(codeApply);
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCodeApply(CodeApply codeApply) {
		try {
			this.delete(codeApply);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCodeApply(Long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public CodeApply getCodeApply(Long id) {
		return this.get(id);
	}

	@Override
	public List<CodeApply> getAllCodeApplies() {
		return this.getAll();
	}

	@Override
	public List<CodeApply> getCodeAppliesWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

}
