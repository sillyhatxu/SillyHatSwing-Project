package com.sillyhat.learningenglish.business.system.view;

import com.sillyhat.swing.module.basic.SillyHatJMenu;
import com.sillyhat.swing.module.basic.SillyHatJMenuBar;
import com.sillyhat.swing.module.basic.SillyHatJMenuItem;
import com.sillyhat.swing.module.container.middle.SillyHatTabModulePanel;
import com.sillyhat.swing.module.container.top.SillyHatWindow;

public class ViewForm extends SillyHatWindow{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -258291671491370326L;

	public final SillyHatJMenuBar jMenuBar = new SillyHatJMenuBar();
	
	public SillyHatJMenu jMenu;
	
	public SillyHatJMenuItem jMenuButton;
	
	public SillyHatTabModulePanel centerPanel = new SillyHatTabModulePanel();
	
}
