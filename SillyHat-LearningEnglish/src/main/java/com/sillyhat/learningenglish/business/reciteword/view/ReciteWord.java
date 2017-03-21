package com.sillyhat.learningenglish.business.reciteword.view;

import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDTO;
import com.sillyhat.learningenglish.business.learningplan.service.LearningPlanService;
import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserLearningParamsDTO;
import com.sillyhat.learningenglish.business.personalinformation.service.UserService;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.learningenglish.utils.cache.SystemCache;
import com.sillyhat.swing.module.container.middle.SillyHatTabPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ${XUSHIKUAN} on 2017-03-19.
 */
public class ReciteWord extends SillyHatTabPanel {

    private static final long serialVersionUID = 2468707319118554415L;

    private MessageService messageService;

    private UserService userService;

    private LearningPlanService learningPlanService;

    @Override
    public void initService() {
        messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
        userService = (UserService) SpringUtils.getInstance().getContext().getBean(UserService.class);
        learningPlanService = (LearningPlanService) SpringUtils.getInstance().getContext().getBean(LearningPlanService.class);
    }

    private JPanel northJpanel;

    private JPanel contextJpanel;

    private JPanel southJpanel;

    private JButton btnKnow;
    private JButton btnUnKnow;

    public void initComponents(){
        UserDTO user = SystemCache.getUserCache();
        //得到用户学习参数表信息
        UserLearningParamsDTO userLearningParams = userService.getUserLearningParamsByUserId(user.getId());
        SystemCache.putCountCache(Constants.CACHE_USER_LEARNING_NUM,userLearningParams.getLearningNum());
        SystemCache.putCountCache(Constants.CACHE_USER_REVIEW_NUM,userLearningParams.getReviewNum());
        TodayPlanDTO todayPlanDTO = learningPlanService.getTodayPlan(user.getId());

        northJpanel = new JPanel(new GridLayout(1, 3));
        contextJpanel = new JPanel();
        southJpanel = new JPanel(new GridLayout(2, 1));

        btnKnow = new JButton(messageService.getMessageZH("btn.know"));
        btnUnKnow = new JButton(messageService.getMessageZH("btn.unknow"));
        southJpanel.add(btnKnow);
        southJpanel.add(btnUnKnow);
        add(northJpanel, BorderLayout.NORTH);
        add(contextJpanel, BorderLayout.CENTER);
        add(southJpanel, BorderLayout.SOUTH);
    }

    /**
     * @param panelCode
     * @Fields panelCode : panel唯一ID
     */
    public ReciteWord(String panelCode) {
        super(panelCode);
    }


}
