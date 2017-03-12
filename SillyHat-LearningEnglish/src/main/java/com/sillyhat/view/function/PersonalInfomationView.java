package com.sillyhat.view.function;

import com.sillyhat.swing.module.basic.SillyHatFactory;
import com.sillyhat.swing.module.basic.SillyHatFormJPanel;
import com.sillyhat.swing.module.basic.SillyHatInputText;
import com.sillyhat.swing.module.container.middle.SillyHatTabPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 个人信息页面
 */
public class PersonalInfomationView extends SillyHatTabPanel{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -7743068812917872442L;

	public PersonalInfomationView(String panelCode) {
		super(panelCode);
//		add(new JLabel("123456789"));
		setBorder(SillyHatFactory.getBorderDistanceNoneTop(10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        TitledBorder titled = BorderFactory.createTitledBorder("徐士宽");
        SillyHatFormJPanel formPanel = SillyHatFactory.createCerticalFormJPanel(titled);
        formPanel.add(new JLabel("sfssdd"));
        formPanel.add(new SillyHatInputText("用户名",80, 30, "",20));
        formPanel.add(new SillyHatInputText("密码",80, 30, "",20));
        add(formPanel);
        
//        addCompForBorder(titled,"default titled border (default just., default pos.)",this);
        
        
//        add(comp);
//		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
//		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
//		Border compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
//		Border titleBorder = BorderFactory.createTitledBorder(compound, "title",TitledBorder.CENTER,TitledBorder.BELOW_BOTTOM);
//		Border titleBorder = BorderFactory.createLineBorder(Color.black);
//		setBorder(titleBorder);
	}
	
	
	void addCompForBorder(Border border, String description, Container container) {
		JPanel comp = new JPanel(new GridLayout(1, 1), false);
		JLabel label = new JLabel(description, JLabel.CENTER);
		comp.add(label);
		comp.setBorder(border);
//		container.add(Box.createRigidArea(new Dimension(0, 10)));
		container.add(comp);
	}
}
