package org.wekit.web.db.dao.impl;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.TempCodeDao;
import org.wekit.web.db.model.TempCode;

/**
 * 临时数据操作表
 * @author HuangWeili
 *
 */
public class TempCodeDaoImpl extends HibernateBaseDao<TempCode,Long>  implements TempCodeDao{

	@Override
	protected Class<TempCode> getEntityClass() {
		return TempCode.class;
	}

	
}
