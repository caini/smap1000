package org.wekit.web.db.model;

public class CodeCancel {

	private long id;
	
	private String code;
	
	private String creater;
	
	private String deptName;
	
	private long createTime;
	
	private String note;
	
	
	public CodeCancel(){
		
	}
	
	/**
	 * 全变量构造函数
	 * @param id
	 * @param code
	 * @param creater
	 * @param deptname
	 * @param createTime
	 * @param note
	 */
	public CodeCancel(long id,String code,String creater,String deptname,long createTime,String note){
		this.id=id;
		this.code=code;
		this.creater=creater;
		this.deptName=deptname;
		this.createTime=createTime;
		this.note=note;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
}
