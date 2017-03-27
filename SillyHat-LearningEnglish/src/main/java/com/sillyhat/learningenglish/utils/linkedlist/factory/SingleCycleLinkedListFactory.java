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

    /**
     * 指针指向元素
     */
    private Element pointer = null;

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
            //temp引用在栈中，temp和header引用都指向堆中的initList()中new的Element对象
            Element temp = header;
            while (temp.getNext() != header) {
                //寻找最后一个元素
                temp = temp.getNext();
            }
            temp.setNext(element);
            element.setNext(header);//新插入的最后一个节点指向头结点
        }
        index++;
    }

    /**
     * 把某一个元素插入到链表中的第i个位置
     * @param i
     * @param value
     */
    public boolean insert(int i,String value){
        if (i < 0 || i > (size() + 1)) {
            logger.error("获取链表的位置有误。无法将" + value + "值插入");
            return false;
        } else {
            if(i >= size()){
                //插入到末尾，直接插入
                insert(value);
            }else if(i == 0){
                //插入到起点
                Element element = new Element();
                element.setValue(value);
                Element temp = header;
                int oldHeaderHashcode = temp.hashCode();
                element.setNext(temp);
                while (temp.getNext() != header) {
                    temp = temp.getNext();
                }
                header = element;
                temp.setNext(header);
            }else{
                int count = 0;
                Element element = new Element();
                element.setValue(value);
                Element temp = header;
                while (temp.getNext() != header) {
                    if (count == i) {
                        element.setNext(temp.getNext());
                        temp.setNext(element);
                        break;
                    }
                    count++;
                    temp = temp.getNext();
                }
            }
        }
        index++;
        return true;
    }

    /**
     * 删除链表中第i个元素
     */
    public void delete(String value) {
        Element temp = header;
        if(temp != null){
            if(temp.getValue().equals(value)){
                //删除header节点
                Element nowHeader = header.getNext();
                while (temp.getNext() != header) {
                    temp = temp.getNext();
                }
                temp.setNext(nowHeader);
                header = temp;
                index--;
            }else{
                while (temp.getNext() != header) {
                    //判断temp当前指向的结点的下一个结点是否是要删除的结点
                    if (temp.getNext().getValue().equals(value)) {
                        temp.setNext(temp.getNext().getNext());//删除结点
                        index--;
                    } else {
                        temp = temp.getNext();//temp“指针”后移
                    }
                }
            }
            if(index == 0){
                header = null;//链表长度为0，清空header数据
            }
        }else{
            logger.error("链表为null，无法删除");
        }
    }

    /**
     * 获取链表的第i个位置的元素
     */
    public Element getElement(int i){
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
        return index;
    }

    /**
     * 判断链表中是否存在某元素
     */
    public boolean isContain(String value) {
        Element temp = header;
        while (temp.getNext() != header) {
            if (temp.getNext().getValue().equals(value)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public Element getNextElement(){
        if(pointer == null){
            pointer = header;
        }else{
            pointer = pointer.getNext();
        }
        return pointer;
    }

    /**
     * 打印链表
     */
    public void print() {
        logger.info("打印链表：");
        Element temp = header;
        if(temp != null){
            logger.info(temp.getValue());
            while (temp.getNext() != header) {
                temp = temp.getNext();
                logger.info(temp.getValue());
            }
        }else{
            logger.error("链表为空，打印失败");
        }
    }

    public static void main(String[] args) {
        SingleCycleLinkedListFactory factory = SingleCycleLinkedListFactory.getInstance();
//        for (int i = 1; i <= 10; i++) {
//            factory.insert("Word-" + i);
//        }
//        factory.print();
        factory.insert("AAA");
        factory.insert("BBB");
        factory.insert("CCC");
        factory.insert("DDD");
        factory.insert("EEE");
        logger.info(factory.size()+"");
        logger.info("-------------------------------------");
        logger.info("-------------------------------------");
        logger.info("-------------------------------------");
        logger.info("-------------------------------------");
        factory.delete("AAA");
        logger.info("delete AAA size--->" + factory.size()+"");
        factory.print();
        factory.delete("BBB");
        logger.info("delete BBB size--->" + factory.size()+"");
        factory.print();
        factory.delete("CCC");
        logger.info("delete CCC size--->" + factory.size()+"");
        factory.print();
        factory.delete("DDD");
        logger.info("delete DDD size--->" + factory.size()+"");
        factory.print();
        factory.delete("EEE");
        logger.info("delete EEE size--->" + factory.size()+"");
        factory.print();
        logger.info((SingleCycleLinkedListFactory.getInstance().getNextElement() == null) + "");

//        for (int i = 0; i < 80; i++) {
//            logger.info(SingleCycleLinkedListFactory.getInstance().getNextElement().getValue());
//        }
//        System.out.println(factory.size());
//        logger.info("链表长度：" + factory.size());
//        factory.delete("Word-1");
//        factory.delete("Word-4");
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
