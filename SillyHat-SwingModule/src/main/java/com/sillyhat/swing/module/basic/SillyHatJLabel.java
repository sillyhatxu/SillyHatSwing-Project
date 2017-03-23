package com.sillyhat.swing.module.basic;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ${XUSHIKUAN} on 2017-03-23.
 */
public class SillyHatJLabel extends JLabel{

    private static final long serialVersionUID = -4425297415076352558L;

    private final int DEFAULT_SIZE = 18;

    public SillyHatJLabel(){

    }

    public SillyHatJLabel(String text){
        super(text);
        setSongTypeface(DEFAULT_SIZE);
    }

    public SillyHatJLabel(String text, int horizontalAlignment) {
        super(text, null, horizontalAlignment);
    }

    /**
     * 设置宋体字
     * @param size  字体大小
     */
    public void setSongTypeface(int size){
        setFont(new Font("宋体", Font.PLAIN, size));
    }

    /**
     * 设置宋体字    加粗
     * @param size  字体大小
     */
    public void setSongTypefaceIsBold(int size){
        setFont(new Font("宋体", Font.BOLD, size));
    }


}
