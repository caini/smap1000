package org.wekit.web.db.model;

import java.io.Serializable;

import javax.persistence.Basic;
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

@XmlRootElement(name = "CodeSequence")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "codesequence")
public class CodeSequence implements Serializable {

	private static final long	serialVersionUID	= -7164061170090955776L;

	// 对应具体的编码
	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "codesequence", allocationSize = 100)
	private long				codesequenceId;

	@Column(name = "coderule", length = 128, nullable = false)
	private String				codeRule;

	@Column(name = "unitcode", length = 64)
	private String				unitCode;

	@Column(name = "locationcode", length = 64)
	private String				locationCode;

	@Column(name = "doccode", length = 64)
	private String				docCode;

	@Basic
	private int					year;

	@Basic
	private int					month;

	@Basic
	private int					day;

	@Column(name = "seq", length = 11, scale = 0)
	private long				seq;

	public CodeSequence(String codeRule, String unitCode, String locationCode, String docCode) {
		this();
		this.codeRule = codeRule;
		this.unitCode = unitCode;
		this.locationCode = locationCode;
		this.docCode = docCode;
		
	}

	public CodeSequence() {
		this.year = 0;
		this.month = 0;
		this.day = 0;
		this.seq=0;
	}

	public long getCodesequenceId() {
		return codesequenceId;
	}

	public void setCodesequenceId(long codesequenceId) {
		this.codesequenceId = codesequenceId;
	}

	public String getCodeRule() {
		return codeRule;
	}

	public void setCodeRule(String codeRule) {
		this.codeRule = codeRule;
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

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
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

}
