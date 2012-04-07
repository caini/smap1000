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
import org.wekit.web.db.dao.LocationCodeDao;
import org.wekit.web.db.model.LocationCode;

/**
 * 
 * @author HuangWeili
 * 
 */
@Controller("locationCodeServiceController")
@Scope(org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
public class LocationCodeServiceController extends BaseController<LocationCode> {
	@Autowired
	@Qualifier("locationCodeDao")
	private LocationCodeDao	locationCodeDao;

	/**
	 * 查询定位码信息
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/locationcode/query.{extend}", method = RequestMethod.GET)
	public String queryLocationCode(@PathVariable("extend") String extend, HttpServletRequest request, HttpServletResponse response, Model model) {
		initParam(request);
		// TODO
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
		initParam(request);
		// TODO
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
		initParam(request);
		// TODO

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
		initParam(request);

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
		initParam(request);

		return displayAPIClient(extend, model);
	}

	public LocationCodeDao getLocationCodeDao() {
		return locationCodeDao;
	}

	public void setLocationCodeDao(LocationCodeDao locationCodeDao) {
		this.locationCodeDao = locationCodeDao;
	}

}
