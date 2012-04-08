package org.wekit.web.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.WekitException;
import org.wekit.web.db.dao.DocCodeTypeDao;
import org.wekit.web.db.model.DocCodeType;
import org.wekit.web.service.DocCodeTypeService;
import org.wekit.web.util.DataWrapUtil;

/**
 * 
 * @author HuangWeili
 * 
 */
@Service("docCodeTypeService")
public class DocCodeTypeServiceImpl implements DocCodeTypeService {

	private static Logger logger=Logger.getLogger(DocCodeTypeServiceImpl.class);
	
	@Autowired
	@Qualifier("docCodeTypeDao")
	private DocCodeTypeDao	docCodeTypeDao;

	public DocCodeTypeDao getDocCodeTypeDao() {
		return docCodeTypeDao;
	}

	public void setDocCodeTypeDao(DocCodeTypeDao docCodeTypeDao) {
		this.docCodeTypeDao = docCodeTypeDao;
	}

	@Transactional(readOnly=true)
	@Override
	public DocCodeType getDocCodeType(long id) {
		if (id < 1)
			return null;
		else
			return this.docCodeTypeDao.getDocCodeType(id);
	}

	@Transactional(readOnly=true)
	@Override
	public DocCodeType getDocCodeType(String code) {
		if (StringUtils.isNotEmpty(code)) {
			return this.docCodeTypeDao.getDocCodeType(code);
		}
		return null;
	}

	@Transactional(readOnly=true)
	@Override
	public List<DocCodeType> getAllDocCodeTypes() {
		return this.docCodeTypeDao.getAllDocCodeTypes();
	}

	@Transactional(readOnly=true)
	@Override
	public List<DocCodeType> queryDocCodeTypes(IPaginable paginable) {
		if (paginable == null)
			return this.docCodeTypeDao.getAllDocCodeTypes();
		return this.docCodeTypeDao.getDocCodeTypesWithPagination(paginable);
	}

	@Transactional(readOnly=true)
	@Override
	public List<DocCodeType> queryDocCodeTypes(String key, int state, IPaginable paginable) {
		return this.docCodeTypeDao.queryDocCodeTypes(key, state, paginable);
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	/**
	 * 根据主键删除文档编码的分类信息
	 * @param key
	 * @param creatername
	 * @param createrId
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public boolean deleteDocCodeTypes(Long key,String creatername,String createrId,String ip)throws Exception{
		DocCodeType codeType=docCodeTypeDao.getDocCodeType(key);
		if(codeType!=null){
			if(docCodeTypeDao.deleteDocCodeType(codeType)){
				logger.info(creatername+"("+createrId+"-- ip:"+ip+") 删除文件类型编码的类型:"+DataWrapUtil.ObjectToJson(codeType));
			}else
			{
				throw new WekitException("删除文档编码的类型失败!");
			}
		}
		return true;
	}
}
