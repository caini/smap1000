package org.wekit.web.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.CodeApplyDao;
import org.wekit.web.db.model.CodeApply;
import org.wekit.web.service.CodeApplyService;

/**
 * 
 * @author HuangWeili
 * 
 */
@Service("codeApplyService")
public class CodeApplyServiceImpl implements CodeApplyService {

	private static Logger logger=Logger.getLogger(CodeApplyServiceImpl.class);
	
	@Autowired
	@Qualifier("codeApplyDao")
	private CodeApplyDao	codeApplyDao;

	public CodeApplyDao getCodeApplyDao() {
		return codeApplyDao;
	}

	public void setCodeApplyDao(CodeApplyDao codeApplyDao) {
		this.codeApplyDao = codeApplyDao;
	}

	@Override
	public boolean deleteCodeApply(Long id) {
		return this.codeApplyDao.deleteCodeApply(id);
	}

	@Override
	public List<CodeApply> getAllCodeApplies() {	
		return this.codeApplyDao.getAllCodeApplies();
	}

	@Override
	public List<CodeApply> getCodeAppliesWithPagination(IPaginable paginable) {
		if(paginable==null){
			return this.codeApplyDao.getAllCodeApplies();
		}else{
			return this.codeApplyDao.getCodeAppliesWithPagination(paginable);
		}
	}

	@Override
	public CodeApply addCodeApply(CodeApply apply) {
		return this.codeApplyDao.addCodeApply(apply);
	}

	@Override
	public boolean udpateCodeApply(CodeApply apply) {
		return this.udpateCodeApply(apply);
	}
	
	

}
