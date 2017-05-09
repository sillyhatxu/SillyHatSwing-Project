package com.sillyhat.listener;

import com.sillyhat.dto.EmailDTO;
import com.sillyhat.utils.Constant;
import com.sillyhat.utils.FileUtils;
import com.sillyhat.view.FormPanel;
import com.sillyhat.view.SillyHatProgressBar;
import com.sillyhat.view.TablePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SendEmailListener implements ActionListener {

	private JButton thisButton;
	
//	private SillyHatJTextField user;//账号
//	private SillyHatJTextField password;//密码
//	private SillyHatJTextField fromAddress;//发件人
//	private SillyHatJTextField toAddress;//收件人
//	private SillyHatJTextField hostName;//HostName
//	private SillyHatJTextField subject;//主题
	
	private FormPanel formPanel;//表单
	private TablePanel tablePanel;//表格
	private String filePath = Constant.PROJECT_PATH + Constant.FILE_PATH;//文件路径
	
	private SendEmailListener(){
		super();
	}
	
//	public SendEmailListener(JButton thisButton,SillyHatJTextField user,SillyHatJTextField password,SillyHatJTextField fromAddress,
//			SillyHatJTextField toAddress,SillyHatJTextField hostName,SillyHatJTextField subject){
//		this();
//		this.thisButton = thisButton;
//		this.user = user;
//		this.password = password;
//		this.fromAddress = fromAddress;
//		this.toAddress = toAddress;
//		this.hostName = hostName;
//		this.subject = subject;
//	}
	public SendEmailListener(JButton thisButton,FormPanel formPanel,TablePanel tablePanel){
		this();
		this.thisButton = thisButton;
		this.formPanel = formPanel;
		this.tablePanel = tablePanel;
//		this.thisButton = thisButton;
//		this.user = user;
//		this.password = password;
//		this.fromAddress = fromAddress;
//		this.toAddress = toAddress;
//		this.hostName = hostName;
//		this.subject = subject;
	}
	
	private boolean isEmpty(String object){
		if(object != null && object.length() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	private boolean checkText(){
		if(isEmpty(formPanel.getUser().getText())){
			return false;
		}else if(isEmpty(formPanel.getPassword().getText())){
			return false;
		}else if(isEmpty(formPanel.getFromAddress().getText())){
			return false;
		}else if(isEmpty(formPanel.getToAddress().getText())){
			return false;
		}else if(isEmpty(formPanel.getHostName().getText())){
			return false;
		}else if(isEmpty(formPanel.getSubject().getText())){
			return false;
		}
		return true;
	}
	
	
	private void sendTestEmail(EmailDTO dto){
		String fileName = Constant.DEFAULT_TEST_ADJUNCT_NAME;
		String filePathName = filePath + fileName;
		FileUtils.writeTextFile(filePathName, "此附件为测试附件");
		List<File> fileList = FileUtils.readDirectoryFile(filePathName);
	    dto.setFileList(fileList);
	    List<EmailDTO> list = new ArrayList<EmailDTO>();
	    list.add(dto);
	    sendEmail(list);
//		instance.sendEmail();
//		if(instance.sendEmailTest()){
//			addRow(fileName, Constant.SEND_SUCCESS);
//			FileUtils.deleteFolder(filePathName);
//		}else{
//			addRow(fileName, Constant.SEND_ERROR);
//		}
		
	}
	
	private void sendEmail(EmailDTO dto){
		List<File> fileList = FileUtils.readDirectoryFile(filePath);
		List<EmailDTO> list = new ArrayList<EmailDTO>();
		for (int i = 0; i < fileList.size(); i++) {
			EmailDTO newDTO = new EmailDTO();
			newDTO.setLoginName(dto.getLoginName());//账号
			newDTO.setPassword(dto.getPassword());//密码
			newDTO.setFromAddress(dto.getFromAddress());//发件人
			newDTO.setToAddress(dto.getToAddress());//收件人
			newDTO.setHostName(dto.getHostName());//HostName
			newDTO.setSubject(dto.getSubject());//主题
			File file = fileList.get(i);
			List<File> accessoriesList = new ArrayList<File>();
			accessoriesList.add(file);
			newDTO.setFileList(accessoriesList);
		    list.add(newDTO);
		}
		sendEmail(list);
//		instance.sendEmail()
//		if(instance.sendEmailTest()){
//			addRow(fileName, Constant.SEND_SUCCESS);
//		}else{
//			addRow(fileName, Constant.SEND_ERROR);
//		}
	}
	
	private void sendEmail(List<EmailDTO> list){
		SillyHatProgressBar progressBar = new SillyHatProgressBar(Constant.BAR_NAME, list, tablePanel);
		progressBar.setModal(true);
		progressBar.showDialog();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(!checkText()){
			JOptionPane.showMessageDialog(null, "文本框中需要设置相应的信息。" , "警告",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		FileUtils.makeDir(filePath);
		EmailDTO dto = new EmailDTO();
		dto.setLoginName(formPanel.getUser().getText());
		dto.setPassword(formPanel.getPassword().getText());
		dto.setFromAddress(formPanel.getFromAddress().getText());
		dto.setToAddress(formPanel.getToAddress().getText());
		dto.setHostName(formPanel.getHostName().getText());
		dto.setSubject(formPanel.getSubject().getText());
		if(thisButton.getText().equals(Constant.BTN_NAME_TEST_EMAIL)){
			sendTestEmail(dto);
		}else if(thisButton.getText().equals(Constant.BTN_NAME_SEND_EMAIL)){
			sendEmail(dto);
		}else{
			
		}
	}
}
