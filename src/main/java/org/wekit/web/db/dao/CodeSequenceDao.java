package org.wekit.web.db.dao;

import java.util.List;

import org.wekit.web.IPaginable;
import org.wekit.web.db.model.CodeSequence;

/**
 * 编码序列访问功能
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
}
