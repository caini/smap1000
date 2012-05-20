package org.wekit.web.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CodeApplyLog")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "codeapplylog")
public class CodeApplyLog implements Serializable{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 4524873629802707437L;
	@Id
	@Column(name="applylogid")
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "codeapplylog", allocationSize = 100)
	private long codeApplyLogId;
	
	@Column(name="userid",length=64,nullable=false)
	private String userId;
	
	@Column(name="username",length=64,nullable=false)
	private String userName;
	
	@Column(name="deptid",length=64,nullable=false)
	private String deptId;
	
	@Column(name="deptname",length=64,nullable=false)
	private String deptName;
	
	@Column(name="ctime",nullable=false)
	private long createTime;
	
	@Column(name="filetype")
	private long fileType;
	
	@Column(name="code",nullable=false)
	private String code;
	
	@Lob
	@Column(name="content",nullable=true,length=2000)
	private String content;
	
	@Column(name="operatetype",nullable=false)
	private String operateType;

	public CodeApplyLog(){
		
	}
	
	/**
	 * 全参数构造函数
	 * @param userId
	 * @param userName
	 * @param deptid
	 * @param deptname
	 * @param createTime
	 * @param fileType
	 * @param code
	 * @param content
	 * @param operateType
	 */
	public CodeApplyLog(String userId,String userName,String deptid,String deptname,long createTime,long fileType,String code,String content,String operateType){
		this.userId=userId;
		this.userName=userName;
		this.deptId=deptid;
		this.deptName=deptname;
		this.createTime=createTime;
		this.fileType=fileType;
		this.code=code;
		this.content=content;
		this.operateType=operateType;
	}
	
	
	public long getCodeApplyLogId() {
		return codeApplyLogId;
	}

	public void setCodeApplyLogId(long codeApplyLogId) {
		this.codeApplyLogId = codeApplyLogId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
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

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public long getFileType() {
		return fileType;
	}

	public void setFileType(long fileType) {
		this.fileType = fileType;
	}
	
	
	
	
}
