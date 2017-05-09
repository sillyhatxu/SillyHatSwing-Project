package com.sillyhat.view;

import com.sillyhat.dto.EmailDTO;
import com.sillyhat.utils.Constant;
import com.sillyhat.utils.EmailUtils;
import com.sillyhat.utils.ReadProperties;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.NumberFormat;
import java.util.Date;

public class EmailTask extends SwingWorker<Void, Void> {
	
	private Logger logger = Logger.getLogger(EmailTask.class);
	
//	private JLabel jLabel;
//	
//	private List<EmailDTO> list;
//	
//	private TablePanel tablePanel;
	
	private SillyHatProgressBar bar;
	
	public EmailTask(SillyHatProgressBar bar){
		this.bar = bar;
	}
	
	private void addRow(String fileName,String sendResult){
		bar.getTablePanel().addRow(fileName, sendResult, new Date());
	}
	
	@Override
	public Void doInBackground() {
		int sleep = 0;
		try {
			sleep = Integer.parseInt(ReadProperties.getValue("sendEmailIntervalSecond")) * 1000;
		} catch (Exception e) {
			logger.error("sendEmailIntervalSecond 不是int类型;默认等待时间是10s",e);
			sleep = 10000;
		}
		try {
			int total = bar.getList().size();
			bar.getjLabel().setText("共需要发送:" + total + "封邮件。");
			for (int i = 0; i < bar.getList().size(); i++) {
				if(i != 0){
					bar.getjLabel().setText("进入等待状态；剩余" + (total - (i+1)) + "邮件未发送");
					Thread.sleep(sleep);
				}
				EmailDTO dto = bar.getList().get(i);
				logger.info(dto.getFileList());
				if(EmailUtils.getInstance().sendEmail(dto)){
					for (File file: dto.getFileList()) {
						addRow(file.getName(),Constant.SEND_SUCCESS);
//						FileUtils.deleteFolder(file.getPath());
					}
				}else{
					for (File file: dto.getFileList()) {
						addRow(file.getName(), Constant.SEND_ERROR);
					}
				}
				logger.info("i" + i);
				// 创建一个数值格式化对象  
		        NumberFormat numberFormat = NumberFormat.getInstance();  
		        // 设置精确到小数点后2位  
		        numberFormat.setMaximumFractionDigits(0); 
		        String result = numberFormat.format((float) i / (float) total * 100);
				logger.info("result" + Integer.parseInt(result));
				setProgress(Integer.parseInt(result));
			}
		} catch (Exception e) {
			logger.error("定时任务出现异常",e);
		}
		return null;
	}

	@Override
	public void done() {
		logger.info("done");
		Toolkit.getDefaultToolkit().beep();
		bar.closeDialog();
	}
}
