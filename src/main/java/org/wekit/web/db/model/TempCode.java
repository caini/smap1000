package org.wekit.web.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

@Entity
@Table(name = "tempcode")
public class TempCode implements Serializable {

	private static final long serialVersionUID = 5070848546386447287L;

	@Id
	@GeneratedValue(generator = "id_gen", strategy = GenerationType.TABLE)
	@TableGenerator(name = "id_gen", table = "sys_id_gen", pkColumnName = "S_ID", valueColumnName = "S_NEXTNUM", pkColumnValue = "tempcode", allocationSize = 100)
	private long codeId;

	// 编码创建时间
	@Column(name = "ctime", nullable = false)
	private long createTime;

	// 编码规则
	@Column(name = "rule", length = 255, nullable = false)
	private String rule;

	// 编码创建人
	@Column(name = "creater", length = 64)
	private String creater;

	@Column(name = "createrid", length = 64)
	private String createrId;

	// 机组号
	@Column(name = "unitcode", length = 64)
	private String unitCode;

	// 定位码
	@Column(name = "locationcode", length = 64)
	private String locationCode;

	// 文档类型码
	@Column(name = "doccode", length = 64)
	private String docCode;

	// 编码状态
	@Column(name = "state")
	private int state;

	// 定义编码的版本，实现乐观锁机制，保证编码生成的唯一性
	@Version
	@Column(name = "version")
	private long version;

	@Column(name="code",length=255,nullable=false,unique=true)
	private String code;
	

	// 编码备注
	@Column(name = "note", length = 512)
	private String note;

	@Column(name = "maxseq", nullable = false)
	private int					maxSequence;

	@Column(name = "minseq", nullable = false)
	private int					minSequence;
	
	
	@Column(name="codename",length=128)
	private String codeName;
	
	public TempCode(String rule,String creater,String createrId,String unitCode,String locationCode,String docCode,int state,String code,String note,long createTime,String codeName,int minSequence,int maxSequence){
		this.rule=rule;
		this.creater=creater;
		this.createrId=createrId;
		this.unitCode=unitCode;
		this.locationCode=locationCode;
		this.docCode=docCode;
		this.state=state;
		this.code=code;
		this.note=note;
		this.createTime=createTime;
		this.codeName=codeName;
		this.minSequence=minSequence;
		this.maxSequence=maxSequence;
	}
	
	
	public TempCode() {

	}

	public long getCodeId() {
		return codeId;
	}

	public void setCodeId(long codeId) {
		this.codeId = codeId;
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

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}


	public String getCodeName() {
		return codeName;
	}


	public void setCodeName(String codeName) {
		this.codeName = codeName;
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
