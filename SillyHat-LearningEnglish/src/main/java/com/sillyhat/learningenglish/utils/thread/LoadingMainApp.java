package com.sillyhat.learningenglish.utils.thread;

import com.sillyhat.learningenglish.main.MainApp;

import java.util.concurrent.Callable;

/**
 * 异步加载Spring和登录页面组件
 */
public class LoadingMainApp implements Callable<MainApp> {

    public LoadingMainApp() {

    }

    @Override
    public MainApp call() throws Exception {
        return new MainApp();
    }
}
