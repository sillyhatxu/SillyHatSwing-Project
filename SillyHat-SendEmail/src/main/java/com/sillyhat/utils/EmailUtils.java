package com.sillyhat.utils;

import com.sillyhat.dto.EmailDTO;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.log4j.Logger;

import java.io.File;


public class EmailUtils {
	
	private Logger logger = Logger.getLogger(EmailUtils.class);
	
	private static EmailUtils instance;
	
//	private String loginName;//账号
//	private String password;//密码
//	private String fromAddress;//发件人
//	private String toAddress;//收件人
//	private String hostName;//HostName
//	private String subject;//主题
//	private String adjunctPath;//附件路径
	
//	private List<EmailAttachment> accessoriesList;
//	private String body;//内容
	
	
	
//	public String getAdjunctPath() {
//		return adjunctPath;
//	}
//	public void setAdjunctPath(String adjunctPath) {
//		this.adjunctPath = adjunctPath;
//	}
//	public String getBody() {
//		return body;
//	}
//	public void setBody(String body) {
//		this.body = body;
//	}
	private EmailUtils(){
		
	}
	
	public static EmailUtils getInstance(){
		if(instance == null){
			instance = new EmailUtils();
		}
		return instance;
	}
	
	public synchronized boolean sendEmailTest(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}
	public synchronized boolean sendEmail(EmailDTO dto){
		try {
			MultiPartEmail email = new MultiPartEmail();
			//smtp host	smtp.163.com
		    email.setHostName(dto.getHostName());
		    email.setCharset("UTF-8");
		    // 登陆邮件服务器的用户名和密码
		    email.setAuthentication(dto.getLoginName(), dto.getPassword());
		    // 接收人
		    // email.addTo(getTo_address(),getFrom_nickname());
//		    for (int i = 0; i < to_addressList.size(); i++) {
//		     email.addTo(((String) to_addressList.get(i)),
//		       ((String) to_addressList.get(i)));
//		    }
		    email.addTo(dto.getToAddress());
		    // 抄送
//		    for (int i = 0; i < cc_to_addressList.size(); i++) {
//		     email.addCc(((String) cc_to_addressList.get(i)),
//		       ((String) cc_to_addressList.get(i)));
//		    }
		    // 密送
//		    for (int i = 0; i < bcc_to_addressList.size(); i++) {
//		     email.addBcc(((String) bcc_to_addressList.get(i)),
//		       ((String) bcc_to_addressList.get(i)));
//		    }
		    // 发送人
		    email.setFrom(dto.getFromAddress());
		    // 标题
		    email.setSubject(dto.getSubject());
		    // 邮件内容
//		    email.setMsg(getBody());
		    // 添加附件(附件，可以定义多个附件对象)
//		    for (int i = 0; i < this.accessoriesList.size(); i++) {
//		     EmailAttachment attachment = (EmailAttachment) this.accessoriesList
//		       .get(i);
//		     email.attach(attachment);
//		    }
		    //添加附件(附件，可以定义多个附件对象)
		    if(dto.getFileList() != null && dto.getFileList().size() > 0){
		    	for (File file : dto.getFileList()) {
		    		EmailAttachment attachment = new EmailAttachment();
		    	    attachment.setPath(file.getPath());
		    	    attachment.setDisposition(EmailAttachment.ATTACHMENT);
		    	    attachment.setDescription("邮件附件");
		    	    attachment.setName(file.getName());
		    	    email.attach(attachment);
				}
		    }
		    // 发送
		    email.send();
			return true;
		} catch (Exception e) {
			logger.error("发送邮件发生异常",e);
			return false;
		}
	}
}
