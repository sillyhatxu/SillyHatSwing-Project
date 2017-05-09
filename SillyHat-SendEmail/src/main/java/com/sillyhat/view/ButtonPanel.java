package com.sillyhat.view;

import com.sillyhat.listener.SendEmailListener;
import com.sillyhat.utils.Constant;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends Panel{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -9186095470652331733L;

	private JLabel jLabel = new JLabel("多个收件人，使用分号隔开");
	
	public static final JButton btnTestEmail = new JButton(Constant.BTN_NAME_TEST_EMAIL);
	public static final JButton btnSendEmail = new JButton(Constant.BTN_NAME_SEND_EMAIL);
//	public static final JButton test = new JButton("test");
	
	private FormPanel formPanel;//表单
	
	private TablePanel tablePanel;//表格
	
	/**
	 * <p>Title: registerEventListener</p>
	 * <p>Description: </p>为控件注册事件监听器
	 * @param 
	 * @author 徐士宽
	 * @date 2016-11-12
	 * @return:void
	 */
	private void registerEventListener() {
//		btnTestEmail.addActionListener(new SendEmailListener(btnTestEmail,user,password,fromAddress,toAddress,hostName,subject));
//		btnSendEmail.addActionListener(new SendEmailListener(btnSendEmail,user,password,fromAddress,toAddress,hostName,subject));
		btnTestEmail.addActionListener(new SendEmailListener(btnTestEmail,formPanel,tablePanel));
		btnSendEmail.addActionListener(new SendEmailListener(btnSendEmail,formPanel,tablePanel));
//		btnSendEmail.addActionListener(new SendEmailListener(test,formPanel,tablePanel));
	}
	
	
//	private ButtonPanel(){
//		registerEventListener();
//		this.setLayout(new FlowLayout(FlowLayout.LEFT));
//		this.add(btnTestEmail);
//		this.add(btnSendEmail);
//		this.add(jLabel);
//	}
	
	public ButtonPanel(FormPanel formPanel,TablePanel tablePanel){
		this.formPanel = formPanel;
		this.tablePanel = tablePanel;
		registerEventListener();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(btnTestEmail);
		this.add(btnSendEmail);
//		this.add(test);
		this.add(jLabel);
	}
}
