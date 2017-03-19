package com.sillyhat.learningenglish.business.learningplan.service.impl;

import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDetailDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.UserLearningPlanDTO;
import com.sillyhat.learningenglish.business.learningplan.mapper.LearningPlanMapper;
import com.sillyhat.learningenglish.business.learningplan.service.LearningPlanService;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.utils.cache.SystemCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ${XUSHIKUAN} on 2017-03-19.
 */
@Service
public class LearningPlanServiceImpl implements LearningPlanService{

    private SimpleDateFormat sdfData = new SimpleDateFormat( "yyyy-MM-dd");

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

    private TodayPlanDTO addTodayPlan(long userId,int learningNum){
        TodayPlanDTO todayPlan = new TodayPlanDTO();
        todayPlan.setUserId(userId);
        todayPlan.setLearningNum(learningNum);//第一次学习
        todayPlan.setIsFinish(Constants.IS_FINISH_NO);//未完成
        todayPlan.setCreatedUser(userId);
        todayPlan.setUpdatedUser(userId);
        learningPlanMapper.addTodayPlan(todayPlan);
        return todayPlan;
    }

    private void addTodayPlanDetail(Long todayPlanId){
        int learningNum = SystemCache.getCountCache(Constants.CACHE_USER_LEARNING_NUM);
        int reviewNum = SystemCache.getCountCache(Constants.CACHE_USER_REVIEW_NUM);

        TodayPlanDetailDTO todayPlanDetail = new TodayPlanDetailDTO();
        todayPlanDetail.setTodayPlanId(todayPlanId);
        learningPlanMapper.addTodayPlanDetail(todayPlanDetail);
    }

    private void copyTodayPlanDetail(Long todayPlanId,Long lastPlanId){
        int learningNum = SystemCache.getCountCache(Constants.CACHE_USER_LEARNING_NUM);
        int reviewNum = SystemCache.getCountCache(Constants.CACHE_USER_REVIEW_NUM);
        //copy上一批计划词汇
        List<TodayPlanDetailDTO> todayPlanDetailList = learningPlanMapper.queryTodayPlanDetailByTodayPlanId(lastPlanId);
        for (TodayPlanDetailDTO todayPlanDetail : todayPlanDetailList){
            todayPlanDetail.setTodayPlanId(todayPlanId);
            learningPlanMapper.addTodayPlanDetail(todayPlanDetail);
        }
    }

    @Override
    public TodayPlanDTO getTodayPlan(long userId) {
        //得到今日计划
        TodayPlanDTO todayPlan = learningPlanMapper.getTodayPlan(sdfData.format(new Date()));
        if(todayPlan == null){
            //未初始化今日计划，需要初始化,得到上一次的今日计划
            todayPlan = learningPlanMapper.getLastTodayPlanByUserId(userId);
            if(todayPlan == null){
                //没有上一次的今日计划，没有初始化，第一次执行，需要初始化第一次数据
                todayPlan = addTodayPlan(userId,1);
                //初始化TodayPlanDetail表
                addTodayPlanDetail(todayPlan.getId());
            }else{
                //有上一次的今日计划，新增今日计划
                long lastTodayPlanId = todayPlan.getId();
                //新增今日计划
                todayPlan = addTodayPlan(userId,todayPlan.getLearningNum()+1);
                if(todayPlan.getIsFinish() == Constants.IS_FINISH_YES){
                    //上一次计划已经完成，
                    addTodayPlanDetail(todayPlan.getId());
                }else{
                    //上一次计划未完成
                    copyTodayPlanDetail(todayPlan.getId(),lastTodayPlanId);
                }
            }
        }
        return todayPlan;
    }
}
