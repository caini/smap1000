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
import org.wekit.web.db.dao.LocationCodeTypeDao;
import org.wekit.web.db.model.LocationCodeType;
import org.wekit.web.service.LocationCodeTypeService;

/**
 * 
 * @author HuangWeili
 * 
 */
@Controller("locationCodeTypeServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class LocationCodeTypeServiceController extends BaseController<LocationCodeType> {

	@Autowired
	@Qualifier("locationCodeTypeService")
	private LocationCodeTypeService	locationCodeTypeService;

	private static Logger			logger	= Logger.getLogger(LocationCodeTypeServiceController.class);

	/**
	 * 查询定位吗类型信息
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/locationcodetype/query.{extend}", method = RequestMethod.GET)
	public String queryLocationCodeType(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if(StringUtils.isEmpty(key)){
				throw new WekitException("key参数的值不能为空!");
			}
			List<LocationCodeType> list=locationCodeTypeService.queryLocationCodeTypes(key, 1, this.pagination);
			setDatas(list);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/locationcodetype/update.{extend}", method = RequestMethod.POST)
	public String updateLocationCodeType(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			//TODO
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/locationcodetype/delete.{extend}", method = RequestMethod.POST)
	public String deleteLocationCodeType(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key)) {
				throw new WekitException("key参数的值不能为空!");
			}
			locationCodeTypeService.deleteLocationType(Long.parseLong(key), creatername, createrid, ip);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/lcoationcodetype/find.{extend}", method = RequestMethod.GET)
	public String findLocationCodetType(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key)) {
				throw new WekitException("key参数的值不能为空!");
			}
			LocationCodeType locationCodeType = locationCodeTypeService.getCodeType(Long.parseLong(key));
			addData(locationCodeType);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

	@RequestMapping(value = "/locationcodetype/add.{extend}", method = RequestMethod.POST)
	public String addLocationCodeType(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			// TODO
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			setState(0);
			setMessage(ex.getMessage());
		}
		return displayAPIClient(extend, model);
	}

}
