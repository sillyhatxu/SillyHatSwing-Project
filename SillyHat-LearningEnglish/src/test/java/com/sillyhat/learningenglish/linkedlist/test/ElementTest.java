package com.sillyhat.learningenglish.linkedlist.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Element
 *
 * @author 徐士宽
 * @date 2017/3/23 11:59
 */
public class ElementTest {

//    public Element(String value) {
//        this.element = value;
//    }
    // 头节点的构造方法
    public ElementTest(ElementTest nextval) {
        this.next = nextval;
    }

    // 非头节点的构造方法
    public ElementTest(String value, ElementTest nextval) {
        this.element = value;
        this.next = nextval;
    }

    private String element;// 数据域

    private ElementTest next;//后继指针域

    private ElementTest prior;//前驱指针域

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public ElementTest getNext() {
        return next;
    }

    public void setNext(ElementTest next) {
//        if(next != null){
//            System.out.println("修改next的值 ----------" + next.getElement());
//        }
        this.next = next;
    }

    public ElementTest getPrior() {
        return prior;
    }

    public void setPrior(ElementTest prior) {
        this.prior = prior;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("Value(" + (i) + ")");
        }
        ElementTest root = new ElementTest(null);
    }
}
