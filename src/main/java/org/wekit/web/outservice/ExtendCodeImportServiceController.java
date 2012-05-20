package org.wekit.web.outservice;

import java.util.Arrays;

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
import org.wekit.web.imports.ExtendCodeWrap;
import org.wekit.web.service.ExtendCodeService;

@Controller("extendCodeImportServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class ExtendCodeImportServiceController extends BaseController<ExtendCodeWrap> {
	
	private static Logger logger=Logger.getLogger(ExtendCodeImportServiceController.class);
	
	@Autowired
	@Qualifier("extendCodeService")
	private ExtendCodeService extendCodeService;
	
	@RequestMapping(value="/extendcode/import.{extend}")
	public String importcode(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		
		try{
			initParam(request,"导入无规则编码");
			ExtendCodeWrap[] extendCodeWraps=extendCodeService.importCodes(this.json);
			this.setDatas(Arrays.asList(extendCodeWraps));
			}catch(Exception ex){
				logger.error(ex.getMessage());
				setState(0);
				setMessage(ex.getMessage());
			}
			return displayAPIClient(extend, model);
	}

}
