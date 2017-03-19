package com.sillyhat.learningenglish.business.learningplan.service.impl;

import com.sillyhat.learningenglish.business.learningplan.mapper.LearningPlanMapper;
import com.sillyhat.learningenglish.business.learningplan.service.LearningPlanService;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserLearningPlanDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ${XUSHIKUAN} on 2017-03-19.
 */
@Service
public class LearningPlanServiceImpl implements LearningPlanService{

    @Resource
    private LearningPlanMapper learningPlanMapper;

    @Override
    public List<UserLearningPlanDTO> queryUserLearningPlanByUserId(long userId) {
        return learningPlanMapper.queryUserLearningPlanByUserId(userId);
    }

    @Override
    public List<UserLearningPlanDTO> queryUserLearningPlanAll() {
        return learningPlanMapper.queryUserLearningPlanAll();
    }

    @Override
    public void addUserLearningPlan(UserLearningPlanDTO dto) {
        learningPlanMapper.addUserLearningPlan(dto);
    }

    @Override
    public void updateUserLearningPlan(UserLearningPlanDTO dto) {
        learningPlanMapper.updateUserLearningPlan(dto);
    }
}
