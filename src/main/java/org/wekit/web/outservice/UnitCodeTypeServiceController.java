package org.wekit.web.outservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.web.BaseController;
import org.wekit.web.db.model.UnitCodeType;
import org.wekit.web.service.BaseDataService;

@Controller("unitCodeTypeServiceController")
public class UnitCodeTypeServiceController extends BaseController<UnitCodeType> {

	@Autowired
	@Qualifier("baseDataService")
	private BaseDataService baseDataService;

	/**
	 * 查询机组类型
	 * @param extend
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/unitcodetype/query.{extend}",method=RequestMethod.GET)
	public String queryUnitCodeType(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
	  this.initParam(request);
	  
	  return null;
	  
	}
    
    
    
    /**
     * 
     * @param extend
     * @param model
     * @return
     */
    @RequestMapping(value="/unitcodetype/add.{extend}",method=RequestMethod.POST)
    public String addUnitCodeType(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
       return null;
    }
    
    /**
     * 机组类型码更新
     * @param extend
     * @param model
     * @return
     */
    @RequestMapping(value="/unitcodetype/update.{extend}",method=RequestMethod.POST)
    public String updateUnitCodeType(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
    	return null;
    }
    
    /**
     * 机组类型码 详细数据获取
     * @param extend
     * @param model
     * @return
     */
    @RequestMapping(value="/unitcodetype/find.{extend}",method=RequestMethod.GET)
    public String findUnitCodeType(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
    	return null;
    }
    
    @RequestMapping(value="/unticodetype/delete.{extend}",method=RequestMethod.POST)
    public String deleteCodeType(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
    	return null;
    }



	public BaseDataService getBaseDataService() {
		return baseDataService;
	}



	public void setBaseDataService(BaseDataService baseDataService) {
		this.baseDataService = baseDataService;
	}
    
    
	
}
