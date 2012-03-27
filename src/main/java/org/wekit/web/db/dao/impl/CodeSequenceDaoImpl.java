package org.wekit.web.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.CodeSequenceDao;
import org.wekit.web.db.model.CodeSequence;

/**
 * 编码序列数据访问层实现
 * @author huangweili
 *
 */
@Repository("codeSequenceDao")
public class CodeSequenceDaoImpl extends HibernateBaseDao<CodeSequence,Long>  implements CodeSequenceDao{

	@Override
	protected Class<CodeSequence> getEntityClass() {
		// TODO Auto-generated method stub
		return CodeSequence.class;
	}

	@Override
	public CodeSequence getCodeSequence(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CodeSequence addCodeSequence(CodeSequence codeSequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCodeSequence(CodeSequence codeSequence) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCodeSequence(CodeSequence codeSequence) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCodeSequence(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CodeSequence> getAllCodeSequences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CodeSequence> getCodeSequencesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}
}
