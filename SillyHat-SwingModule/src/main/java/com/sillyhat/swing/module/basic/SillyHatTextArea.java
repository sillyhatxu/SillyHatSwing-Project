package com.sillyhat.swing.module.basic;

import com.sillyhat.swing.utils.LineNumberHeaderView;

import java.awt.*;

import javax.swing.*;

/**
 * SillyHatTextArea
 *
 * @author 徐士宽
 * @date 2017/3/15 18:15
 */
public class SillyHatTextArea extends JPanel{

    private JLabel label;

    public static final String LAYOUT_NORTH = "North";

    public static final String LAYOUT_CENTER = "Center";

    public JScrollPane centerPanel = new JScrollPane();

    public JTextPane showJTextPane = new JTextPane();


    public SillyHatTextArea(String labelName){
        showJTextPane.setBorder(BorderFactory.createLineBorder(Color.red));
        label = new JLabel(labelName);
        centerPanel.setRowHeaderView(new LineNumberHeaderView());
        centerPanel.setViewportView(showJTextPane);
        centerPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        centerPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
//        add(label, LAYOUT_CENTER);
        add(centerPanel, LAYOUT_CENTER);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
//        setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }


}
