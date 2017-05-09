package com.sillyhat.view;

import com.sillyhat.dto.EmailDTO;
import com.sillyhat.utils.Constant;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;


public class SillyHatProgressBar extends JDialog  implements PropertyChangeListener{

	private Logger logger = Logger.getLogger(SillyHatProgressBar.class);
	
	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -3394725058036941342L;

	private JLabel jLabel;
	
	private JProgressBar progressBar;
	
	private EmailTask task;
	
	private String barName;
	private List<EmailDTO> list;
	private TablePanel tablePanel;
	
	
	public JLabel getjLabel() {
		return jLabel;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public List<EmailDTO> getList() {
		return list;
	}

	public TablePanel getTablePanel() {
		return tablePanel;
	}

	private SillyHatProgressBar(){
		super();
	}
	
	public SillyHatProgressBar(String barName,List<EmailDTO> list,TablePanel tablePanel){
		this();
		setSize(300,100);
		setLocationRelativeTo(null);
		this.barName = barName;
		this.list = list;
		this.tablePanel = tablePanel;
		initProgressBar();
	}
	
	private void initProgressBar(){
		jLabel = new JLabel("正在准备发送邮件。");
		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		setTitle(barName);
		add(progressBar);
		task = new EmailTask(this);
		task.addPropertyChangeListener(this);
		task.execute();
		getContentPane().add(jLabel, Constant.LAYOUT_NORTH);
		getContentPane().add(progressBar, Constant.LAYOUT_CENTER);
	}

	public void showDialog(){
		setVisible(true);
	}
	
	public void closeDialog(){
		if(progressBar != null){
			progressBar.setValue(0);
		}
		setVisible(false);
	}

	/* (非 Javadoc) 
	 * <p>Title: setProgress值改变事件</p> 
	 * <p>Description: </p> 
	 * @param evt 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent) 
	 */ 
	public void propertyChange(PropertyChangeEvent evt) {
		logger.info("propertyChange----------" + evt.getPropertyName());
		if ("progress" == evt.getPropertyName()) {
			int progress = (Integer) evt.getNewValue();
			logger.info("propertyChange---" + progress);
			progressBar.setValue(progress);
		}
	}
	
}
