package org.wekit.web.db.dao.impl;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.UnitCodeDao;
import org.wekit.web.db.model.UnitCode;
/**
 * 机组码访问类
 * @author HuangWeili
 *
 */
@Repository("unitCodeDao")
public class UnitCodeDaoImpl extends HibernateBaseDao<UnitCode,Long> implements UnitCodeDao {

	@Override
	protected Class<UnitCode> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
