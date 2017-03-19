package com.sillyhat.learningenglish.business.personalinformation.view;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserLearningParamsDTO;
import com.sillyhat.learningenglish.business.personalinformation.service.UserService;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.learningenglish.utils.cache.UserCache;
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
public class PersonalInfomationDetail extends SillyHatTabPanel{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -7743068812917872442L;

	private MessageService messageService;

	private UserService userService;

	@Override
	public void initService() {
		messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
		userService = (UserService) SpringUtils.getInstance().getContext().getBean(UserService.class);
	}

	public PersonalInfomationDetail(String panelCode) {
		super(panelCode);
		setBorder(SillyHatFactory.getBorderDistanceNoneTop(10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		UserDTO user = UserCache.getCache();
        TitledBorder titled = BorderFactory.createTitledBorder(user.getUserName());
        SillyHatFormJPanel formPanel = SillyHatFactory.createCerticalFormJPanel(titled);
		UserLearningParamsDTO userLearningParams = userService.loadUserLearningParamsByUserId(user.getId());
//        formPanel.add(new SillyHatInputText(messageService.getMessageZH("personal.infomation.learning.params.learningNum"),80, 30, "",20,BorderFactory.createLineBorder(Color.blue)));
        formPanel.add(new SillyHatInputText(messageService.getMessageZH("personal.infomation.learning.params.learningNum"),80, 30, userLearningParams.getLearningNum() + "",20));
        formPanel.add(new SillyHatInputText(messageService.getMessageZH("personal.infomation.learning.params.reviewNum"),80, 30, userLearningParams.getReviewNum() + "",20));
        add(formPanel);
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
