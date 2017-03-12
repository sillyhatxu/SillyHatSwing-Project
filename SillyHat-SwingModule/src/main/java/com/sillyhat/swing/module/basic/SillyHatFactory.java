package com.sillyhat.swing.module.basic;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class SillyHatFactory {

	/**
	 * <p>Title: createCerticalFormJPanel</p>
	 * <p>Description: </p>创建垂直布局的FormJPanel
	 * @return
	 * @author XUSHIKUAN642
	 * @date 2016-11-21
	 */
	public static SillyHatFormJPanel createCerticalFormJPanel(){
		SillyHatFormJPanel jPanel = new SillyHatFormJPanel();
		jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS)); 
		return jPanel;
	}
	public static SillyHatFormJPanel createCerticalFormJPanel(TitledBorder border){
		SillyHatFormJPanel jPanel = new SillyHatFormJPanel();
		jPanel.setBorder(border);
		jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS)); 
		return jPanel;
	}
	
	
	
	/**
	 * <p>Title: getBorderDistance</p>
	 * <p>Description: </p>设置panel边界距离
	 * @param distance
	 * @author XUSHIKUAN642
	 * @date 2016-11-19
	 */
	public static Border getBorderDistance(int distance){
		return BorderFactory.createEmptyBorder(distance,distance,distance,distance);
	}
	
	/**
	 * <p>Title: getBorderDistanceNoneTop</p>
	 * <p>Description: </p>设置panel边界距离（距上边距为0）
	 * @param distance
	 * @author XUSHIKUAN642
	 * @date 2016-11-19
	 */
	public static Border getBorderDistanceNoneTop(int distance){
		return BorderFactory.createEmptyBorder(0,distance,distance,distance);
	}
	
	/**
	 * <p>Title: getBorderDistanceNoneBottom</p>
	 * <p>Description: </p>设置panel边界距离（距下边距为0）
	 * @param distance
	 * @author XUSHIKUAN642
	 * @date 2016-11-19
	 */
	public static Border getBorderDistanceNoneBottom(int distance){
		return BorderFactory.createEmptyBorder(distance,distance,distance,0);
	}
	
	/**
	 * <p>Title: getBorderDistance</p>
	 * <p>Description: </p>设置panel边界距离
	 * @param top
	 * @param left
	 * @param bottom
	 * @param right
	 * @author XUSHIKUAN642
	 * @date 2016-11-19
	 */
	public static Border getBorderDistance(int top, int left, int bottom, int right){
		return BorderFactory.createEmptyBorder(top, left, bottom, right);
	}
}
