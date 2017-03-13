package com.sillyhat.business.question.listener;

import com.sillyhat.swing.module.container.middle.SillyHatTabModulePanel;
import com.sillyhat.utils.Constants;
import com.sillyhat.business.question.view.WordQuestionList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 题库录入页面
 */
public class WordQuestionEntryListener implements ActionListener{

	private SillyHatTabModulePanel modulePanel;
	
	
	public WordQuestionEntryListener(SillyHatTabModulePanel modulePanel){
		this.modulePanel = modulePanel;
	}

	public void actionPerformed(ActionEvent e) {
		WordQuestionList wordQuestionList = new WordQuestionList(Constants.PANEL_CODE_THE_QUESTION_ENTRY);
		wordQuestionList.initTable();
		wordQuestionList.hiddenColumn(0);
		wordQuestionList.refreshTable();;
		modulePanel.addTabPanel("题库录入",wordQuestionList);
	}

}
