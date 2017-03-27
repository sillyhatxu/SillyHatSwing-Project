package com.sillyhat.swing.module.container.middle;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

//public class SillyHatTabPanel extends JPanel implements KeyListener {
public class SillyHatTabPanel extends JPanel{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -3083158849745153721L;

	/** 
	 * @Fields panelCode : panel唯一ID 
	 */ 
	public SillyHatTabPanel(String panelCode){
		initService();//业务初始化Service
		initComponents();
		setName(panelCode);
//		this.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				panelKeyPressed(e);
//			}
//		});
	}

//	public void panelKeyPressed(KeyEvent e){
//
//	}


	public void initService(){

	}

	public void initComponents(){

	}


	public void debugFrame(Color color){
		setBorder(BorderFactory.createLineBorder(color));
	}

//	public void keyTyped(KeyEvent e) {
//		System.out.println("keyTyped--->" + e.getKeyCode());
//	}
//
//	public void keyPressed(KeyEvent e) {
//		System.out.println("keyPressed--->" + e.getKeyCode());
////		panelKeyPressed(e);
//	}
//
//	public void keyReleased(KeyEvent e) {
//		System.out.println("keyReleased--->" + e.getKeyCode());
//	}
}
