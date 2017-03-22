package com.sillyhat.learningenglish.utils.queue;

import com.sillyhat.learningenglish.utils.thread.TodayPlanDetailThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ${XUSHIKUAN} on 2017-03-22.
 */
public class QueueUtils {

    private static Logger logger = LoggerFactory.getLogger(QueueUtils.class);

    public volatile static QueueUtils instance;

    public boolean isStart = false;//线程是否已经开启

    public static QueueUtils getInstance() {
        if (instance == null) {
            synchronized (QueueUtils.class) {
                if (instance == null) instance = new QueueUtils();
            }
        }
        return instance;
    }

    public void startThread(){
        logger.info("启动队列线程");
        if(!isStart){
            isStart = true;
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
            fixedThreadPool.execute(new TodayPlanDetailThread());
        }
        logger.info("启动队列线程结束");
    }
}
