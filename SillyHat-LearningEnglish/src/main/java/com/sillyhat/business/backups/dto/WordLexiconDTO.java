package com.sillyhat.business.backups.dto;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.Serializable;
import java.util.Date;

/**
 * 单词库
 */
public class WordLexiconDTO implements Serializable {

    private static final long serialVersionUID = -2992912088565114022L;

    /**
     *  主键
     */
    private String id;

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
    private String translate;

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

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
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