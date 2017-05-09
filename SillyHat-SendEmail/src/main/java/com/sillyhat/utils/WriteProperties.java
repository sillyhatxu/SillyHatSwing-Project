package com.sillyhat.utils;

import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class WriteProperties {

	private static Logger logger = Logger.getLogger(WriteProperties.class);
	
	private static WriteProperties instance;
	
	private static Properties properties = new Properties();
	
//	private static OutputStream outputStream = null;
	
	private static ByteArrayOutputStream outputStream = null;
	
	private WriteProperties(){
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream(Constant.PROPERTIES_NAME);
			//加载资源文件
			properties.load(in);
			//初始化流文件
			outputStream = new ByteArrayOutputStream();
	        int ch;
	        while ((ch = in.read()) != -1) {   
	            outputStream.write(ch);
	        }
		} catch (Exception e) {
			logger.error("在加载配置文件发生异常：",e);
		}
	}
	
	public static void updateProperties(String key,String value){
		InputStream in = WriteProperties.class.getClassLoader().getResourceAsStream(Constant.PROPERTIES_NAME);
		OutputStream outputStream = new ByteArrayOutputStream();
		try {
			//加载资源文件
			properties.load(in);
			int ch;
	        while ((ch = in.read()) != -1) {   
	            outputStream.write(ch);
	        }
		    // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
			// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
			properties.setProperty(key, value);
			// 以适合使用 load 方法加载到 Properties 表中的格式，
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			properties.store(outputStream, "Update '" + key + "' value");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("属性文件更新发生异常",e);
		}
//		if(instance == null){
//			instance = new WriteProperties();
//		}
	}
	
	public static void main(String[] args) throws IOException {
		WriteProperties.updateProperties("test", "hahahhaahahah");
		WriteProperties.updateProperties("olalala", "fasdflaskdflasdfsd");
		logger.info(ReadProperties.getValue("test"));
		logger.info(ReadProperties.getValue("olalala"));
//		new FileOutput
//		WriteProperties.setValue("test", "hahahhaahahah");
//		logger.info(WriteProperties.class.getClassLoader().getResourceAsStream(Constant.PROPERTIES_NAME));
////		File file = new File
//		InputStream in = WriteProperties.class.getClassLoader().getResourceAsStream(Constant.PROPERTIES_NAME);
//		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
//        int ch;
//        while ((ch = in.read()) != -1) {   
//            swapStream.write(ch);   
//        }
//        properties.store(swapStream, "Update '" + "" + "' value");
//		logger.info(WriteProperties.class.getClassLoader().getResourceAsStream(Constant.PROPERTIES_NAME));
	}
}
