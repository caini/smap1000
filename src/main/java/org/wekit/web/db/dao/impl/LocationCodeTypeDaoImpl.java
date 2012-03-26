package org.wekit.web.db.dao.impl;

import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.LocationCodeTypeDao;
import org.wekit.web.db.model.LocationCodeType;
/**
 * 定位码类型访问实现
 * @author HuangWeili
 *
 */
@Repository("locationCodeTypeDao")
public class LocationCodeTypeDaoImpl  extends HibernateBaseDao<LocationCodeType, Long> implements LocationCodeTypeDao{

	@Override
	protected Class<LocationCodeType> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
