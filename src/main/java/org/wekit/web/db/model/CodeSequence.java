package org.wekit.web.db.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@XmlRootElement(name = "CodeSequence")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "codesequence")
public class CodeSequence implements Serializable {

	private static final long serialVersionUID = -7164061170090955776L;

	// 对应具体的编码
	@Id
	@GeneratedValue(generator = "assigned")
	@GenericGenerator(name = "assigned", strategy = "assigned")
	private String codeRule;

	// 编码规则的掩码信息
	@Column(name = "marsk", length = 64)
	private String marsk;

	@Basic
	private int year;

	@Basic
	private int month;

	@Basic
	private int day;

	@Column(name = "seq", length = 11, scale = 0)
	private long seq;

	public CodeSequence() {
	}

	public String getCodeRule() {
		return codeRule;
	}

	public void setCodeRule(String codeRule) {
		this.codeRule = codeRule;
	}

	public String getMarsk() {
		return marsk;
	}

	public void setMarsk(String marsk) {
		this.marsk = marsk;
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
}
