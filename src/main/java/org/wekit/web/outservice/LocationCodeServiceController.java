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
import org.wekit.web.db.model.LocationCode;
import org.wekit.web.service.LocationCodeService;

/**
 * 
 * @author HuangWeili
 * 
 */
@Controller("locationCodeServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class LocationCodeServiceController extends BaseController<LocationCode> {
	@Autowired
	@Qualifier("locationCodeService")
	private LocationCodeService	locationCodeService;

	private static Logger		logger	= Logger.getLogger(LocationCodeServiceController.class);

	/**
	 * 查询定位码信息
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/locationcode/query.{extend}", method = RequestMethod.GET)
	public String queryLocationCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key)) {
				throw new WekitException("key的参数值不能为空!");
			}
			List<LocationCode> locationCodes = this.locationCodeService.queryLocationCodes(key, typeId, 1, this.pagination);
			setDatas(locationCodes);
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
	@RequestMapping(value = "/locationcode/update.{extend}", method = RequestMethod.POST)
	public String updateLocationCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
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
	 * 
	 * @param extend
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/locationcode/delete.{extend}", method = RequestMethod.POST)
	public String deleteLocationCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key)) {
				throw new WekitException("key的参数值不能为空!");
			}
			this.locationCodeService.deleteLocationCode(Long.parseLong(key), creatername, createrid, ip);
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
	@RequestMapping(value = "/localtioncode/find.{extend}", method = RequestMethod.GET)
	public String findLocationCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			initParam(request);
			if (StringUtils.isEmpty(key)) {
				throw new WekitException("key的参数值不能为空!");
			}
			LocationCode locationCode=locationCodeService.getLocationCode(Long.parseLong(key));
			this.addData(locationCode);
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
	@RequestMapping(value = "/locationcode/add.{extend}", method = RequestMethod.POST)
	public String addLocaitonCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
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

	public LocationCodeService getLocationCodeService() {
		return locationCodeService;
	}

	public void setLocationCodeService(LocationCodeService locationCodeService) {
		this.locationCodeService = locationCodeService;
	}

}
