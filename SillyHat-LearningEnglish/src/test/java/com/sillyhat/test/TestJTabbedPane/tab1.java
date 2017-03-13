package com.sillyhat.test.TestJTabbedPane;

import javax.swing.*;

public class tab1 extends JFrame {
    tab1() {
        super("选项卡窗格");
        setVisible(true);
        setSize(500, 310);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn = new JButton("X");
        JTabbedPane pane = new JTabbedPane();
        JLabel lab = new JLabel("选项卡I");
        pane.addTab("i", lab);
        pane.setTabComponentAt(pane.indexOfComponent(lab), btn);
        add(pane);
    }

    public static void main(String[] args) {
        new tab1();
    }
}