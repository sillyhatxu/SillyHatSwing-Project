package com.sillyhat.swing.module.basic;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import java.awt.*;

/**
 * Created by ${XUSHIKUAN} on 2017-03-26.
 */
public class SillyHatJTextPane extends JPanel{

    private static final long serialVersionUID = 3926217597839139864L;

    private JTextPane jTextPane;

    public SillyHatJTextPane(String textValue, int textWidth,int textHeight){
        jTextPane = new JTextPane();
        setPreferredSize(new Dimension(textWidth, textHeight));//关键代码,设置JPanel的大小
        setLayout(new FlowLayout(FlowLayout.LEFT));
        jTextPane.setPreferredSize(new Dimension(textWidth, textHeight));
        Style style = jTextPane.getStyledDocument().addStyle(null, null);
        StyleConstants.setFontFamily(style, "verdana");
        StyleConstants.setFontSize(style, getFondSize());
        Style normal = jTextPane.addStyle("normal", style);
        jTextPane.setParagraphAttributes(normal, true);
        add(jTextPane);
        setTextValue(textValue);
    }

    public void setTextValue(String textArea) {
        jTextPane.setText(textArea);
    }

    public String getTextValue() {
        return jTextPane.getText();
    }

    public int getFondSize(){
        return 18;
    }
    /**
     * 是否只读 true:只读
     * @param value
     */
    public void isReadonly(boolean value){
        jTextPane.setEnabled(!value);
    }
}
