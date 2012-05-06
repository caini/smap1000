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
 * 反馈意见类型实体
 * 
 * @author Encore
 * 
 */

@XmlRootElement(name = "FeedbackType")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "feedbacktype")
public class FeedbackType implements Serializable {

	private static final long serialVersionUID = -4363421440756000321L;
	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "feedbacktype", allocationSize = 100)
	private long typeId;

	// 编码类型名称
	@Column(name = "name", length = 64)
	private String name;

	//英文名称
	@Column(name="ename",length=64)
	private String ename;
	
	
	// 编码备注
	@Column(name = "note", length = 500)
	private String note;

	// 类型创建时间
	@Column(name = "ctime")
	private long createTime;

	// 类型创建人
	@Column(name = "creater", length = 64)
	private String creater;

	@Column(name = "createrid", length = 64)
	private String createrId;

	public FeedbackType() {
	}

	/**
	 * 全参数匹配构造函数
	 * @param name
	 * @param ename
	 * @param note
	 * @param createTime
	 * @param creater
	 * @param createrId
	 */
	public FeedbackType(String name,String ename,String note,long createTime,String creater,String createrId){
		this.name=name;
		this.ename=ename;
		this.note=note;
		this.createTime=createTime;
		this.creater=creater;
		this.createrId=createrId;
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
