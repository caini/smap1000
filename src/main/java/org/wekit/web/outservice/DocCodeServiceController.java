package org.wekit.web.outservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.web.BaseController;
import org.wekit.web.WekitException;
import org.wekit.web.db.model.DocCode;
import org.wekit.web.service.DocCodeService;

/**
 * 
 * @author HuangWeili
 * 
 */
@Controller("docCodeServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class DocCodeServiceController extends BaseController<DocCode> {

	private static Logger	logger	= Logger.getLogger(DocCodeServiceController.class);

	@Autowired
	@Qualifier("docCodeDao")
	private DocCodeService	docCodeService;

	/**
	 * 查询文档类型编码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/query.{extend}", method = RequestMethod.GET)
	public String queryDocCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key))
				throw new WekitException("传入key不能为空");
			docCodeService.queryDocCodes(key, typeId, 1, this.pagination);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			pagination.setState(0);
			pagination.setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	/**
	 * 更新文旦类型编码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/update.{extend}", method = RequestMethod.POST)
	public String updateDocCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			// TODO
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	/**
	 * 添加文件类型编码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/add.{extend}", method = RequestMethod.POST)
	public String addDocCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			// TODO
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	/**
	 * 获取编码详细状态
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/find.{extend}", method = RequestMethod.GET)
	public String findDocCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key)) {
				throw new WekitException("传入的参数key不能为空!");
			}
			DocCode docCode = docCodeService.getDocCode(Long.parseLong(key));
			this.addData(docCode);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			pagination.setState(0);
			pagination.setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	/**
	 * 删除文件类型编码
	 * 
	 * @param extend
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/delete.{extend}", method = RequestMethod.POST)
	public String deleteDocCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key)) {
				throw new WekitException("传入的参数key不能为空");
			}
			docCodeService.deleteDocCodes(Long.parseLong(key), creatername, createrid, ip);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			pagination.setState(0);
			pagination.setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	public DocCodeService getDocCodeService() {
		return docCodeService;
	}

	public void setDocCodeService(DocCodeService docCodeService) {
		this.docCodeService = docCodeService;
	}

}
