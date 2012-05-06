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
 * 定位码记录实体
 * 
 * @author Encore
 * 
 */
@XmlRootElement(name = "LocationCode")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "locationcode")
public class LocationCode implements Serializable {

	private static final long serialVersionUID = -6924437514540265344L;

	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "locationcode", allocationSize = 100)
	private long locationId;

	// 编码创建时间
	@Column(name = "ctime", nullable = false)
	private long createTime;

	// 编码
	@Column(name = "code", length = 64)
	private String code;

	// 编码状态
	@Column(name = "state")
	private int state;

	// 中文编码名称
	@Column(name = "name", length = 64)
	private String name;

	// 英文编码名称
	@Column(name = "ename", length = 64)
	private String ename;

	// 编码表述
	@Column(name = "illustrate")
	private String illustrate;

	// 编码扩展信息
	@Column(name = "extend", length = 64)
	private String extend;

	// 编码类型ID
	@Column(name = "typeid")
	private long typeId;

	// 编码类型名称
	@Column(name = "typename")
	private String typeName;

	// 编码创建人
	@Column(name = "creater", length = 64)
	private String creater;

	@Column(name = "craterid", length = 64)
	private String createrId;

	public LocationCode() {

	}

	/**
	 * 全参数匹配构造函数
	 * @param code
	 * @param name
	 * @param ename
	 * @param illustrate
	 * @param extend
	 * @param state
	 * @param typeId
	 * @param typeName
	 * @param creater
	 * @param createrid
	 * @param createTime
	 */
	public LocationCode(String code,String name,String ename,String illustrate,String extend,int state,long typeId,String typeName,String creater,String createrid,long createTime){
		this.code=code;
		this.name=name;
		this.ename=ename;
		this.illustrate=illustrate;
		this.extend=extend;
		this.state=state;
		this.typeId=typeId;
		this.typeName=typeName;
		this.creater=creater;
		this.createrId=createrid;
		this.createTime=createTime;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

}
