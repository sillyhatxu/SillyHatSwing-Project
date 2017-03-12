package com.sillyhat.swing.module.basic;

import javax.swing.*;

public class SillyHatJMenu extends JMenu{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -1868290232920318132L;

	public SillyHatJMenu(){
		
	}
	
	public SillyHatJMenu(String menuName){
		setText(menuName);
	}
	/**
	 * <p>Title: addMenuButton</p>
	 * <p>Description: </p>添加菜单按钮
	 * @param jMenuItem
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public void addMenuButton(SillyHatJMenuItem jMenuItem){
		add(jMenuItem);
	}
}
