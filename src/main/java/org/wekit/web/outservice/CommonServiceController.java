package org.wekit.web.outservice;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wekit.security.RC4CipherEntity;

@Controller("commonServiceController")
public class CommonServiceController {

	/**
	 * 进行base64编码处理
	 * 
	 * @param extend
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/base64", method = RequestMethod.GET)
	public String base64(HttpServletRequest request, HttpServletResponse response, Model model) {
		String param = request.getParameter("p");
		if (StringUtils.isEmpty(param))
			model.addAttribute("content", "");
		else {
			model.addAttribute("content", Base64.encodeBase64URLSafeString(param.getBytes()));
		}
		return "ftl/json";
	}

	/**
	 * 对字符串进行编码
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/encode", method = RequestMethod.GET)
	public String encode(HttpServletRequest request, HttpServletResponse response, Model model) {

		try {
			String input = request.getParameter("k");
			String passowrd = request.getParameter("p");
			if (StringUtils.isEmpty(input) || StringUtils.isEmpty(passowrd)) {
				model.addAttribute("content", "");
			} else {
				model.addAttribute("content", RC4CipherEntity.code(input, passowrd));
			}
		} catch (Exception e) {
			model.addAttribute("content", e.getMessage());
		}
		return "ftl/json";
	}

	/**
	 * 对字符串进行加密后并base64编码
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/encodeBase64", method = RequestMethod.GET)
	public String encodeBase64(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			String input = request.getParameter("k");
			String passowrd = request.getParameter("p");
			if (StringUtils.isEmpty(input) || StringUtils.isEmpty(passowrd)) {
				model.addAttribute("content", "");
			} else {
				String temp = RC4CipherEntity.code(input, passowrd);
				model.addAttribute("content",Base64.encodeBase64URLSafeString(input.getBytes()));
			}
		} catch (Exception e) {
			model.addAttribute("content", e.getMessage());
		}
		return "ftl/json";
	}

}
