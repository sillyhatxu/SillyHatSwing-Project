package com.sillyhat.learningenglish.load;

import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDetailDTO;
import com.sillyhat.learningenglish.business.learningplan.service.LearningPlanService;
import com.sillyhat.learningenglish.business.personalinformation.service.UserService;
import com.sillyhat.learningenglish.utils.JunitTestSupport;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * UserPlanTest
 *
 * @author 徐士宽
 * @date 2017/3/21 10:09
 */
public class UserPlanTest extends JunitTestSupport{

    private final Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Autowired
    private UserService userService;

    @Autowired
    private LearningPlanService learningPlanService;

    @Test
    public void testClear() {
        learningPlanService.clearUserPlan();
    }

    @Test
    public void testQueryLearningPlan() {
        TodayPlanDTO dto = learningPlanService.getTodayPlan(2l);
        logger.info(dto.toString());
        logger.info("--------------------------------------------------");
        List<TodayPlanDetailDTO> list = dto.getTodayPlanDetailList();
        for (int i = 0; i < list.size(); i++) {
            logger.info(list.get(i).toString());
        }
    }
}
