package com.sillyhat.swing.module.container.table;

import com.sillyhat.swing.module.container.middle.SillyHatTabPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.Vector;

/**
 * 自定义分页表格
 */
public abstract class SillyHatPageTable extends SillyHatTabPanel {

    private static JScrollPane jsp = new JScrollPane();

    private static DefaultTableModel tableModel = new DefaultTableModel(0,0);

    private static JTable table = new JTable(tableModel);
//    private static SillyHatTable table1 = new SillyHatTable(tableModel);



    private boolean isSingle = true;//默认表格单选

    private boolean isReorderingAllowed = true;//默认禁止拖拽

    public static final JLabel totalJLabel = new JLabel("共" + 0 + "条记录");
    public static final JLabel pageJLabel = new JLabel("第" + 1 + "页");
    public static final JButton btnHomePage = new JButton("首页");
    public static final JButton btnUpPage = new JButton("上一页");
    public static final JButton btnNextPage = new JButton("下一页");
    public static final JButton btnLastPage = new JButton("最后一页");

    /**
     * @param panelCode
     * @Fields panelCode : panel唯一ID
     */
    public SillyHatPageTable(String panelCode) {
        super(panelCode);
    }

    /**
     * initTable前设置表格是否单选
     * @param isSingle
     */
    public void setSingleSelection(boolean isSingle){
        this.isSingle = isSingle;
    }

    /**
     * initTable前设置表格是否禁止拖拽
     * @param reorderingAllowed
     */
    public void setReorderingAllowed(boolean reorderingAllowed) {
        this.isReorderingAllowed = reorderingAllowed;
    }

    public void initTable(){
        tableModel = new DefaultTableModel(getRowData(), getColumns());
        table = new JTable(tableModel);
        if(isSingle){
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        }
        if(isReorderingAllowed){
            table.getTableHeader().setReorderingAllowed(false);//禁止列拖拽
        }
    }

    /**
     * 隐藏某一列
     * @param columnNumber
     */
    public void hiddenColumn(int columnNumber){
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column = columnModel.getColumn(columnNumber);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
    }

    /**
     * 刷新表格
     */
    public void refreshTable(){
        //刷新table
        jsp.setViewportView(table);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));//全屏显示，占满panel
        add(jsp);
    }

    public void addRow(){

    }

    public void editRow(){

    }

    /**
     * 表格列名称
     * @return
     */
    public abstract Vector<String> getColumns();

    /**
     * 表格内容
     * @return
     */
    public abstract Vector<Vector<String>> getRowData();

    public static JTable getTable() {
        return table;
    }

    public boolean isSingle() {
        return isSingle;
    }
}
