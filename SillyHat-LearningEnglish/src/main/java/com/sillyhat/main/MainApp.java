package com.sillyhat.main;

import com.sillyhat.business.help.listener.ExitListener;
import com.sillyhat.business.message.listener.PersonalInformationListener;
import com.sillyhat.business.question.listener.WordQuestionEntryListener;
import com.sillyhat.swing.exception.SillyHatException;
import com.sillyhat.swing.module.basic.SillyHatJMenu;
import com.sillyhat.swing.module.basic.SillyHatJMenuItem;
import com.sillyhat.business.main.view.ViewForm;

public class MainApp extends ViewForm{
	
	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -690238177122305692L;

	public MainApp(){
//		initListener();
//		initComponents();
//		initStyle(inputPane);
//		registerListener();
//		initPosition();
		setTitleName("帽子学习系统");
//		setWindowSize(1000,800);
		setWindowSize(1000,500);
		setWindowLocation(null);
		initComponents();
		setTopJMenuBar(jMenuBar);
		setborderLayoutCenter(centerPanel);
	}


	private void initComponents(){
		initJMenuSystem();
		initJMenuFunction();
		initJMenuHelp();
	}

	/**
	 * 初始化系统菜单
	 */
	private void initJMenuSystem(){
		jMenu = new SillyHatJMenu("系统");

		jMenuButton = new SillyHatJMenuItem("个人信息",new PersonalInformationListener(centerPanel));
		jMenu.addMenuButton(jMenuButton);

		jMenuButton = new SillyHatJMenuItem("切换数据库");
		jMenu.addMenuButton(jMenuButton);

		jMenuButton = new SillyHatJMenuItem("创建新数据库");
		jMenu.addMenuButton(jMenuButton);

		jMenuBar.addMenu(jMenu);
	}

	/**
	 * 初始化功能菜单
	 */
	private void initJMenuFunction(){
		jMenu = new SillyHatJMenu("功能");

		jMenuButton = new SillyHatJMenuItem("题库录入", new WordQuestionEntryListener(centerPanel));
		jMenu.addMenuButton(jMenuButton);

		jMenuButton = new SillyHatJMenuItem("选择答题");
		jMenu.addMenuButton(jMenuButton);

		jMenuBar.addMenu(jMenu);
	}

	/**
	 * 初始化帮助菜单
	 */
	private void initJMenuHelp(){
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
