package com.sillyhat.swing.module.basic;

import javax.swing.*;
import java.awt.event.ActionListener;


public class SillyHatJMenuItem extends JMenuItem{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = 3173820775841959658L;

	public SillyHatJMenuItem(){
		
	}
	
	public SillyHatJMenuItem(String menuName){
		setText(menuName);
	}
	
	public SillyHatJMenuItem(String menuName,ActionListener listener){
		setText(menuName);
		addActionListener(listener);
	}
	
}
