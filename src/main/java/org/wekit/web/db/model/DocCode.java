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
 * 定义文档类型实体类
 * 
 * @author Encore
 * 
 */
@XmlRootElement(name = "DocCode")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "doccode")
public class DocCode implements Serializable {
	private static final long	serialVersionUID	= -77721154122274573L;

	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "doccode", allocationSize = 100)
	private long				docId;

	@Column(name = "code", nullable = false, unique = true)
	private String				code;

	// 编码创建时间
	@Column(name = "ctime", nullable = false)
	private long				createTime;

	// 编码状态
	@Column(name = "state")
	private int					state;

	// 编码名称
	@Column(name = "name", length = 128)
	private String				name;

	@Column(name = "ename", length = 128)
	private String				ename;

	// 编码表述
	@Column(name = "illustrate")
	private String				illustrate;

	// 编码类型ID
	@Column(name = "typeid")
	private long				typeId;

	// 编码类型名称
	@Column(name = "typename")
	private String				typeName;

	// 编码创建人
	@Column(name = "creater", length = 64)
	private String				creater;

	@Column(name = "createrid", length = 64)
	private String				createrId;

	// 编码描述
	@Column(name = "note", length = 128)
	private String				note;

	public DocCode(String code, String name, String ename, String illustrate, long typeId, String typeName, String creater, String createrid, long creatertime, int state) {
		this.code = code;
		this.name = name;
		this.ename = ename;
		this.illustrate = illustrate;
		this.typeId = typeId;
		this.typeName = typeName;
		this.creater = creater;
		this.createrId = createrid;
		this.createTime = creatertime;
		this.state = state;
	}

	public DocCode() {

	}

	public long getDocId() {
		return docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIllustrate() {
		return illustrate;
	}

	public void setIllustrate(String illustrate) {
		this.illustrate = illustrate;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}
