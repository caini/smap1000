package org.wekit.web.outservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.web.BaseController;

@Controller("docCodeServiceController")
public class DocCodeServiceController extends BaseController {

	/**
	 * 查询文档类型编码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/query.{extend}", method = RequestMethod.GET)
	public String queryDocCode(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	/**
	 * 更新文旦类型编码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/update.{extend}", method = RequestMethod.POST)
	public String updateDocCode(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	/**
	 * 添加文件类型编码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/add.{extend}", method = RequestMethod.POST)
	public String addDocCode(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	/**
	 * 获取编码详细状态
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccode/find.{extend}", method = RequestMethod.GET)
	public String findDocCode(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	@RequestMapping(value = "/doccode/delete.{extend}", method = RequestMethod.POST)
	public String deleteDocCode(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	/**
	 * 查询文档类型的类型码
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doccodetype/query.{extend}", method = RequestMethod.GET)
	public String queryDocType(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	@RequestMapping(value = "/doccodetype/add.{extend}", method = RequestMethod.POST)
	public String addDocType(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	@RequestMapping(value = "/doccodetype/update.{extend}", method = RequestMethod.POST)
	public String updateDocType(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	@RequestMapping(value = "/doccodetype/delete.{extend}", method = RequestMethod.POST)
	public String deleteDocType(@PathVariable("extend") String extend, Model model) {
		return null;
	}

	@RequestMapping(value = "/doccodetype/find.{extend}", method = RequestMethod.GET)
	public String findDocType(@PathVariable("extend") String extend, Model model) {
		return null;
	}
}
