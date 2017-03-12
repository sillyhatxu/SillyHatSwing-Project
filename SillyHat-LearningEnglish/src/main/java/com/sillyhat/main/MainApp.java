package com.sillyhat.main;

import com.sillyhat.listener.function.ExitListener;
import com.sillyhat.listener.function.PersonalInformationListener;
import com.sillyhat.listener.function.TheQuestionEntryListener;
import com.sillyhat.swing.exception.SillyHatException;
import com.sillyhat.swing.module.basic.SillyHatJMenu;
import com.sillyhat.swing.module.basic.SillyHatJMenuItem;
import com.sillyhat.view.main.ViewForm;

public class MainApp extends ViewForm{
	
	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -690238177122305692L;

	public MainApp(){
		setTitleName("帽子学习系统");
//		setWindowSize(1000,800);
		setWindowSize(1000,500);
		setWindowLocation(null);
		initJMenuBar();
		setTopJMenuBar(jMenuBar);
		setborderLayoutCenter(centerPanel);
	}
	
	private void initJMenuBar(){
		jMenu = new SillyHatJMenu("功能");
		
		jMenuButton = new SillyHatJMenuItem("个人信息",new PersonalInformationListener(centerPanel));
		jMenu.addMenuButton(jMenuButton);
		
		jMenuButton = new SillyHatJMenuItem("题库录入", new TheQuestionEntryListener(centerPanel));
		jMenu.addMenuButton(jMenuButton);
		
		jMenuButton = new SillyHatJMenuItem("选择答题");
		jMenu.addMenuButton(jMenuButton);
		
		jMenuBar.addMenu(jMenu);
		
		jMenu = new SillyHatJMenu("帮助");
		
		jMenuButton = new SillyHatJMenuItem("帮助文档");
		jMenu.addMenuButton(jMenuButton);
		
		jMenuButton = new SillyHatJMenuItem("关于本系统");
		jMenu.addMenuButton(jMenuButton);
		
		jMenuButton = new SillyHatJMenuItem("退出",new ExitListener());
		jMenu.addMenuButton(jMenuButton);
		
		jMenuBar.addMenu(jMenu);
	}
	
	public static void main(String[] args) {
		try {
			MainApp window = new MainApp();
			window.openWindow();
		} catch (Exception e) {
			new SillyHatException(e.getMessage());
		}
	}
}
