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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    }

    /**
     * 新增learningNum个新词汇，新增reviewNum个复习词汇
     * @param learningNum
     * @param reviewNum
     * @param todayPlanId
     */
    private void addTodayPlanDetail(int learningNum,int reviewNum,long todayPlanId){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("learningNum",learningNum);
        params.put("reviewNum",reviewNum);
        params.put("todayPlanId",todayPlanId);
        List<TodayPlanDetailDTO> addUserLearningPlanList = new ArrayList<TodayPlanDetailDTO>();
        List<UserLearningPlanDTO> userLearningPlanList = learningPlanMapper.queryUserLearningPlanByParams(params);
//        private int isError;//记忆过程中发生错误次数  默认0
//        private int occurrenceNum;//出现次数    默认 3
//        private int sortNum;   //乱序后    取值i
        for (UserLearningPlanDTO userLearningPlan : userLearningPlanList) {
            TodayPlanDetailDTO todayPlanDetail = new TodayPlanDetailDTO();
            todayPlanDetail.setWordId(userLearningPlan.getWordId());
            todayPlanDetail.setTodayPlanId(todayPlanId);
            addUserLearningPlanList.add(todayPlanDetail);
        }

        //乱序算法



        for (int i = 0; i < addUserLearningPlanList.size(); i++) {
            TodayPlanDetailDTO dto = addUserLearningPlanList.get(i);
            dto.setSortNum(i + 1);
            learningPlanMapper.addTodayPlanDetail(dto);
        }
    }

    private void copyTodayPlanDetail(Long todayPlanId,Long lastPlanId){
        int learningNum = SystemCache.getCountCache(Constants.CACHE_USER_LEARNING_NUM);
        int reviewNum = SystemCache.getCountCache(Constants.CACHE_USER_REVIEW_NUM);
        int total = learningNum + reviewNum;
        //copy上一批计划词汇
        List<TodayPlanDetailDTO> todayPlanDetailList = learningPlanMapper.queryTodayPlanDetailByTodayPlanId(lastPlanId);
        for (TodayPlanDetailDTO todayPlanDetail : todayPlanDetailList){
            todayPlanDetail.setTodayPlanId(todayPlanId);
            learningPlanMapper.addTodayPlanDetail(todayPlanDetail);
        }
        int nowWordNum = todayPlanDetailList.size();
        if(nowWordNum < total){
            //单词不够，默认上次单词为已经学过的内容，为单词添加新单词
            if(learningNum > total - nowWordNum){
                //不需要补充全部新词汇

            }else{

            }
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
