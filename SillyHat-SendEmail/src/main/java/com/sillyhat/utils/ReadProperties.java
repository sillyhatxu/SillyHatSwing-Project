package com.sillyhat.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	private Logger logger = Logger.getLogger(ReadProperties.class);
	
	private static ReadProperties instance;
	
	private static Properties properties = new Properties();
	
	private ReadProperties(){
		try {
			InputStream is = new FileInputStream(new File(Constant.PROJECT_PATH + Constant.PROPERTIES_NAME));
			properties.load(is);
		} catch (Exception e) {
			logger.error("在加载配置文件发生异常：",e);
		}
	}
	
	public static String getValue(String key){
		if(instance == null){
			instance = new ReadProperties();
		}
		return properties.getProperty(key) != null ? properties.getProperty(key) : "";
	}
	
	/**
	 * <p>Title: main</p>
	 * <p>Description: </p>TODO
	 * @param args
	 * @author XUSHIKUAN642
	 * @date 2016-11-7
	 */
	public static void main(String[] args) {
		System.out.println(ReadProperties.getValue("user"));
		System.out.println(ReadProperties.getValue("sid"));
		System.out.println(ReadProperties.getValue("sid"));
		System.out.println(ReadProperties.getValue("sid"));
		System.out.println(ReadProperties.getValue("sid"));
		System.out.println(ReadProperties.getValue("sid"));
	}
}
