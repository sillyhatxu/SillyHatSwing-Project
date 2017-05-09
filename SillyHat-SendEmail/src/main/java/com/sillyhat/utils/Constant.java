package com.sillyhat.utils;


public class Constant {

	
	public static final String PROJECT_NAME = "Send To Kindle";
	
	public static final String LAYOUT_NORTH = "North";
	public static final String LAYOUT_CENTER = "Center";
	public static final String LAYOUT_SOUTH = "South";
	
	public static final String PROPERTIES_NAME = "send-email.properties";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir") + "\\";
	
	public static final String FILE_PATH = "filelist\\";
	
	
	
	public static final String KEY_USER = "loginUser";
	public static final String KEY_PASSWORD = "password";
	
	public static final String KEY_FROM_ADDRESS = "fromAddress";
	public static final String KEY_TO_ADDRESS = "toAddress";
	
	public static final String KEY_HOST_NAME = "hostName";
	public static final String KEY_SUBJECT = "subject";
	
	public static final String KEY_BODY = "body";
	
	/** 
	 * @Fields KEY_INTERVAL : 邮件发送间隔 
	 */ 
	public static final String KEY_INTERVAL = "sendEmailIntervalSecond";
	
	public static final String BTN_NAME_TEST_EMAIL = "发送测试邮件";
	public static final String BTN_NAME_SEND_EMAIL = "发送";
	public static final String DEFAULT_TEST_ADJUNCT_NAME = "Test.txt";
	public static final String SEND_ERROR = "发送失败";
	public static final String SEND_SUCCESS = "发送成功";
	public static final String BAR_NAME = "正在发送邮件";
	
}
