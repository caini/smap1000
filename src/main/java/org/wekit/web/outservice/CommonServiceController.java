package org.wekit.web.outservice;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.jasypt.util.text.BasicTextEncryptor;
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
	@RequestMapping(value = "/base64")
	public String base64(HttpServletRequest request, HttpServletResponse response, Model model) {
		String param = request.getParameter("p");
		try {
			if (StringUtils.isEmpty(param))
				model.addAttribute("content", "");
			else {
				param = URLDecoder.decode(param, "UTF-8");
				model.addAttribute("content", Base64.encodeBase64URLSafeString(param.getBytes()));
			}
		} catch (UnsupportedEncodingException e) {
			model.addAttribute("content", 0);
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
	@RequestMapping(value = "/encode")
	public String encode(HttpServletRequest request, HttpServletResponse response, Model model) {

		try {
			String input =URLDecoder.decode(request.getParameter("k"),"UTF-8");
			String passowrd =URLDecoder.decode(request.getParameter("p"),"UTF-8");
			if (StringUtils.isEmpty(input) || StringUtils.isEmpty(passowrd)) {
				model.addAttribute("content", "");
			} else {
				model.addAttribute("content", RC4CipherEntity.code(input, passowrd));
			}
		} catch (Exception e) {
			model.addAttribute("content", 0);
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
	@RequestMapping(value = "/encodeBase64")
	public String encodeBase64(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			String input =URLDecoder.decode(request.getParameter("k"),"UTF-8")+"&t="+System.currentTimeMillis();
			String passowrd =URLDecoder.decode(request.getParameter("p"),"UTF-8");
			if (StringUtils.isEmpty(input) || StringUtils.isEmpty(passowrd)) {
				model.addAttribute("content", "");
			} else {
				BasicTextEncryptor strongTextEncryptor=new BasicTextEncryptor();
				strongTextEncryptor.setPassword(passowrd);
				model.addAttribute("content",strongTextEncryptor.encrypt(input));
			}
		} catch (Exception e) {
			model.addAttribute("content", e.getMessage());
		}
		return "ftl/json";
	}

}
