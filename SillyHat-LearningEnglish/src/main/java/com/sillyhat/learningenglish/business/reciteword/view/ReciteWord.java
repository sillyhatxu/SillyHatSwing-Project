package com.sillyhat.learningenglish.business.reciteword.view;

import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDetailDTO;
import com.sillyhat.learningenglish.business.learningplan.service.LearningPlanService;
import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserLearningParamsDTO;
import com.sillyhat.learningenglish.business.personalinformation.service.UserService;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.learningenglish.utils.cache.SystemCache;
import com.sillyhat.learningenglish.utils.linkedlist.factory.SingleCycleLinkedListFactory;
import com.sillyhat.swing.module.basic.SillyHatJLabel;
import com.sillyhat.swing.module.container.middle.SillyHatTabPanel;
import com.sillyhat.swing.utils.SillyHatWindowUtils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by ${XUSHIKUAN} on 2017-03-19.
 */
public class ReciteWord extends SillyHatTabPanel {

    private static final long serialVersionUID = 2468707319118554415L;

    private MessageService messageService;

    private UserService userService;

    private LearningPlanService learningPlanService;

    public void initService() {
        messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
        userService = (UserService) SpringUtils.getInstance().getContext().getBean(UserService.class);
        learningPlanService = (LearningPlanService) SpringUtils.getInstance().getContext().getBean(LearningPlanService.class);
    }

    private JPanel northJPanel;
    private JPanel getJPanel;
    private JPanel knowJPanel;
    private JPanel unKnowJPanel;
    private SillyHatJLabel getJLabel;
    private SillyHatJLabel getTextJLabel;
    private SillyHatJLabel knowJLabel;
    private SillyHatJLabel knowTextJLabel;
    private SillyHatJLabel unKnowJLabel;
    private SillyHatJLabel unKnowTextJLabel;

    private JPanel questionJPanel;
    private JPanel answerJPanel;

    private JPanel contextJpanel;

    private JPanel buttonJPanel;

    private JButton btnKnow;
    private JButton btnUnKnow;

    public void initCache(long userId){
        TodayPlanDTO todayPlanDTO = learningPlanService.getTodayPlan(userId);
        List<TodayPlanDetailDTO> todayPlanDetailList = todayPlanDTO.getTodayPlanDetailList();
        for (int i = 0; i < todayPlanDetailList.size(); i++) {
            TodayPlanDetailDTO dto = todayPlanDetailList.get(i);
            String key = Constants.CACHE_USER_PLAN_WORD + i;
            SingleCycleLinkedListFactory.getInstance().insert(key);//插入单循环链表
            SystemCache.putTodayPlanDetailCache(key,dto);//插入缓存
        }
    }
    public void initContextJpanel(){
        northJPanel = new JPanel(new GridLayout(1, 3));
        getJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        getJLabel = new SillyHatJLabel(messageService.getMessageZH("recite.word.get") + "：");
        getTextJLabel = new SillyHatJLabel("0");
        getJPanel.add(getJLabel);
        getJPanel.add(getTextJLabel);
        northJPanel.add(getJPanel);
        knowJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        knowJLabel = new SillyHatJLabel(messageService.getMessageZH("recite.word.know") + "：");
        knowTextJLabel = new SillyHatJLabel("0");
        knowJPanel.add(knowJLabel);
        knowJPanel.add(knowTextJLabel);
        northJPanel.add(knowJPanel);
        unKnowJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        unKnowJLabel = new SillyHatJLabel(messageService.getMessageZH("recite.word.unknow") + "：");
        unKnowTextJLabel = new SillyHatJLabel("0");
        unKnowJPanel.add(unKnowJLabel);
        unKnowJPanel.add(unKnowTextJLabel);
        northJPanel.add(unKnowJPanel);
        northJPanel.setPreferredSize(new Dimension((int)SillyHatWindowUtils.getWindowsWidth() - 20,40));
        contextJpanel.add(northJPanel);

        String wordKey = SingleCycleLinkedListFactory.getInstance().getNextElement().getValue();
        TodayPlanDetailDTO dto = SystemCache.getTodayPlanDetailCache(wordKey);

        questionJPanel = new JPanel();
        SillyHatJLabel jLabel1 = new SillyHatJLabel(dto.getWord().getUkPhonetic() + "    "  + dto.getWord().getUsPhonetic());
        SillyHatJLabel jLabel2 = new SillyHatJLabel(dto.getWord().getWordTranslate());
        SillyHatJLabel jLabel3 = new SillyHatJLabel(dto.getWord().getWebTranslate());
        questionJPanel.add(jLabel1);
        questionJPanel.add(jLabel2);
        questionJPanel.add(jLabel3);
        contextJpanel.add(questionJPanel);

        answerJPanel = new JPanel();
//        answerJPanel.add(answerJLabel);
        contextJpanel.add(answerJPanel);
//        questionJPanel.drawString
//        private JPanel questionJPanel;
//        private JPanel answerJPanel;
        northJPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        contextJpanel.setBorder(BorderFactory.createLineBorder(Color.red));
    }

    public void initComponents(){
        UserDTO user = SystemCache.getUserCache();
        //得到用户学习参数表信息
        UserLearningParamsDTO userLearningParams = userService.getUserLearningParamsByUserId(user.getId());
        SystemCache.putCountCache(Constants.CACHE_USER_LEARNING_NUM,userLearningParams.getLearningNum());
        SystemCache.putCountCache(Constants.CACHE_USER_REVIEW_NUM,userLearningParams.getReviewNum());
        initCache(user.getId());
        contextJpanel = new JPanel();
        contextJpanel.setPreferredSize(new Dimension((int)SillyHatWindowUtils.getWindowsWidth() - 20,(int)SillyHatWindowUtils.getWindowsHeight() - 180));
        initContextJpanel();
        buttonJPanel = new JPanel(new GridLayout(2, 1));
        buttonJPanel.setPreferredSize(new Dimension((int)SillyHatWindowUtils.getWindowsWidth() - 20,80));
        btnKnow = new JButton(messageService.getMessageZH("btn.know"));
        btnUnKnow = new JButton(messageService.getMessageZH("btn.unknow"));
        buttonJPanel.add(btnKnow);
        buttonJPanel.add(btnUnKnow);
        add(contextJpanel,BorderLayout.SOUTH);
        add(buttonJPanel,BorderLayout.NORTH);
    }

    /**
     * @param panelCode
     * @Fields panelCode : panel唯一ID
     */
    public ReciteWord(String panelCode) {
        super(panelCode);
    }


}
