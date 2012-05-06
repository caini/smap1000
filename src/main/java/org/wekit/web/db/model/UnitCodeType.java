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
 * 机组号类型实体
 * 
 * @author Encore
 * 
 */
@XmlRootElement(name = "UnitCodeType")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "unitcodetype")
public class UnitCodeType implements Serializable {

	private static final long serialVersionUID = -542505585106689988L;

	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "unitcodetype", allocationSize = 100)
	private long typeId;

	// 机组类型名称
	@Column(name = "name", length = 64)
	private String name;

	@Column(name="ename",length=64)
	private String ename;
	
	// 机组类型码
	@Column(name = "code", length = 64)
	private String code;

	// 机组备注
	@Column(name = "note", length = 1024)
	private String note;

	// 类型创建时间
	@Column(name = "ctime")
	private long createTime;

	// 类型创建时间
	@Column(name = "creater", length = 64)
	private String creater;

	@Column(name = "craterid", length = 64)
	private String createrId;

	// 类型状态
	@Column(name = "state")
	private int state;

	public UnitCodeType() {
	}
	
	/**
	 * 全参数匹配构造函数
	 * @param name
	 * @param ename
	 * @param code
	 * @param note
	 * @param createTime
	 * @param creater
	 * @param createrId
	 * @param state
	 */
	public UnitCodeType(String name,String ename,String code,String note,long createTime,String creater,String createrId,int state){
		this.name=name;
		this.ename=ename;
		this.code=code;
		this.note=note;
		this.createTime=createTime;
		this.creater=creater;
		this.createrId=createrId;
		this.state=state;
	}
	
	

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

}
