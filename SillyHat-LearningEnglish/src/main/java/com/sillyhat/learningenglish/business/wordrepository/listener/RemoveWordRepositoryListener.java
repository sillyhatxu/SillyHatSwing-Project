package com.sillyhat.learningenglish.business.wordrepository.listener;

import com.sillyhat.learningenglish.business.system.dto.UserDTO;
import com.sillyhat.learningenglish.utils.cache.UserCache;
import com.sillyhat.swing.module.container.middle.SillyHatJOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ${XUSHIKUAN} on 2017-03-13.
 */
public class RemoveWordRepositoryListener implements ActionListener {

    public RemoveWordRepositoryListener(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserDTO user = UserCache.getCache();
        SillyHatJOptionPane.alert("",user.toString());
    }
}
