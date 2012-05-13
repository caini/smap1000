package org.wekit.web.outservice;

import java.util.List;

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
import org.wekit.web.db.model.DocCodeType;
import org.wekit.web.service.DocCodeTypeService;
/**
 * 
 * @author HuangWeili
 *
 */
@Controller("docCodeTypeServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class DocCodeTypeServiceController extends BaseController<DocCodeType> {

	private static Logger logger=Logger.getLogger(DocCodeTypeServiceController.class);
	
	@Autowired
	@Qualifier("docCodeTypeService")
	private DocCodeTypeService  docCodeTypeService;
	
	/**
	 * 查询文档类型的类型码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccodetype/query.{extend}", method = RequestMethod.GET)
	public String queryDocType(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		try{
		initParam(request,"查询文件编码类型");
		if(StringUtils.isEmpty(key)){
			throw new WekitException("key的值不能为空!");
		}
		List<DocCodeType> docCodeTypes=this.docCodeTypeService.queryDocCodeTypes(key, 1,this.pagination);
		setDatas(docCodeTypes);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/doccodetype/add.{extend}", method = RequestMethod.POST)
	public String addDocType(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		try{
			initParam(request,"添加文件编码类型");
			//TODO
			}catch(Exception ex){
				logger.error(ex.getMessage());
				setState(0);
				setMessage(ex.getMessage());
			}
			return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/doccodetype/update.{extend}", method = RequestMethod.POST)
	public String updateDocType(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		try{
			initParam(request,"更新文件编码类型");
			//TODO
			}catch(Exception ex){
				logger.error(ex.getMessage());
				setState(0);
				setMessage(ex.getMessage());
			}
			return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/doccodetype/delete.{extend}", method = RequestMethod.POST)
	public String deleteDocType(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		try{
			initParam(request,"删除文件编码类型");
			if(StringUtils.isEmpty(key)){
				throw new WekitException("key参数的值不能为空!");
			}
			this.docCodeTypeService.deleteDocCodeTypes(Long.parseLong(key), creatername, this.createrid, ip);
			}catch(Exception ex){
				logger.error(ex.getMessage());
				setState(0);
				setMessage(ex.getMessage());
			}
			return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/doccodetype/find.{extend}", method = RequestMethod.GET)
	public String findDocType(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		try{
			initParam(request,"查询文件编码类型");
			if(StringUtils.isEmpty(key)){
				throw new WekitException("key参数的值不能为空!");
			}
			DocCodeType docCodeType=this.docCodeTypeService.getDocCodeType(Long.parseLong(key));
			addData(docCodeType);
			}catch(Exception ex){
				logger.error(ex.getMessage());
				setState(0);
				setMessage(ex.getMessage());
			}
			return displayAPIClient(extend, model);
	}

	public DocCodeTypeService getDocCodeTypeService() {
		return docCodeTypeService;
	}

	public void setDocCodeTypeService(DocCodeTypeService docCodeTypeService) {
		this.docCodeTypeService = docCodeTypeService;
	}


	
	
}
