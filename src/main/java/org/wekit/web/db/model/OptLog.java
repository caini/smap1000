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
 * 远程访问登录日志
 * @author Encore
 *
 */
@XmlRootElement(name="OptLog")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="optlog")
public class OptLog  implements Serializable{

	private static final long serialVersionUID = 6469685168229335336L;

	@Id
	@GeneratedValue(generator="id_gen",strategy=GenerationType.TABLE)
	@TableGenerator(
			name="id_gen",
			table="sys_id_gen",
			pkColumnName="S_ID",
			valueColumnName="S_NEXTNUM",
			pkColumnValue="acllog",
			allocationSize=100
	)
	private long logId;
	
	@Column(name="systemid",length=64)
	private String systemId;
	
	@Column(name="systemname",length=64)
	private String systemName;
	
	@Column(name="username",length=64)
	private String userName;
	
	
	@Column(name="userid",length=64)
	private String userId;
	
	@Column(name="otime")
	private long  operatorTime;
	
	@Column(name="content",length=512)
	private String content;
	
	@Column(name="ip",length=128)
	private String ip;
	
	@Column(name="operate",length=64)
	private String operate;
	
	@Column(name="deptname",length=128)
	private String deptName;
	
	public OptLog()
	{}

	/**
	 * 全参数匹配构造函数
	 * @param systemId
	 * @param systemName
	 * @param userid
	 * @param content
	 * @param operatorTime
	 * @param ip
	 * @param operate
	 */
	public OptLog(String systemId,String systemName,String userid,String username,String content,long operatorTime,String ip,String operate,String deptName){
		this.systemId=systemId;
		this.systemName=systemName;
		this.userId=userid;
		this.userName=username;
		this.content=content;
		this.operatorTime=operatorTime;
		this.ip=ip;
		this.operate=operate;
		this.deptName=deptName;
	}
	
	
	public long getLogId() {
		return logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
    
	public long getOperatorTime() {
		return operatorTime;
	}

	public void setOperatorTime(long operatorTime) {
		this.operatorTime = operatorTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
}
