package com.sillyhat.learningenglish.linkedlist.factory;

import com.sillyhat.learningenglish.linkedlist.dto.Element;

/**
 * 单循环链表工厂
 *
 * @author 徐士宽
 * @date 2017/3/23 10:25
 */
public class SingleCycleLinkedListFactory {

    /**
     * 头指针（第一个节点的前一个节点）
     */
    private Element headPointer;

    /**
     * 头节点（第一个节点）
     */
    private Element headNode;

    /**
     * 当前指针所指向节点元素
     */
    private Element current;

    int size;//节点的个数

    /**
     * 得到链表长度
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 初始化一个空链表
     */
    public SingleCycleLinkedListFactory() {
        //初始化头节点，让头指针指向头节点,并且让当前节点对象等于头节点
        this.headPointer = current = new Element(null);
        this.headNode = new Element(null);
        //循环列表属性
        this.headPointer.setNext(headPointer);
        this.headPointer.setPrior(headPointer);
        this.size = 0;// 单项链表出事长度为0
    }

    // 定位函数,实现当前操作对象的前一个节点，也就是让当前节点对象定位到要要操作节点的前一个节点
    public void index(int index) throws Exception {
        //参数非法
        //第一个元素的下标是0，不允许出现-1;而第一个元素的前面就是头节点，该节点就得用-1表示下标了。
        if (index < -1 || index > size - 1) {
            throw new Exception("参数错误");
        }
        // 说明是在头节点之后进行操作
        if (index == -1) return;
        // 通过该循环获得要操作的那个数的前一个节点
        current = headPointer.getNext();
        int i = 0;// 循环变量
        // 循环链表属性
        while (current != headPointer && i < index) {
            current = current.getNext();
            i++;
        }
    }

    /**
     * 获得节点
     * @return
     */
    public Element getHeadNode(){


        return headNode;
    }

//    public Element getHeadNode() {
//        return headNode;
//    }

    /**
     * 向链表插入数据
     * @param index
     * @param value
     * @throws Exception
     */
    public void insert(int index, String value) throws Exception {
        // 可以等于0表示在一个元素的前面插入，也就是头结点的后面
        if (index < 0 || index > size) {
            throw new Exception("参数错误！ ");
        }
        /**
         * 这里是核心操作
         */
        // 定位到要操作节点的前一个节点对象
        index(index - 1);
        // 将前一个节点进行设置,使其指向要插入节点的指针域，
        Element element = new Element(value, current.getNext());
        element.setPrior(current);
        current.setNext(element);
        refreshHeadNode(index);
        size++;
    }


    public void delete(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("链表为空，无法删除");
        }
        if (index < 0 || index > size) {
            throw new Exception("参数错误！");
        }
        // 进行定位
        index(index - 1);
        // current此时表示要删除节点的前一个节点的指示，因此需要将该节点指向要删除的那个节点的下一个节点才对
        // 修改后继指针
        current.setNext(current.getNext().getNext());
        // 修改前驱指针
        current.getNext().setPrior(current);
        size--;

    }

    public Element get(int index) throws Exception {
        if (index < -1 || index > size - 1) {
            throw new Exception("参数非法，无法查询");
        }
        index = getIndex(index);
        // 先定位
        index(index);
        return current;
    }

    /**
     * 重新设定指定index的值，因为是循环链表，所以允许在链表长度为3时提取index为4的值，实际是提取index为0的值
     * @param index
     * @return
     */
    private int getIndex(int index){
        boolean goonGetIndex = true;
        while(goonGetIndex){
            if(index >= size()){
                index = index - (size() + 1);
            }else{
                goonGetIndex = false;
            }
        }
        return index;
    }

    /**
     * 刷新头节点
     * @param index
     */
    private void refreshHeadNode(int index){
        if(index == 0){
            headNode.setElement(current.getNext().getElement());
            headNode.setNext(current.getNext());
            headNode.setPrior(current.getNext());
        }else{
            if(index == 1){
                //更新头节点的上一个节点（最后一个节点）
                headNode.setNext(current.getNext());
            }
            headNode.setPrior(current.getNext());
        }
    }

    public static void main(String[] args) throws Exception {
        SingleCycleLinkedListFactory linkedListFactory = new SingleCycleLinkedListFactory();
        for (int i = 0; i < 5; i++) {
            linkedListFactory.insert(i,"Value(" + (i) + ")");
        }
        System.out.println("链表长度：" + linkedListFactory.size());
        System.out.println("head元素 --- " + linkedListFactory.getHeadNode().getElement());
        System.out.println("head上一个元素 --- " + linkedListFactory.getHeadNode().getPrior().getElement());
        System.out.println("head下一个元素 --- " + linkedListFactory.getHeadNode().getNext().getElement());
        for (int i = 0; i < linkedListFactory.size(); i++) {
            Element element = linkedListFactory.get(i);
            System.out.println("得到第"+i+"个元素 --- " + element.getElement() + "");
            System.out.println("直接得到上一个元素 --- " + (element.getPrior() != null ? element.getPrior().getElement() : "") + "");
            System.out.println("直接得到下一个元素 --- " + element.getNext().getElement() + "");
            System.out.println("---------------------------------------------------");
        }
//        System.out.println("现在链表的大小值：" + linkedList.size);
//        int doubleCycle = 0;//打算循环两次
//        while(doubleCycle < 2){
//            System.out.println("headPointer --- " + linkedList.getHead().getElement());
//            for (int i = 0; i < linkedList.size; i++) {
//                System.out.println("得到第 "+i+"个元素 --- " + linkedList.get(i).getElement() + "");
//                System.out.println("直接得到下一个元素 --- " + linkedList.get(i).getNext().getElement() + "");
//                System.out.println("直接得到上一个元素 --- " + (linkedList.get(i).getPrior() != null ? linkedList.get(i).getPrior().getElement() : "") + "");
//                System.out.println("---------------------------------------------------");
//            }
//            doubleCycle++;
//        }
//        linkedList.delete(4);
//        System.out.println("----删除第五个元素之后------");
//        System.out.println("现在链表的大小值：" + linkedList.size);
//        System.out.println("输出链表的内容");
//        System.out.println("");
//        System.out.println("");

    }
}
