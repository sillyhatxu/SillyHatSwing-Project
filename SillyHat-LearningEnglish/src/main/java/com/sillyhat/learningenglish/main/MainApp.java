package com.sillyhat.learningenglish.main;

import com.sillyhat.learningenglish.business.message.service.MessageService;
import com.sillyhat.learningenglish.business.personalinformation.listener.PersonalInformationListener;
import com.sillyhat.learningenglish.business.reciteword.listener.ReciteWordListener;
import com.sillyhat.learningenglish.business.system.listener.ExitListener;
import com.sillyhat.learningenglish.business.system.view.ViewForm;
import com.sillyhat.learningenglish.business.wordrepository.listener.WordRepositoryListListener;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.exception.SillyHatException;
import com.sillyhat.swing.module.basic.SillyHatJMenu;
import com.sillyhat.swing.module.basic.SillyHatJMenuItem;

public class MainApp extends ViewForm{
	
	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -690238177122305692L;

	private MessageService messageService;

	public MainApp(){
		initService();
//		initListener();
//		initComponents();
//		initStyle(inputPane);
//		registerListener();
//		initPosition();
		setTitleName(messageService.getMessageZH("ui.title"));
//		setWindowSize(1000,800);
		setWindowSize(1200,800);
		setWindowLocation(null);
		initComponents();
		setTopJMenuBar(jMenuBar);
		setborderLayoutCenter(centerPanel);
	}


	private void initService(){
		//加载Spring与注入service
		messageService = (MessageService) SpringUtils.getInstance().getContext().getBean(MessageService.class);
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
		jMenu = new SillyHatJMenu(messageService.getMessageZH("menu.system"));

		jMenuButton = new SillyHatJMenuItem(messageService.getMessageZH("menu.personal.message"),new PersonalInformationListener(centerPanel));
		jMenu.addMenuButton(jMenuButton);

		jMenuButton = new SillyHatJMenuItem(messageService.getMessageZH("menu.switch.database"));
		jMenu.addMenuButton(jMenuButton);

		jMenuButton = new SillyHatJMenuItem(messageService.getMessageZH("menu.create.database"));
		jMenu.addMenuButton(jMenuButton);

		jMenuBar.addMenu(jMenu);
	}

	/**
	 * 初始化功能菜单
	 */
	private void initJMenuFunction(){
		jMenu = new SillyHatJMenu(messageService.getMessageZH("menu.function"));

		jMenuButton = new SillyHatJMenuItem(messageService.getMessageZH("menu.word.repository"), new WordRepositoryListListener(centerPanel));
		jMenu.addMenuButton(jMenuButton);

		jMenuButton = new SillyHatJMenuItem(messageService.getMessageZH("menu.recite.word"), new ReciteWordListener(centerPanel));
		jMenu.addMenuButton(jMenuButton);

		jMenuButton = new SillyHatJMenuItem(messageService.getMessageZH("menu.select.answer"));
		jMenu.addMenuButton(jMenuButton);

		jMenuBar.addMenu(jMenu);
	}

	/**
	 * 初始化帮助菜单
	 */
	private void initJMenuHelp(){
		jMenu = new SillyHatJMenu(messageService.getMessageZH("menu.help"));

		jMenuButton = new SillyHatJMenuItem(messageService.getMessageZH("menu.help.doc"));
		jMenu.addMenuButton(jMenuButton);

		jMenuButton = new SillyHatJMenuItem(messageService.getMessageZH("menu.about"));
		jMenu.addMenuButton(jMenuButton);

		jMenuButton = new SillyHatJMenuItem(messageService.getMessageZH("menu.exit"),new ExitListener());
		jMenu.addMenuButton(jMenuButton);

		jMenuBar.addMenu(jMenu);
	}
	
	public static void main(String[] args) {
//		JFrame.setDefaultLookAndFeelDecorated(true);//是否提供装饰（如边界、关闭窗口的小部件、标题……）
		try {
			MainApp window = new MainApp();
			window.openWindow();
		} catch (Exception e) {
			new SillyHatException(e.getMessage());
		}
	}
}
