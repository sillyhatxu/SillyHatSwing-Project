package com.sillyhat.learningenglish.business.reciteword.view;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.personalinformation.service.UserService;
import com.sillyhat.learningenglish.utils.SpringUtils;
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

    @Override
    public void initService() {
        messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
        userService = (UserService) SpringUtils.getInstance().getContext().getBean(UserService.class);
    }

    private JPanel northJpanel = new JPanel(new GridLayout(1, 3));

    private JPanel contextJpanel = new JPanel();

    private JPanel southJpanel = new JPanel(new GridLayout(2, 1));

    private JButton btnKnow;
    private JButton btnUnKnow;

    private void initComponents(){
        initComponents();
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
