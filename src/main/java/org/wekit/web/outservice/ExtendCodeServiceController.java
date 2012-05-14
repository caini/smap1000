package org.wekit.web.outservice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wekit.web.BaseController;
import org.wekit.web.db.model.ExtendCode;
import org.wekit.web.service.ExtendCodeService;

/**
 * 无规则编码获取
 * @author HuangWeili
 *
 */
@Controller("extendCodeServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class ExtendCodeServiceController  extends BaseController<ExtendCode>{

	private final static Logger logger=Logger.getLogger(ExtendCodeServiceController.class);
	
	@Autowired
	@Qualifier("extendCodeService")
	private ExtendCodeService extendCodeService;
	
	/**
	 * 更新无规则编码接口
	 * @param extend
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/extendcode/update.{extend}")
	public String updateCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try{
		initParam(request,"更新无规则编码");
		//TODO
		}catch(Exception ex){
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}
	
	
	@RequestMapping(value="/extendcode/fetch.{extend}")
	public String fetch(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		
		try{
			initParam(request,"获取无规则编码");
			ExtendCode code= extendCodeService.addExtendCode(this.createrid, this.note, this.applyId, this.applyTitle,this.docCode, this.unitCode, this.locationCode, 1, this.code,this.filename, this.mask,this.typeId);
			List<ExtendCode> codes=new ArrayList<ExtendCode>();
			codes.add(code);
			this.setDatas(codes);
			this.setMessage("添加无规则编码成功");
			}catch(Exception ex){
				logger.error(ex.getMessage());
				setState(0);
				setMessage(ex.getMessage());
			}
			return displayAPIClient(extend, model);
		
	}
	
	@RequestMapping(value="/extendcode/import.{extend}")
	public String importcode(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		
		try{
			initParam(request,"导入无规则编码");
			//TODO
			
			}catch(Exception ex){
				logger.error(ex.getMessage());
				setState(0);
				setMessage(ex.getMessage());
			}
			return displayAPIClient(extend, model);
	}

	@RequestMapping(value="/extendcode/delete.{extend}")
	public String deletecode(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		
		try{
			initParam(request,"删除无规则编码");
			//TODO
			
			}catch(Exception ex){
				logger.error(ex.getMessage());
				setState(0);
				setMessage(ex.getMessage());
			}
			return displayAPIClient(extend, model);
	}
	

	public ExtendCodeService getExtendCodeService() {
		return extendCodeService;
	}

	public void setExtendCodeService(ExtendCodeService extendCodeService) {
		this.extendCodeService = extendCodeService;
	}

	
}
