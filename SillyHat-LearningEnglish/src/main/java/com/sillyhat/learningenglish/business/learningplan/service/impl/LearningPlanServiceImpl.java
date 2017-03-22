package com.sillyhat.learningenglish.business.learningplan.service.impl;

import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDetailDTO;
import com.sillyhat.learningenglish.business.learningplan.dto.UserLearningPlanDTO;
import com.sillyhat.learningenglish.business.learningplan.mapper.LearningPlanMapper;
import com.sillyhat.learningenglish.business.learningplan.service.LearningPlanService;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.utils.SortNumUtils;
import com.sillyhat.learningenglish.utils.cache.SystemCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

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
        UserDTO user = SystemCache.getUserCache();
        List<UserLearningPlanDTO> learningWordList = learningPlanMapper.queryLearningPlanLearningWordList(user.getId(),learningNum,null);
        List<UserLearningPlanDTO> reviewWordList = learningPlanMapper.queryLearningPlanReviewWordList(user.getId(),reviewNum,null);
        List<TodayPlanDetailDTO> todayPlanDetailList = new ArrayList<TodayPlanDetailDTO>();
        List<Integer> sortList = SortNumUtils.getSortList(learningNum + reviewNum);
        int sortIndex = 0;
        for (UserLearningPlanDTO dto : learningWordList) {
            TodayPlanDetailDTO todayPlanDetail = new TodayPlanDetailDTO();
            todayPlanDetail.setTodayPlanId(todayPlanId);
            todayPlanDetail.setWordId(dto.getWordId());
            todayPlanDetail.setIsError(Constants.DEFAULT_IS_ERROR);
            todayPlanDetail.setOccurrenceNum(Constants.DEFAULT_OCCURRENCE_NUM);
            todayPlanDetail.setSortNum(sortList.get(sortIndex));
            sortIndex++;
            learningPlanMapper.addTodayPlanDetail(todayPlanDetail);
        }
        for (UserLearningPlanDTO dto : reviewWordList) {
            TodayPlanDetailDTO todayPlanDetail = new TodayPlanDetailDTO();
            todayPlanDetail.setTodayPlanId(todayPlanId);
            todayPlanDetail.setWordId(dto.getWordId());
            todayPlanDetail.setIsError(Constants.DEFAULT_IS_ERROR);
            todayPlanDetail.setOccurrenceNum(Constants.DEFAULT_OCCURRENCE_NUM);
            todayPlanDetail.setSortNum(sortList.get(sortIndex));
            sortIndex++;
            learningPlanMapper.addTodayPlanDetail(todayPlanDetail);
        }
    }

    private Set<Long> getWordIdSet(List<TodayPlanDetailDTO> todayPlanDetailList){
        Set<Long> existingWordIdSet = new HashSet<Long>();
        for (TodayPlanDetailDTO dto : todayPlanDetailList){
            existingWordIdSet.add(dto.getWordId());
        }
        return  existingWordIdSet;
    }

    private void copyTodayPlanDetail(Long todayPlanId,Long lastPlanId){
        UserDTO user = SystemCache.getUserCache();
        int learningNum = SystemCache.getCountCache(Constants.CACHE_USER_LEARNING_NUM);
        int reviewNum = SystemCache.getCountCache(Constants.CACHE_USER_REVIEW_NUM);
        //copy上一批计划词汇
        List<TodayPlanDetailDTO> todayPlanDetailList = queryTodayPlanDetailByTodayPlanId(lastPlanId);
        Set<Long> existingWordIdSet = getWordIdSet(todayPlanDetailList);//已经存在的WordID列表
        int total = learningNum + reviewNum;
        if(todayPlanDetailList.size() < total){
            //词汇数量不足，需要补充
            if(total - todayPlanDetailList.size() >= learningNum){
                //需从数据库中提取新词汇
                int collectNum = learningNum;
                List<UserLearningPlanDTO> learningWordList = learningPlanMapper.queryLearningPlanLearningWordList(user.getId(),learningNum,existingWordIdSet);
                for (UserLearningPlanDTO dto : learningWordList) {
                    TodayPlanDetailDTO todayPlanDetail = new TodayPlanDetailDTO();
                    todayPlanDetail.setWordId(dto.getWordId());
                    todayPlanDetailList.add(todayPlanDetail);
                }
            }
            if(total - todayPlanDetailList.size() - learningNum > 0){
                //需从数据库中提取复习词汇
                int collectNum = total - todayPlanDetailList.size() - learningNum;
                List<UserLearningPlanDTO> reviewWordList = learningPlanMapper.queryLearningPlanReviewWordList(user.getId(),collectNum,existingWordIdSet);
                for (UserLearningPlanDTO dto : reviewWordList) {
                    TodayPlanDetailDTO todayPlanDetail = new TodayPlanDetailDTO();
                    todayPlanDetail.setWordId(dto.getWordId());
                    todayPlanDetailList.add(todayPlanDetail);
                }
            }
        }
        batchAddTodayPlanDetail(todayPlanDetailList,todayPlanId);
    }

    private void batchAddTodayPlanDetail(List<TodayPlanDetailDTO> todayPlanDetailList,long todayPlanId){
        List<Integer> sortList = SortNumUtils.getSortList(todayPlanDetailList.size());
        int sortIndex = 0;
        for (TodayPlanDetailDTO todayPlanDetail : todayPlanDetailList){
            todayPlanDetail.setTodayPlanId(todayPlanId);
            todayPlanDetail.setIsError(Constants.DEFAULT_IS_ERROR);
            todayPlanDetail.setOccurrenceNum(Constants.DEFAULT_OCCURRENCE_NUM);
            todayPlanDetail.setSortNum(sortList.get(sortIndex));
            sortIndex++;
            learningPlanMapper.addTodayPlanDetail(todayPlanDetail);
        }
    }

    private String getNextDate(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR,1);
        return sdfData.format(calendar.getTime());
    }
    @Override
    public TodayPlanDTO getTodayPlan(long userId) {
        //得到今日计划
        TodayPlanDTO todayPlan = learningPlanMapper.getTodayPlan(sdfData.format(new Date()),getNextDate());
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
        List<TodayPlanDetailDTO> todayPlanDetailList = queryTodayPlanDetailByTodayPlanId(todayPlan.getId());
        todayPlan.setTodayPlanDetailList(todayPlanDetailList);
        return todayPlan;
    }

    @Override
    public List<TodayPlanDetailDTO> queryTodayPlanDetailByTodayPlanId(long todayPlanId) {
        return learningPlanMapper.queryTodayPlanDetailByTodayPlanId(todayPlanId);
    }

    @Override
    public void updateTodayPlanDetail(TodayPlanDetailDTO dto) {
        learningPlanMapper.updateTodayPlanDetail(dto);
    }

    @Override
    public void clearUserPlan() {
        learningPlanMapper.deleteUserTodayPlan();
        learningPlanMapper.deleteUserTodayPlanDetail();

    }
}
