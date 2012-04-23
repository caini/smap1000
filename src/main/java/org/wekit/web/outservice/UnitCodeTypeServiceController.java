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
import org.wekit.web.db.dao.UnitCodeTypeDao;
import org.wekit.web.db.model.UnitCodeType;

/**
 * 
 * @author HuangWeili
 * 
 */
@Controller("unitCodeTypeServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class UnitCodeTypeServiceController extends BaseController<UnitCodeType> {

	@Autowired
	@Qualifier("unitCodeTypeDao")
	private UnitCodeTypeDao	unitCodeTypeDao;

	private final static Logger logger=Logger.getLogger(UnitCodeTypeServiceController.class);
	
	/**
	 * 查询机组类型
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/unitcodetype/query.{extend}", method = RequestMethod.GET)
	public String queryUnitCodeType(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if(StringUtils.isEmpty(this.key)){
				throw new WekitException("参数key不能为空!");
			}
			//TODO
	
		} catch (Exception e) {
			logger.error(e.getMessage());
			setState(0);
			setMessage(e.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	/**
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/unitcodetype/add.{extend}", method = RequestMethod.POST)
	public String addUnitCodeType(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			//TODO
		} catch (Exception e) {
			logger.error(e.getMessage());
			setState(0);
			setMessage(e.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	/**
	 * 机组类型码更新
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/unitcodetype/update.{extend}", method = RequestMethod.POST)
	public String updateUnitCodeType(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
		
			// TODO: handle exception
		} catch (Exception e) {
			logger.error(e.getMessage());
			setState(0);
			setMessage(e.getMessage());
		}

		return displayAPIClient(extend, model);
	}

	/**
	 * 机组类型码 详细数据获取
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/unitcodetype/find.{extend}", method = RequestMethod.GET)
	public String findUnitCodeType(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if(StringUtils.isEmpty(this.key)){
				throw new WekitException("参数key不能为空!");
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			setState(0);
			setMessage(e.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	/**
	 * 
	 * @param extend
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/unticodetype/delete.{extend}", method = RequestMethod.POST)
	public String deleteCodeType(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try{
		initParam(request);
		if(StringUtils.isEmpty(this.key)){
			throw new WekitException("参数key不能为空!");
		//TODO
		}
		}catch (Exception e) {
			logger.error(e.getMessage());
			setState(0);
			setMessage(e.getMessage());
		}
	
		return displayAPIClient(extend, model);

	}

	public UnitCodeTypeDao getUnitCodeTypeDao() {
		return unitCodeTypeDao;
	}

	public void setUnitCodeTypeDao(UnitCodeTypeDao unitCodeTypeDao) {
		this.unitCodeTypeDao = unitCodeTypeDao;
	}

}
