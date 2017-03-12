package com.sillyhat.listener.function;

import com.sillyhat.swing.module.container.middle.SillyHatTabModulePanel;
import com.sillyhat.utils.Constants;
import com.sillyhat.view.function.PersonalInfomationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalInformationListener implements ActionListener{

	
	private SillyHatTabModulePanel modulePanel;
	
	
	public PersonalInformationListener(SillyHatTabModulePanel modulePanel){
		this.modulePanel = modulePanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		modulePanel.removeAll();
//		JPanel jPanel = new JPanel();
//		JLabel jLabel = new JLabel("这里是用户资料");
//		jPanel.add(jLabel);
//		modulePanel.setTabComponentAt("用户资料",jPanel);
		modulePanel.addTabPanel("用户资料",new PersonalInfomationView(Constants.PANEL_CODE_PERSONAL_INFOMATION));
//		window.repaint();
//		modulePanel.repaintPanel();  
	}
}
