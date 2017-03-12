package com.sillyhat.swing.exception;

import com.sillyhat.swing.constants.SillyHatConstants;
import com.sillyhat.swing.module.container.middle.SillyHatJOptionPane;
import org.apache.log4j.Logger;

public class SillyHatException extends RuntimeException{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = 7705860483268299755L;

	private Logger logger = Logger.getLogger(SillyHatException.class);
	
	private int code;
	
	private String msg;
	
//	public SillyHatException(){
//		super();
//		logger.error("code:" + getLocalizedMessage() + ";message:" + getMessage());
//	}
	
	public SillyHatException(String msg){
		super(msg);
		this.msg = msg;
		logger.error(getMsg());
		SillyHatJOptionPane.alertError(SillyHatConstants.CODE_EXCEPTION_MSG,"code:" + SillyHatConstants.CODE_EXCEPTION + ";message:" + SillyHatConstants.CODE_EXCEPTION_MSG);
    }
	
	public SillyHatException(int code,String msg){
		super(msg);
		this.code = code;
		this.msg = msg;
		logger.error("code:" + getCode() + ";message:" + getMsg());
		SillyHatJOptionPane.alertError("提示","code:" + getCode() + ";message:" + getMsg());
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
	private static void test(String src){
		Integer.parseInt(src);
	}
	
	public static void main(String[] args) {
		try {
			test("34");
			test("asdfs");
		} catch (Exception e) {
			throw new SillyHatException(e.getMessage());
		}
		
//		throw new SillyHatException(50,"初始化组件发生异常");
//		throw new SillyHatException("初始化组件发生异常");
//		throw new SillyHatException();
	}
	
}
