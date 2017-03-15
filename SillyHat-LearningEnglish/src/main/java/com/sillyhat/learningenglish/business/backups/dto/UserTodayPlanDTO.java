package com.sillyhat.learningenglish.business.backups.dto;

import java.io.Serializable;

/**
 *  今日计划
 *
 * @author 徐士宽
 * @date 2017/3/14 13:40
 */
public class UserTodayPlanDTO implements Serializable {

    private static final long serialVersionUID = 1545917272572810508L;

    /**
     *  主键
     */
    private String id;

    /**
     *  用户ID
     */
    private String userId;

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
    private String createdUser;

    /**
     *  创建时间
     */
    private String createdDate;

    /**
     *  修改人
     */
    private String updatedUser;

    /**
     *  修改时间
     */
    private String updatedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
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