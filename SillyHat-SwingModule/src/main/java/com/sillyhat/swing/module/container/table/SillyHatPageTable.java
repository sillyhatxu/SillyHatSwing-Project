package com.sillyhat.swing.module.container.table;

import com.sillyhat.swing.dto.PageDTO;
import com.sillyhat.swing.module.container.middle.SillyHatTabPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.Vector;

/**
 * 自定义分页表格
 */
public abstract class SillyHatPageTable extends SillyHatTabPanel {

    private JScrollPane jsp = new JScrollPane();

    private DefaultTableModel tableModel = null;

    private PageDTO page;

    private SillyHatTable table = null;

    private JPanel searchJPanel = null;
    private final JButton btnSearch = new JButton("查询");

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
    public SillyHatPageTable(String panelCode,PageDTO page) {
        super(panelCode);
        this.page = page;
        initService();
        searchJPanel = getSearchJPanel();
        searchJPanel.add(btnSearch);
        if(searchJPanel != null){
            add(searchJPanel);
        }
        refreshTable();
        operatorBar = getJToolBar();
        operatorBar.setFloatable(isFixationJToolBar());//是否固定不允许拖动，默认不允许拖动
        if(operatorBar != null){
            jToolBarPanel = new JPanel(new FlowLayout(getJToolBarFlow()));
            jToolBarPanel.add(operatorBar);
            add(jToolBarPanel);
        }
        initPageButton();
        initButtonListener();
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));//全屏显示，占满panel
        add(jsp);
        add(btnJPanel);
    }

    private void initButtonListener(){
        btnSearch.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                clickSearch();
            }
        });
        btnHomePage.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                clickHomePage();
            }
        });
        btnUpPage.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                clickUpPage();
            }
        });
        btnNextPage.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                clickNextPage();
            }
        });
        btnLastPage.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                clickLastPage();
            }
        });
    }

    public void clickSearch(){

    }
    public void clickUpPage(){

    }
    public void clickHomePage(){

    }
    public void clickNextPage(){

    }
    public void clickLastPage(){

    }

    /**
     * 刷新表格
     */
    public void refreshTable(){
        tableModel = new DefaultTableModel(getRowData(page), getColumns());
        totalJLabel.setText("共" + getTotalCount(page) + "条记录");

        table = new SillyHatTable(tableModel);
        if(getSingleSelection()){
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        }
        table.getTableHeader().setReorderingAllowed(getReorderingAllowed());//禁止列拖拽
        //刷新table
        jsp.setViewportView(table);
    }

    public void initService(){

    }

    /**
     * 表格是否单选
     */
    public boolean getSingleSelection(){
        return true;//默认表格单选
    }

    /**
     * 设置表格是否禁止拖拽
     */
    public boolean getReorderingAllowed() {
        return false;//默认禁止拖拽
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
     * @return
     */
    public abstract Vector<String> getColumns();


    /**
     * 表格内容
     * @param page      分页实体
     * @return
     */
    public abstract Vector<Vector<String>> getRowData(PageDTO page);

    /**
     * 分页总数
     * @param page      分页实体
     * @return
     */
    public abstract int getTotalCount(PageDTO page);

    public SillyHatTable getTable() {
        return table;
    }


    public void setPageParams(Map<String,Object> params){
        page.setParams(params);
    }
}
