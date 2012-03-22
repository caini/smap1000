package org.wekit.web.outservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("unitCodeServiceController")
public class UnitCodeServiceController {
    
	/**
	 * 查询机组编码
	 * @param extend 扩展名称 .xml .json
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/unitcode/query.{extend}",method=RequestMethod.GET)
	public String queryUnitCode(@PathVariable("extend")String extend,Model model){
		return null;
	}
	
	/**
	 * 添加机组码
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/unitcode/add.{extend}",method=RequestMethod.POST)
	public String addUnitCode(@PathVariable("extend")String extend,Model model)
	{
	   return null;	
	}
	
	/**
	 * 更新机组码
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/unitcode/update.{extend}",method=RequestMethod.POST)
	public String updateUntiCode(@PathVariable("exntend")String extend,Model model){
		return null;
	}
	
	/**
	 * 删除机组码
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/unitcode/delete.{extend}",method=RequestMethod.POST)
	public String deleteUnitCode(@PathVariable("extend")String extend,Model model){
		return null;
	}
	
	/**
	 * 查找机组码，返回唯一的值
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/unitcode/find.{extend}",method=RequestMethod.GET)
	public String findUntiCode(@PathVariable("extend")String extend,Model model){
		return null;
	}
	
	
	
	/**
	 * 查询机组类型
	 * @param extend
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/unitcodetype/query.{extend}",method=RequestMethod.GET)
	public String queryUnitCodeType(@PathVariable("extend")String extend,Model model){
	   return null;
	}
    
    
    
    /**
     * 
     * @param extend
     * @param model
     * @return
     */
    @RequestMapping(value="/unitcodetype/add.{extend}",method=RequestMethod.POST)
    public String addUnitCodeType(@PathVariable("extend")String extend,Model model){
       return null;
    }
    
    /**
     * 机组类型码更新
     * @param extend
     * @param model
     * @return
     */
    @RequestMapping(value="/unitcodetype/update.{extend}",method=RequestMethod.POST)
    public String updateUnitCodeType(@PathVariable("extend")String extend,Model model){
    	return null;
    }
    
    /**
     * 机组类型码 详细数据获取
     * @param extend
     * @param model
     * @return
     */
    @RequestMapping(value="/unitcodetype/find.{extend}",method=RequestMethod.GET)
    public String findUnitCodeType(@PathVariable("extend")String extend,Model model){
    	return null;
    }
    
    @RequestMapping(value="/unticodetype/delete.{extend}",method=RequestMethod.POST)
    public String deleteCodeType(@PathVariable("extend")String extend,Model model){
    	return null;
    }
}
