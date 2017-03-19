package com.sillyhat.learningenglish.business.learningplan.mapper;

import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDetailDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.UserLearningPlanDTO;

import java.util.List;

/**
 * Created by ${XUSHIKUAN} on 2017-03-19.
 */
public interface LearningPlanMapper {

    public List<UserLearningPlanDTO> queryUserLearningPlanByUserId(long userId);

    public List<UserLearningPlanDTO> queryUserLearningPlanAll();

    public void addUserLearningPlan(UserLearningPlanDTO dto);

    public void updateUserLearningPlan(UserLearningPlanDTO dto);


    /**************************************************************/
    /**
     * 得到上一次的今日计划
     * @param userId
     * @return
     */
    public TodayPlanDTO getLastTodayPlanByUserId(long userId);

    /**
     * 得到今日计划
     * @return
     */
    public TodayPlanDTO getTodayPlan(String data);

    /**
     * 初始化今日计划
     * @param dto
     */
    public void addTodayPlan(TodayPlanDTO dto);

    public void updateTodayPlan(TodayPlanDTO dto);

    public List<TodayPlanDetailDTO> queryTodayPlanDetailByTodayPlanId(long todayPlanId);

    public void addTodayPlanDetail(TodayPlanDetailDTO dto);

    public void updateTodayPlanDetail(TodayPlanDetailDTO dto);

}
