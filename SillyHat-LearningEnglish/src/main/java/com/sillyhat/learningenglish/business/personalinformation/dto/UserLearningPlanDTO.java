package com.sillyhat.learningenglish.business.personalinformation.dto;

import java.io.Serializable;

/**
 * 学习计划
 *
 * @author 徐士宽
 * @date 2017/3/14 13:40
 */
public class UserLearningPlanDTO implements Serializable {

    private static final long serialVersionUID = 7997455559092406211L;
    /**
     *  主键
     */
    private long id;

    /**
     *  用户ID
     */
    private long userId;

    /**
     *  单词ID
     */
    private long wordId;

    /**
     *  是否已经学习：0：未学；1：已学
     */
    private int isLearning;

    /**
     *  复习次数
     */
    private int reviewFrequency;

    /**
     *  错误次数
     */
    private int errorFrequency;

    /**
     *  成功次数
     */
    private int successFrequency;

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

    private String createdUserName;
    private String updatedUserName;
    public String getCreatedUserName() {
        return createdUserName;
    }

    public void setCreatedUserName(String createdUserName) {
        this.createdUserName = createdUserName;
    }

    public String getUpdatedUserName() {
        return updatedUserName;
    }

    public void setUpdatedUserName(String updatedUserName) {
        this.updatedUserName = updatedUserName;
    }

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

    public long getWordId() {
        return wordId;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public int getIsLearning() {
        return isLearning;
    }

    public void setIsLearning(int isLearning) {
        this.isLearning = isLearning;
    }

    public int getReviewFrequency() {
        return reviewFrequency;
    }

    public void setReviewFrequency(int reviewFrequency) {
        this.reviewFrequency = reviewFrequency;
    }

    public int getErrorFrequency() {
        return errorFrequency;
    }

    public void setErrorFrequency(int errorFrequency) {
        this.errorFrequency = errorFrequency;
    }

    public int getSuccessFrequency() {
        return successFrequency;
    }

    public void setSuccessFrequency(int successFrequency) {
        this.successFrequency = successFrequency;
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

    @Override
    public String toString() {
        return "UserLearningPlanDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", wordId=" + wordId +
                ", isLearning=" + isLearning +
                ", reviewFrequency=" + reviewFrequency +
                ", errorFrequency=" + errorFrequency +
                ", successFrequency=" + successFrequency +
                ", createdUser=" + createdUser +
                ", createdDate='" + createdDate + '\'' +
                ", updatedUser=" + updatedUser +
                ", updatedDate='" + updatedDate + '\'' +
                ", createdUserName='" + createdUserName + '\'' +
                ", updatedUserName='" + updatedUserName + '\'' +
                '}';
    }
}
