package org.wekit.web.db.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 反馈意见实体
 * 
 * @author Encore
 * 
 */
@XmlRootElement(name = "Feedback")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "feedback")
public class Feedback implements Serializable {

	private static final long serialVersionUID = -9180783952449210471L;

	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "feedback", allocationSize = 100)
	private long feedbackId;

	@Column(name = "typeid")
	private long typeId;

	@Column(name = "typename", length = 128)
	private String typeName;

	@Column(name = "title", length = 500)
	private String title;

	// 提交的内容
	@Column(name = "content", length = 2048)
	private String content;

	// 信息创建人
	@Column(name = "creater", length = 64)
	private String creater;

	@Column(name = "createrid", length = 64)
	private String createrId;

	// 反馈状态
	@Column(name = "state")
	private int state;

	@ManyToOne
	@JoinColumn(name = "parentid")
	private Feedback parent;

	@OneToMany(mappedBy = "parent")
	private List<Feedback> replies;

	public long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Feedback getParent() {
		return parent;
	}

	public void setParent(Feedback parent) {
		this.parent = parent;
	}

	public List<Feedback> getReplies() {
		return replies;
	}

	public void setReplies(List<Feedback> replies) {
		this.replies = replies;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

}
