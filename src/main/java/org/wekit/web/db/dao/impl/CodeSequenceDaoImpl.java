package org.wekit.web.db.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
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
	public boolean incCodeSequence(CodeSequence sequence) {
		if (sequence == null)
			return false;

		try {
			sequence.setSeq(sequence.getSeq() + 1);
			this.update(sequence);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeSequence> queryCodeSequences(String rule, String unitCode, String locationCode, String docCode, Map<String, Integer> params, IPaginable paginable) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from CodeSequence bean where 1=1");
		if (params != null) {
			Set<Entry<String, Integer>> set = params.entrySet();
			for (Entry<String, Integer> entry : set) {
				buffer.append(" and bean." + entry.getKey() + "=" + entry.getValue());
			}
		}
		if (StringUtils.isNotEmpty(rule))
			buffer.append(" and bean.codeRule='" + rule + "' ");
		if (StringUtils.isNotEmpty(unitCode)) {
			buffer.append(" and bean.unitCode='" + unitCode + "' ");
		}
		if (StringUtils.isNotEmpty(locationCode)) {
			buffer.append(" and bean.locationCode='" + locationCode + "' ");
		}
		if (StringUtils.isNotEmpty(docCode)) {
			buffer.append(" and bean.docCode='" + docCode + "' ");
		}
		Query query = createrQuery(buffer.toString());
		if (paginable != null) {
			paginationParam(query, paginable);
		}
		return query.list();
	}

}
