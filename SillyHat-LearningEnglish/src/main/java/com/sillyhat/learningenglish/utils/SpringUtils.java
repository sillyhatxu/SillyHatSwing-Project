package com.sillyhat.learningenglish.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 因为本项目并不考虑高并发，所以此单例为纯装逼写法……
 *
 * @author 徐士宽
 * @date 2017/3/14 17:20
 */
public class SpringUtils {

    public volatile static SpringUtils instance;

    private ApplicationContext context;

    public static SpringUtils getInstance() {
        if (instance == null) {
            synchronized (SpringUtils.class) {
                if (instance == null) instance = new SpringUtils();
            }
        }
        return instance;
    }

    private SpringUtils(){
        String paths[] = {"applicationContext-database.xml", "applicationContext-config.xml"};
        //加载spring的配置文件
        context = new ClassPathXmlApplicationContext(paths);
    }

    public ApplicationContext getContext() {
        return context;
    }
}
