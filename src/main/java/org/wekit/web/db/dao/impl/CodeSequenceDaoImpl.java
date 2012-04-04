package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.CodeSequenceDao;
import org.wekit.web.db.model.CodeSequence;

/**
 * 编码序列数据访问层实现
 * 
 * @author huangweili
 * 
 */
@Repository("codeSequenceDao")
public class CodeSequenceDaoImpl extends HibernateBaseDao<CodeSequence, Long> implements CodeSequenceDao {

	private static Logger	logger	= Logger.getLogger(CodeSequenceDaoImpl.class);

	@Override
	protected Class<CodeSequence> getEntityClass() {
		return CodeSequence.class;
	}

	@Override
	public CodeSequence getCodeSequence(long id) {
		return this.get(id);
	}

	@Override
	public CodeSequence addCodeSequence(CodeSequence codeSequence) {
		return this.save(codeSequence);
	}

	@Override
	public boolean updateCodeSequence(CodeSequence codeSequence) {
		try {
			this.update(codeSequence);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}

		return true;
	}

	@Override
	public boolean deleteCodeSequence(CodeSequence codeSequence) {
		try {
			this.delete(codeSequence);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCodeSequence(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;

	}

	@Override
	public List<CodeSequence> getAllCodeSequences() {
		return this.getAll();
	}

	@Override
	public List<CodeSequence> getCodeSequencesWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

	@Override
	public List<CodeSequence> queryCodeSequences(String rule, int year, int month, int day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean incCodeSequence(CodeSequence sequence) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
