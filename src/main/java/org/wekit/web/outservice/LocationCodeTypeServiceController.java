package org.wekit.web.outservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.web.BaseController;
import org.wekit.web.db.model.LocationCodeType;

@Controller("locationCodeTypeServiceController")
public class LocationCodeTypeServiceController extends BaseController<LocationCodeType> {

	/**
	 * 查询定位吗类型信息
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/locationcodetype/query.{extend}", method = RequestMethod.GET)
	public String queryLocationCodeType(@PathVariable("extend") String extend,HttpServletRequest request,HttpServletResponse response, Model model) {
		return null;
	}
	
	@RequestMapping(value="/locationcodetype/update.{extend}",method=RequestMethod.POST)
	public String updateLocationCodeType(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		return null;
	}
	
	@RequestMapping(value="/locationcodetype/delete.{extend}",method=RequestMethod.POST)
	public String deleteLocationCodeType(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		return null;
	}
	
	@RequestMapping(value="/lcoationcodetype/find.{extend}",method=RequestMethod.GET)
	public String findLocationCodetType(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		return null;
	}
	
	@RequestMapping(value="/locationcodetype/add.{extend}",method=RequestMethod.POST)
	public String addLocationCodeType(@PathVariable("extend")String extend,HttpServletRequest request,HttpServletResponse response,Model model){
		return null;
	}

	
}
