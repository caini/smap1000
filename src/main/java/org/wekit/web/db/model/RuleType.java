package org.wekit.web.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@XmlRootElement(name = "RuleType")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "ruletype")
public class RuleType implements Serializable {

	private static final long	serialVersionUID	= -2259247961479539929L;
	@Id
	@GenericGenerator(name="assigned",strategy="assigned")
	@GeneratedValue(generator = "assigned")
	@Column(name="typeid")
	private long				typeId;

	@Column(name="typename",length=64,nullable=false)
	private String typeName;
	
	@Column(name="typenote",length=512,nullable=true)
	private String note;
	
	public RuleType(){
		
	}
	
	public RuleType(int typeid,String typeName,String typeNote){
		this.typeId=typeid;
		this.typeName=typeName;
		this.note=typeNote;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}