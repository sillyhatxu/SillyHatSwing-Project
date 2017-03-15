package com.sillyhat.swing.module.container.middle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 * SillyHatDialog
 *
 * @author 徐士宽
 * @date 2017/3/15 14:12
 */
public abstract class SillyHatDialog extends JDialog{

    private Component relativeTo;

    private Map<String,Object> content;

    private JPanel btnPanel;
    private JButton submitButton;
    private JButton cancelButton;

    public SillyHatDialog(Component relativeTo){
        super();
        initDialog();
        this.relativeTo = relativeTo;
        content = new HashMap<String,Object>();
        setTitle(getDialogName());
        setSize(getDialogWidth(), getDialogHeight());
    }


    /**
     * 打开dialog窗口
     * @return
     */
    public Map<String,Object> openDialog(){
        dialogButton();
        getContentPane().add(dialogContent(), getDialogContentPanelLocation());
        setModal(getModal());//模态窗口
        setLocationRelativeTo(relativeTo);
        setVisible(true);
        return closeDialog();
    }

    /**
     * 是否模态窗口
     * @return
     */
    public boolean getModal(){
        return true;//默认模态窗口
    }

    /**
     * 初始化dialog按钮
     */
    public void dialogButton(){
        btnPanel = new JPanel();
        submitButton = new JButton(getButtonNameSubmit());
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clickSubmitEvent()){
                    dispose();//关闭窗口
                }
            }
        });
        cancelButton = new JButton(getButtonNameCancel());
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clickCancelEvent()){
                    dispose();//关闭窗口
                }
            }
        });
        btnPanel.add(submitButton);
        btnPanel.add(cancelButton);
        getContentPane().add(btnPanel, getButtonPanelLocation());
    }

    /**
     * 初始化dialog内容
     */
    public JPanel dialogContent(){
        return null;
    }

    /**
     * btn按钮位置
     * @return
     */
    public String getButtonPanelLocation(){
        return BorderLayout.SOUTH;//默认在下方显示
    }

    public String getDialogContentPanelLocation(){
        return BorderLayout.CENTER;//默认在中间显示
    }

    /**
     * Submit按钮事件
     * @return
     */
    public boolean clickSubmitEvent(){
        return true;
    }

    /**
     * Cancel按钮事件
     * @return
     */
    public boolean clickCancelEvent(){
        return true;
    }

    public String getButtonNameSubmit(){
        return "submit";
    }

    public String getButtonNameCancel(){
        return "cancel";
    }

    /**
     * 关闭窗口事件（默认不返回数据）
     * @return
     */
    public Map<String,Object> closeDialog(){
        return null;
    }

    /**
     * 初始化dialog窗口传参数前可初始化业务接口
     */
    public abstract void initDialog();

    /**
     * 定义dialog名称
     * @return
     */
    public abstract String getDialogName();

    /**
     * 定义dialog宽度
     * @return
     */
    public abstract int getDialogWidth();

    /**
     * 定义dialog高度
     * @return
     */
    public abstract int getDialogHeight();



}
