package com.sillyhat.learningenglish.business.personalinformation.listener;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.personalinformation.view.PersonalInfomationDetail;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.module.container.middle.SillyHatTabModulePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalInformationListener implements ActionListener{

	
	private SillyHatTabModulePanel modulePanel;

	private MessageService messageService;

	public PersonalInformationListener(SillyHatTabModulePanel modulePanel){
		messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
		this.modulePanel = modulePanel;
	}

	public void actionPerformed(ActionEvent e) {
		modulePanel.addTabPanel(messageService.getMessageZH("personal.infomation"),new PersonalInfomationDetail(Constants.PANEL_CODE_PERSONAL_INFOMATION));
	}
}
