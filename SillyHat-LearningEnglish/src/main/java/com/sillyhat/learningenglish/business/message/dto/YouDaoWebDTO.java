package com.sillyhat.learningenglish.business.message.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${XUSHIKUAN} on 2017-03-18.
 */
public class YouDaoWebDTO implements Serializable {

    private static final long serialVersionUID = -6586212417855991949L;

    private String key;

    private List<String> value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "YouDaoWebDTO{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
