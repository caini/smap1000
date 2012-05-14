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
	
	@Column(name="filetype",nullable=true)
	private long fileType;

	public UnitCode() {
	}

	/**
	 * 全参数匹配构造函数
	 * @param name
	 * @param ename
	 * @param code
	 * @param typeName
	 * @param typeId
	 * @param creater
	 * @param createrId
	 * @param createTime
	 * @param state
	 */
	public UnitCode(String name,String ename,String code,String typeName,long typeId,String creater,String createrId,long createTime,int state,long fileType){
		this.name=name;
		this.ename=ename;
		this.code=code;
		this.typeName=typeName;
		this.typeId=typeId;
		this.creater=creater;
		this.createrId=createrId;
		this.createTime=createTime;
		this.state=state;
		this.fileType=fileType;
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

	public long getFileType() {
		return fileType;
	}

	public void setFileType(long fileType) {
		this.fileType = fileType;
	}
	
	

}
