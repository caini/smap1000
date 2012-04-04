package org.wekit.web.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wekit.web.IPaginable;
import org.wekit.web.db.dao.CodeDao;
import org.wekit.web.db.dao.CodeRuleDao;
import org.wekit.web.db.dao.CodeSequenceDao;
import org.wekit.web.db.dao.TempCodeDao;
import org.wekit.web.db.model.Code;
import org.wekit.web.db.model.CodeRule;
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

	@Autowired
	@Qualifier("tempCodeDao")
	private TempCodeDao		tempCodeDao;

	@Autowired
	@Qualifier("codeSequenceDao")
	private CodeSequenceDao	codeSequenceDao;

	@Autowired
	@Qualifier("codeRuleDao")
	private CodeRuleDao		codeRuleDao;

	@Override
	public Code getCode(Long id) {
		if (id != null && id > 0) {
			return codeDao.getCode(id);
		}
		return null;
	}

	@Override
	public Code getCode(String code) {
		if (StringUtils.isEmpty(code))
			return null;
		return this.codeDao.getCode(code);
	}

	@Override
	public boolean deleteCode(Code code) {
		return this.codeDao.deleteCode(code);
	}

	@Override
	public boolean deleteCode(Long codeId) {
		return this.codeDao.deleteCode(codeId);
	}

	@Override
	public boolean updateCode(Code code) {
		return this.codeDao.updateCode(code);
	}

	@Override
	public List<Code> getAllCodes() {
		return this.codeDao.getAllCodes();
	}

	@Override
	public List<Code> getCodesWithPagination(IPaginable paginable) {
		if (paginable != null)
			return codeDao.getCodesWithPaginable(paginable);
		else
			return codeDao.getAllCodes();
	}

	@Override
	public Code addCode(Code code) {
		return this.codeDao.addCode(code);
	}

	public CodeDao getCodeDao() {
		return codeDao;
	}

	public void setCodeDao(CodeDao codeDao) {
		this.codeDao = codeDao;
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

	public CodeRuleDao getCodeRuleDao() {
		return codeRuleDao;
	}

	public void setCodeRuleDao(CodeRuleDao codeRuleDao) {
		this.codeRuleDao = codeRuleDao;
	}

	@Override
	public boolean cancelCode(Long codeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelCode(String code) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 独立取号和批量取号的差别是独立取号有限查找可用的序列号，在生成新的序列号，而批量操作只生成联系的新号而不关心旧的号码
	 */
	@Override
	public Code fetchCode(String rule, String unitCode, String locationCode, String docCode, String creater, String createId, String note) {

		return null;

	}

	public Code batchCode(String rule, String unitCode, String locationCode, String docCode, String creater, String createId, String note, int batchSize) {

		// TODO
		return null;
	}

	/**
	 * 返回[n]中n的长度
	 * 
	 * @param mask
	 * @return
	 */
	public MaskParser paserMask(String mask) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.MONDAY);

		if (mask.indexOf("[yyyy]") > 0) {
			mask = mask.replace("[yyyy]", String.valueOf(year));
			param.put("year", year);
		}
		if (mask.indexOf("[yy]") > 0) {
			mask = mask.replace("[yy]", String.valueOf(year % 100));
			param.put("year", year);
		}
		if (mask.indexOf("[mm]") > 0) {
			if (month > 9)
				mask = mask.replace("[mm]", String.valueOf(month));
			else
				mask = mask.replace("[mm]", "0" + String.valueOf(month));
			param.put("month", month);
		}
		if (mask.indexOf("[dd]") > 0) {
			if (day > 9) {
				mask = mask.replace("[dd]", String.valueOf(day));
			} else {
				mask = mask.replace("[dd]", "0" + String.valueOf(day));
			}
			param.put("day", day);
		}
		int left = mask.indexOf('[');
		if (left < 0) {
			return new MaskParser(param, mask, 0);
		}
		int right = mask.indexOf(']');

		return new MaskParser(param, mask, right - left - 1);
	}

	/**
	 * 判断传递的参数是否有效
	 * 
	 * @param codeRule
	 * @param unitCode
	 * @param locationCode
	 * @param docCode
	 * @return
	 */
	public boolean checkRule(String codeRule, String unitCode, String locationCode, String docCode) {
		String[] rules = codeRule.split("-");
		if (rules.length != 4)
			return false;
		if (!(rules[0].endsWith("x") || rules.equals(unitCode)))
			return false;
		if (!(rules[1].equals("xxx") || rules[1].equals(locationCode)))
			return false;
		if (!(rules[2].equals("xxx") || rules[2].equals(docCode)))
			return false;
		return true;
	}

}
