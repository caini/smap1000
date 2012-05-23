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
import org.wekit.web.imports.CodeWrap;
import org.wekit.web.service.CodeService;

@Controller("codeImportServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class CodeImportServiceController  extends BaseController<CodeWrap>{
	
	private Logger logger=Logger.getLogger(CodeImportServiceController.class);
	@Autowired
	@Qualifier("codeService")
	private CodeService codeService;
	
	@RequestMapping(value="/code/import.{extend}")
	public String importcode(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		String cid=request.getParameter("cid");
		try {
			initParam(request,"有规则编码导入");
			CodeWrap[] wraps=codeService.importCodes(this.json);
			this.setDatas(Arrays.asList(wraps));
		} catch (Exception ex) {
			logger.error(ex);
			pagination.setState(0);
			pagination.setMessage(ex.getMessage());
			addRemoteLog(cid+"导入有规则编码时发生错误："+ex.getMessage(),"有规则编码导入");
		}
		addRemoteLog(cid+"导入有规则编码成功!", "有规则编码导入");
		return displayAPIClient(extend, model);
	}

}
