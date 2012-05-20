package org.wekit.web.outservice;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@Autowired
	@Qualifier("codeService")
	private CodeService codeService;
	
	@RequestMapping(value="/code/import.{extend}")
	public String importcode(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			initParam(request,"导入规则编码");
			CodeWrap[] wraps=codeService.importCodes(this.json);
			this.setDatas(Arrays.asList(wraps));
		} catch (Exception ex) {
			pagination.setState(0);
			pagination.setMessage(ex.getMessage());
		}
		
		return displayAPIClient(extend, model);
	}

}
