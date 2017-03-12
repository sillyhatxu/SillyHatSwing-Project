package com.sillyhat.listener.function;

import com.sillyhat.swing.module.container.middle.SillyHatTabModulePanel;
import com.sillyhat.utils.Constants;
import com.sillyhat.view.question.QuestionList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 题库录入页面
 */
public class TheQuestionEntryListener implements ActionListener{

	private SillyHatTabModulePanel modulePanel;
	
	
	public TheQuestionEntryListener(SillyHatTabModulePanel modulePanel){
		this.modulePanel = modulePanel;
	}

	public void actionPerformed(ActionEvent e) {
		QuestionList questionList = new QuestionList(Constants.PANEL_CODE_THE_QUESTION_ENTRY);
		questionList.initTable();
		questionList.hiddenColumn(0);
		questionList.refreshTable();;
		modulePanel.addTabPanel("题库录入",questionList);
	}

}
