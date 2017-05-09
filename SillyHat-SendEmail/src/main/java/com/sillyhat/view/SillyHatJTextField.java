package com.sillyhat.view;

import javax.swing.*;
import java.awt.*;

public class SillyHatJTextField extends Panel{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -8934096872367840586L;

	private String lable;
	
	private String text;
	
	private int DEFAULT_TEXT_FIELD_SIZE = 20;
	
	private JLabel jLabel = null;
	
	private JTextField jTextField = null;
	
	public SillyHatJTextField(){
		init();
	}
	
	private void init() {
		jLabel = new JLabel(lable);
		jTextField = new JTextField(text, DEFAULT_TEXT_FIELD_SIZE);
		add(jLabel);
		add(jTextField);
	}
	
	public SillyHatJTextField(String lable){
		this.lable = lable;
		init();
	}
	
	public SillyHatJTextField(String lable,String text){
		this.lable = lable;
		this.text = text;
		init();
	}
	
	public void setText(String text){
		jTextField.setText(text);
	}
	
	public String getText(){
		return jTextField.getText();
	}
	
	/**
	 * <p>Title: setHorizontalAlignmentRight</p>
	 * <p>Description: </p>设置对齐方式：右对齐
	 * @param 
	 * @author 徐士宽
	 * @date 2016-11-12
	 * @return:void
	 */
	public void setHorizontalAlignmentRight(){
		jLabel.setHorizontalAlignment(JLabel.RIGHT);
	}
	/**
	 * <p>Title: setHorizontalAlignmentLeft</p>
	 * <p>Description: </p>设置对齐方式：左对齐
	 * @param 
	 * @author 徐士宽
	 * @date 2016-11-12
	 * @return:void
	 */
	public void setHorizontalAlignmentLeft(){
		jLabel.setHorizontalAlignment(JLabel.LEFT);
	}
	
	/**
	 * <p>Title: setPreferredSize</p>
	 * <p>Description: </p>设置lable宽度和高度
	 * @param 
	 * @author 徐士宽
	 * @date 2016-11-12
	 * @return:void
	 */
	public void setLablePreferredSize(int width,int height){
		jLabel.setPreferredSize(new Dimension(width,height));
	}
	
//	passwordJLabel.setHorizontalAlignment(JLabel.RIGHT);
//	jLabel.setPreferredSize(new Dimension(100,30));
//	userJTextField.setText(ReadProperties.getValue(Constant.KEY_USER));
}
