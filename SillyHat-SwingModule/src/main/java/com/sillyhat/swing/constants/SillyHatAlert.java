package com.sillyhat.swing.constants;

import javax.swing.*;

/**
 * Created by ${XUSHIKUAN} on 2017-03-13.
 */
public class SillyHatAlert {

    public static void alert(String message){
        JOptionPane.showMessageDialog(null,message);
    }

    public static void alertError(String message,String title){
        JOptionPane.showMessageDialog(null,message,title, JOptionPane.ERROR_MESSAGE);
    }

    public static void alertWarning(String message,String title){
        JOptionPane.showMessageDialog(null,message,title, JOptionPane.WARNING_MESSAGE);
    }

}
