package org.wekit.web.imports;

import java.io.Serializable;

/**
 * wrap参数封装类
 * @author HuangWeili
 *
 */
public class CodeWrap implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -5416344810147626221L;
	
	
	private String ruleName;
	
	private String rule;
	
	
	private String note;
	
	private String fileName;
	
	private String codeName;

	private String userId;
	
	private String code;
	
	private String result;
	
	public CodeWrap(){
		
		
	}
	
	public CodeWrap(String code,String ruleName,String rule,String userId,String note,String fileName,String codeName){
		this.code=code;
		this.rule=rule;
		this.ruleName=ruleName;
		this.userId=userId;

		this.note=note;
		this.fileName=fileName;
		this.codeName=codeName;
	}
	
	
	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	

}
