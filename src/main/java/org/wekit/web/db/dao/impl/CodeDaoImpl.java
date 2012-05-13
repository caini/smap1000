package org.wekit.web.db.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.CodeDao;
import org.wekit.web.db.model.Code;
import org.wekit.web.db.model.CodeRule;
import org.wekit.web.db.model.User;

@Repository("codeDao")
public class CodeDaoImpl extends HibernateBaseDao<Code, Long> implements CodeDao {

	private static Logger	logger	= Logger.getLogger(CodeDaoImpl.class);

	@Override
	protected Class<Code> getEntityClass() {
		return Code.class;
	}

	@Override
	public Code addCode(Code code) {
		return this.save(code);
	}

	@Override
	public List<Code> getAllCodes() {
		return this.getAll();
	}

	@Override
	public List<Code> getCodesWithPaginable(IPaginable paginable) {
		return getObjectsWithPagination(paginable);
	}

	@Override
	public boolean updateCode(Code code) {
		try {
			this.update(code);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCode(Code code) {
		try {
			this.delete(code);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCode(Long id) {
		try {
			this.deleteByPK(id);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Code getCode(Long id) {
		return this.get(id);
	}

	@Override
	public Code getCode(String code) {
		List<Code> list = this.queryByProperty("code", code);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Code> addCodes(List<String> codes,CodeRule codeRule, String unitCode, String locationCode, String docCode,User user, String note,String filename,String codeName) {
		List<Code> list = new ArrayList<Code>();
		String uuid = UUID.randomUUID().toString();
		int i = 0;
		for (String code : codes) {
			i++;
			Code newCode = new Code(codeRule.getRuleName(),codeRule.getRule(),user.getDisplayName(),user.getLoginName(), unitCode, locationCode, docCode, code, 1, uuid, System.currentTimeMillis(), note,filename,user.getDeptDisplayName(),codeRule.getFileTypeName(),codeName);
			this.save(newCode);
			list.add(newCode);
			if (i % 20 == 0) {
				this.flush();
			}
		}
		return list;
	}

	/**
	 * 通过动态参数匹配函数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Code> queryCodes(Map<String, String> map, IPaginable paginable) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from Code bean  where 1=1 ");
		Set<Entry<String, String>> entries = map.entrySet();
		for (Entry<String, String> entry : entries) {
			if (entry.getValue().equalsIgnoreCase("code")) {
				buffer.append("  and bean.code like '%" + entry.getValue() + "%' ");
			} else {
				buffer.append(" and bean."+entry.getKey()+"='"+entry.getValue()+"' ");
			}
		}
		Query query = createrQuery(buffer.toString());
		if (paginable != null) {
			paginationParam(query, paginable);
		}
		return query.list();
	}
}
