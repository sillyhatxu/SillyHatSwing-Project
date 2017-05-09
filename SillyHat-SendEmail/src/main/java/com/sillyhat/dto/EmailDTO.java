package com.sillyhat.dto;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class EmailDTO implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = 134272018324304257L;
	
	private String loginName;//账号
	private String password;//密码
	private String fromAddress;//发件人
	private String toAddress;//收件人
	private String hostName;//HostName
	private String subject;//主题
	private List<File> fileList;//附件列表
//	private List<EmailAttachment> accessoriesList;//附件列表
//	private List<String> fileNameList;//附件名称
	
	public String getLoginName() {
		return loginName;
	}
	
//	public List<EmailAttachment> getAccessoriesList() {
//		return accessoriesList;
//	}
//
//	public void setAccessoriesList(List<EmailAttachment> accessoriesList) {
//		this.accessoriesList = accessoriesList;
//	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<File> getFileList() {
		return fileList;
	}

	public void setFileList(List<File> fileList) {
		this.fileList = fileList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailDTO [loginName=");
		builder.append(loginName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", fromAddress=");
		builder.append(fromAddress);
		builder.append(", toAddress=");
		builder.append(toAddress);
		builder.append(", hostName=");
		builder.append(hostName);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", fileList=");
		builder.append(fileList);
		builder.append("]");
		return builder.toString();
	}

//	public List<String> getFileNameList() {
//		return fileNameList;
//	}
//
//	public void setFileNameList(List<String> fileNameList) {
//		this.fileNameList = fileNameList;
//	}
	
	
}
