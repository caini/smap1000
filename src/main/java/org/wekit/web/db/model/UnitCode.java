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
 * 机组号实体
 * 
 * @author Encore
 * 
 */
@XmlRootElement(name = "UnitCode")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "unitcode")
public class UnitCode implements Serializable {

	private static final long serialVersionUID = -5103890729363073177L;

	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "unitcode", allocationSize = 100)
	private long unitId;

	// 编码名称
	@Column(name = "name", length = 64)
	private String name;

	// 编码英文名称
	@Column(name = "ename", length = 64)
	private String ename;

	// 编码
	@Column(name = "code", length = 64)
	private String code;

	// 所属分类名称
	@Column(name = "typename", length = 64)
	private String typeName;

	// 所属分类ID
	@Column(name = "typeid")
	private long typeId;

	// 编码创建人
	@Column(name = "creater", length = 64)
	private String creater;

	@Column(name = "createrid", length = 64)
	private String createrId;

	// 编码创建时间
	@Column(name = "ctime")
	private long createTime;

	// 编码状态
	@Column(name = "state")
	private int state;

	public UnitCode() {
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
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

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

}
