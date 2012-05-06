package org.wekit.web.db.dao;

import org.wekit.web.db.model.CodePool;


public interface CodePoolDao {
	
	boolean isExistsed(String code);
	
	CodePool insertCodePool(String code);
}
