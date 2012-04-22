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
import org.wekit.web.db.model.UnitCode;
import org.wekit.web.service.UnitCodeService;
/**
 * 
 * @author HuangWeili
 *
 */
@Controller("unitCodeServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class UnitCodeServiceController extends BaseController<UnitCode> {
    
	@Autowired
	@Qualifier("unitCodeService")
	private UnitCodeService unitCodeService;
	
	private static Logger logger=Logger.getLogger(UnitCodeServiceController.class);
	
	/**
	 * 查询机组编码
	 * @param extend 扩展名称 .xml .json
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/unitcode/query.{extend}",method=RequestMethod.GET)
	public String queryUnitCode(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		try{
		initParam(request);
		if(StringUtils.isEmpty(key)){
			throw new WekitException("key参数的值不能为空!");
		}
		List<UnitCode> list=this.unitCodeService.queryUnitCodes(key, typeId, 1, this.pagination);
		setDatas(list);
		}catch (Exception e) {
			logger.error(e.getMessage());
			setState(0);
			setMessage(e.getMessage());
		}
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
		try{
			initParam(request);
			//TODO
		}catch (Exception e) {
			logger.error(e.getMessage());
			setState(0);
			setMessage(e.getMessage());
		}
		
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
		try{
		initParam(request);
		//TODO
		}catch (Exception e) {
			logger.error(e.getMessage());
			setState(0);
			setMessage(e.getMessage());
		}
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
		try{
			initParam(request);
			if(StringUtils.isEmpty(key)){
				throw new WekitException("key参数的值不能为空");
			}
			this.unitCodeService.deleteUnitCode(Long.parseLong(key),creatername, createrid, ip);
		}catch(Exception ex){
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		
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
		try{
		initParam(request);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return displayAPIClient(extend, model);
	}

	public UnitCodeService getUnitCodeService() {
		return unitCodeService;
	}

	public void setUnitCodeService(UnitCodeService unitCodeService) {
		this.unitCodeService = unitCodeService;
	}

	
}
