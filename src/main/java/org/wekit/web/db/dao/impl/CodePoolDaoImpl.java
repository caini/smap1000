package org.wekit.web.db.dao.impl;

import org.wekit.web.HibernateBaseDao;
import org.wekit.web.db.dao.CodePoolDao;
import org.wekit.web.db.model.CodePool;

public class CodePoolDaoImpl  extends HibernateBaseDao<CodePool, String> implements CodePoolDao{

	@Override
	public boolean isExistsed(String code) {
		return this.get(code)==null?false:true;
	}

	@Override
	public CodePool insertCodePool(String code) {
		return this.save(new CodePool(code));
	}
	
	public void deleteCodePool(String code){
		 this.delete(new CodePool(code));
	}

	@Override
	protected Class<CodePool> getEntityClass() {
		return CodePool.class;
	}

	
}
