package com.sillyhat.swing.module.basic;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SillyHatInputText extends JPanel{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -3706771645845791062L;
	
	private JLabel jLabel;
	
	private JTextField jTextField;
	
	private String labelName;
	
	private String textValue;
	
	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
		if (null != jLabel){
			jLabel.setText(labelName);
		}
	}

	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
		if (null != jTextField){
			jTextField.setText(textValue);
		}
	}

	public JLabel getjLabel() {
		return jLabel;
	}

	public JTextField getjTextField() {
		return jTextField;
	}

	public SillyHatInputText(){
		initSillyHatInputText("",null,null,"",null,null);
	}
	
	public SillyHatInputText(String labelName){
		initSillyHatInputText(labelName,null,null,"",null,null);
	}
	
	public SillyHatInputText(String labelName,String textValue){
		initSillyHatInputText(labelName,null,null,textValue,null,null);
	}
	
	public SillyHatInputText(String labelName,int labelWidth,int labelHeight,String textValue,int textWidth){
		initSillyHatInputText(labelName, labelWidth, labelHeight, textValue, textWidth,null);
	}

	public SillyHatInputText(String labelName,int labelWidth,int labelHeight,String textValue,int textWidth,Color color){
		initSillyHatInputText(labelName, labelWidth, labelHeight, textValue, textWidth,color);
	}

	public SillyHatInputText(String labelName,int labelWidth,int labelHeight,String textValue,int textWidth,Border border){
		initSillyHatInputText(labelName, labelWidth, labelHeight, textValue, textWidth,null);
		if(border == null){
			
		}
		setBorder(border);
	}

	private void initSillyHatInputText(String labelName,Integer labelWidth,Integer labelHeight,String textValue,Integer textWidth,Color color){
		jLabel = new JLabel();
		if(textWidth != null){
			jTextField = new JTextField(textWidth);
		}else{
			jTextField = new JTextField();
		}
		setLabelName(labelName);
		setTextValue(textValue);
		add(jLabel);
		add(jTextField);
		if(labelWidth != null && labelHeight != null){
			setLabelWidthHeight(labelWidth, labelHeight);
			setPreferredSize(new Dimension(800, labelHeight+10));//关键代码,设置JPanel的大小
		}
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if(color != null){
			setBorder(BorderFactory.createLineBorder(color));
		}
	}
	
	private void setLabelWidthHeight(int width,int height){
		jLabel.setHorizontalAlignment(JLabel.RIGHT);
		jLabel.setPreferredSize(new Dimension(width,height));
	}
	
}
