package com.sillyhat.main;

import com.sillyhat.utils.Constant;
import com.sillyhat.view.ViewForm;
import org.apache.log4j.Logger;

import javax.swing.*;

public class MainApp extends ViewForm{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = 5591913916650633331L;
	
	private Logger logger = Logger.getLogger(MainApp.class);
	
	private void initWindows(){
		setTitle(Constant.PROJECT_NAME);
		setSize(800,650);
//		setLocation(150, 150);
		setLocationRelativeTo(null);
	}
	
	public MainApp(){
		initWindows();
		getContentPane().add(northPanel, Constant.LAYOUT_NORTH);
		getContentPane().add(centerPanel, Constant.LAYOUT_CENTER);
		getContentPane().add(southPanel, Constant.LAYOUT_SOUTH);
	}
	
	public static void main(String[] args) {
//		System.out.println(Constant.PROJECT_PATH);
//		System.out.println(Constant.PROJECT_PATH + Constant.FILE_PATH);
		MainApp windows = new MainApp();
//		JButton test = new JButton("test");
//		test.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				JDialog test = new JDialog();
//				test.setVisible(true);
//				SillyHatProgressBar progressBar = new SillyHatProgressBar("测试");
//				progressBar.setModal(true);
//				progressBar.showDialog();
				
//				for (int i = 1; i <= 100; i++) {
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e1) {
//						e1.printStackTrace();
//					}
//					progressBar.setBarProgress(i);
//				}
//			}
//		});
//		windows.add(test);
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.setVisible(true);
	}
}
    