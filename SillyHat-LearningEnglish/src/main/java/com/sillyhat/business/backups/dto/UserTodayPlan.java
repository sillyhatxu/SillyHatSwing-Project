package com.sillyhat.business.backups.dto;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.Serializable;
import java.util.Date;

/**
 *  今日计划
 *
 * @author 徐士宽
 * @date 2017/3/14 13:40
 */
public class UserTodayPlan implements Serializable {

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
    private Date createdDate;

    /**
     *  修改人
     */
    private String updatedUser;

    /**
     *  修改时间
     */
    private Date updatedDate;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
