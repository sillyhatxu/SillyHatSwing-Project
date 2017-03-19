package com.sillyhat.learningenglish.business.message.dto;

import java.io.Serializable;

/**
 * Created by ${XUSHIKUAN} on 2017-03-18.
 */
public class YouDaoBasicDTO implements Serializable{

    private static final long serialVersionUID = 6389584531640435600L;

    /**
     * 英式读音
     */
    private String ukPhonetic;

    /**
     * 美式读音
     */
    private String usPhonetic;

    /**
     * 读音
     */
    private String phonetic;

    /**
     * 翻译列表
     */
//    private List<String> explains;


    public String getUkPhonetic() {
        return ukPhonetic;
    }

    public void setUkPhonetic(String ukPhonetic) {
        this.ukPhonetic = ukPhonetic;
    }

    public String getUsPhonetic() {
        return usPhonetic;
    }

    public void setUsPhonetic(String usPhonetic) {
        this.usPhonetic = usPhonetic;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

//    public List<String> getExplains() {
//        return explains;
//    }
//
//    public void setExplains(List<String> explains) {
//        this.explains = explains;
//    }

    @Override
    public String toString() {
        return "YouDaoBasicDTO{" +
                "ukPhonetic='" + ukPhonetic + '\'' +
                ", usPhonetic='" + usPhonetic + '\'' +
                ", phonetic='" + phonetic + '\'' +
//                ", explains=" + explains +
                '}';
    }
}
