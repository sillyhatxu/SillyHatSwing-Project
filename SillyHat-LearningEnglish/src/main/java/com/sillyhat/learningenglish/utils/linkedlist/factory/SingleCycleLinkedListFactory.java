package com.sillyhat.learningenglish.utils.linkedlist.factory;


import com.sillyhat.learningenglish.utils.linkedlist.dto.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 单循环链表工厂
 *
 * @author 徐士宽
 * @date 2017/3/23 10:25
 */
public class SingleCycleLinkedListFactory {

    private static Logger logger = LoggerFactory.getLogger(SingleCycleLinkedListFactory.class);

    private volatile static SingleCycleLinkedListFactory instance;

    private SingleCycleLinkedListFactory(){

    }

    public static SingleCycleLinkedListFactory getInstance() {
        if (instance == null) {
            synchronized (SingleCycleLinkedListFactory.class) {
                if (instance == null) instance = new SingleCycleLinkedListFactory();
            }
        }
        return instance;
    }

    /**
     * 头结点
     */
    private Element header = null;

    private int index = 0;

    /**
     * 插入链表
     */
    public void insert(String value) {
        if(index == 0){
            //第一次插入元素
            header = new Element();
            header.setValue(value);
            header.setNext(header);
        }else{
            //不是第一次插入元素
            Element element = new Element();
            element.setValue(value);
            if (header.getNext() == header){

                header.setNext(element);
                element.setNext(header);
            } else {

                //temp引用在栈中，temp和header引用都指向堆中的initList()中new的Element对象
                Element temp = header;
                while (temp.getNext() != header) {
                    //寻找最后一个元素
                    temp = temp.getNext();
                }
                temp.setNext(element);
                element.setNext(header);//新插入的最后一个节点指向头结点
            }
        }
        index++;
    }

    /**
     * 删除链表中第i个元素
     */
    public void deletelist(String value) {
        Element temp = header;
        while (temp.getNext() != header) {
            //判断temp当前指向的结点的下一个结点是否是要删除的结点
            if (temp.getNext().getValue().equals(value)) {
                temp.setNext(temp.getNext().getNext());//删除结点
            } else {
                temp = temp.getNext();//temp“指针”后移
            }
        }
    }

    /**
     * 获取链表的第i个位置的元素
     */
    public Element getElement(int i) {
        if (i <= 0 || i > size()) {
            logger.info("获取链表的位置有误！返回null");
            return null;
        } else {
            int count = 0;
            Element element = new Element();
            Element temp = header;
            while (temp.getNext() != header) {
                count++;
                if (count == i) {
                    element.setValue(temp.getNext().getValue());
                }
                temp = temp.getNext();
            }
            return element;
        }
    }

    /**
     * 链表长度
     */
    public int size() {
        Element temp = header;
        int size = 0;
        while (temp.getNext() != header) {
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    /**
     * 判断链表中是否存在某元素
     */
    public boolean isContain(String o) {
        Element temp = header;
        while (temp.getNext() != header) {
            if (temp.getNext().getValue().equals(o)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    /**
     * 打印链表
     */
    public void print() {
        logger.info("打印链表：");
        Element temp = header;
        while (temp.getNext() != header) {
            temp = temp.getNext();
            logger.info(temp.getValue());
        }
    }

    public static void main(String[] args) {
        SingleCycleLinkedListFactory factory = SingleCycleLinkedListFactory.getInstance();
        for (int i = 1; i <= 10; i++) {
            factory.insert("Word-" + i);
        }
        Element element = factory.header;
        logger.info(element.getValue());
        while(element.getNext() != null){
            element = element.getNext();
            logger.info(element.getValue());
        }

//        logger.info("打印链表结果：");
//        factory.print();
//        logger.info("生成链表结束");
//        logger.info("-------------------------");
//
//        logger.info("链表长度：" + factory.size());
//        factory.deletelist("Word-1");
//        factory.deletelist("Word-4");
//        factory.print();
//        logger.info("第1个元素值为：" + factory.getElement(1).getValue());
//        logger.info("第2个元素值为：" + factory.getElement(2).getValue());
//        logger.info("第3个元素值为：" + factory.getElement(3).getValue());
//
//        logger.info(factory.isContain("Word-1") + "");
//        logger.info(factory.isContain("Word-2") + "");
//        logger.info(factory.isContain("Word-3") + "");
//        logger.info(factory.isContain("Word-4") + "");
//        logger.info(factory.isContain("Word-5") + "");
    }
}
