package org.wekit.web.outservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.web.BaseController;
import org.wekit.web.db.dao.DocCodeTypeDao;
import org.wekit.web.db.model.DocCodeType;
/**
 * 
 * @author HuangWeili
 *
 */
@Controller("docCodeTypeServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class DocCodeTypeServiceController extends BaseController<DocCodeType> {

	@Autowired
	@Qualifier("docCodeTypeDao")
	private DocCodeTypeDao docCodeTypeDao;
	
	/**
	 * 查询文档类型的类型码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccodetype/query.{extend}", method = RequestMethod.GET)
	public String queryDocType(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		initParam(request);
		//TODO
		return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/doccodetype/add.{extend}", method = RequestMethod.POST)
	public String addDocType(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		initParam(request);
		//TODO
		return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/doccodetype/update.{extend}", method = RequestMethod.POST)
	public String updateDocType(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		initParam(request);
		//TODO
		return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/doccodetype/delete.{extend}", method = RequestMethod.POST)
	public String deleteDocType(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		initParam(request);
		//TODO
		return displayAPIClient(extend, model);
	
	}

	@RequestMapping(value = "/doccodetype/find.{extend}", method = RequestMethod.GET)
	public String findDocType(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		initParam(request);
		//TODO
		return displayAPIClient(extend, model);
	}

	public DocCodeTypeDao getDocCodeTypeDao() {
		return docCodeTypeDao;
	}

	public void setDocCodeTypeDao(DocCodeTypeDao docCodeTypeDao) {
		this.docCodeTypeDao = docCodeTypeDao;
	}
	
	
	
}
