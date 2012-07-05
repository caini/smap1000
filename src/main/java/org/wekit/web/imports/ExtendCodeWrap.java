package org.wekit.web.imports;

import java.io.Serializable;

/**
 * 无规则编码封装类
 * @author HuangWeili
 *
 */
public class ExtendCodeWrap  implements Serializable{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -522536752898052236L;

	private long applyId;
	
	private String applyTitle;
	
	private String userId;
	
	private String note;
	
	private String code;
	
	private String result;
	
	private int state;
	
	private String applyedId;
	
	private String mask;
	
	private long filType;
	
	private int flag;
	
	private String fileName;

	public ExtendCodeWrap(){
		
	}
	
	public ExtendCodeWrap(long applyId,String applyTitle,String userId,String code,String note,int state,String applyedId,String mask,long fileType,String fileName){
		this.applyTitle=applyTitle;
		this.applyId=applyId;
		this.applyedId=applyedId;
		this.userId=userId;
		this.code=code;
		this.note=note;
		this.state=state;
		this.mask=mask;
		this.filType=fileType;
		this.fileName=fileName;
	}
	
	
	
	public long getApplyId() {
		return applyId;
	}

	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getApplyedId() {
		return applyedId;
	}

	public void setApplyedId(String applyedId) {
		this.applyedId = applyedId;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public long getFilType() {
		return filType;
	}

	public void setFilType(long filType) {
		this.filType = filType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getApplyTitle() {
		return applyTitle;
	}

	public void setApplyTitle(String applyTitle) {
		this.applyTitle = applyTitle;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	
	
	
}
