package com.sillyhat.swing.module.container.table;

import com.sillyhat.swing.dto.PageDTO;
import com.sillyhat.swing.module.container.middle.SillyHatTabPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Vector;

/**
 * 自定义分页表格
 */
public abstract class SillyHatPageTable extends SillyHatTabPanel {


    private PageDTO page;

    /****************** 查询 Panel ******************************/
    private JPanel searchContextJPanel = null;
    private JPanel searchButtonJPanel = null;
    private final JButton btnSearch = new JButton("查询");


    /****************** 工具按钮 ToolBarPanel ******************************/
    private JPanel jToolBarPanel = null;
    private JToolBar operatorBar = null;
    private final JPanel btnJPanel = new JPanel();
    private final JLabel totalBeginJLabel = new JLabel("共");
    private final JLabel totalJLabel = new JLabel("0");
    private final JLabel totalEndJLabel = new JLabel("条记录");

    private final JLabel pageBeginJLabel = new JLabel("第");
    private final JLabel pageCurrentJLabel = new JLabel("1");
    private final JLabel pageMiddleJLabel = new JLabel("页/共");
    private final JLabel pageTotalJLabel = new JLabel("1");
    private final JLabel pageEndJLabel = new JLabel("页");

    private final JButton btnHomePage = new JButton("首页");
    private final JButton btnUpPage = new JButton("上一页");
    private final JButton btnNextPage = new JButton("下一页");
    private final JButton btnLastPage = new JButton("最后一页");

    /****************** 表格内容 Tabel ******************************/
    private JScrollPane jsp = null;
    private DefaultTableModel tableModel = null;
    private SillyHatTable table = null;

    /**
     * 初始化搜索Panel
     */
    private void initComponentsSearchContextJPanel(){
        searchContextJPanel = new JPanel();
        searchButtonJPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchButtonJPanel.add(btnSearch);
        JPanel searchJPanel = getSearchJPanel();
        searchContextJPanel.add(searchJPanel);
        searchContextJPanel.add(searchButtonJPanel);
//        searchJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        searchContextJPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
//        searchButtonJPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    /**
     * 初始化工具条
     */
    private void initComponentsToolBar(){
        operatorBar = getJToolBar();
        if(operatorBar != null){
            operatorBar.setFloatable(isFixationJToolBar());//是否固定不允许拖动，默认不允许拖动
            jToolBarPanel = new JPanel(new FlowLayout(getJToolBarFlow()));
            jToolBarPanel.add(operatorBar);
        }
    }

    /**
     * 初始化分页按钮
     */
    private void initComponentsPageButton(){
        btnJPanel.add(totalBeginJLabel);
        btnJPanel.add(totalJLabel);
        btnJPanel.add(totalEndJLabel);
        btnJPanel.add(btnHomePage);
        btnJPanel.add(btnUpPage);
        btnJPanel.add(btnNextPage);
        btnJPanel.add(btnLastPage);
        btnJPanel.add(pageBeginJLabel);
        btnJPanel.add(pageCurrentJLabel);
        btnJPanel.add(pageMiddleJLabel);
        btnJPanel.add(pageTotalJLabel);
        btnJPanel.add(pageEndJLabel);
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
                page.setCurrentPage(1);

                refreshTable();
            }
        });
        btnUpPage.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                clickUpPage();
                page.setCurrentPage(page.getCurrentPage() - 1);
                refreshTable();
            }
        });
        btnNextPage.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                clickNextPage();
                page.setCurrentPage(page.getCurrentPage() + 1);
                refreshTable();
            }
        });
        btnLastPage.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                clickLastPage();
                page.setCurrentPage(page.getTotalPage());
                refreshTable();
            }
        });
    }

    /**
     * 初始化组件
     */
    private void initComponents(){
        initComponentsSearchContextJPanel();//初始化搜索Panel
        initComponentsToolBar();//初始化工具条
        initComponentsPageButton();//初始化分页按钮
        initButtonListener();//添加按钮监听
        jsp = new JScrollPane();
    }
    /**
     * @param panelCode panel唯一ID
     */
    public SillyHatPageTable(String panelCode) {
        super(panelCode);
        initService();//业务初始化Service
        initComponents();//初始化组件
        add(searchContextJPanel);//加载查询区域
        add(jToolBarPanel);//加载工具按钮区域
        initTable();
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));//全屏显示，占满panel
        add(jsp);
        add(btnJPanel);
    }

    /**
     * 刷新表格
     */
    public void initTable(){
        this.page = new PageDTO();//刷新页面，重新刷新分页实体
        refreshTable();
    }

    public void refreshTable(){
        tableModel = new DefaultTableModel(getRowData(page), getColumns());
        page.setTotalCount(getTotalCount(page));
        computePage();

        table = new SillyHatTable(tableModel);
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                tableKeyPressed(e);
            }
        });

        if(getSingleSelection()){
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
        }
        table.getTableHeader().setReorderingAllowed(getReorderingAllowed());//禁止列拖拽

        hiddenColumn(getHiddenColumns());
        //刷新table
        jsp.setViewportView(table);
    }

    private void computePage(){
        totalJLabel.setText(page.getTotalCount()+"");
        pageCurrentJLabel.setText(page.getCurrentPage()+"");
        pageTotalJLabel.setText(page.getTotalPage()+"");
        refreshButton();
    }

    private void refreshButton(){
        if(page.getTotalPage() == 1 || page.getTotalPage() == 0){
            btnHomePage.setEnabled(false);
            btnUpPage.setEnabled(false);
            btnNextPage.setEnabled(false);
            btnLastPage.setEnabled(false);
        }else{
            if(page.getCurrentPage() == 1){
                btnHomePage.setEnabled(false);
                btnUpPage.setEnabled(false);
                btnNextPage.setEnabled(true);
                btnLastPage.setEnabled(true);
            }else if(page.getCurrentPage() == page.getTotalPage()){
                btnHomePage.setEnabled(true);
                btnUpPage.setEnabled(true);
                btnNextPage.setEnabled(false);
                btnLastPage.setEnabled(false);
            }else{
                btnHomePage.setEnabled(true);
                btnUpPage.setEnabled(true);
                btnNextPage.setEnabled(true);
                btnLastPage.setEnabled(true);
            }
        }
    }

    /**
     * 隐藏某一列
     * @param columnNumber
     */
    private void hiddenColumn(int columnNumber){
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column = columnModel.getColumn(columnNumber);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
    }

    private void hiddenColumn(int... intArray){
        if(intArray != null){
            for(int column : intArray){
                hiddenColumn(column);
            }
        }
    }

    /********************重写区域 Begin****************************/

    /**
     * 业务初始化service
     */
    public void initService(){

    }

    /**
     * 查询条件（需要时重写）
     * @return
     */
    public JPanel getSearchJPanel(){
        JPanel searchJPanel = new JPanel();
        return searchJPanel;
    }

    /**
     * 工具条（需要时重写）
     * @return
     */
    public JToolBar getJToolBar(){
        return null;
    }

    /**
     * 是否允许拖动JToolBar
     * @return
     */
    public boolean isFixationJToolBar(){
        return false;
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

    public void tableKeyPressed(KeyEvent e){

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
     * 默认左对齐
     * @return
     */
    public int getJToolBarFlow(){
        return FlowLayout.LEFT;
    }

    /**
     * 获取隐藏列数
     * @return
     */
    public int [] getHiddenColumns(){
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

    /********************重写区域 End****************************/
}
