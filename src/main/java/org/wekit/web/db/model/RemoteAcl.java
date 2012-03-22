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

@XmlRootElement(name="RemoteAcl")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="remoteacl")
public class RemoteAcl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4923085775125064154L;

	@Id
	@GeneratedValue(generator="id_gen",strategy=GenerationType.TABLE)
	@TableGenerator(
			name="id_gen",
			table="sys_id_gen",
			pkColumnName="S_ID",
			valueColumnName="S_NEXTNUM",
			pkColumnValue="remoteacl",
			allocationSize=100
	)
	private long aclId;
	
	//账户对应的系统名称
	@Column(name="systemname",length=64)
	private String systemName;
	
	//登录用户名
	@Column(name="username",length=64)
	private String username;
	
	//账户密码
	@Column(name="password",length=128)
	private String password;
	
	//账户创建时间
	@Column(name="ctime")
	private long createTime;
	
	@Column(name="state")
	private int state; //用户状态
	
	
	
	public RemoteAcl()
	{}


	public long getAclId() {
		return aclId;
	}


	public void setAclId(long aclId) {
		this.aclId = aclId;
	}


	public String getSystemName() {
		return systemName;
	}


	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public long getCreateTime() {
		return createTime;
	}


	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	
	
}
