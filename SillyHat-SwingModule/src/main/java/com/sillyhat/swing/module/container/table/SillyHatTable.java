package com.sillyhat.swing.module.container.table;

import javax.swing.*;
import javax.swing.table.TableModel;

/**
 * Created by ${XUSHIKUAN} on 2017-03-12.
 */
public class SillyHatTable extends JTable{


    public SillyHatTable(){
        super();
    }

    public SillyHatTable(TableModel dm){
        super(dm);
    }
}
