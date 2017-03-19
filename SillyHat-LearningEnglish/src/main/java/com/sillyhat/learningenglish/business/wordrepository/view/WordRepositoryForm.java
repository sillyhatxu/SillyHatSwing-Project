package com.sillyhat.learningenglish.business.wordrepository.view;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.module.basic.SillyHatInputText;
import com.sillyhat.swing.module.basic.SillyHatLabelTextArea;
import com.sillyhat.swing.module.container.middle.SillyHatDialog;
import com.sillyhat.swing.module.container.middle.SillyHatJOptionPane;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

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

    public String getButtonNameSubmit(){
        return messageService.getMessageZH("btn.save");
    }

    public String getButtonNameCancel(){
        return messageService.getMessageZH("btn.cancel");
    }

    private String id;
    private SillyHatInputText wordText;
    private SillyHatInputText phonetic;
    private SillyHatLabelTextArea reminder;
    private SillyHatLabelTextArea wordTranslate;


    public JPanel dialogContent() {
        JPanel fromPanel = new JPanel();
        if(dto == null){
            dto = new WordRepositoryDTO();
        }
        wordText = new SillyHatInputText(messageService.getMessageZH("word.repository.word"),80, 30, dto.getWord(),20);
        phonetic = new SillyHatInputText(messageService.getMessageZH("word.repository.phonetic"),80, 30, dto.getPhonetic(),20);
        reminder = new SillyHatLabelTextArea(messageService.getMessageZH("word.repository.reminder"),80, 30, dto.getReminder(),500,100);
        wordTranslate = new SillyHatLabelTextArea(messageService.getMessageZH("word.repository.word.translate"),80, 30, dto.getWordTranslate(),500,100);
        fromPanel.add(wordText);
        fromPanel.add(phonetic);
        fromPanel.add(reminder);
        fromPanel.add(wordTranslate);
        return fromPanel;
    }

    public boolean clickSubmitEvent(){
        dto.setWord(wordText.getTextValue());
        dto.setPhonetic(phonetic.getTextValue());
        dto.setReminder(reminder.getTextValue());
        dto.setWordTranslate(wordTranslate.getTextValue());
        wordRepositoryService.saveWordRepository(dto);
        SillyHatJOptionPane.alert(messageService.getMessageZH("alert.reminder"),messageService.getMessageZH("alert.submit.success"));
        return true;
    }

    public Map<String,Object> closeDialog(){
        return null;
    }



}
