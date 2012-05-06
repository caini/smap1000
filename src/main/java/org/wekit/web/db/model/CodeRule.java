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
 * 定义编码规则实体类
 * 
 * @author Encore
 * 
 */
@XmlRootElement(name = "CodeRule")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "coderule")
public class CodeRule implements Serializable {

	private static final long	serialVersionUID	= -5360821840364956382L;

	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "coderule", allocationSize = 100)
	private long				ruleId;

	// 编码名称(文件类型)
	@Column(name = "rulename", length = 128)
	private String				ruleName;

	// 编码规则创建人
	@Column(name = "creater", length = 64, nullable = false, updatable = false)
	private String				creater;

	@Column(name = "createrId", length = 64, nullable = false, updatable = false)
	private String				createrId;

	// 编码创建时间
	@Column(name = "ctime", updatable = false)
	private long				createTime;

	// 编码规则列
	@Column(name = "rule", length = 128)
	private String				rule;

	// 获取规则的封面
	@Column(name = "face", length = 500)
	private String				face;

	// 规则状态
	@Column(name = "state")
	private int					state;

	@Column(name = "maxseq", nullable = false)
	private int					maxSequence;

	@Column(name = "minseq", nullable = false)
	private int					minSequence;

	public CodeRule() {
		this.maxSequence=0;
		this.minSequence=0;
		this.state=1;
	}

	/**
	 * 全参数匹配构造函数
	 * @param ruleName
	 * @param creater
	 * @param createrId
	 * @param createrTime
	 * @param rule
	 * @param face
	 * @param state
	 * @param minSequence
	 * @param maxSequence
	 */
	public CodeRule(String ruleName,String creater,String createrId,long createrTime,String rule,String face,int state,int minSequence,int maxSequence){
		this.ruleName=ruleName;
		this.creater=creater;
		this.createrId=createrId;
		this.createTime=createrTime;
		this.rule=rule;
		this.face=face;
		this.state=state;
		this.minSequence=minSequence;
		this.maxSequence=maxSequence;
	}
	
	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public long getRuleId() {
		return ruleId;
	}

	public void setRuleId(long ruleId) {
		this.ruleId = ruleId;
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


	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public int getMaxSequence() {
		return maxSequence;
	}

	public void setMaxSequence(int maxSequence) {
		this.maxSequence = maxSequence;
	}

	public int getMinSequence() {
		return minSequence;
	}

	public void setMinSequence(int minSequence) {
		this.minSequence = minSequence;
	}
}
