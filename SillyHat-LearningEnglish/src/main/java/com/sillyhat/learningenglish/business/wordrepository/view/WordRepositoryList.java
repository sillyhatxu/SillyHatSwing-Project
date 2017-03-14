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
        JButton btnAdd = new JButton("新增");
        JButton btnEdit = new JButton("修改");
        JButton btnRemove = new JButton("删除");
        btnAdd.addActionListener(new DetailWordRepositoryListener(this.getTable()));
        btnEdit.addActionListener(new DetailWordRepositoryListener(this.getTable()));
        btnRemove.addActionListener(new RemoveWordRepositoryListener());
        operatorBar.add(btnAdd);
        operatorBar.add(btnEdit);
        operatorBar.add(btnRemove);
        return operatorBar;
    }

    public Vector<String> getColumns() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("ID");
        columnNames.add("单词");
        columnNames.add("音标");
        columnNames.add("提示");
        columnNames.add("翻译");
        columnNames.add("创建人");
        columnNames.add("创建时间");
        columnNames.add("修改人");
        columnNames.add("修改时间");
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
            iColumns.add(dto.getTranslate());
            iColumns.add(dto.getCreatedUser());
//            iColumns.add(dto.getCreatedDate());
            iColumns.add("");
            iColumns.add(dto.getUpdatedUser());
//            iColumns.add(dto.getUpdatedDate());
            iColumns.add("");
            rowData.add(iColumns);
        }
        return rowData;
    }
}
