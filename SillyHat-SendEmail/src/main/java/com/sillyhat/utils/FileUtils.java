package com.sillyhat.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	private static Logger logger = Logger.getLogger(FileUtils.class);
	
	public static boolean writeTextFile(String filePathName,String content) {
		RandomAccessFile mm = null;
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(filePathName);
			o.write(content.getBytes("UTF-8"));
			o.close();
			flag = true;
		} catch (Exception e) {
			logger.error("writeTextFile error",e);
		} finally {
			if (mm != null) {
				try {
					mm.close();
				} catch (IOException e) {
					logger.error("close RandomAccessFile error",e);
				}
			}
		}
		return flag;
	}
	
	
	/**
	 * <p>Title: readDirectoryFile</p>
	 * <p>Description: </p>读取目录下的所有文件
	 * @param 
	 * @author 徐士宽
	 * @date 2016-11-13
	 * @return:List<File>
	 */
	public static List<File> readDirectoryFile(File rootFile){
		List<File> list = new ArrayList<File>();
		if (!rootFile.exists()) {//不存在返回null
	        return null;  
	    }else{
	    	// 判断是否为文件  
	        if (rootFile.isFile()) {//是文件直接新增到文件列表
	        	list.add(rootFile);
	        } else {//不是文件，查看目录下的所有文件
	        	File[] tempList = rootFile.listFiles();
	        	for (File file : tempList) {
	        		if (file.isFile()) {
	        			//如果是文件存入文件列表
	        			list.add(file);
	        		}else if(file.isDirectory()){
	        			//如果是目录，继续读取目录下的文件列表
	        			list.addAll(readDirectoryFile(file));
	        		}
				}
	        }
	    }
		return list;
	}
	
	/**
	 * <p>Title: readDirectoryFile</p>
	 * <p>Description: </p>读取目录下的所有文件
	 * @param 
	 * @author 徐士宽
	 * @date 2016-11-13
	 * @return:List<File>
	 */
	public static List<File> readDirectoryFile(String rootPath){
		File rootFile = new File(rootPath);  
		return readDirectoryFile(rootFile);
	}
	
	/**
	 * <p>Title: DeleteFolder</p>
	 * <p>Description: </p>根据路径删除指定的目录或文件，无论存在与否 
	 * @param 	sPath  要删除的目录或文件 
	 * @author 徐士宽
	 * @date 2016-11-12
	 * @return:boolean	删除成功返回 true，否则返回 false。 
	 */
	public static boolean deleteFolder(String sPath) {  
	    File file = new File(sPath);  
	    // 判断目录或文件是否存在  
	    if (!file.exists()) {  // 不存在返回 false  
	        return false;  
	    } else {  
	        // 判断是否为文件  
	        if (file.isFile()) {  // 为文件时调用删除文件方法  
	            return deleteFile(sPath);  
	        } else {  // 为目录时调用删除目录方法  
	            return deleteDirectory(sPath);  
	        }  
	    }  
	}
	
	/**
	 * <p>Title: deleteDirectory</p>
	 * <p>Description: </p>删除目录（文件夹）以及目录下的文件 
	 * @param 	sPath 被删除目录的文件路径 
	 * @author 徐士宽
	 * @date 2016-11-12
	 * @return:boolean	目录删除成功返回true，否则返回false
	 */
	public static boolean deleteDirectory(String sPath) {  
	    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //如果dir对应的文件不存在，或者不是一个目录，则退出  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean flag = true;  
	    //删除文件夹下的所有文件(包括子目录)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //删除子文件  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } //删除子目录  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) return false;  
	    //删除当前目录  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}  
	
	/**
	 * <p>Title: deleteFile</p>
	 * <p>Description: </p>删除单个文件 
	 * @param 	sPath    被删除文件的文件名 
	 * @author 徐士宽
	 * @date 2016-11-12
	 * @return:boolean	单个文件删除成功返回true，否则返回false 
	 */
	public static boolean deleteFile(String sPath) {  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        return file.delete();
	    }else{
	    	return false; 
	    }
	}  
	
	/**
     * <p>Title: makeDir</p>
     * <p>Description: </p>创建目录
     * @param dirPath   目录
     * @author XUSHIKUAN642
     * @date 2016-10-17
     */
    public static void makeDir(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
    
    public static void main(String[] args) {
		List<File> list = readDirectoryFile("F:\\Develop\\workspace\\workspace_sillyhat\\SendEmail\\filelist\\");
		for (File file : list) {
			System.out.println(file.getPath() + "||||||||||||" + file.getName());
		}
	}
}
