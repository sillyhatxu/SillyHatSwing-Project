package com.sillyhat.learningenglish.business.learningplan.dto;

import java.io.Serializable;

/**
 * 今日计划单词列表
 *
 * @author 徐士宽
 * @date 2017/3/14 13:40
 */
public class TodayPlanDetailDTO implements Serializable {


    private static final long serialVersionUID = 9154750008848809392L;
    /**
     *  主键
     */
    private long id;

    /**
     *  今日计划ID
     */
    private long todayPlanId;

    /**
     *  单词ID
     */
    private long wordId;

    /**
     * 记忆过程中发生错误次数
     */
    private int isError;

    /**
     * 出现次数
     */
    private int occurrenceNum;

    /**
     *  排序
     */
    private int sortNum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTodayPlanId() {
        return todayPlanId;
    }

    public void setTodayPlanId(long todayPlanId) {
        this.todayPlanId = todayPlanId;
    }

    public long getWordId() {
        return wordId;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public int getIsError() {
        return isError;
    }

    public void setIsError(int isError) {
        this.isError = isError;
    }

    public int getOccurrenceNum() {
        return occurrenceNum;
    }

    public void setOccurrenceNum(int occurrenceNum) {
        this.occurrenceNum = occurrenceNum;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }


    @Override
    public String toString() {
        return "TodayPlanDetail{" +
                "id='" + id + '\'' +
                ", todayPlanId='" + todayPlanId + '\'' +
                ", wordId='" + wordId + '\'' +
                ", isError=" + isError +
                ", occurrenceNum=" + occurrenceNum +
                ", sortNum=" + sortNum +
                '}';
    }
}
