package org.wekit.web.db.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
/**
 * 代码池用来存储所有以申请的编码
 * @author HuangWeili
 *
 */
@XmlRootElement(name = "CodePool")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "codepool")
public class CodePool implements Serializable {

	private static final long	serialVersionUID	= -4214927630464248024L;
	
	@Id
	@GenericGenerator(name="assigned",strategy="assigned")
	@GeneratedValue(generator="assigned")
	private String code;
	
	public CodePool(){
		
	}
	
	public CodePool(String code){
		this.code=code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
