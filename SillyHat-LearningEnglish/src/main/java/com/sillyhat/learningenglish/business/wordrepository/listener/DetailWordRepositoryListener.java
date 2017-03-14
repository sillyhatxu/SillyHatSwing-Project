package com.sillyhat.learningenglish.business.wordrepository.listener;

import com.sillyhat.swing.constants.SillyHatAlert;
import com.sillyhat.swing.module.container.table.SillyHatTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ${XUSHIKUAN} on 2017-03-13.
 */
public class DetailWordRepositoryListener implements ActionListener {

    private SillyHatTable table;

    public DetailWordRepositoryListener(SillyHatTable table){
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = (String)table.getValueAt(table.getSelectedRow(), 0);
        SillyHatAlert.alert(id);
    }
}
