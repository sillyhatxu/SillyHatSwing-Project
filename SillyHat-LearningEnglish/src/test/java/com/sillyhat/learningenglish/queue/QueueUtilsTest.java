package com.sillyhat.learningenglish.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * QueueUtils
 *
 * @author 徐士宽
 * @date 2017/3/22 17:58
 */
public class QueueUtilsTest {

    private static Logger logger = LoggerFactory.getLogger(QueueUtilsTest.class);
    //队列大小
    private static final BlockingQueue<String> queue = new LinkedBlockingDeque<>(500);

    public volatile static QueueUtilsTest instance;

    public static QueueUtilsTest getInstance() {
        if (instance == null) {
            synchronized (QueueUtilsTest.class) {
                if (instance == null) instance = new QueueUtilsTest();
            }
        }
        return instance;
    }

    public boolean updateTodayPlanDetail(String dto){
        try {
            return queue.offer(dto,2, TimeUnit.SECONDS);//添加一个元素并返回true,如果队列已满，则返回false;超时返回false
        } catch (InterruptedException e) {
            logger.error("上传队列发生异常；",e);
            return false;
        }
    }

    public String getTodayPlanDetail(){
        try {
            Thread.sleep(1000);
            return queue.poll(2, TimeUnit.SECONDS);//移除并返问队列头部的元素,如果队列为空，则返回null；超时返回null
        } catch (InterruptedException e) {
            logger.error("从队列取值发生异常",e);
            return null;
        }
    }

    class GetThread extends Thread {
        public void run() {
            while(true){
                System.out.println("得到-----" + QueueUtilsTest.getInstance().getTodayPlanDetail());
            }
        }
    }

    private void test(){
        Thread thread = new Thread(new GetThread());
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 20; i++) {
            boolean test = QueueUtilsTest.getInstance().updateTodayPlanDetail("AAA" + (i + 1));
            System.out.println((i + 1) + "----> " + test);
        }
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 50; i < 80; i++) {
            boolean test = QueueUtilsTest.getInstance().updateTodayPlanDetail("BBB" + (i + 1));
            System.out.println((i + 1) + "----> " + test);
        }
        System.out.println("加载队列完毕");
    }
    public static void main(String[] args) {
        new QueueUtilsTest().test();
    }
}
