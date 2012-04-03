package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.LocationCodeTypeDao;
import org.wekit.web.db.model.LocationCodeType;
/**
 * 定位码类型访问实现
 * @author HuangWeili
 *
 */
@Repository("locationCodeTypeDao")
public class LocationCodeTypeDaoImpl  extends HibernateBaseDao<LocationCodeType, Long> implements LocationCodeTypeDao{

	private static Logger logger=Logger.getLogger(LocationCodeTypeDaoImpl.class);
	
	@Override
	protected Class<LocationCodeType> getEntityClass() {
		return LocationCodeType.class;
	}

	@Override
	public LocationCodeType addLocationCodeType(LocationCodeType locationCodeType) {
		return this.save(locationCodeType);
	}

	@Override
	public LocationCodeType getLocationCodeType(long id) {
		return this.get(id);
	}

	@Override
	public boolean deleteLocationCodeType(long id) {
		try{
			this.deleteByPK(id);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteLocationCodeType(LocationCodeType locationCodeType) {
		try{
			this.delete(locationCodeType);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateLocationCodeType(LocationCodeType locationCodeType) {
		try{
		 this.update(locationCodeType);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<LocationCodeType> getAllLocationCodeTypes() {
		return this.getAll();
	}

	@Override
	public List<LocationCodeType> getLocationCodeTypesWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LocationCodeType> queryLocationCodeTypes(String key, int state, IPaginable paginable) {
		StringBuffer buffer=new StringBuffer();
		buffer.append("from LocationCodeType bean where 1=1");
		if(StringUtils.isNotEmpty(key)){
			buffer.append(" and ( bean.name like '%"+key +"%' and bean.code like '%"+key+"%' )");
		}
		if(state>=0){
			buffer.append(" and bean.state="+state);
		}
		Query query=createrQuery(buffer.toString());
		if(paginable!=null){
			this.paginationParam(query, paginable);
		}
		return query.list();
			
	}

	
}
