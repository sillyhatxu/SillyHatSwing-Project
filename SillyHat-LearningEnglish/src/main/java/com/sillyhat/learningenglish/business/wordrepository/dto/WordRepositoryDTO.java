package com.sillyhat.learningenglish.business.wordrepository.dto;

import java.io.Serializable;

/**
 * 单词库
 */
public class WordRepositoryDTO implements Serializable {

    private static final long serialVersionUID = -2992912088565114022L;

    /**
     *  主键
     */
    private long id;

    /**
     *  单词
     */
    private String word;

    /**
     *  音标
     */
    private String phonetic;

    /**
     *  提示
     */
    private String reminder;

    /**
     *  翻译
     */
    private String wordTranslate;

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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public String getWordTranslate() {
        return wordTranslate;
    }

    public void setWordTranslate(String wordTranslate) {
        this.wordTranslate = wordTranslate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "WordRepositoryDTO{" +
                "id='" + id + '\'' +
                ", word='" + word + '\'' +
                ", phonetic='" + phonetic + '\'' +
                ", reminder='" + reminder + '\'' +
                ", wordTranslate='" + wordTranslate + '\'' +
                ", createdUser='" + createdUser + '\'' +
                ", createdDate=" + createdDate +
                ", updatedUser='" + updatedUser + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}