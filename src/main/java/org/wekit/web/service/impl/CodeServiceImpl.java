package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.IPaginable;
import org.wekit.web.db.Pagination;
import org.wekit.web.db.dao.CodeDao;
import org.wekit.web.db.dao.CodeSequenceDao;
import org.wekit.web.db.dao.ExtendCodeDao;
import org.wekit.web.db.dao.TempCodeDao;
import org.wekit.web.db.model.Code;
import org.wekit.web.db.model.TempCode;
import org.wekit.web.service.CodeService;

/**
 * 编码功能申请服务实现
 * 
 * @author huangweili
 * 
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {

	@Autowired
	@Qualifier("codeDao")
	private CodeDao			codeDao;



	@Override
	public Code getCode(Long id) {
		if (id != null && id > 0) {
			return codeDao.getCode(id);
		}
		return null;
	}

	@Override
	public Code getCode(String code) {
		return this.codeDao.getCode(code);
	}

	@Override
	public boolean deleteCode(Code code) {
		return false;
	}

	@Override
	public boolean deleteCode(Long codeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Code updateCode(Code code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Code> getAllCodes() {
		return this.codeDao.getAllCodes();
	}

	@Override
	public Pagination<Code> getCodesWithPagination(IPaginable paginable) {
		List<Code> list = codeDao.getCodesWithPaginable(paginable);
		Pagination<Code> pagination = new Pagination<Code>(paginable);
		return null;
	}

	@Override
	public Code addCode(Code code) {
		// TODO Auto-generated method stub
		return null;
	}

	public CodeDao getCodeDao() {
		return codeDao;
	}

	public void setCodeDao(CodeDao codeDao) {
		this.codeDao = codeDao;
	}



}
