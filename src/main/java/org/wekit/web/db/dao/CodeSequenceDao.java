package org.wekit.web.db.dao;

import java.util.List;
import java.util.Map;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.CodeSequence;

/**
 * 编码序列访问功能
 * 
 * @author huangweili
 * 
 */
public interface CodeSequenceDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public CodeSequence getCodeSequence(long id);

	/**
	 * 
	 * @param codeSequence
	 * @return
	 */
	public CodeSequence addCodeSequence(CodeSequence codeSequence);

	/**
	 * 
	 * @param codeSequence
	 * @return
	 */
	public boolean updateCodeSequence(CodeSequence codeSequence);

	/**
	 * 
	 * @param codeSequence
	 * @return
	 */
	public boolean deleteCodeSequence(CodeSequence codeSequence);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteCodeSequence(long id);

	/**
	 * 
	 * @return
	 */
	public List<CodeSequence> getAllCodeSequences();

	/**
	 * 
	 * @param paginable
	 * @return
	 */
	public List<CodeSequence> getCodeSequencesWithPagination(IPaginable paginable);

	/**
	 * 根据编码规则和年月日获取编码的序列 //一般情况下 这个序列都是唯一的
	 * 
	 * @param rule
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public List<CodeSequence> queryCodeSequences(String rule, String unitCode, String locationCode, String docCode, int year, int month, int day);

	/**
	 * 增加编码的序列计数
	 * 
	 * @param sequence
	 * @return
	 */
	public boolean incCodeSequence(CodeSequence sequence);

	/**
	 * 根据参数查找对象
	 * 
	 * @param rule
	 * @param params
	 * @return
	 */
	public List<CodeSequence> queryCodeSequences(String rule, String unitCode, String locationCode, String docCode, Map<String, Integer> params,IPaginable paginable);
}
