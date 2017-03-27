package com.sillyhat.learningenglish.business.reciteword.view;

import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDetailDTO;
import com.sillyhat.learningenglish.business.learningplan.service.LearningPlanService;
import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserLearningParamsDTO;
import com.sillyhat.learningenglish.business.personalinformation.service.UserService;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.utils.MathUtils;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.learningenglish.utils.cache.SystemCache;
import com.sillyhat.learningenglish.utils.linkedlist.factory.SingleCycleLinkedListFactory;
import com.sillyhat.swing.module.basic.SillyHatJLabel;
import com.sillyhat.swing.module.basic.SillyHatJTextPane;
import com.sillyhat.swing.module.container.middle.SillyHatJOptionPane;
import com.sillyhat.swing.module.container.middle.SillyHatTabPanel;
import com.sillyhat.swing.utils.SillyHatWindowUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * Created by ${XUSHIKUAN} on 2017-03-19.
 */
public class ReciteWord extends SillyHatTabPanel{

    private static final long serialVersionUID = 2468707319118554415L;

    private Logger logger = LoggerFactory.getLogger(ReciteWord.class);

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

    private int getTextNum;
    private int knowTextNum;
    private int unKnowTextNum;
    private int maxTextNum;//单词显示最大数量

    private JPanel questionJPanel;
    private JPanel answerJPanel;

    private SillyHatJTextPane question;

    private SillyHatJTextPane answer;

    private JPanel contextJpanel;

    private JPanel buttonJPanel;

    private JButton btnKnow;
    private JButton btnUnKnow;

    private String currentWordKey;//当前单词在缓存中的key值

    public void initCache(long userId){
        TodayPlanDTO todayPlanDTO = learningPlanService.getTodayPlan(userId);
        List<TodayPlanDetailDTO> todayPlanDetailList = todayPlanDTO.getTodayPlanDetailList();
        for (int i = 0; i < todayPlanDetailList.size(); i++) {
            TodayPlanDetailDTO dto = todayPlanDetailList.get(i);
            String key = Constants.CACHE_USER_PLAN_WORD + dto.getWordId();
            SingleCycleLinkedListFactory.getInstance().insert(key);//插入单循环链表
            SystemCache.putTodayPlanDetailCache(key,dto);//插入缓存
        }
    }
    public void initContextJpanel(){
        getTextNum = 0;
        knowTextNum = 0;
        unKnowTextNum = SingleCycleLinkedListFactory.getInstance().size();
        maxTextNum = SingleCycleLinkedListFactory.getInstance().size();
        northJPanel = new JPanel(new GridLayout(1, 3));
        getJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        getJLabel = new SillyHatJLabel(messageService.getMessageZH("recite.word.get") + "：");
        getTextJLabel = new SillyHatJLabel(getTextNum+"");
        getJPanel.add(getJLabel);
        getJPanel.add(getTextJLabel);
        northJPanel.add(getJPanel);
        knowJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        knowJLabel = new SillyHatJLabel(messageService.getMessageZH("recite.word.know") + "：");
        knowTextJLabel = new SillyHatJLabel(knowTextNum+"");
        knowJPanel.add(knowJLabel);
        knowJPanel.add(knowTextJLabel);
        northJPanel.add(knowJPanel);
        unKnowJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        unKnowJLabel = new SillyHatJLabel(messageService.getMessageZH("recite.word.unknow") + "：");
        unKnowTextJLabel = new SillyHatJLabel(unKnowTextNum+"");
        unKnowJPanel.add(unKnowJLabel);
        unKnowJPanel.add(unKnowTextJLabel);
        northJPanel.add(unKnowJPanel);
        northJPanel.setPreferredSize(new Dimension((int)SillyHatWindowUtils.getWindowsWidth() - 20,40));
        contextJpanel.add(northJPanel);

        currentWordKey = SingleCycleLinkedListFactory.getInstance().getNextElement().getValue();
        TodayPlanDetailDTO dto = SystemCache.getTodayPlanDetailCache(currentWordKey);

        questionJPanel = new JPanel(new GridLayout(1, 1));
        question = new SillyHatJTextPane(dto.getWord().getWord() + dto.getWord().getUkPhonetic() + " " + dto.getWord().getUsPhonetic(),(int)SillyHatWindowUtils.getWindowsWidth()-20,50);
        question.isReadonly(true);
        questionJPanel.add(question);
        contextJpanel.add(questionJPanel);

        answerJPanel = new JPanel(new GridLayout(1, 1));
        answer = new SillyHatJTextPane(dto.getWord().getWordTranslate() + dto.getWord().getWebTranslate(),(int)SillyHatWindowUtils.getWindowsWidth()-20,300);
        answer.isReadonly(true);
        answerJPanel.add(answer);
        contextJpanel.add(answerJPanel);

//        questionJPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
//        answerJPanel.setBorder(BorderFactory.createLineBorder(Color.red));
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
        btnKnow.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                clickButtonKnow();
            }
        });
//        btnKnow.addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyPressed(KeyEvent e) {
//                panelKeyPressed(e);
//            }
//        });
        btnUnKnow.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                clickButtonUnKnow();
            }
        });
//        btnUnKnow.addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyPressed(KeyEvent e) {
//                panelKeyPressed(e);
//            }
//        });
        buttonJPanel.add(btnKnow);
        buttonJPanel.add(btnUnKnow);
//        buttonJPanel.addKeyListener(new KeyAdapter() {
//            public void keyPressed(KeyEvent e) {
//                System.out.println(e.getKeyCode());
//                panelKeyPressed(e);
//            }
//        });
        add(contextJpanel,BorderLayout.SOUTH);
        add(buttonJPanel,BorderLayout.NORTH);
//        this.grabFocus();//获取焦点
    }


    public void panelKeyPressed(KeyEvent e){
        if(e.getKeyChar() == KeyEvent.VK_UP){
            clickButtonKnow();
        }else if(e.getKeyChar() == KeyEvent.VK_DOWN){
            clickButtonUnKnow();
        }
    }

    /**
     * 点击认识按钮
     */
    private void clickButtonKnow(){
        logger.info("know key : " + currentWordKey);
        TodayPlanDetailDTO currentDTO = SystemCache.getTodayPlanDetailCache(currentWordKey);
        int occurrenceNum = currentDTO.getOccurrenceNum() - 1;
        if(occurrenceNum <= 0){
            //学习完毕，从环状链表中移除;认识的单词增加一个，了解的单词，减少一个
            SingleCycleLinkedListFactory.getInstance().delete(currentWordKey);
            if(getTextNum != maxTextNum) getTextNum++;
            if(knowTextNum != 0) knowTextNum--;
        }else if(occurrenceNum < 3){
            //了解的单词增加一个，未学会的单词，减少一个
            if(knowTextNum != maxTextNum) knowTextNum++;
            if(unKnowTextNum != 0) unKnowTextNum--;
        }
        currentDTO.setOccurrenceNum(occurrenceNum);
        SystemCache.putTodayPlanDetailCache(currentWordKey,currentDTO);
        if(SingleCycleLinkedListFactory.getInstance().size() == 0){
            //学习完毕，返回今日全部单词
            SillyHatJOptionPane.alert(messageService.getMessageZH("alert.reminder"),"完成本日计划");
        }else{
            currentWordKey = SingleCycleLinkedListFactory.getInstance().getNextElement().getValue();
            TodayPlanDetailDTO dto = SystemCache.getTodayPlanDetailCache(currentWordKey);
            refreshPage(dto.getWord().getWord() + dto.getWord().getUkPhonetic() + " " + dto.getWord().getUsPhonetic(),dto.getWord().getWordTranslate() + dto.getWord().getWebTranslate());
        }
        SingleCycleLinkedListFactory.getInstance().print();
    }

    /**
     * 点击不认识按钮
     */
    private void clickButtonUnKnow(){
        logger.info("know key : " + currentWordKey);
        TodayPlanDetailDTO currentDTO = SystemCache.getTodayPlanDetailCache(currentWordKey);
        int occurrenceNum = currentDTO.getOccurrenceNum();
        if(occurrenceNum < Constants.DEFAULT_OCCURRENCE_NUM){
            if(unKnowTextNum != maxTextNum) unKnowTextNum++;
            if(knowTextNum != 0) knowTextNum--;
        }
        currentDTO.setOccurrenceNum(Constants.DEFAULT_OCCURRENCE_NUM);//重新赋值
        SystemCache.putTodayPlanDetailCache(currentWordKey,currentDTO);
        logger.info("CycleLinked size -----> " + SingleCycleLinkedListFactory.getInstance().size());
        if(SingleCycleLinkedListFactory.getInstance().size() >= Constants.DEFAULT_LEARNING_GROUP_NUM * 2){
            //链表长度在每组长度之上，随机插入到隔着1组之后的位置
            int insertIndex = MathUtils.getSectionMath(Constants.DEFAULT_LEARNING_GROUP_NUM * 2,SingleCycleLinkedListFactory.getInstance().size());
            logger.info("change to " + insertIndex);
            SingleCycleLinkedListFactory.getInstance().delete(currentWordKey);
            SingleCycleLinkedListFactory.getInstance().insert(insertIndex,currentWordKey);//随机插入到后边位置
        }
        currentWordKey = SingleCycleLinkedListFactory.getInstance().getNextElement().getValue();
        TodayPlanDetailDTO dto = SystemCache.getTodayPlanDetailCache(currentWordKey);
        refreshPage(dto.getWord().getWord() + dto.getWord().getUkPhonetic() + " " + dto.getWord().getUsPhonetic(),dto.getWord().getWordTranslate() + dto.getWord().getWebTranslate());
        SingleCycleLinkedListFactory.getInstance().print();
    }


    /**
     * 刷新页面显示
     * @param questionTextValue
     * @param answerTextValue
     */
    private void refreshPage(String questionTextValue,String answerTextValue){
        getTextJLabel.setText(getTextNum+"");
        knowTextJLabel.setText(knowTextNum+"");
        unKnowTextJLabel.setText(unKnowTextNum+"");
        question.setTextValue(questionTextValue);
        answer.setTextValue(answerTextValue);
    }
    /**
     * @param panelCode
     * @Fields panelCode : panel唯一ID
     */
    public ReciteWord(String panelCode) {
        super(panelCode);
    }

}
