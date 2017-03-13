package com.sillyhat.swing.module.container.table;

import javax.swing.*;
import javax.swing.table.TableModel;

/**
 * 不可编辑的JTable
 */
public class SillyHatTable extends JTable{


    public SillyHatTable(){
        super();
    }

    public SillyHatTable(TableModel dm){
        super(dm);
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
