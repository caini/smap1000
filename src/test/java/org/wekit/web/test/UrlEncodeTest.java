package org.wekit.web.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncodeTest {

	public static void main(String[] args){
		try {
			System.out.println(URLEncoder.encode("unit=SM1&codename=&location=GV5&doc=GSR&filename=状态报告1&createrid=gexc&ruleid=1335174996109&note=备注2","UTF-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
