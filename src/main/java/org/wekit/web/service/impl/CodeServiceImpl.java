package org.wekit.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.CodeDao;
import org.wekit.web.db.dao.CodeSequenceDao;
import org.wekit.web.db.dao.ExtendCodeDao;
import org.wekit.web.db.dao.TempCodeDao;
import org.wekit.web.db.model.Code;
import org.wekit.web.db.model.TempCode;
import org.wekit.web.service.CodeService;
/**
 * 编码功能申请服务实现
 * @author huangweili
 *
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService{

	@Autowired
	@Qualifier("codeDao")
	private CodeDao codeDao;
	
	@Autowired
	@Qualifier("extendCodeDao")
	private ExtendCodeDao extendCodeDao;
	
	@Autowired
	@Qualifier("tempCodeDao")
	private TempCodeDao tempCodeDao;
	
	@Autowired
	@Qualifier("codeSequenceDao")
	private CodeSequenceDao codeSequenceDao;
	
	
	@Override
	public Code getCode(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Code getCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCode(Code code) {
		// TODO Auto-generated method stub
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
	public List<Code> getAllCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Code> getCodesWithPagination(IPaginable paginable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Code addCode(Code code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TempCode getTempCode(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TempCode getTempCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTempCode(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTempCode(String code) {
		// TODO Auto-generated method stub
		return false;
	}

	public CodeDao getCodeDao() {
		return codeDao;
	}

	public void setCodeDao(CodeDao codeDao) {
		this.codeDao = codeDao;
	}

	public ExtendCodeDao getExtendCodeDao() {
		return extendCodeDao;
	}

	public void setExtendCodeDao(ExtendCodeDao extendCodeDao) {
		this.extendCodeDao = extendCodeDao;
	}

	public TempCodeDao getTempCodeDao() {
		return tempCodeDao;
	}

	public void setTempCodeDao(TempCodeDao tempCodeDao) {
		this.tempCodeDao = tempCodeDao;
	}

	public CodeSequenceDao getCodeSequenceDao() {
		return codeSequenceDao;
	}

	public void setCodeSequenceDao(CodeSequenceDao codeSequenceDao) {
		this.codeSequenceDao = codeSequenceDao;
	}

	
}
