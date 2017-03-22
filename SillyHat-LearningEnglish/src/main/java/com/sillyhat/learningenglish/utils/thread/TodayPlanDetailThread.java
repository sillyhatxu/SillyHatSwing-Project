package com.sillyhat.learningenglish.utils.thread;

import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDetailDTO;
import com.sillyhat.learningenglish.business.learningplan.service.LearningPlanService;
import com.sillyhat.learningenglish.utils.SpringUtils;
import com.sillyhat.learningenglish.utils.queue.TodayPlanDetailQueueUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ${XUSHIKUAN} on 2017-03-22.
 */
public class TodayPlanDetailThread implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(TodayPlanDetailThread.class);

    private LearningPlanService learningPlanService;

    public TodayPlanDetailThread(){
        learningPlanService = (LearningPlanService) SpringUtils.getInstance().getContext().getBean(LearningPlanService.class);
    }
    @Override
    public void run() {
        while (true){
            TodayPlanDetailDTO dto = TodayPlanDetailQueueUtils.getInstance().getTodayPlanDetail();
            if(dto != null){
                logger.info("得到队列中内容：",dto);
                learningPlanService.updateTodayPlanDetail(dto);
                logger.info("完成修改");
            }
        }
    }
}
