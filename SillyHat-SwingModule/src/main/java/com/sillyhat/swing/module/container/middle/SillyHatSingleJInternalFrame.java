package com.sillyhat.swing.module.container.middle;

import javax.swing.*;

/** 
 * @ClassName: SillyHatSingleJInternalFrame 
 * @Description: 未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成
 * @author XUSHIKUAN642
 * @date 2016-11-18 下午2:10:19  
 */ 
public class SillyHatSingleJInternalFrame extends JInternalFrame{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -39922427122295036L;

	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成未完成
	 * @param windowId 
	 */
	public SillyHatSingleJInternalFrame(String windowId){
		System.out.println(getUIClassID());
		System.out.println(getUI());
	}
	
	public static void main(String[] args) {
		new SillyHatSingleJInternalFrame("test");
		new SillyHatSingleJInternalFrame("sdfgdsfgdsfg");
	}
	
}
