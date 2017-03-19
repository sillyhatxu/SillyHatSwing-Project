package com.sillyhat.learningenglish.business.learningplan.mapper;

import com.sillyhat.learningenglish.business.personalinformation.dto.UserLearningPlanDTO;

import java.util.List;

/**
 * Created by ${XUSHIKUAN} on 2017-03-19.
 */
public interface LearningPlanMapper {

    public List<UserLearningPlanDTO> queryUserLearningPlanByUserId(long userId);

    public List<UserLearningPlanDTO> queryUserLearningPlanAll();

    public void addUserLearningPlan(UserLearningPlanDTO dto);

    public void updateUserLearningPlan(UserLearningPlanDTO dto);

}
