package com.sillyhat.learningenglish.business.wordrepository.listener;

import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.constants.SillyHatAlert;
import com.sillyhat.swing.module.container.table.SillyHatTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ${XUSHIKUAN} on 2017-03-13.
 */
public class DetailWordRepositoryListener implements ActionListener {

    private SillyHatTable table;

    private boolean isEdit;

    private WordRepositoryService wordRepositoryService;

    public DetailWordRepositoryListener(SillyHatTable table,boolean isEdit){
        this.isEdit = isEdit;
        this.table = table;
        wordRepositoryService = (WordRepositoryService) SpringUtils.getInstance().getContext().getBean(WordRepositoryService.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WordRepositoryDTO dto = null;
        if(isEdit){
            String id = (String)table.getValueAt(table.getSelectedRow(), 0);
            //进入编辑界面
            dto = wordRepositoryService.getWordRepositoryById(id);
        }else{
            //进入新增界面
            dto = new WordRepositoryDTO();
        }
        SillyHatAlert.alert(dto.toString());
    }
}
