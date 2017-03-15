package com.sillyhat.swing.module.container.middle;

import javax.swing.*;
import java.awt.*;

/** 
 * @ClassName: SillyHatJOptionPane 
 * @Description: 弹出消息提示框
 * @author XUSHIKUAN642
 * @date 2016-11-17 下午2:23:08  
 */ 
public class SillyHatJOptionPane extends JOptionPane{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = 2928559892169791961L;
	
	/**
	 * <p>Title: alert</p>
	 * <p>Description: </p>信息对话框
	 * @param title
	 * @param body
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static void alert(String title,String body){
		JOptionPane.showMessageDialog(null, body, title,JOptionPane.INFORMATION_MESSAGE);  
	}

	/**
	 * <p>Title: alertWarning</p>
	 * <p>Description: </p>警告对话框
	 * @param title
	 * @param body
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static void alertWarning(String title,String body){
		JOptionPane.showMessageDialog(null, body, title,JOptionPane.WARNING_MESSAGE); 
	}
	
	/**
	 * <p>Title: alertError</p>
	 * <p>Description: </p>异常对话框
	 * @param title		提示框标题
	 * @param body		提示框内容
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static void alertError(String title,String body){
		JOptionPane.showMessageDialog(null, body, title,JOptionPane.ERROR_MESSAGE); 
	}
	
	/**
	 * <p>Title: alertPlain</p>
	 * <p>Description: </p>简单对话框
	 * @param title
	 * @param body
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static void alertPlain(String title,String body){
		JOptionPane.showMessageDialog(null, body, title,JOptionPane.PLAIN_MESSAGE); 
	}
	
	/**
	 * <p>Title: confirm</p>
	 * <p>Description: </p>确认对话框
	 * @param title
	 * @param body
	 * @return
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static int confirm(String title,String body){
		return JOptionPane.showConfirmDialog(null, body, title, JOptionPane.YES_NO_OPTION);
	}
	
	public static int confirmAndCancel(Container container,Object[] options,String title,String body){
		int n = JOptionPane.showOptionDialog(container,body,title,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
		System.out.println(n);
		return n;
	}
	
	public static void main(String[] args) {
		alert("test", "异常");
		alertWarning("test", "异常");
		alertError("test", "异常");
		alertPlain("test", "异常");
		confirm("提示", "异常");
		Object[] options = {"Yes, please","No, thanks","No eggs, no ham!"};
		confirmAndCancel(null, options, "标题行", "内容内容内容内容");
	}
}
