package org.wekit.web.db.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.DocCodeTypeDao;
import org.wekit.web.db.model.DocCodeType;

/**
 * 编码的文档类型
 * 
 * @author HuangWeili
 * 
 */
@Repository("docCodeTypeDao")
public class DocCodeTypeDaoImpl extends HibernateBaseDao<DocCodeType, Long> implements DocCodeTypeDao {

	private static Logger	logger	= Logger.getLogger(DocCodeTypeDaoImpl.class);

	@Override
	protected Class<DocCodeType> getEntityClass() {
		return DocCodeType.class;
	}

	@Override
	public DocCodeType addDocCodeType(DocCodeType docCodeType) {
		return this.save(docCodeType);
	}

	@Override
	public DocCodeType getDocCodeType(long id) {
		return this.get(id);
	}

	@Override
	public boolean deleteDocCodeType(long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDocCodeType(DocCodeType docCodeType) {
		try {
			this.delete(docCodeType);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateDocCodeType(DocCodeType docCodeType) {
		try {
			this.update(docCodeType);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<DocCodeType> getAllDocCodeTypes() {
		return this.getAll();
	}

	@Override
	public List<DocCodeType> getDocCodeTypesWithPagination(IPaginable paginable) {
		return this.getObjectsWithPagination(paginable);
	}

	@Override
	public DocCodeType getDocCodeType(String code) {
		List<DocCodeType> list = queryByProperty("code", code);
		if (list != null)
			return list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocCodeType> queryDocCodeTypes(String key, int state, IPaginable paginable) {
		StringBuffer buffer=new StringBuffer();
		buffer.append("from DocCodeType bean where 1=1 ");
		if(StringUtils.isNotEmpty(key)){
			buffer.append("and (bean.name like '%"+key+"%' or bean.code like '%"+key+"%') ");
		}
		if(state>=0){
			buffer.append(" and bean.state="+state);
		}
		Query query=createrQuery(buffer.toString());
		if(paginable!=null){
			paginationParam(query, paginable);
		}
		return query.list();
	}

}
