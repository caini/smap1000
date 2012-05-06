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

@XmlRootElement(name="RemoteLog")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="remotelog")
public class RemoteLog implements Serializable {

	private static final long	serialVersionUID	= -7477353917681736199L;
	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "remotelog", allocationSize = 100)
	private long remotelogId;
	
	@Column(name="remoteid",length=11,nullable=false)
	private long remoteId;
	
	@Column(name="remotename",nullable=false,length=64)
	private String remoteName;
	
	@Column(name = "ctime", nullable = false)
	private long createTime;
	
	@Column(name="operatetype",length=16,nullable=false)
	private String operateType;
	
	@Column(name="content",length=2000,nullable=true)
	private String content;

	
	public RemoteLog(){
		
	}
	
	public RemoteLog(long remoteId,String remoteName,String operaterType,String content,long createTime){
		this.remoteId=remoteId;
		this.remoteName=remoteName;
		this.operateType=operaterType;
		this.content=content;
		this.createTime=createTime;
	}
	
	
	
	
	public long getRemotelogId() {
		return remotelogId;
	}

	public void setRemotelogId(long remotelogId) {
		this.remotelogId = remotelogId;
	}

	public long getRemoteId() {
		return remoteId;
	}

	public void setRemoteId(long remoteId) {
		this.remoteId = remoteId;
	}

	public String getRemoteName() {
		return remoteName;
	}

	public void setRemoteName(String remoteName) {
		this.remoteName = remoteName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}




	public String getOperateType() {
		return operateType;
	}




	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	
	
	
	
}
