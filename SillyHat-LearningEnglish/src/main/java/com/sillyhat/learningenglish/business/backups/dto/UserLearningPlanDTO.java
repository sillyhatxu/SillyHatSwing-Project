package com.sillyhat.learningenglish.business.backups.dto;

import java.io.Serializable;

/**
 * 学习计划
 *
 * @author 徐士宽
 * @date 2017/3/14 13:40
 */
public class UserLearningPlanDTO implements Serializable {

    private static final long serialVersionUID = 3388712574491877305L;

    /**
     *  主键
     */
    private String id;

    /**
     *  用户ID
     */
    private String userId;

    /**
     *  单词ID
     */
    private String wordId;

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

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
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
        return "UserLearningPlanDTO{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", wordId='" + wordId + '\'' +
                ", isLearning=" + isLearning +
                ", reviewFrequency=" + reviewFrequency +
                ", errorFrequency=" + errorFrequency +
                ", successFrequency=" + successFrequency +
                ", createdUser='" + createdUser + '\'' +
                ", createdDate=" + createdDate +
                ", updatedUser='" + updatedUser + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
