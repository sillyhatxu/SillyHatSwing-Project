package com.sillyhat.swing.utils;

import java.awt.*;

/**
 * 窗口工具类
 *
 * @author 徐士宽
 * @date 2017/3/15 14:37
 */
public class SillyHatWindowUtils {


    /**
     * 如果聚焦窗口与调用线程位于同一个上下文中，则返回聚焦窗口。
     * @return
     */
    public static Window getCurrentFocusWindow(){
        return KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusedWindow();
    }

    /**
     * 如果活动 Window 与调用线程位于同一个上下文中，则返回活动 Window。
     * @return
     */
    public static Window getActiveWindow(){
        return KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
    }


}
