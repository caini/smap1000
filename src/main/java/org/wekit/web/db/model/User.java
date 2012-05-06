package org.wekit.web.db.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User {

	@Id
	@Column(name="loginname")
	@GeneratedValue(generator="assigned")
	private String loginName;
	
	@Column(name="displayname",length=64,nullable=false)
	private String displayName;
	
	@Column(name="userstatus",length=2)
	private int status;
	
	@Column(name="deptname",length=64,nullable=false)
	private String deptName;
	
	@Column(name="deptdisplayname",length=64,nullable=false)
	private String deptDisplayName;

	/**
	 * 全参数匹配构造函数
	 * @param loginName
	 * @param displayName
	 * @param deptname
	 * @param deptDisplayName
	 * @param status
	 */
	public User(String loginName,String displayName,String deptname,String deptDisplayName,int status){
		this.loginName=loginName;
		this.displayName=displayName;
		this.deptName=deptname;
		this.deptDisplayName=deptDisplayName;
		this.status=status;
	}
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDisplayName() {
		return deptDisplayName;
	}

	public void setDeptDisplayName(String deptDisplayName) {
		this.deptDisplayName = deptDisplayName;
	}
	
	
}
