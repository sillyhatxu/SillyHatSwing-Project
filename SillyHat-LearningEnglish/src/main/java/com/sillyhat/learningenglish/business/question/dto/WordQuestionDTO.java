package com.sillyhat.learningenglish.business.question.dto;

import java.io.Serializable;

/**
 * 单词考察
 * @author 徐士宽
 * @date 2017/3/13 11:47
 */
public class WordQuestionDTO implements Serializable {

    private String id;

    private String question;

    private String reminder;

    private String translate;

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getReminder() {
        return reminder;
    }

    public String getTranslate() {
        return translate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    @Override
    public String toString() {
        return "WordQuestionDTO{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", reminder='" + reminder + '\'' +
                ", translate='" + translate + '\'' +
                '}';
    }
}
