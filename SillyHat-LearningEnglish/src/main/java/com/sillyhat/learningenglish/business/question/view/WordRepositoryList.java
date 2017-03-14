package com.sillyhat.learningenglish.business.question.view;

import com.sillyhat.learningenglish.business.wordrepository.listener.DetailWordRepositoryListener;
import com.sillyhat.learningenglish.business.wordrepository.listener.RemoveWordRepositoryListener;
import com.sillyhat.swing.module.basic.SillyHatInputText;
import com.sillyhat.swing.module.container.table.SillyHatPageTable;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by ${XUSHIKUAN} on 2017-03-12.
 */
public class WordRepositoryList extends SillyHatPageTable {

    public WordRepositoryList(String panelCode) {
        super(panelCode);
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
        columnNames.add("序号");
        columnNames.add("公司编号");
        columnNames.add("部门编号");
        columnNames.add("部门名称");
        columnNames.add("部门层级");
        columnNames.add("父节点编号");
        columnNames.add("是否删除");
        columnNames.add("是否删除");
        columnNames.add("是否删除");
        columnNames.add("是否删除");
        columnNames.add("是否删除");
        columnNames.add("是否删除");
        return columnNames;
    }

    public Vector<Vector<String>> getRowData() {
        Vector<Vector<String>> rowData = new Vector<Vector<String>>();
        for (int i = 1; i <= 100; i++) {
            Vector<String> iColumns = new Vector<String>();
            for (int j = 1; j <= 8; j++) {
                iColumns.add(i + "-" + j);
            }
            rowData.add(iColumns);
        }
        return rowData;
    }
}
