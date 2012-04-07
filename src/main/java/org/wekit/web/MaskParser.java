package org.wekit.web;

import java.util.Map;

public class MaskParser {

	private int count;
	
	private Map<String,Integer> param;
	
	private String mask;

	
	public MaskParser(Map<String, Integer> param,String mask,int count){
		this.count=count;
		this.param=param;
		this.mask=mask;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Map<String, Integer> getParam() {
		return param;
	}

	public void setParam(Map<String, Integer> param) {
		this.param = param;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}
	
	
}
