package org.wekit.web.db.dao.impl;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.CodeSequenceDao;
import org.wekit.web.db.model.CodeSequence;

/**
 * 编码序列数据访问层实现
 * @author huangweili
 *
 */
public class CodeSequenceDaoImpl extends HibernateBaseDao<CodeSequence,Long>  implements CodeSequenceDao{

	@Override
	protected Class<CodeSequence> getEntityClass() {
		// TODO Auto-generated method stub
		return CodeSequence.class;
	}
}
