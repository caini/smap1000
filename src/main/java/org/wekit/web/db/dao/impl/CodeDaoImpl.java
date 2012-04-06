package org.wekit.web.db.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.wekit.web.HibernateBaseDao;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.CodeDao;
import org.wekit.web.db.model.Code;

@Repository("codeDao")
public class CodeDaoImpl extends HibernateBaseDao<Code,Long> implements CodeDao {

	private static Logger logger=Logger.getLogger(CodeDaoImpl.class);
	
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
		try{
			this.update(code);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCode(Code code) {
		try{
			this.delete(code);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCode(Long id) {
		try{
			this.deleteByPK(id);
		}catch(Exception ex){
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
		List<Code> list=this.queryByProperty("code", code);
		if(list!=null)
		{
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Code> addCodes(List<String> codes, String rule, String unitCode, String locationCode, String docCode, String creater, String createId, String note) {
		List<Code> list=new ArrayList<Code>();
		String uuid=UUID.randomUUID().toString();
		int i=0;
		for(String code:codes){
			i++;
			
			Code newCode=new Code(rule, creater, createId, unitCode, locationCode, docCode, code, 1,uuid, System.currentTimeMillis(), note);
			list.add(newCode);
			if(i%20==0){
				this.getSession().flush();
			}
		}
		return list;
	}
}
