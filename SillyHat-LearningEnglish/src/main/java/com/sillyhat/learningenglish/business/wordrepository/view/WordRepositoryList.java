package com.sillyhat.learningenglish.business.wordrepository.view;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.wordrepository.dto.WordRepositoryDTO;
import com.sillyhat.learningenglish.business.wordrepository.listener.DetailWordRepositoryListener;
import com.sillyhat.learningenglish.business.wordrepository.listener.RemoveWordRepositoryListener;
import com.sillyhat.learningenglish.business.wordrepository.service.WordRepositoryService;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.dto.PageDTO;
import com.sillyhat.swing.module.basic.SillyHatInputText;
import com.sillyhat.swing.module.container.table.SillyHatPageTable;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

/**
 * Created by ${XUSHIKUAN} on 2017-03-12.
 */
public class WordRepositoryList extends SillyHatPageTable {

    private MessageService messageService;

    private WordRepositoryService wordRepositoryService;

    public WordRepositoryList(String panelCode) {
        super(panelCode);
        messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
        wordRepositoryService = (WordRepositoryService) SpringUtils.getInstance().getContext().getBean(WordRepositoryService.class);
//        debugFrame(Color.red);
    }

    @Override
    public JPanel getSearchJPanel() {
        JPanel searchJPanel = new JPanel();
        searchJPanel.add(new SillyHatInputText("这里有查询",80, 30, "",20));
        return searchJPanel;
    }

    @Override
    public JToolBar getJToolBar() {
        JToolBar operatorBar = new JToolBar();
        JButton btnAdd = new JButton(messageService.getMessageZH("btn.add"));
        JButton btnEdit = new JButton(messageService.getMessageZH("btn.edit"));
        JButton btnRemove = new JButton(messageService.getMessageZH("btn.remove"));
        btnAdd.addActionListener(new DetailWordRepositoryListener(this.getTable(),false));
        btnEdit.addActionListener(new DetailWordRepositoryListener(this.getTable(),true));
        btnRemove.addActionListener(new RemoveWordRepositoryListener());
        operatorBar.add(btnAdd);
        operatorBar.add(btnEdit);
        operatorBar.add(btnRemove);
        return operatorBar;
    }

    public Vector<String> getColumns() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("");
        columnNames.add(messageService.getMessageZH("word.repository.word"));
        columnNames.add(messageService.getMessageZH("word.repository.phonetic"));
        columnNames.add(messageService.getMessageZH("word.repository.reminder"));
        columnNames.add(messageService.getMessageZH("word.repository.word.translate"));
        columnNames.add(messageService.getMessageZH("public.label.created.user"));
        columnNames.add(messageService.getMessageZH("public.label.created.date"));
        columnNames.add(messageService.getMessageZH("public.label.updated.user"));
        columnNames.add(messageService.getMessageZH("public.label.updated.date"));
        return columnNames;
    }

    public Vector<Vector<String>> getRowData(PageDTO page) {
        Vector<Vector<String>> rowData = new Vector<Vector<String>>();
        List<WordRepositoryDTO> list = wordRepositoryService.queryWordRepositoryByPage(page);
        for (WordRepositoryDTO dto : list) {
            Vector<String> iColumns = new Vector<String>();
            iColumns.add(dto.getId());
            iColumns.add(dto.getWord());
            iColumns.add(dto.getPhonetic());
            iColumns.add(dto.getReminder());
            iColumns.add(dto.getWordTranslate());
            iColumns.add(dto.getCreatedUser());
            iColumns.add(dto.getCreatedDate());
            iColumns.add(dto.getUpdatedUser());
            iColumns.add(dto.getUpdatedDate());
            rowData.add(iColumns);
        }
        return rowData;
    }

    @Override
    public int getTotalCount(PageDTO page) {
        return wordRepositoryService.queryWordRepositoryTotalCountByPage(page);
    }
}
