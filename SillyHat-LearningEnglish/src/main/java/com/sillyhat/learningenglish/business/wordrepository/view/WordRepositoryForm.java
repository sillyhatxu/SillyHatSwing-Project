package com.sillyhat.learningenglish.business.wordrepository.view;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.module.basic.SillyHatInputText;
import com.sillyhat.swing.module.basic.SillyHatTextArea;
import com.sillyhat.swing.module.container.middle.SillyHatDialog;
import com.sillyhat.swing.module.container.middle.SillyHatJOptionPane;

import java.awt.*;
import java.util.Map;

import javax.swing.*;

/**
 * Created by ${XUSHIKUAN} on 2017-03-12.
 */
public class WordRepositoryForm extends SillyHatDialog {

    private MessageService messageService;

    private WordRepositoryDTO dto;

    private WordRepositoryService wordRepositoryService;

    public WordRepositoryForm(Component relativeTo,WordRepositoryDTO dto) {
        super(relativeTo);
        this.dto = dto;
    }

    @Override
    public void initDialog() {
        messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
        wordRepositoryService = (WordRepositoryService) SpringUtils.getInstance().getContext().getBean(WordRepositoryService.class);
    }

    @Override
    public String getDialogName() {
        return messageService.getMessageZH("word.repository.word.edit");
    }

    @Override
    public int getDialogWidth() {
        return 800;
    }

    @Override
    public int getDialogHeight() {
        return 500;
    }

    private SillyHatInputText wordText;
    private SillyHatInputText phonetic;
    private SillyHatInputText reminder;
    public JPanel dialogContent() {
//        JPanel fromPanel = new JPanel(new GridLayout(4,1));
        JPanel fromPanel = new JPanel();
        fromPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        wordText = new SillyHatInputText(messageService.getMessageZH("word.repository.word"),80, 30, "",20);
        phonetic = new SillyHatInputText(messageService.getMessageZH("word.repository.phonetic"),80, 30, "",20);
        reminder = new SillyHatInputText(messageService.getMessageZH("word.repository.reminder"),80, 30, "",20);
//        fromPanel.add(new SillyHatInputText(messageService.getMessageZH("word.repository.word"),80, 30, "",20,Color.BLUE));
//        fromPanel.add(new SillyHatInputText(messageService.getMessageZH("word.repository.phonetic"),80, 30, "",20,Color.RED));
//        fromPanel.add(new SillyHatInputText(messageService.getMessageZH("word.repository.reminder"),80, 30, "",20,Color.BLUE));
        fromPanel.add(wordText);
        fromPanel.add(phonetic);
        fromPanel.add(reminder);
//        TextArea textAreaOutput = new TextArea("缩略词词典", 20, 43,TextArea.SCROLLBARS_VERTICAL_ONLY);
//        textAreaOutput.setSelectedTextColor(Color.RED);
//        textAreaOutput.setLineWrap(true);//激活自动换行功能
//        textAreaOutput.setWrapStyleWord(true);// 激活断行不断字功能
//        JPanel panelOutput = new JPanel();
//        panelOutput.add(new JScrollPane(textAreaOutput));
//        fromPanel.add(new SillyHatInputText(messageService.getMessageZH("word.repository.word.translate"),80, 30, "",20));
        fromPanel.add(new SillyHatTextArea("测试"));
        return fromPanel;
    }

    public boolean clickCancelEvent(){
        SillyHatJOptionPane.alert("提示","clickCancelEvent");
        return false;
    }

    public boolean clickSubmitEvent(){
        SillyHatJOptionPane.alert("提示",wordText.getTextValue() + "---" + phonetic.getTextValue() + "---" + reminder.getTextValue());
        return false;
    }

    public Map<String,Object> closeDialog(){
        return null;
    }



}
