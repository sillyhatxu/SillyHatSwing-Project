package com.sillyhat.swing.module.basic;

import javax.swing.*;

/** 
 * @ClassName: SillyHatJMenuBar 
 * @Description: 顶级菜单栏
 * @author XUSHIKUAN642
 * @date 2016-11-17 下午3:29:09  
 */ 
public class SillyHatJMenuBar extends JMenuBar{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -5084050791592159847L;

	/**
	 * <p>Title: addMenu</p>
	 * <p>Description: </p>在顶级菜单中添加菜单
	 * @param jMenu
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public void addMenu(SillyHatJMenu jMenu){
		add(jMenu);
	}
	
	public void addJMenuItem(SillyHatJMenuItem jMenuItem){
		add(jMenuItem);
	}
	
}
