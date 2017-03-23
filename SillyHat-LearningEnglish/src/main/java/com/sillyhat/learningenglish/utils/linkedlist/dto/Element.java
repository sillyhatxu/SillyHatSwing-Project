package com.sillyhat.learningenglish.utils.linkedlist.dto;

/**
 * Created by ${XUSHIKUAN} on 2017-03-23.
 */
public class Element {

    private String value;

    private Element next;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}
