package com.sillyhat.learningenglish.business.reciteword.listener;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.reciteword.view.ReciteWord;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.module.container.middle.SillyHatTabModulePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ${XUSHIKUAN} on 2017-03-19.
 */
public class ReciteWordListener implements ActionListener {

    private SillyHatTabModulePanel modulePanel;

    private MessageService messageService;

    public ReciteWordListener(SillyHatTabModulePanel modulePanel) {
        messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
        this.modulePanel = modulePanel;
    }

    public void actionPerformed(ActionEvent e) {
        modulePanel.addTabPanel(messageService.getMessageZH("recite.word"), new ReciteWord(Constants.PANEL_CODE_RECITE_WORD));
    }
}

