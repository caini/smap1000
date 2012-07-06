package org.wekit.web.db.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.BatchSize;

/**
 * 定义编码记录实体类
 * 
 * @author Encore
 * 
 *         在该类中
 */

@XmlRootElement(name = "Code")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "code")
@BatchSize(size = 20)
public class Code implements Serializable {

	private static final long	serialVersionUID	= 1728886805018009356L;

	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "code", allocationSize = 100)
	private long				codeId;

	// 编码创建时间
	@Column(name = "ctime", nullable = false)
	private long				createTime;

	// 编码对应的编码规则
	@Column(name = "rule", length = 255, nullable = false)
	private String				rule;

	// 编码创建人
	@Column(name = "creater", length = 64)
	private String				creater;

	@Column(name = "createrid", length = 64)
	private String				createrId;

	// 机组号
	@Column(name = "unitcode", length = 64)
	private String				unitCode;

	// 定位码
	@Column(name = "locationcode", length = 64)
	private String				locationCode;

	// 文档类型码
	@Column(name = "doccode", length = 64)
	private String				docCode;

	@Column(name = "code", length = 255, nullable = false, unique = true)
	private String				code;

	// 编码状态
	@Column(name = "state")
	private int					state;

	// 定义编码的版本，实现乐观锁机制，保证编码生成的唯一性
	@Version
	@Column(name = "version")
	private long				version;

	// 批量申请ID号，一个uuid码
	@Column(name = "batch")
	private String				batchId;

	// 编码备注
	@Column(name = "note")
	@Lob
	private String				note;
	
	@Column(name="filename",nullable=true)
	@Lob
	private String filename;

	@Column(name="rulename",length=128,nullable=true)
	private String ruleName;
	
	@Column(name="deptname",length=128)
	private String deptName;
	
	@Column(name="filetypename",length=128)
	private String fileTypeName;
	
	@Column(name="codename",length=128)
	private String codeName;
	
	@Basic
	private int					year;

	@Basic
	private int					month;

	@Basic
	private int					day;
	
	
	// 初始化工作
	public Code(String ruleName,String rule, String creater, String createrId, String unitCode, String locationCode, String docCode, String code, int state, String batchId, long createTime, String note,String filename,String deptName,String fileTypeName,String codeName,int year,int month,int day) {
		this.rule = rule;
		this.creater = creater;
		this.createrId = createrId;
		this.unitCode = unitCode;
		this.locationCode = locationCode;
		this.docCode = docCode;
		this.code = code;
		this.state = state;
		this.batchId = batchId;
		this.createTime = createTime;
		this.note = note;
		this.filename=filename;
		this.ruleName=ruleName;
		this.deptName=deptName;
		this.fileTypeName=fileTypeName;
		this.codeName=codeName;
		this.year=year;
		this.month=month;
		this.day=day;
	}

	public Code() {
	}

	public long getCodeId() {
		return codeId;
	}

	public void setCodeId(long codeId) {
		this.codeId = codeId;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getFileTypeName() {
		return fileTypeName;
	}

	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	
	

}
