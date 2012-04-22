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
 * 定义管理员实体类
 * 
 * @author Encore
 * 
 */
@XmlRootElement(name = "Admin")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "admin")
public class Admin implements Serializable {

	private static final long serialVersionUID = -1396718604830746928L;

	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "admin", allocationSize = 100)
	private long adminId;

	@Column(name = "username", length = 64, nullable = false, updatable = false)
	private String userName;

	@Column(name = "displayName", length = 64, nullable = false, updatable = false)
	private String displayName;

	@Column(name = "password", length = 128, nullable = false)
	private String password;

	@Column(name = "ctime", nullable = false)
	private long createTime;

	@Column(name = "logintimes",nullable=true)
	private long loginTimes;

	@Column(name = "lastip", length = 128, nullable = true)
	private String lastIp;


	public Admin() {
	}
	
	/**
	 * 系统管理员构造函数
	 * @param username
	 * @param displayName
	 * @param password
	 * @param createTime
	 * @param loginTimes
	 * @param lastip
	 */
	public Admin(String username,String displayName,String password,long createTime,long loginTimes,String lastip){
		this.userName=username;
		this.displayName=displayName;
		this.password=password;
		this.loginTimes=loginTimes;
		this.createTime=createTime;
		this.lastIp=lastip;
	}
	

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(long loginTimes) {
	     try{
		   this.loginTimes = loginTimes;
	     }catch(Exception ex)
	     {
	    	this.loginTimes=0; 
	     }
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
