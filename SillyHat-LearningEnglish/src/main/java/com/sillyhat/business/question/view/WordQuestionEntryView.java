package com.sillyhat.business.question.view;

import com.sillyhat.swing.module.basic.SillyHatFactory;
import com.sillyhat.swing.module.basic.SillyHatFormJPanel;
import com.sillyhat.swing.module.container.middle.SillyHatTabPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class WordQuestionEntryView extends SillyHatTabPanel{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -7743068812917872442L;

	public WordQuestionEntryView(String panelCode) {
		super(panelCode);
		setBorder(SillyHatFactory.getBorderDistanceNoneTop(10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		TitledBorder titled = BorderFactory.createTitledBorder("题库录入");//添加页签名称
		SillyHatFormJPanel formPanel = SillyHatFactory.createCerticalFormJPanel(titled);
		formPanel.add(new JLabel("sfssdd"));

		add(formPanel);
	}
	
}
