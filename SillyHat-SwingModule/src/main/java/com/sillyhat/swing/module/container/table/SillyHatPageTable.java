package com.sillyhat.swing.module.container.table;

import com.sillyhat.swing.dto.PageDTO;
import com.sillyhat.swing.module.container.middle.SillyHatTabPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.Vector;

/**
 * 自定义分页表格
 */
public abstract class SillyHatPageTable extends SillyHatTabPanel {

    private JScrollPane jsp = new JScrollPane();

    private DefaultTableModel tableModel = null;

    private PageDTO page = null;

    private SillyHatTable table = null;

    private boolean isSingle = true;//默认表格单选

    private boolean isReorderingAllowed = true;//默认禁止拖拽

    private JPanel searchJPanel = null;
    private JToolBar operatorBar = null;
    private JPanel jToolBarPanel = null;

    private final JPanel btnJPanel = new JPanel();
    private final JLabel totalJLabel = new JLabel("共" + 0 + "条记录");
    private final JLabel pageJLabel = new JLabel("第" + 1 + "页");
    private final JButton btnHomePage = new JButton("首页");
    private final JButton btnUpPage = new JButton("上一页");
    private final JButton btnNextPage = new JButton("下一页");
    private final JButton btnLastPage = new JButton("最后一页");

    /**
     * @param panelCode
     * @Fields panelCode : panel唯一ID
     */
    public SillyHatPageTable(String panelCode) {
        super(panelCode);
        initPageButton();
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

    public void initTable(PageDTO page){
        this.page = page;
        tableModel = new DefaultTableModel(getRowData(page), getColumns());
        searchJPanel = getSearchJPanel();
        table = new SillyHatTable(tableModel);
        if(isSingle){
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        }
        if(isReorderingAllowed){
            table.getTableHeader().setReorderingAllowed(false);//禁止列拖拽
        }
        operatorBar = getJToolBar();
        operatorBar.setFloatable(isFixationJToolBar());//是否固定不允许拖动，默认不允许拖动
    }


    /**
     * 是否允许拖动JToolBar
     * @return
     */
    public boolean isFixationJToolBar(){
        return false;
    }

    /**
     * 默认左对齐
     * @return
     */
    public int getJToolBarFlow(){
        return FlowLayout.LEFT;
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
        if(searchJPanel != null){
            add(searchJPanel);
        }
        if(operatorBar != null){
            jToolBarPanel = new JPanel(new FlowLayout(getJToolBarFlow()));
            jToolBarPanel.add(operatorBar);
            add(jToolBarPanel);
        }
        //刷新table
        jsp.setViewportView(table);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));//全屏显示，占满panel
        add(jsp);
        add(btnJPanel);
    }


    public void addRow(){

    }

    public void editRow(){

    }

    /**
     * 初始化分页按钮
     */
    private void initPageButton(){
        btnJPanel.add(totalJLabel);
        btnJPanel.add(btnHomePage);
        btnJPanel.add(btnUpPage);
        btnJPanel.add(btnNextPage);
        btnJPanel.add(btnLastPage);
        btnJPanel.add(pageJLabel);
    }


    /**
     * 查询条件（需要时重写）
     * @return
     */
    public JPanel getSearchJPanel(){
        return null;
    }


    /**
     * 工具条（需要时重写）
     * @return
     */
    public JToolBar getJToolBar(){
        return null;
    }


    /**
     * 表格列名称
     * @param page      分页实体
     * @return
     */
    public abstract Vector<String> getColumns();

    /**
     * 表格内容
     * @return
     */
    public abstract Vector<Vector<String>> getRowData(PageDTO page);

    public SillyHatTable getTable() {
        return table;
    }

    public boolean isSingle() {
        return isSingle;
    }
}
