package org.wekit.web.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 编码申请实体类
 * 
 * @author Encore
 * 
 */

@XmlRootElement(name = "CodeApply")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "codeapply")
public class CodeApply implements Serializable {

	private static final long serialVersionUID = -6901992830709143952L;

	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "codeapply", allocationSize = 100)
	private long applyId;

	// 编码申请人姓名
	@Column(name = "creater", length = 64)
	private String creater;

	@Column(name = "createrid", length = 64)
	private String createrId;

	// 申请提交时间
	@Column(name = "ctime", nullable = false)
	private long createTime;

	// 编码申请结果
	@Column(name = "result", length = 1024)
	private String result;

	// 机组号信息
	@Column(name = "unit", length = 500)
	private String unit;

	// 文件类型
	@Column(name = "doctype", length = 500)
	private String doc;

	// 定位信息
	@Column(name = "location", length = 500)
	private String location;

	// 文件名称
	@Column(name = "file", length = 500)
	private String file;
	// 掩码描述
	@Column(name = "mask", length = 500)
	private String mask;

	// 信息备注
	@Column(name = "note", length = 1024)
	private String note;

	// 审核状态
	@Column(name = "state", length = 2)
	private int state;

	// 审核通过人姓名
	@Column(name = "applyedname", length = 64)
	private String applyedName;
	
	@Column(name="applyedid",length=64)
	private String applyedId;

	@Column(name="filename",length=512,nullable=true)
	private String fileName;
	
	@Column(name="deptname",length=128,nullable=true)
	private String deptName;
	
	@Column(name="filetype",nullable=true)
	private long fileType;
	
	@Column(name="filetypename",length=128,nullable=true)
	private String fileTypeName;
	
	
	public CodeApply() {
	}
	
	
	public CodeApply(String creater,String createrid,long creatertime,String unit,String location ,String doc,String file,String mask,String note,int state,String applayName,String applyedId,String fileName,String deptName,long fileType,String fileTypeName){
		this.creater=creater;
		this.createrId=createrid;
		this.createTime=creatertime;
		this.unit=unit;
		this.location=location;
		this.doc=doc;
		this.file=file;
		this.mask=mask;
		this.note=note;
		this.state=state;
		this.applyedName=applayName;
		this.applyedId=applyedId;
		this.fileName=fileName;
		this.deptName=deptName;
		this.fileType=fileType;
		this.fileTypeName=fileTypeName;
	}

	public long getApplyId() {
		return applyId;
	}

	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getApplyedName() {
		return applyedName;
	}

	public void setApplyedName(String applyedName) {
		this.applyedName = applyedName;
	}

	public String getApplyedId() {
		return applyedId;
	}

	public void setApplyedId(String applyedId) {
		this.applyedId = applyedId;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public long getFileType() {
		return fileType;
	}


	public void setFileType(long fileType) {
		this.fileType = fileType;
	}


	public String getFileTypeName() {
		return fileTypeName;
	}


	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}
	
	

	
}
