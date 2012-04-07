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
import org.wekit.web.db.dao.UnitCodeDao;
import org.wekit.web.db.model.UnitCode;
/**
 * 
 * @author HuangWeili
 *
 */
@Controller("unitCodeServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class UnitCodeServiceController extends BaseController<UnitCode> {
    
	@Autowired
	@Qualifier("unitCodeDao")
	private UnitCodeDao unitCodeDao;
	
	
	/**
	 * 查询机组编码
	 * @param extend 扩展名称 .xml .json
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/unitcode/query.{extend}",method=RequestMethod.GET)
	public String queryUnitCode(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		initParam(request);
		//TODO
		return displayAPIClient(extend, model);
	}
	
	/**
	 * 添加机组码
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/unitcode/add.{extend}",method=RequestMethod.POST)
	public String addUnitCode(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model)
	{
		initParam(request);
		//TODO
		return displayAPIClient(extend, model);
	}
	
	/**
	 * 更新机组码
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/unitcode/update.{extend}",method=RequestMethod.POST)
	public String updateUntiCode(@PathVariable("exntend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		initParam(request);
		//TODO
		return displayAPIClient(extend, model);
	
	}
	
	/**
	 * 删除机组码
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/unitcode/delete.{extend}",method=RequestMethod.POST)
	public String deleteUnitCode(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		initParam(request);
		//TODO
		return displayAPIClient(extend, model);
	
	}
	
	/**
	 * 查找机组码，返回唯一的值
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/unitcode/find.{extend}",method=RequestMethod.GET)
	public String findUntiCode(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		initParam(request);
		//TODO
		return displayAPIClient(extend, model);
	}

	public UnitCodeDao getUnitCodeDao() {
		return unitCodeDao;
	}

	public void setUnitCodeDao(UnitCodeDao unitCodeDao) {
		this.unitCodeDao = unitCodeDao;
	}
	
	
	
}
