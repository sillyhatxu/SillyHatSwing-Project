package com.sillyhat.swing.module.basic;

import com.sillyhat.swing.utils.LineNumberHeaderView;

import javax.swing.*;
import java.awt.*;

/**
 * SillyHatTextArea
 *
 * @author 徐士宽
 * @date 2017/3/15 18:15
 */
public class SillyHatTextArea extends JPanel{

    private JScrollPane centerPanel = new JScrollPane();

    private JTextPane jTextPane = new JTextPane();

    public SillyHatTextArea(String textValue, int textWidth,int textHeight){
        setTextValue(textValue);
        centerPanel.setRowHeaderView(new LineNumberHeaderView());
        centerPanel.setViewportView(jTextPane);
        centerPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        centerPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        centerPanel.setPreferredSize(new Dimension(textWidth, textHeight));//关键代码,设置JPanel的大小
        add(centerPanel);
        setPreferredSize(new Dimension(textWidth, textHeight + 20));//关键代码,设置JPanel的大小
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public void setTextValue(String textArea) {
        jTextPane.setText(textArea);
    }

    public String getTextValue() {
        return jTextPane.getText();
    }

    /**
     * 是否只读 true:只读
     * @param value
     */
    public void isReadonly(boolean value){
        jTextPane.setEnabled(!value);
    }
}
