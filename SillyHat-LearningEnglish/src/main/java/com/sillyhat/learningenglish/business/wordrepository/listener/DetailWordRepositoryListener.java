package com.sillyhat.learningenglish.business.wordrepository.listener;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.business.wordrepository.view.WordRepositoryForm;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.module.container.middle.SillyHatJOptionPane;
import com.sillyhat.swing.module.container.table.SillyHatPageTable;
import com.sillyhat.swing.utils.SillyHatWindowUtils;
import com.sillyhat.swing.utils.StringUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ${XUSHIKUAN} on 2017-03-13.
 */
public class DetailWordRepositoryListener implements ActionListener {

    private SillyHatPageTable sillyHatPageTable;

    private boolean isEdit;

    private WordRepositoryService wordRepositoryService;

    private MessageService messageService;

    public DetailWordRepositoryListener(SillyHatPageTable sillyHatPageTable,boolean isEdit){
        this.isEdit = isEdit;
        this.sillyHatPageTable = sillyHatPageTable;
        wordRepositoryService = (WordRepositoryService) SpringUtils.getInstance().getContext().getBean(WordRepositoryService.class);
        messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WordRepositoryDTO dto = null;
        String id = "";
        if(sillyHatPageTable.getTable().getSelectedRowCount() > 0){
            id = (String)sillyHatPageTable.getTable().getValueAt(sillyHatPageTable.getTable().getSelectedRow(), 0);
        }
        if(StringUtils.isEmpty(id) && isEdit){
            SillyHatJOptionPane.alert(messageService.getMessageZH("alert.reminder"),messageService.getMessageZH("alert.reminder.select.data"));
        }else{
            if(isEdit){
                //进入编辑界面
                dto = wordRepositoryService.getWordRepositoryById(id);
            }else{
                //进入新增界面
                dto = new WordRepositoryDTO();
            }
            WordRepositoryForm form = new WordRepositoryForm(SillyHatWindowUtils.getActiveWindow(),dto);
            form.openDialog();
            sillyHatPageTable.refreshTable();
        }
    }
}
