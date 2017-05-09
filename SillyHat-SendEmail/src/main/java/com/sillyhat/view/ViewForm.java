package com.sillyhat.view;

import javax.swing.*;

public class ViewForm extends JFrame{
	
	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -258291671491370326L;

	
	public static final FormPanel centerPanel = new FormPanel();
	
	public static final TablePanel southPanel = new TablePanel();
	
	public static final ButtonPanel northPanel = new ButtonPanel(centerPanel,southPanel);
	
}
