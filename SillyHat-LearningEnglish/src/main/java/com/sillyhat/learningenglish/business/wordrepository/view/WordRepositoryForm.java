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
    private SillyHatInputText usPhonetic;
    private SillyHatInputText ukPhonetic;
    private SillyHatLabelTextArea wordTranslate;
    private SillyHatLabelTextArea webTranslate;
    private SillyHatLabelTextArea sampleSentences;

    public JPanel dialogContent() {
        JPanel fromPanel = new JPanel();
        if(dto == null){
            dto = new WordRepositoryDTO();
        }
        wordText = new SillyHatInputText(messageService.getMessageZH("word.repository.word"),80, 30, dto.getWord(),20);
        usPhonetic = new SillyHatInputText(messageService.getMessageZH("word.repository.us.phonetic"),80, 30, dto.getUsPhonetic(),20);
        ukPhonetic = new SillyHatInputText(messageService.getMessageZH("word.repository.uk.phonetic"),80, 30, dto.getUkPhonetic(),20);
        webTranslate = new SillyHatLabelTextArea(messageService.getMessageZH("word.repository.web.translate"),80, 30, dto.getWebTranslate(),500,100);
        wordTranslate = new SillyHatLabelTextArea(messageService.getMessageZH("word.repository.word.translate"),80, 30, dto.getWordTranslate(),500,100);
        sampleSentences = new SillyHatLabelTextArea(messageService.getMessageZH("word.repository.sample.sentences"),80, 30, dto.getSampleSentences(),500,100);
        fromPanel.add(wordText);
        fromPanel.add(usPhonetic);
        fromPanel.add(ukPhonetic);
        fromPanel.add(webTranslate);
        fromPanel.add(wordTranslate);
        return fromPanel;
    }

    public boolean clickSubmitEvent(){
        dto.setWord(wordText.getTextValue());
        dto.setUsPhonetic(usPhonetic.getTextValue());
        dto.setUkPhonetic(ukPhonetic.getTextValue());
        dto.setWebTranslate(webTranslate.getTextValue());
        dto.setWordTranslate(wordTranslate.getTextValue());
        dto.setSampleSentences(sampleSentences.getTextValue());
        wordRepositoryService.saveWordRepository(dto);
        SillyHatJOptionPane.alert(messageService.getMessageZH("alert.reminder"),messageService.getMessageZH("alert.submit.success"));
        return true;
    }

    public Map<String,Object> closeDialog(){
        return null;
    }



}
