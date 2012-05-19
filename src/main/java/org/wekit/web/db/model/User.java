package org.wekit.web.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name="loginname")
	@GenericGenerator(name="assigned",strategy="assigned")
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

	public User(){}
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
