package org.wekit.web.outservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.web.BaseController;
@Controller("locationCodeServiceController")
public class LocationCodeServiceController extends BaseController{

	/**
	 * 查询定位码信息
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/locationcode/query.{extend}", method = RequestMethod.GET)
	public String queryLocationCode(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	@RequestMapping(value = "/locationcode/update.{extend}", method = RequestMethod.POST)
	public String updateLocationCode(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	@RequestMapping(value = "/locationcode/delete.{extend}", method = RequestMethod.POST)
	public String deleteLocationCode(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	@RequestMapping(value = "/localtioncode/find.{extend}", method = RequestMethod.GET)
	public String findLocationCode(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	@RequestMapping(value = "/locationcode/add.{extend}", method = RequestMethod.POST)
	public String addLocaitonCode(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	/**
	 * 查询定位吗类型信息
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/locationcodetype/query.{extend}", method = RequestMethod.GET)
	public String queryLocationCodeType(@PathVariable("extend") String extend, Model model) {
		return null;
	}
	
	@RequestMapping(value="/locationcodetype/update.{extend}",method=RequestMethod.POST)
	public String updateLocationCodeType(@PathVariable("extend")String extend,Model model){
		return null;
	}
	
	@RequestMapping(value="/locationcodetype/delete.{extend}",method=RequestMethod.POST)
	public String deleteLocationCodeType(@PathVariable("extend")String extend,Model model){
		return null;
	}
	
	@RequestMapping(value="/lcoationcodetype/find.{extend}",method=RequestMethod.GET)
	public String findLocationCodetType(@PathVariable("extend")String extend,Model model){
		return null;
	}
	
	@RequestMapping(value="/locationcodetype/add.{extend}",method=RequestMethod.POST)
	public String addLocationCodeType(@PathVariable("extend")String extend,Model model){
		return null;
	}

}
