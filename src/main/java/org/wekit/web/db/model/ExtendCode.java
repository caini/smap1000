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
 * 无规则编码记录实体
 * @author Encore
 *
 */

@XmlRootElement(name="ExtendCode")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="extendcode")
public class ExtendCode implements Serializable{

	private static final long serialVersionUID = -1807017736745114037L;

	@Id
	@GeneratedValue(generator="id_gen",strategy=GenerationType.TABLE)
	@TableGenerator(
			name="id_gen",
			table="sys_id_gen",
			pkColumnName="S_ID",
			valueColumnName="S_NEXTNUM",
			pkColumnValue="extendid",
			allocationSize=100
	)
	private long extendId;
	
	//编码结果
	@Column(name="result",length=128)
	private String result;
	
	//编码创建人
	@Column(name="creater",length=64)
	private String creater;
	
	@Column(name="createrid",length=64)
	private String createrId;
	
	//编码创建时间
	@Column(name="ctime")
	private long createTime;
	
	//无规则编码的备注
	@Column(name="note",length=1024)
	private String note;
	
	//编码申请时的标题
	@Column(name="applytitle",length=512)
	private String applyTitle;
	
	//对应的编码申请
	@Column(name="applyid")
	private long applyId;
	
	//文件类型码
	@Column(name="doccode",length=64)
	private String docCode;

	//机组码
	@Column(name="unitcode",length=64)
	private String unitCode;
	
	//定位码
	@Column(name="locationcode",length=64)
	private String locationCode;
	
	//编码状态
	@Column(name="state")
	private int state;
	
	@Column(name="applyedid",length=64)
	private String applyedId;
	
	@Column(name="applyedname",length=64)
	private String applyedName;
	
	@Column(name="filename",length=512)
	private String fileName;
	
	@Column(name="deptname",length=128)
	private String deptName;
	
	@Column(name="mask",length=128)
	private String mask;
	
	@Column(name="filetype",nullable=true)
	private long fileType;
	
	@Column(name="filetypename",length=128,nullable=true)
	private String fileTypeName;
	
	/**
	 * 全参数匹配构造函数
	 * @param cratername
	 * @param createrid
	 * @param createtime
	 * @param note
	 * @param applyTitle
	 * @param applyid
	 * @param docCode
	 * @param unitCode
	 * @param locationCode
	 * @param state
	 * @param applyedid
	 * @param applyedname
	 * @param result
	 */
	public ExtendCode(String cratername,String createrid,long createtime,String note,String applyTitle,long applyid,String docCode,String unitCode,String locationCode,int state,String applyedid,String applyedname,String result,String filename
			,String deptName,String mask,long fileType,String fileTypeName
			){
		this.createrId=createrid;
		this.creater=cratername;
		this.createTime=createtime;
		this.note=note;
		this.applyTitle=applyTitle;
		this.applyedId=applyedid;
		this.docCode=docCode;
		this.unitCode=unitCode;
		this.locationCode=locationCode;
		this.state=state;
		this.applyId=applyid;
		this.applyedName=applyedname;
		this.result=result;
		this.fileName=filename;
		this.deptName=deptName;
		this.mask=mask;
		this.fileType=fileType;
		this.fileTypeName=fileTypeName;
		
	}
	
	
	public ExtendCode()
	{}

	public long getExtendId() {
		return extendId;
	}

	public void setExtendId(long extendId) {
		this.extendId = extendId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getApplyId() {
		return applyId;
	}

	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getApplyTitle() {
		return applyTitle;
	}

	public void setApplyTitle(String applyTitle) {
		this.applyTitle = applyTitle;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
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

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getApplyedId() {
		return applyedId;
	}

	public void setApplyedId(String applyedId) {
		this.applyedId = applyedId;
	}

	public String getApplyedName() {
		return applyedName;
	}

	public void setApplyedName(String applyedName) {
		this.applyedName = applyedName;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getMask() {
		return mask;
	}


	public void setMask(String mask) {
		this.mask = mask;
	}


	public long getFileType() {
		return fileType;
	}


	public void setFileType(long fileType) {
		this.fileType = fileType;
	}


	public String getFileTypeName() {
		return fileTypeName;
	}


	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}
	
	
}
