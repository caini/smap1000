package org.wekit.web.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.wekit.web.imports.CodeWrap;
import org.wekit.web.util.DataWrapUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class CreaterJson {

	public static void main(String[] rags) throws JsonGenerationException, JsonMappingException, IOException{
		List<CodeWrap> wraps=new ArrayList<CodeWrap>();
		CodeWrap codeWrap=new CodeWrap("SM2-TES-Test-DS12", "caini", "SMx-xxx-xxx-DS[nn]", "caini", "test", "test", "test");
		wraps.add(codeWrap);
		CodeWrap codeWrap2=new CodeWrap("SM2-TES-Test-DS13", "caini", "SMx-xxx-xxx-DS[nn]", "caini", "test", "test", "test");
		wraps.add(codeWrap2);
		
		System.out.println(DataWrapUtil.ObjectToJson(wraps));
	}
}
