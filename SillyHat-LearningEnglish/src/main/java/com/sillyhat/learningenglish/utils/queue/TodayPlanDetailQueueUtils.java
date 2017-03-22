package com.sillyhat.learningenglish.utils.queue;

import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDetailDTO;
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
public class TodayPlanDetailQueueUtils {

    private static Logger logger = LoggerFactory.getLogger(TodayPlanDetailQueueUtils.class);
    //队列大小
    private static final BlockingQueue<TodayPlanDetailDTO> queue = new LinkedBlockingDeque<>(500);

    public volatile static TodayPlanDetailQueueUtils instance;

    public static TodayPlanDetailQueueUtils getInstance() {
        if (instance == null) {
            synchronized (TodayPlanDetailQueueUtils.class) {
                if (instance == null) instance = new TodayPlanDetailQueueUtils();
            }
        }
        return instance;
    }

    public boolean updateTodayPlanDetail(TodayPlanDetailDTO dto){
        try {
            return queue.offer(dto,5, TimeUnit.SECONDS);//添加一个元素并返回true,如果队列已满，则返回false;超时返回false
        } catch (InterruptedException e) {
            logger.error("上传队列发生异常；",e);
            return false;
        }
    }

    public TodayPlanDetailDTO getTodayPlanDetail(){
        try {
            return queue.poll(5, TimeUnit.SECONDS);//移除并返问队列头部的元素,如果队列为空，则返回null；超时返回null
        } catch (InterruptedException e) {
            logger.error("从队列取值发生异常",e);
            return null;
        }
    }
}
