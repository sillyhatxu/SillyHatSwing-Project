package com.sillyhat.main;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class SillyHatProgressBar extends JDialog  implements PropertyChangeListener {

	private Logger logger = Logger.getLogger(SillyHatProgressBar.class);
	
	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -3394725058036941342L;

	private ProgressMonitor progressMonitor;
	
	private EmailTask task;
	
	public SillyHatProgressBar(){
		super();
		initProgressBar("");
	}
	
	public SillyHatProgressBar(String barName){
		this();
		initProgressBar(barName);
		task = new EmailTask();
		task.addPropertyChangeListener(this);
		task.execute();
	}
	
	private void initProgressBar(String barName){
		progressMonitor = new ProgressMonitor(SillyHatProgressBar.this,barName, "", 0, 100);
		progressMonitor.setProgress(0);
	}

	public void showDialog(){
		setVisible(true);
	}
	
	public void closeDialog(){
		if(progressMonitor != null){
			progressMonitor.setProgress(0);
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
			progressMonitor.setProgress(progress);
			String message = String.format("Completed %d%%.\n", progress);
			progressMonitor.setNote(message);
		}
	}
	
	
	public void setBarProgress(int value){
		progressMonitor.setProgress(value);
	}
}
