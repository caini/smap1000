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
