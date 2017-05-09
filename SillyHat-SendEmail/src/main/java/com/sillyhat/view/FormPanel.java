package com.sillyhat.view;

import com.sillyhat.utils.Constant;
import com.sillyhat.utils.ReadProperties;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends Panel{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -9186095470652331733L;

//	private JLabel jLabel = new JLabel("多个收件人，使用分号隔开");
	
//	public static final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	public static final JPanel upJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	public static final JPanel centerJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	public static final JPanel downJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
//	public static final JButton btnTestEmail = new JButton(Constant.BTN_NAME_TEST_EMAIL);
//	public static final JButton btnSendEmail = new JButton(Constant.BTN_NAME_SEND_EMAIL);
	
	
	private SillyHatJTextField user = new SillyHatJTextField("用户名：");
	private SillyHatJTextField password = new SillyHatJTextField("密码：");
	private SillyHatJTextField fromAddress = new SillyHatJTextField("发件人：");
	private SillyHatJTextField toAddress = new SillyHatJTextField("收件人：");
	private SillyHatJTextField subject = new SillyHatJTextField("主题：");
	private SillyHatJTextField hostName = new SillyHatJTextField("Host Name：");
	
//	public static JTextArea body = new JTextArea("", 10, 80);
	
//	public static JScrollPane bodyPanel = new JScrollPane();
//	public static final JTextPane body = new JTextPane();
//	2         textAreaOutput = new JTextArea("缩略词词典", 20, 43);
//	3         textAreaOutput.setSelectedTextColor(Color.RED);
//	4         textAreaOutput.setLineWrap(true);        //激活自动换行功能 
//	5         textAreaOutput.setWrapStyleWord(true);   
//	public static final SillyHatJTextField body = new SillyHatJTextField("发送邮件主题：");
//	public static final JLabel userJLabel = new JLabel("用户名：");
//	public static final JLabel passwordJLabel = new JLabel("密码：");
//	public static final JLabel sendEmailJLabel = new JLabel("发送邮件地址：");
//	public static final JLabel subjectJLabel = new JLabel("发送邮件主题：");
	
//	public static final JTextField userJTextField = new JTextField("", 20);
//	public static final JTextField passwordJTextField = new JTextField("", 20);
//	public static final JTextField sendEmailJTextField = new JTextField("", 20);
//	public static final JTextField subjectJTextField = new JTextField("", 20);
	
	

	/**
	 * <p>Title: registerEventListener</p>
	 * <p>Description: </p>为控件注册事件监听器
	 * @param 
	 * @author 徐士宽
	 * @date 2016-11-12
	 * @return:void
	 */
//	private void registerEventListener() {
//		btnTestEmail.addActionListener(new SendEmailListener(btnTestEmail,user,password,fromAddress,toAddress,hostName,subject));
//		btnSendEmail.addActionListener(new SendEmailListener(btnSendEmail,user,password,fromAddress,toAddress,hostName,subject));
//	}
	
	private void initSillyHatJTextField(){
		user.setText(ReadProperties.getValue(Constant.KEY_USER));
		user.setHorizontalAlignmentRight();
		user.setLablePreferredSize(100, 30);
		password.setText(ReadProperties.getValue(Constant.KEY_PASSWORD));
		password.setHorizontalAlignmentRight();
		password.setLablePreferredSize(100, 30);
		
		subject.setText(ReadProperties.getValue(Constant.KEY_SUBJECT));
		subject.setHorizontalAlignmentRight();
		subject.setLablePreferredSize(100, 30);
		hostName.setText(ReadProperties.getValue(Constant.KEY_HOST_NAME));
		hostName.setHorizontalAlignmentRight();
		hostName.setLablePreferredSize(100, 30);
		
		fromAddress.setText(ReadProperties.getValue(Constant.KEY_FROM_ADDRESS));
		fromAddress.setHorizontalAlignmentRight();
		fromAddress.setLablePreferredSize(100, 30);
		toAddress.setText(ReadProperties.getValue(Constant.KEY_TO_ADDRESS));
		toAddress.setHorizontalAlignmentRight();
		toAddress.setLablePreferredSize(100, 30);
	}
	
	public SillyHatJTextField getUser() {
		return user;
	}

	public SillyHatJTextField getPassword() {
		return password;
	}

	public SillyHatJTextField getFromAddress() {
		return fromAddress;
	}

	public SillyHatJTextField getToAddress() {
		return toAddress;
	}

	public SillyHatJTextField getSubject() {
		return subject;
	}

	public SillyHatJTextField getHostName() {
		return hostName;
	}

	public FormPanel(){
//		buttonPanel.add(btnTestEmail);
//		buttonPanel.add(btnSendEmail);
//		buttonPanel.add(jLabel);
		upJPanel.add(user);
		upJPanel.add(password);
		centerJPanel.add(subject);
		centerJPanel.add(hostName);
		downJPanel.add(fromAddress);
		downJPanel.add(toAddress);
//		body.setLineWrap(true);//自动换行
		
//		bodyPanel.setRowHeaderView(new LineNumberHeaderView());  
//		bodyPanel.setViewportView(body);
//		bodyPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		bodyPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
//		bodyJPanel.add(bodyPanel);
		initSillyHatJTextField();
//		registerEventListener();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); 
//		this.add(buttonPanel);
		this.add(upJPanel);
		this.add(centerJPanel);
		this.add(downJPanel);
//		this.add(bodyPanel);
	}
}
