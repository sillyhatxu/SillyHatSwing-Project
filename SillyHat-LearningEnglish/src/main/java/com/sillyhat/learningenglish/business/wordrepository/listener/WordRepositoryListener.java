package com.sillyhat.learningenglish.business.wordrepository.listener;

import com.sillyhat.swing.module.container.middle.SillyHatTabModulePanel;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.business.question.view.WordRepositoryList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 题库录入页面
 */
public class WordRepositoryListener implements ActionListener{

	private SillyHatTabModulePanel modulePanel;
	
	
	public WordRepositoryListener(SillyHatTabModulePanel modulePanel){
		this.modulePanel = modulePanel;
	}

	public void actionPerformed(ActionEvent e) {
		WordRepositoryList wordRepositoryList = new WordRepositoryList(Constants.PANEL_CODE_WORD_REPOSITORY);
		wordRepositoryList.initTable();
		wordRepositoryList.hiddenColumn(0);
		wordRepositoryList.refreshTable();;
		modulePanel.addTabPanel("题库管理",wordRepositoryList);
	}

}
