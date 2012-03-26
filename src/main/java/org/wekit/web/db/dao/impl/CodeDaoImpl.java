package org.wekit.web.db.dao.impl;

import java.util.List;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.CodeDao;
import org.wekit.web.db.model.Code;

public class CodeDaoImpl extends HibernateBaseDao<Code,Long> implements CodeDao {

	@Override
	protected Class<Code> getEntityClass() {
		return Code.class;
	}

	@Override
	public Code addCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Code> getAllCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Code> getCodesWithPaginable(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCode(Code code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCode(Code code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCode(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Code getCode(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
