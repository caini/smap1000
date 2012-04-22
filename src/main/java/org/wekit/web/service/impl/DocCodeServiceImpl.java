package org.wekit.web.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wekit.web.IPaginable;
import org.wekit.web.WekitException;
import org.wekit.web.db.dao.DocCodeDao;
import org.wekit.web.db.model.DocCode;
import org.wekit.web.service.DocCodeService;
import org.wekit.web.util.DataWrapUtil;

/**
 * 
 * @author HuangWeili
 * 
 */
@Service("docCodeService")
public class DocCodeServiceImpl implements DocCodeService {

	private static Logger logger=Logger.getLogger(DocCodeServiceImpl.class);
	
	
	@Autowired
	@Qualifier("docCodeDao")
	private DocCodeDao	docCodeDao;

	public DocCodeDao getDocCodeDao() {
		return docCodeDao;
	}

	public void setDocCodeDao(DocCodeDao docCodeDao) {
		this.docCodeDao = docCodeDao;
	}

	@Transactional(readOnly = true)
	@Override
	public DocCode getDocCode(long id) {
		return this.docCodeDao.getDocCode(id);
	}

	@Transactional(readOnly = true)
	@Override
	public DocCode getDocCode(String code) {
		return this.docCodeDao.getDocCode(code);
	}

	@Transactional(readOnly = true)
	@Override
	public List<DocCode> getAllDocCodes() {
		return this.docCodeDao.getAllDocCodes();
	}

	@Transactional(readOnly = true)
	@Override
	public List<DocCode> queryDocCodes(IPaginable paginable) {
		if (paginable == null)
			return this.docCodeDao.getAllDocCodes();
		else
			return this.docCodeDao.getDocCodesWithPagination(paginable);
	}

	@Transactional(readOnly = true)
	@Override
	public List<DocCode> queryDocCodes(String key, long typeId, int state, IPaginable paginable) {
		return this.docCodeDao.queryDocCodes(key, typeId, state, paginable);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean deleteDocCodes(long doccodeId, String creatername, String createrId, String ip)throws Exception {
		DocCode docCode = docCodeDao.getDocCode(doccodeId);
		if (docCode != null) {
			if (docCodeDao.deleteDocCode(docCode)) {
				logger.info(creatername+"("+createrId+"-- ip:"+ip+") 删除文件类型编码:"+DataWrapUtil.ObjectToJson(docCode));
			} else {
				throw new WekitException("删除文档类型编码失败!");
			}
		}
		return true;
	}

	@Override
	public DocCode saveDocCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocCode updateDocCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
