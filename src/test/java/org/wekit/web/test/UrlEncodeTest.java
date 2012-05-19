package org.wekit.web.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncodeTest {

	public static void main(String[] args){
		try {
			System.out.println(URLEncoder.encode("ruleid=1&unit=SM2&location=TES&doc=Test&createrid=caini&note=test&filename=test&codename=test","UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
