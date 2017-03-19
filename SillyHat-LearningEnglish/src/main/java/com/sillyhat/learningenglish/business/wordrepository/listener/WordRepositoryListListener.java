package com.sillyhat.learningenglish.business.wordrepository.listener;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.wordrepository.view.WordRepositoryList;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.module.container.middle.SillyHatTabModulePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 题库录入页面
 */
public class WordRepositoryListListener implements ActionListener{

	private SillyHatTabModulePanel modulePanel;

	private MessageService messageService;
	
	public WordRepositoryListListener(SillyHatTabModulePanel modulePanel){
		messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
		this.modulePanel = modulePanel;
	}

	public void actionPerformed(ActionEvent e) {
		modulePanel.addTabPanel(messageService.getMessageZH("menu.word.repository"),new WordRepositoryList(Constants.PANEL_CODE_WORD_REPOSITORY));
	}

}
