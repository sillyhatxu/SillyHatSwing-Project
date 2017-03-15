package com.sillyhat.swing.module.basic;

import com.sillyhat.swing.utils.SillyHatWindowUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SillyHatInputText extends JPanel{

	private static final long serialVersionUID = -3706771645845791062L;
	
	private JLabel jLabel;
	
	private JTextField jTextField;
	
	public SillyHatInputText(String labelName,int labelWidth,int labelHeight,String textValue,int textWidth){
		initSillyHatInputText(labelName, labelWidth, labelHeight, textValue, textWidth);
	}

	public SillyHatInputText(String labelName,int labelWidth,int labelHeight,String textValue,int textWidth,Border border){
		initSillyHatInputText(labelName, labelWidth, labelHeight, textValue, textWidth);
		if(border != null){
			setBorder(border);
		}
	}

	private void initSillyHatInputText(String labelName,Integer labelWidth,Integer labelHeight,String textValue,Integer textWidth){
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
			setPreferredSize(new Dimension((int) SillyHatWindowUtils.getWindowsHeight(), labelHeight+10));//关键代码,设置JPanel的大小
		}
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	
	private void setLabelWidthHeight(int width,int height){
		jLabel.setHorizontalAlignment(JLabel.RIGHT);
		jLabel.setPreferredSize(new Dimension(width,height));
	}

	public String getLabelName() {
		return jLabel.getText();
	}

	public void setLabelName(String labelName) {
		jLabel.setText(labelName);
	}

	public String getTextValue() {
		return jTextField.getText();
	}

	public void setTextValue(String textValue) {
		jTextField.setText(textValue);
	}

	public JLabel getjLabel() {
		return jLabel;
	}

	public JTextField getjTextField() {
		return jTextField;
	}
	
}
