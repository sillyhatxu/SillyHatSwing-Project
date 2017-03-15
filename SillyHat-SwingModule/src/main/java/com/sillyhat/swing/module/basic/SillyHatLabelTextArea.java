package com.sillyhat.swing.module.basic;

import com.sillyhat.swing.utils.SillyHatWindowUtils;

import javax.swing.*;
import java.awt.*;

/**
 * SillyHatTextArea
 *
 * @author 徐士宽
 * @date 2017/3/15 18:15
 */
public class SillyHatLabelTextArea extends JPanel{

    private JLabel jLabel;

    private SillyHatTextArea sillyHatTextArea;

    public SillyHatLabelTextArea(String labelName, int labelWidth, int labelHeight, String textValue, int textWidth,int textHeight){
        jLabel = new JLabel(labelName);
//        jLabel.setBorder(BorderFactory.createLineBorder(Color.cyan));
        jLabel.setHorizontalAlignment(JLabel.RIGHT);
        jLabel.setPreferredSize(new Dimension(labelWidth,labelHeight));
        add(jLabel);

        sillyHatTextArea = new SillyHatTextArea(textValue,textWidth,textHeight);
        add(sillyHatTextArea);

        setPreferredSize(new Dimension((int)SillyHatWindowUtils.getWindowsHeight(), textHeight + 20));//关键代码,设置JPanel的大小
        setLayout(new FlowLayout(FlowLayout.LEFT));
//        setBorder(BorderFactory.createLineBorder(Color.blue));
    }

    public String getLabelName() {
        return jLabel.getText();
    }

    public void setTextValue(String textArea) {
        sillyHatTextArea.setTextValue(textArea);
    }

    public String getTextValue() {
        return sillyHatTextArea.getTextValue();
    }

}
