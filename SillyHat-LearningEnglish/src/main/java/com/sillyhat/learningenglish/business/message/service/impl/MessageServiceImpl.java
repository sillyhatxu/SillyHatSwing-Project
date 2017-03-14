package com.sillyhat.learningenglish.business.message.service.impl;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * MessageServiceImpl
 *
 * @author 徐士宽
 * @date 2017/3/14 16:39
 */
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageSource messageSource;

    @Override
    public String getMessageZH(String code) {
        return messageSource.getMessage(code, null, Constants.DEFAULT_MESSAGE,  new Locale("zh"));
    }

    @Override
    public String getMessageEN(String code) {
        return messageSource.getMessage(code, null, Constants.DEFAULT_MESSAGE,  new Locale("en"));
    }
}
