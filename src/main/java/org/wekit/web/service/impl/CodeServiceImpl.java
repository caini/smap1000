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
import org.wekit.web.WekitException;
import org.wekit.web.db.dao.CodeDao;
import org.wekit.web.db.dao.CodeRuleDao;
import org.wekit.web.db.dao.CodeSequenceDao;
import org.wekit.web.db.dao.TempCodeDao;
import org.wekit.web.db.model.Code;
import org.wekit.web.db.model.CodeRule;
import org.wekit.web.db.model.CodeSequence;
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
	private CodeDao codeDao;

	@Autowired
	@Qualifier("tempCodeDao")
	private TempCodeDao tempCodeDao;

	@Autowired
	@Qualifier("codeSequenceDao")
	private CodeSequenceDao codeSequenceDao;

	@Autowired
	@Qualifier("codeRuleDao")
	private CodeRuleDao codeRuleDao;

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
	public Code fetchCode(String rule, String unitCode, String locationCode, String docCode, String creater, String createrId, String note) {
		List<TempCode> tempCodes = tempCodeDao.queryTempCodes(rule, unitCode, locationCode, docCode, null);
		if (tempCodes != null && tempCodes.size() > 0) {
			TempCode tempCode = tempCodes.get(0);
			Code code = new Code(rule, creater, createrId, unitCode, locationCode, docCode, tempCode.getCode(), 1, null, System.currentTimeMillis(), note);
			code = codeDao.addCode(code);
			tempCodeDao.deleteTempCode(tempCode);
			return code;
		} else {
			List<Code> codes = batchCode(rule, unitCode, locationCode, docCode, creater, createrId, note, 1);
			if (codes != null && codes.size() > 0)
				return codes.get(0);
		}
		return null;

	}

	/**
	 * 批量获取编码,会抛出运行时异常
	 * 
	 * @param rule
	 * @param unitCode
	 * @param locationCode
	 * @param docCode
	 * @param creater
	 * @param createId
	 * @param note
	 * @param batchSize
	 * @return
	 */
	public List<Code> batchCode(String rule, String unitCode, String locationCode, String docCode, String creater, String createId, String note, int batchSize) {
		String mask = checkRule(rule, unitCode, locationCode, docCode);
		if (mask == null)
			throw new WekitException("规则验证无效!");
		CodeRule codeRule = codeRuleDao.getCodeRule(rule);
		if (codeRule == null)
			throw new WekitException("所选择的规则不存在!");
		MaskParser maskParser = paserMask(mask);
		List<CodeSequence> codeSequences = codeSequenceDao.queryCodeSequences(rule, unitCode, locationCode, docCode, maskParser.getParam());
		CodeSequence codeSequence = null;
		int minSeq = codeRule.getMinSequence();
		int maxSeq = codeRule.getMaxSequence();
		if (codeSequences != null && codeSequences.size() > 0) {
			codeSequence = codeSequences.get(0);
			if (maxSeq > 0 && (codeSequence.getSeq() + batchSize) > maxSeq)
				throw new WekitException("需要生成的编码已经超过了该规则可生成的数量限制!");
		} else {
			// 构造新的dequence
			codeSequence = initCodeSequence(rule, unitCode, locationCode, docCode, maskParser.getParam());
			if (maxSeq > 0 && (maxSeq - minSeq + 1) < batchSize)
				throw new WekitException("需要生成的编码已经超过了该规则可生成的数量限制!");
		}
		List<String> codes = generationCode(maskParser.getMask(), codeSequence.getSeq(), batchSize);
		List<Code> generationCodes = codeDao.addCodes(codes, rule, unitCode, locationCode, docCode, creater, createId, note);
		codeSequence.setSeq(codeSequence.getSeq() + batchSize);
		if (!codeSequenceDao.updateCodeSequence(codeSequence))
			throw new WekitException("生成编码时发生意外请与管理员联系!");
		return generationCodes;
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

	protected List<String> generationCode(String rule, long seq, int batchNums) {
		return null;
	}

	/**
	 * 添加新的序列
	 * 
	 * @param rule
	 * @param unitCode
	 * @param locationCode
	 * @param docCode
	 * @param params
	 * @return
	 */
	private CodeSequence initCodeSequence(String rule, String unitCode, String locationCode, String docCode, Map<String, Integer> params) {
		// TODO
		return null;
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
	public String checkRule(String codeRule, String unitCode, String locationCode, String docCode) {
		String[] rules = codeRule.split("-");
		if (rules.length != 4)
			return null;
		if (!(rules[0].endsWith("x") || rules.equals(unitCode)))
			return null;
		if (!(rules[1].equals("xxx") || rules[1].equals(locationCode)))
			return null;
		if (!(rules[2].equals("xxx") || rules[2].equals(docCode)))
			return null;
		return rules[3];
	}

}
