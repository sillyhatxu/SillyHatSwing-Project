package com.sillyhat.swing.module.container.middle;

import javax.swing.*;
import java.awt.*;

public class ModulePanel extends JPanel{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -3083158849745153721L;

	private Container container;
	
	public ModulePanel(){
		
	}
	
	public ModulePanel(Container container){
		this.container = container;
	}
	
	public void repaintPanel(){
		validate();  
		repaint(); 
	}
}
