package org.wekit.web;

/**
 * 定义接口的运行异常类
 * @author HuangWeili
 *
 */
public class WekitException extends RuntimeException {

	private static final long	serialVersionUID	= 1283080875781305364L;
    
	public WekitException()
	{
		super();
	}
	
	public WekitException(String message){
		super(message);
	}
}
