package org.wekit.web.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.MaskParser;
import org.wekit.web.WekitException;
import org.wekit.web.db.dao.CodeApplyLogDao;
import org.wekit.web.db.dao.CodeDao;
import org.wekit.web.db.dao.CodePoolDao;
import org.wekit.web.db.dao.CodeRuleDao;
import org.wekit.web.db.dao.CodeSequenceDao;
import org.wekit.web.db.dao.RuleTypeDao;
import org.wekit.web.db.dao.TempCodeDao;
import org.wekit.web.db.dao.UserDao;
import org.wekit.web.db.model.Code;
import org.wekit.web.db.model.CodeRule;
import org.wekit.web.db.model.CodeSequence;
import org.wekit.web.db.model.TempCode;
import org.wekit.web.db.model.User;
import org.wekit.web.imports.CodeWrap;
import org.wekit.web.service.CodeService;
import org.wekit.web.util.DataWrapUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * 编码功能申请服务实现
 * 
 * @author huangweili
 * 
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {

	private static Logger	logger	= Logger.getLogger(CodeServiceImpl.class);

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

	@Autowired
	@Qualifier("userDao")
	private UserDao			userDao;

	@Autowired
	@Qualifier("codePoolDao")
	private CodePoolDao		codePoolDao;

	@Autowired
	@Qualifier("codeApplyLogDao")
	private CodeApplyLogDao	codeApplyLogDao;

	@Autowired
	@Qualifier("ruleTypeDao")
	private RuleTypeDao		ruleTypeDao;

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

	/**
	 * 独立取号和批量取号的差别是独立取号有限查找可用的序列号，在生成新的序列号，而批量操作只生成联系的新号而不关心旧的号码
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Override
	public Code fetchCode(long ruleId, String unitCode, String locationCode, String docCode, String createrId, String note, String filename, String codeName) throws JsonGenerationException, JsonMappingException, IOException {
		CodeRule codeRule = codeRuleDao.getCodeRule(ruleId);

		if (codeRule == null)
			throw new WekitException("对应编码规则ID的信息不存在!");
		String mask = checkRule(codeRule.getRule(), unitCode, locationCode, docCode);
		if (mask == null)
			throw new WekitException("规则验证无效!");
		MaskParser maskParser = paserMask(mask);
		User user = userDao.getByID(createrId, 1);
		if (user == null) {
			throw new WekitException("对应的用户信息不存在!");
		}
		List<TempCode> tempCodes = tempCodeDao.queryTempCodes(codeRule.getRule(), unitCode, locationCode, docCode, codeRule.getMinSequence(), codeRule.getMaxSequence(), maskParser.getParam().get("year"), maskParser.getParam().get("month"), maskParser.getParam().get("day"), null);
		if (tempCodes != null && tempCodes.size() > 0) {
			TempCode tempCode = tempCodes.get(0);
			String uuid = UUID.randomUUID().toString();
			Code code = new Code(codeRule.getRuleName(), codeRule.getRule(), user.getDisplayName(), user.getLoginName(), unitCode, locationCode, docCode, tempCode.getCode(), 1, uuid, System.currentTimeMillis(), note, filename, user.getDeptDisplayName(), codeRule.getFileTypeName(), tempCode.getCodeName(), tempCode.getYear(), tempCode.getMonth(), tempCode.getDay());
			codeApplyLogDao.saveCodeApplyLog(user.getLoginName(), user.getDisplayName(), user.getDeptName(), user.getDeptDisplayName(), codeRule.getFileType(), code.getCode(), DataWrapUtil.ObjectToJson(code), CodeApplyLogDao.APPLYOPERATE, System.currentTimeMillis(), codeRule.getFileTypeName());
			code = codeDao.addCode(code);
			tempCodeDao.deleteTempCode(tempCode);
			return code;

		}
		List<Code> codes = createCodes(codeRule, unitCode, locationCode, docCode, user, note, 1, filename, codeName, maskParser);
		if (codes != null && codes.size() > 0) {
			Code code = codes.get(0);
			codePoolDao.insertCodePool(code.getCode());
			codeApplyLogDao.saveCodeApplyLog(user.getLoginName(), user.getDisplayName(), user.getDeptName(), user.getDeptDisplayName(), codeRule.getFileType(), code.getCode(), DataWrapUtil.ObjectToJson(code), CodeApplyLogDao.APPLYOPERATE, System.currentTimeMillis(), codeRule.getFileTypeName());
			return code;
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
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Override
	public List<Code> batchCode(long ruleId, String unitCode, String locationCode, String docCode, String createId, String note, int batchSize, String filename, String codeName) throws JsonGenerationException, JsonMappingException, IOException {
		CodeRule codeRule = codeRuleDao.getCodeRule(ruleId);
		if (codeRule == null) {
			throw new WekitException("找不到对应的编码规则!");
		}
		String mask = checkRule(codeRule.getRule(), unitCode, locationCode, docCode);
		if (mask == null)
			throw new WekitException("规则验证无效!");
		MaskParser maskParser = paserMask(mask);
		User user = userDao.getByID(createId, 1);
		if (user == null) {
			throw new WekitException("找不到对应的用户信息!");
		}

		List<Code> codes = this.createCodes(codeRule, unitCode, locationCode, docCode, user, note, batchSize, filename, codeName, maskParser);
		for (Code code : codes) {
			codeApplyLogDao.saveCodeApplyLog(user.getLoginName(), user.getDisplayName(), user.getDeptName(), user.getDeptDisplayName(), codeRule.getFileType(), code.getCode(), DataWrapUtil.ObjectToJson(code), CodeApplyLogDao.APPLYOPERATE, System.currentTimeMillis(), codeRule.getFileTypeName());
			codePoolDao.insertCodePool(code.getCode());
		}

		return codes;
	}

	/**
	 * 隔离事务单独的函数
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
	private List<Code> createCodes(CodeRule codeRule, String unitCode, String locationCode, String docCode, User user, String note, int batchSize, String fileName, String codeName, MaskParser maskParser) {
		List<String> codes = null;
		if (maskParser.getCount() != 0) {
			List<CodeSequence> codeSequences = codeSequenceDao.queryCodeSequences(codeRule.getRule(), unitCode, locationCode, docCode, maskParser.getParam(), codeRule.getMinSequence(), codeRule.getMaxSequence(), null);
			CodeSequence codeSequence = null;
			int minSeq = codeRule.getMinSequence();
			int maxSeq = codeRule.getMaxSequence();
			if (codeSequences != null && codeSequences.size() > 0) {
				codeSequence = codeSequences.get(0);
				if (maxSeq > 0 && (codeSequence.getSeq() + batchSize-1) >= maxSeq)
					throw new WekitException("需要生成的编码已经超过了该规则可生成的数量限制!还可以申请" + (maxSeq - codeSequence.getSeq() +1) + "个编码!");
			} else {
				// 构造新的dequence
				codeSequence = initCodeSequence(codeRule.getRule(), unitCode, locationCode, docCode, maskParser.getParam(), codeRule.getMinSequence(), codeRule.getMaxSequence());
				if (maxSeq > 0 && (maxSeq - codeSequence.getSeq() +1) <= batchSize)
					throw new WekitException("需要生成的编码已经超过了该规则可生成的数量限制!还可以申请" + (maxSeq - codeSequence.getSeq()+1) + "个编码!");
			}

			codes = generationCode(unitCode + "-" + locationCode + "-" + docCode + "-" + maskParser.getMask(), maskParser.getCount(), codeSequence, batchSize, maxSeq);
			if (!codeSequenceDao.updateCodeSequence(codeSequence))
				throw new WekitException("生成编码时发生意外请与管理员联系!");
		} else {
			if (batchSize > 1) {
				throw new WekitException("该编码规则没有流水号不能进行批量申请！");
			}
			codes = generationNoSeqCode(unitCode + "-" + locationCode + "-" + docCode + "-" + maskParser.getMask());
		}
		List<Code> generationCodes = codeDao.addCodes(codes, codeRule, unitCode, locationCode, docCode, user, note, fileName, codeName, maskParser.getParam().get("year"), maskParser.getParam().get("month"), maskParser.getParam().get("day"));
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
		int month = calendar.get(Calendar.MONTH + 1); // 英文的1月份是0开始的
		int day = calendar.get(Calendar.MONDAY);

		if (mask.indexOf("[yyyy]") != -1) {
			mask = mask.replace("[yyyy]", String.valueOf(year));
			param.put("year", year);
		} else {
			param.put("year", 0);
		}
		if (mask.indexOf("[yy]") != -1) {
			mask = mask.replace("[yy]", String.valueOf(year % 100));
			param.put("year", year);
		} else {
			param.put("year", 0);
		}
		if (mask.indexOf("[mm]") != -1) {
			if (month > 9)
				mask = mask.replace("[mm]", String.valueOf(month));
			else
				mask = mask.replace("[mm]", "0" + String.valueOf(month));
			param.put("month", month);
		} else {
			param.put("month", 0);
		}
		if (mask.indexOf("[dd]") != -1) {
			if (day > 9) {
				mask = mask.replace("[dd]", String.valueOf(day));
			} else {
				mask = mask.replace("[dd]", "0" + String.valueOf(day));
			}
			param.put("day", day);
		} else {
			param.put("day", 0);
		}
		int left = mask.indexOf('[');
		if (left < 0) {
			return new MaskParser(param, mask, 0);
		}
		int right = mask.indexOf(']');

		return new MaskParser(param, mask, right - left - 1);
	}

	protected List<String> generationCode(String rule, int count, CodeSequence codeSequence, int batchNums, int maxseq) {
		List<String> result = new ArrayList<String>();
		long seq = codeSequence.getSeq();
		String temp = null;
		String relseq = null;
		int canApply = 0;
		boolean ishave = true;
		Code code = null;
		while (batchNums > 0) {
			ishave = true;
			while (ishave) {
				if (seq > maxseq && maxseq > 0) {
					throw new WekitException("需要生成的编码已经超过了该规则可生成的数量限制 还可以申请" + canApply + "个编码!");
				}
				temp = new String(rule);
				relseq = String.format("%0" + count + "d", seq);
				temp = temp.replaceAll("\\[n*\\]", relseq);
				code = codeDao.getCode(temp);
				if (code == null) {
					if (!codePoolDao.isExistsed(temp)) {
						result.add(temp);
						ishave = false;
						canApply++;
					}
				}
				seq++;
			}
			batchNums--;
		}
		codeSequence.setSeq(seq);
		return result;
	}

	public List<String> generationNoSeqCode(String rule) {
		List<String> list = new ArrayList<String>();
		if (codePoolDao.isExistsed(rule)) {
			throw new WekitException("该申请的编码已经存在了！请选择其他的编码！");
		}
		list.add(rule);
		return list;
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
	private CodeSequence initCodeSequence(String codeRule, String unitCode, String locationCode, String docCode, Map<String, Integer> params, int minSeq, int maxSeq) {
		CodeSequence codeSequence = new CodeSequence(codeRule, unitCode, locationCode, docCode);
		if (params.containsKey("year")) {
			codeSequence.setYear(params.get("year"));
		}
		if (params.containsKey("month")) {
			codeSequence.setMonth(params.get("month"));
		}
		if (params.containsKey("day")) {
			codeSequence.setDay(params.get("day"));
		}
		codeSequence.setMinSequence(minSeq);
		codeSequence.setMaxSequence(maxSeq);
		if (minSeq == 0) {
			codeSequence.setSeq(1); // 设置起始的序列
		} else {
			codeSequence.setSeq(minSeq); // 设置起始的序列
		}
		codeSequenceDao.addCodeSequence(codeSequence);
		if (codeSequence.getCodesequenceId() == 0)
			throw new WekitException("生成编码时发生意外请与管理员联系!");
		return codeSequence;
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
		if (!(rules[0].endsWith("x") || rules[0].equals(unitCode)))
			return null;
		if (!(rules[1].equals("xxx") || rules[1].equals(locationCode)))
			return null;
		if (!(rules[2].equals("xxx") || rules[2].equals(docCode)))
			return null;
		return rules[3];
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public boolean cancelCode(Long codeId, String createrid, String ip, String note) {
		Code temp = codeDao.getCode(codeId);
		return cancel(temp, createrid, ip, note);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	@Override
	public boolean cancelCode(String code, String createrid, String ip, String note) {
		Code temp = codeDao.getCode(code);
		return cancel(temp, createrid, ip, note);

	}

	protected boolean cancel(Code code, String createrid, String ip, String note) {
		if (code == null)
			throw new WekitException("该编码不存在");
		User user = userDao.getByID(createrid, 1);
		if (user == null)
			throw new WekitException("用户信息不存在!");

		CodeRule codeRule = codeRuleDao.getCodeRule(code.getRuleName(), code.getRule());
		String oldinfo = null;
		try {
			if (codeRule != null) {
				TempCode tempCode = new TempCode(code.getRule(), user.getDisplayName(), user.getDisplayName(), code.getUnitCode(), code.getLocationCode(), code.getDocCode(), 0, code.getCode(), note, code.getCreateTime(), code.getCodeName(), codeRule.getMinSequence(), codeRule.getMaxSequence(), code.getYear(), code.getMonth(), code.getDay());
				tempCodeDao.addTempCode(tempCode);
			}
			oldinfo = DataWrapUtil.ObjectToJson(code);
			codeDao.deleteCode(code);
			codeApplyLogDao.saveCodeApplyLog(user.getLoginName(), user.getDisplayName(), user.getDeptName(), user.getDeptDisplayName(), codeRule.getFileType(), code.getCode(), oldinfo, CodeApplyLogDao.CANCELOPERATE, System.currentTimeMillis(), codeRule.getFileTypeName());
			logger.info("creater:" + user.getDisplayName() + "||createrid:" + createrid + "取消:编码 " + oldinfo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new WekitException(e.getMessage());
		}
		return true;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Code> queryCodes(Map<String, String> map, IPaginable paginable) {
		return this.codeDao.queryCodes(map, paginable);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@Override
	public boolean deleteCode(Long id, String creatername, String createrid, String ip) throws Exception {
		Code code = codeDao.getCode(id);
		if (code != null) {
			if (codeDao.deleteCode(code)) {
				logger.info(creatername + "(" + createrid + "-- ip:" + ip + ") 删除编码:" + DataWrapUtil.ObjectToJson(code));
			} else {
				throw new WekitException("删除编码失败!");
			}
		}
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Override
	public CodeWrap[] importCodes(String json) {
		try {
			CodeWrap[] wraps = DataWrapUtil.jsonToCodeWrapList(json);
			String uuid = UUID.randomUUID().toString();
			for (CodeWrap wrap : wraps) {
				try {
					if (StringUtils.isEmpty(wrap.getCode())) {
						wrap.setResult("编码存在!");
						continue;
					}

					CodeRule codeRule = codeRuleDao.getCodeRule(wrap.getRuleName(), wrap.getRule());
					if (codeRule == null) {
						wrap.setResult("rulename和rule没有能找到对应的规则!");
						continue;
					}

					User user = userDao.getByID(wrap.getUserId(), 1);
					if (user == null) {
						wrap.setResult("对应的userid的信息不存在");
						continue;
					}
					Map<String, Integer> param = new HashMap<String, Integer>();
					if (checkImport(wrap.getRule(), wrap.getCode(), param)) {
						if (codePoolDao.isExistsed(wrap.getCode())) {
							wrap.setResult("该编码在数据库中已经存在!");
							continue;
						} else {
							String[] temp = wrap.getCode().split("-");
							Code code = new Code(codeRule.getRuleName(), codeRule.getRule(), user.getDisplayName(), user.getLoginName(), temp[0], temp[1], temp[2], wrap.getCode(), 1, uuid, System.currentTimeMillis(), wrap.getNote(), wrap.getFileName(), user.getDeptDisplayName(), codeRule.getFileTypeName(), wrap.getCodeName(), param.get("year"), param.get("month"), param.get("day"));
							codeDao.addCode(code);
							codePoolDao.insertCodePool(wrap.getCode());
						}

					} else {
						wrap.setResult("编码规则和编码不匹配!");
						continue;
					}
					wrap.setResult("导入成功!");
				} catch (Exception ex) {
					wrap.setResult(ex.getMessage());
				}
			}
			return wraps;

		} catch (JsonParseException e) {
			logger.error(e.getMessage());
			throw new WekitException(e.getMessage());
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
			throw new WekitException(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new WekitException(e.getMessage());
		}
	}

	private boolean checkImport(String rule, String code, Map<String, Integer> params) {
		String[] rules = rule.split("-");
		String[] codes = code.split("-");
		if (!rules[0].endsWith("x") && !rules[0].equals(codes[0]))
			return false;
		if (!rules[1].equals("xxx") && !rules[1].equals(codes[1]))
			return false;
		if (!rules[2].equals("xxx") && !rules[2].equals(codes[2])) {
			return false;
		}
		int index = 0;
		index = rule.indexOf("[yyyy]");
		if (index != -1) {
			params.put("year", Integer.parseInt(code.substring(index, index + 5)));
		} else {
			params.put("year", 0);
		}
		index = rule.indexOf("[yy]");
		if (index != -1) {
			params.put("year", Integer.parseInt(code.substring(index, index + 3)));
		} else {
			params.put("year", 0);
		}
		index = rule.indexOf("[mm]");
		if (index != -1) {
			params.put("month", Integer.parseInt(code.substring(index, index + 3)));
		} else {
			params.put("month", 0);
		}

		index = rule.indexOf("[dd]");
		if (index != -1) {
			params.put("day", Integer.parseInt(code.substring(index, index + 3)));
		} else {
			params.put("day", 0);
		}
		if (!checkMask(rules[3], codes[3])) {
			return false;
		}
		return true;
	}

	private boolean checkMask(String mask, String code) {

		int index = 1;
		String temp = null;
		String temp2 = null;

		while (true) {
			index = mask.indexOf("[");
			if (index == -1)
				break;
			temp = mask.substring(0, index);
			temp2 = code.substring(0, index);
			if (!temp.equals(temp2))
				return false;
			index = mask.indexOf("]");
			if (index == -1)
				return false;

			mask = mask.substring(index + 1, mask.length());
			code = code.substring(index - 1, code.length());
		}
		return true;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public CodePoolDao getCodePoolDao() {
		return codePoolDao;
	}

	public void setCodePoolDao(CodePoolDao codePoolDao) {
		this.codePoolDao = codePoolDao;
	}

	public CodeApplyLogDao getCodeApplyLogDao() {
		return codeApplyLogDao;
	}

	public void setCodeApplyLogDao(CodeApplyLogDao codeApplyLogDao) {
		this.codeApplyLogDao = codeApplyLogDao;
	}

}
