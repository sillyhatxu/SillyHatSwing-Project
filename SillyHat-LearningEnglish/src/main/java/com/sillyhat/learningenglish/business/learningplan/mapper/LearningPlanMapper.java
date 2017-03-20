package com.sillyhat.learningenglish.business.learningplan.mapper;

import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDetailDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.UserLearningPlanDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

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
    public TodayPlanDTO getTodayPlan(@Param("data")String data,@Param("nextData")String nextDate);

    /**
     * 初始化今日计划
     * @param dto
     */
    public void addTodayPlan(TodayPlanDTO dto);

    public void updateTodayPlan(TodayPlanDTO dto);

    public List<TodayPlanDetailDTO> queryTodayPlanDetailByTodayPlanId(long todayPlanId);

    public void addTodayPlanDetail(TodayPlanDetailDTO dto);

    public void updateTodayPlanDetail(TodayPlanDetailDTO dto);

    public List<UserLearningPlanDTO> queryLearningPlanLearningWordList(@Param("userId")long userId,@Param("learningNum")int learningNum,@Param("existingWordIdSet")Set<Long> existingWordIdSet);

    public List<UserLearningPlanDTO> queryLearningPlanReviewWordList(@Param("userId")long userId,@Param("reviewNum")int reviewNum,@Param("existingWordIdSet")Set<Long> existingWordIdSet);

}
