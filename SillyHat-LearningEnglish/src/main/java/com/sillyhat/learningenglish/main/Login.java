package com.sillyhat.learningenglish.main;

import com.sillyhat.learningenglish.business.personalinformation.service.UserService;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.swing.module.container.middle.SillyHatJOptionPane;
import com.sillyhat.swing.utils.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.*;

public class Login extends JFrame {

    private MainApp window;
    private Future future;
    private UserService userService;

    private JPanel contextPanel = new JPanel(new GridLayout(2, 1));
    private JPanel userNamePanel = new JPanel();
    private JPanel passwordPanel = new JPanel();
//    private JPanel rememberPasswordPanel = new JPanel();

//    private JPanel btnPanel = new JPanel(new GridLayout(1, 3));
    private JPanel btnPanel = new JPanel();
    // 用户名
    private JTextField fieldLogin = new JTextField(20);
    // 密码
    private JPasswordField fieldPassword = new JPasswordField(20);

    // 小容器
    private JLabel lblLogin = new JLabel("用户名：");
    private JLabel lblPassword = new JLabel("密码：");
//    private JLabel lblRememberPassword = new JLabel("记住密码");

    // 小按钮
    private JButton btnLogin = new JButton("登录");
    private JButton btnCancel = new JButton("取消");;

    // 复选框
//    private JCheckBox rememberPassword = new JCheckBox();

    private void setLoading(boolean isLoading){
        fieldLogin.setEnabled(!isLoading);
        fieldPassword.setEnabled(!isLoading);
        btnLogin.setEnabled(!isLoading);
    }

    /*
     * 初始化方法
     */
    public void initComponents() {
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setLoading(true);
                String login = fieldLogin.getText();
                String password = new String(fieldPassword.getPassword());
                if(StringUtils.isEmpty(login)){
                    SillyHatJOptionPane.alert("提示","用户名不能为空。");
                    setLoading(false);
                    return;
                }else if(StringUtils.isEmpty(password)){
                    SillyHatJOptionPane.alert("提示","密码不能为空。");
                    setLoading(false);
                    return;
                }
                try {
                    window = (MainApp) future.get();
                    userService = (UserService) SpringUtils.getInstance().getContext().getBean(UserService.class);
                    if(userService.checkUser(login,password)){
                        setVisible(false);
                        window.openWindow();
                    }else{
                        SillyHatJOptionPane.alert("提示","用户名或密码错误。");
                        setLoading(false);
                    }
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    SillyHatJOptionPane.alertError("提示","系统发生异常:"+interruptedException.getMessage());
                    System.exit(0);
                } catch (ExecutionException executionException) {
                    executionException.printStackTrace();
                    SillyHatJOptionPane.alertError("提示","系统发生异常:"+executionException.getMessage());
                    System.exit(0);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        lblLogin.setHorizontalAlignment(JLabel.RIGHT);
        lblLogin.setPreferredSize(new Dimension(80,30));
        userNamePanel.add(lblLogin);
        userNamePanel.add(fieldLogin);

        lblPassword.setHorizontalAlignment(JLabel.RIGHT);
        lblPassword.setPreferredSize(new Dimension(80,30));
        passwordPanel.add(lblPassword);
        passwordPanel.add(fieldPassword);
//        rememberPasswordPanel.add(rememberPassword);
//        rememberPasswordPanel.add(lblRememberPassword);

        contextPanel.add(userNamePanel);
        contextPanel.add(passwordPanel);
//        contextPanel.add(rememberPasswordPanel);

        btnPanel.add(btnLogin,BorderLayout.WEST);
        btnPanel.add(new JPanel(),BorderLayout.CENTER);
        btnPanel.add(btnCancel,BorderLayout.EAST);
        getContentPane().add(contextPanel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);

        fieldLogin.setText("xushikuan");
        fieldPassword.setText("123");
    }

    /**
     * 加载主窗口页面
     */
    private void startLoadingMainApp(){
        ExecutorService exec = Executors.newCachedThreadPool();
        future = exec.submit(new LoadingMainApp());
    }

    /*
     * 构造方法
     */
    public Login() {
        startLoadingMainApp();
        // 设置窗口标题
        this.setTitle("欢迎使用嘿咻傻帽的学习系统");
        // 窗体组件初始化
        initComponents();
        this.pack();
        // 窗体大小不能改变
        this.setResizable(false);
        // 居中显示
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 窗体可见
        this.setVisible(true);
    }


    public static void main(String[] args) {
//        JFrame.setDefaultLookAndFeelDecorated(true);
        new Login();
    }

    class LoadingMainApp implements Callable<MainApp> {

        public LoadingMainApp() {

        }

        @Override
        public MainApp call() throws Exception {
            return new MainApp();
        }
    }
}
