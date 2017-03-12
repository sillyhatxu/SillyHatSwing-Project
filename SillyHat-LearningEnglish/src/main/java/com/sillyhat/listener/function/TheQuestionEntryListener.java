package com.sillyhat.listener.function;

import com.sillyhat.swing.module.container.middle.SillyHatTabModulePanel;
import com.sillyhat.utils.Constants;
import com.sillyhat.view.function.TheQuestionEntryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheQuestionEntryListener implements ActionListener{

	private SillyHatTabModulePanel modulePanel;
	
	
	public TheQuestionEntryListener(SillyHatTabModulePanel modulePanel){
		this.modulePanel = modulePanel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		modulePanel.removeAll();
		modulePanel.addTabPanel("题库录入",new TheQuestionEntryView(Constants.PANEL_CODE_THE_QUESTION_ENTRY));
//		modulePanel.add(pane);
//		ModulePanel userPanel = new ModulePanel();
//		userPanel.add(new SillyHatInputText("题库","题库题库题库题库题库题库题库题库题库题库题库题库题库"));
//		modulePanel.repaintPanel();
	}
}
