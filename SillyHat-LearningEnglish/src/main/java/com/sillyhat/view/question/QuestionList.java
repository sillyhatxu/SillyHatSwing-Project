package com.sillyhat.view.question;

import com.sillyhat.swing.module.container.table.SillyHatPageTable;

import java.awt.*;
import java.util.Vector;

/**
 * Created by ${XUSHIKUAN} on 2017-03-12.
 */
public class QuestionList extends SillyHatPageTable {

    public QuestionList(String panelCode) {
        super(panelCode);
        debugFrame(Color.red);
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
