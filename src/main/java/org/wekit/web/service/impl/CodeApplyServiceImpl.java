package org.wekit.web.service.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CodeApply> getAllCodeApplies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CodeApply> getCodeAppliesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CodeApply addCodeApply(CodeApply apply) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean udpateCodeApply(CodeApply apply) {
		// TODO Auto-generated method stub
		return false;
	}

}
