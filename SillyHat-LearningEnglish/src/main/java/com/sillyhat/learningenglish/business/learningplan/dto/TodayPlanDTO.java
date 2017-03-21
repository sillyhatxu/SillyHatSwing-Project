package com.sillyhat.learningenglish.business.learningplan.dto;

import java.io.Serializable;
import java.util.List;

/**
 *  今日计划
 *
 * @author 徐士宽
 * @date 2017/3/14 13:40
 */
public class TodayPlanDTO implements Serializable {


    private static final long serialVersionUID = 8277707522673895793L;
    /**
     *  主键
     */
    private long id;

    /**
     *  用户ID
     */
    private long userId;

    /**
     *  学习次数
     */
    private int learningNum;

    /**
     * 是否完成；0：未完成；1：已完成
     */
    private int isFinish;

    /**
     *  创建人
     */
    private long createdUser;

    /**
     *  创建时间
     */
    private String createdDate;

    /**
     *  修改人
     */
    private long updatedUser;

    /**
     *  修改时间
     */
    private String updatedDate;

    private List<TodayPlanDetailDTO> todayPlanDetailList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getLearningNum() {
        return learningNum;
    }

    public void setLearningNum(int learningNum) {
        this.learningNum = learningNum;
    }

    public int getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(int isFinish) {
        this.isFinish = isFinish;
    }

    public long getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(long createdUser) {
        this.createdUser = createdUser;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public long getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(long updatedUser) {
        this.updatedUser = updatedUser;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<TodayPlanDetailDTO> getTodayPlanDetailList() {
        return todayPlanDetailList;
    }

    public void setTodayPlanDetailList(List<TodayPlanDetailDTO> todayPlanDetailList) {
        this.todayPlanDetailList = todayPlanDetailList;
    }

    @Override
    public String toString() {
        return "UserTodayPlanDTO{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", learningNum=" + learningNum +
                ", isFinish=" + isFinish +
                ", createdUser='" + createdUser + '\'' +
                ", createdDate=" + createdDate +
                ", updatedUser='" + updatedUser + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
