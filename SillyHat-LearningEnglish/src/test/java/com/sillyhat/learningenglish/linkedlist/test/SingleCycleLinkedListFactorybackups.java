package com.sillyhat.learningenglish.linkedlist.test;

import com.sillyhat.learningenglish.linkedlist.dto.Element;

/**
 * 单循环链表工厂
 *
 * @author 徐士宽
 * @date 2017/3/23 10:25
 */
public class SingleCycleLinkedListFactorybackups {

    /**
     * 开头节点元素
     */
    private Element head;
    private Element headPointer;

    /**
     * 当前指针所指向节点元素
     */
    private Element current;

    /**
     * 链表节点的个数（存储时使用下一个节点的指针，既链表长度）
     */
    private int index;

    /**
     *  指针位置
     */
    private int currentIndex;
    /**
     * 空链表初始化
     */
    public SingleCycleLinkedListFactorybackups() {
        this.index = 0;//单项链表出事长度为0
        this.currentIndex = 0;//提取时使用的指针位置
    }

    /**
     * 插入
     * @param index
     * @param obj
     * @throws Exception
     */
    public void insert(String value) throws Exception {
        if(index == 0){
            //head节点
//            head = new Element(value);
//            current = new Element(value);
            //如果链表长度，紧紧唯1，则当前节点的下一个节点和上一个节点都是它自己
            current.setNext(current);
            current.setPrior(current);
            head.setNext(current);
            head.setPrior(current);
        }else{
            // 定位到要操作节点的前一个节点对象
            index(index - 1);
            // 将前一个节点进行设置,使其指向要插入节点的指针域，
            current.setNext(new Element(value, current.getNext()));
            current.setPrior(current);
            if(index == 1){
                //更新头节点的上一个节点（最后一个节点）
                head.setNext(current.getNext());
            }
            head.setPrior(current.getNext());
        }
        index++;
    }

    public void index(int index) throws Exception {
        if (index <= -1) {
            //参数非法
            //第一个元素的下标是0，不允许出现-1;而第一个元素的前面就是头节点，该节点就得用-1表示下标了。
            throw new Exception("参数错误");
        }
        index = getIndex(index);//重新设定指定index的值，因为是循环链表，所以允许在链表长度为3时提取index为4的值，实际是提取index为0的值
        // 说明是在头节点之后进行操作
        if (index == -1)
            return;
        // 通过该循环获得要操作的那个数的前一个节点
        current = head;
        int i = 0;// 循环变量
        // 循环链表属性
        while (i < index) {
            current = current.getNext();
            i++;
        }
    }

    /**
     * 重新设定指定index的值，因为是循环链表，所以允许在链表长度为3时提取index为4的值，实际是提取index为0的值
     * @param index
     * @return
     */
    private int getIndex(int index){
        boolean goonGetIndex = true;
        while(goonGetIndex){
            if(index >= getSize()){
                index = index - (getSize() + 1);
            }else{
                goonGetIndex = false;
            }
        }
        return index;
    }

    /**
     * 得到链表单向长度
     * @return
     */
    public int getSize() {
        return this.index;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.index == 0;
    }

//    public void delete(int index) throws Exception {
//        if (isEmpty()) {
//            throw new Exception("链表为空，无法删除");
//        }
//
//        if (index < 0 || index > size) {
//            throw new Exception("参数错误！");
//        }
//        // 进行定位
//        index(index - 1);
//        // current此时表示要删除节点的前一个节点的指示，因此需要将该节点指向要删除的那个节点的下一个节点才对
//        // 修改后继指针
//        current.setNext(current.getNext().getNext());
//        // 修改前驱指针
//        current.getNext().setPrior(current);
//        size--;
//
//    }

    /**
     * 得到当前指针指向位置
     * @return
     */
    public Element get(int index) throws Exception {
        if (index < -1) {
            throw new Exception("参数非法，无法查询");
        }
        // 先定位
        index(index);
        return current;
    }

    /**
     * 得到头指针
     * @return
     */
    public Element getHead() {
        return head;
    }

    public static void main(String[] args) throws Exception {
        SingleCycleLinkedListFactorybackups linkedListFactory = new SingleCycleLinkedListFactorybackups();
        for (int i = 0; i < 10; i++) {
            linkedListFactory.insert("Value(" + (i) + ")");
        }
        System.out.println(linkedListFactory.getSize());
        System.out.println("head元素 --- " + linkedListFactory.getHead().getElement());
        System.out.println("head上一个元素 --- " + linkedListFactory.getHead().getPrior().getElement());
        System.out.println("head下一个元素 --- " + linkedListFactory.getHead().getNext().getElement());
        for (int i = 0; i < linkedListFactory.getSize(); i++) {
            Element element = linkedListFactory.get(i);
            System.out.println("得到第"+i+"个元素 --- " + element.getElement() + "");
            System.out.println("直接得到上一个元素 --- " + (element.getPrior() != null ? element.getPrior().getElement() : "") + "");
            System.out.println("直接得到下一个元素 --- " + element.getNext().getElement() + "");
            System.out.println("---------------------------------------------------");
        }
//        System.out.println(linkedListFactory.getIndex(11));

//        for (int i = 0; i < 20; i++) {
//            // 0-99之间的整数
////            int temp = (int) (Math.random() * 100);
////            linkedList.insert(i, "Value(" + (i + 1) + ")");
//        }
//        System.out.println("现在链表的大小值：" + linkedList.size);
//        int doubleCycle = 0;//打算循环两次
//        while(doubleCycle < 2){
//            System.out.println("Head --- " + linkedList.getHead().getElement());
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
