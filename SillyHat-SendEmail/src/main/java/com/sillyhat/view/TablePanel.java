package com.sillyhat.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class TablePanel extends Panel{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -9186095470652331733L;
	
	private SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static JScrollPane jsp = new JScrollPane();
	
	public static DefaultTableModel tableModel = null;
	
	public static JTable table = null;
	
	private int serialNumber = 0;
	
	private void initTable(){
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("序号");
		columnNames.add("文件名称");
		columnNames.add("发送结果");
		columnNames.add("发送时间");
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		tableModel = new DefaultTableModel(rowData, columnNames);
		table = new JTable(tableModel);
	}
	
	public TablePanel(){
		initTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//单选
		table.getTableHeader().setReorderingAllowed(false);//禁止列拖拽
		jsp.setViewportView(table);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(jsp);
	}
	
	public void addRow(String fileName,String sendResult,Date sendTime){
		serialNumber++;
		String[] rowValues = {serialNumber+"",fileName,sendResult,sdfTime.format(sendTime)};
		tableModel.addRow(rowValues); // 添加一行
	}
	
}
