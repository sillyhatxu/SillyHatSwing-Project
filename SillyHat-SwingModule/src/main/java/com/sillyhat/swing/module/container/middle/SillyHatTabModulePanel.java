package com.sillyhat.swing.module.container.middle;

import com.sillyhat.swing.exception.SillyHatException;
import com.sillyhat.swing.utils.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class SillyHatTabModulePanel extends JTabbedPane{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -3083158849745153721L;

	private Set<String> existModule = new HashSet<String>();
	
	public SillyHatTabModulePanel(){
		
	}
	
	public void addTabPanel(String panelName,SillyHatTabPanel tabPanel){
		if(null == tabPanel || StringUtils.isEmpty(tabPanel.getName())){
			throw new SillyHatException("SillyHatTabPanel 和 getName()不能为空");
		}
		if(existModule.contains(tabPanel.getName())){
			//panel已经存在，获取焦点
			for (int i = 0; i < getTabCount(); i++) {
				Component component = getComponentAt(i);
				if(component.getName() != null && !"".equals(component.getName())){
					if(component.getName().equals(tabPanel.getName())){
						setSelectedComponent(component);
					}
				}
			}
		}else{
			existModule.add(tabPanel.getName());
			add(panelName,tabPanel);
			setSelectedComponent(tabPanel);
		}
	}
	
	public void repaintPanel(){
		validate();  
		repaint(); 
	}
}
