package com.sillyhat.learningenglish.business.learningplan.service;

import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.UserLearningPlanDTO;

import java.util.List;

/**
 * Created by ${XUSHIKUAN} on 2017-03-19.
 */
public interface LearningPlanService {

    public List<UserLearningPlanDTO> queryUserLearningPlanByUserId(long userId);

    public List<UserLearningPlanDTO> queryUserLearningPlanAll();

    public void addUserLearningPlan(UserLearningPlanDTO dto);

    public void updateUserLearningPlan(UserLearningPlanDTO dto);

    /**
     * 得到今日计划
     * @param userId
     * @return
     */
    public TodayPlanDTO getTodayPlan(long userId);


}
