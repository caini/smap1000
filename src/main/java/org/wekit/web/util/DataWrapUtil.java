package org.wekit.web.util;

import java.io.IOException;
import java.util.List;

import org.wekit.web.imports.CodeWrap;
import org.wekit.web.imports.ExtendCodeWrap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class DataWrapUtil {

	private static ObjectMapper objectMapper=new ObjectMapper();
	
	private static XmlMapper xmlMapper=new XmlMapper();
	
	
	public static String convertObject(Object object,String extend) throws JsonGenerationException, JsonMappingException, IOException{
		if(extend.equalsIgnoreCase("xml")){
			return ObjectToXml(object);
		}
		
		return ObjectToJson(object);
	}
	
	
	/**
	 * 将对象转转换成json文件
	 * @param object
	 * @param model
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public static String ObjectToJson(Object object) throws JsonGenerationException, JsonMappingException, IOException
	{
		return objectMapper.writeValueAsString(object);
	}
	
	/**
	 * 将对像转换成xml文件
	 * @param object
	 * @param model
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public static String ObjectToXml(Object object) throws JsonGenerationException, JsonMappingException, IOException{
		
		return xmlMapper.writeValueAsString(object);
	}
	
	/**
	 * 编码json列表转换
	 * @param json
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static CodeWrap[] jsonToCodeWrapList(String json) throws JsonParseException, JsonMappingException, IOException{
		CodeWrap[] codeWraps=objectMapper.readValue(json,CodeWrap[].class);
		return codeWraps;
	}
	
	/**
	 * 无规则编码json列表转换
	 * @param json
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static ExtendCodeWrap[] jsonToExtendCodeWrapList(String json) throws JsonParseException, JsonMappingException, IOException{
		ExtendCodeWrap[] codeWraps=objectMapper.readValue(json, ExtendCodeWrap[].class);
		return codeWraps;
	}
	
}
