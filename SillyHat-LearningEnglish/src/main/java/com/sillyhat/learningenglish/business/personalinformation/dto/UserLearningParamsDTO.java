package com.sillyhat.learningenglish.business.personalinformation.dto;

import java.io.Serializable;

/**
 * 学习参数
 *
 * @author 徐士宽
 * @date 2017/3/14 13:40
 */
public class UserLearningParamsDTO implements Serializable {


    private static final long serialVersionUID = 4798578886854498036L;
    /**
     *  主键
     */
    private long id;

    /**
     *  用户ID
     */
    private long userId;

    /**
     *  学习新词数量
     */
    private int learningNum;

    /**
     *  复习词汇数量
     */
    private int reviewNum;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(long createdUser) {
        this.createdUser = createdUser;
    }

    public long getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(long updatedUser) {
        this.updatedUser = updatedUser;
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

    public int getReviewNum() {
        return reviewNum;
    }

    public void setReviewNum(int reviewNum) {
        this.reviewNum = reviewNum;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "UserLearningParamsDTO{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", learningNum=" + learningNum +
                ", reviewNum=" + reviewNum +
                ", createdUser='" + createdUser + '\'' +
                ", createdDate=" + createdDate +
                ", updatedUser='" + updatedUser + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
