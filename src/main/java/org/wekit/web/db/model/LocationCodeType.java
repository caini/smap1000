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
 * 定位码类型实体
 * 
 * @author Encore
 * 
 */
@XmlRootElement(name = "LocationCodeType")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "locationcodetype")
public class LocationCodeType implements Serializable {

	private static final long serialVersionUID = 295504693398701681L;

	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "locationcodetype", allocationSize = 100)
	private long typeId;

	// 定位码类型名称
	@Column(name = "name", length = 64)
	private String name;

	
	@Column(name="ename",length=64,nullable=true)
	private String ename;
	
	// 类型编码
	@Column(name = "code", length = 64)
	private String code;

	// 定位码备注
	@Column(name = "note", length = 1024)
	private String note;

	// 编码创建人
	@Column(name = "creater", length = 64)
	private String creater;

	@Column(name = "createrid", length = 64)
	private String createrId;

	// 创建时间
	@Column(name = "ctime")
	private long createTime;

	// 类型状态
	@Column(name = "state")
	private int state;

	public LocationCodeType() {
	}
	
	/**
	 * 全参数匹配构造函数
	 * @param name
	 * @param ename
	 * @param code
	 * @param note
	 * @param creater
	 * @param createrId
	 * @param createTime
	 * @param state
	 */
	public LocationCodeType(String name,String ename,String code,String note,String creater,String createrId,long createTime,int state){
		this.name=name;
		this.code=code;
		this.note=note;
		this.creater=creater;
		this.createrId=createrId;
		this.createTime=createTime;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
