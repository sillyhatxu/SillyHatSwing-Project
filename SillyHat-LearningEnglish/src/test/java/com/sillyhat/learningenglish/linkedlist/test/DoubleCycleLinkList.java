package com.sillyhat.learningenglish.linkedlist.test;

/**
 * DoubleCycleLinkList
 *
 * @author 徐士宽
 * @date 2017/3/23 16:27
 */
public class DoubleCycleLinkList {

    public static void main(String[] args) throws Exception {
        DoubleCycleLinkList list = new DoubleCycleLinkList();
        for (int i = 0; i < 10; i++) {
            // 0-99之间的整数
//            int temp = (int) (Math.random() * 100);
            list.insert(i, "Value(" + (i + 1) + ")");
        }
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
        list.delete(4);
        System.out.println();
        System.out.println("----删除第五个元素之后------");
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    Node head;// 头指针
    Node current;// 当前节点对象
    int size; // 节点的个数

    // 初始化一个空链表
    public DoubleCycleLinkList() {
        // 初始化头节点，让头指针指向头节点,并且让当前节点对象等于头节点
        this.head = current = new Node(null);
        this.size = 0; // 单项链表出事长度为0
        // 循环列表属性
        this.head.next = head;
        this.head.prior = head;
    }

    // 定位函数,实现当前操作对象的前一个节点，也就是让当前节点对象定位到要要操作节点的前一个节点
    public void index(int index) throws Exception {
        // 参数非法时，出现-1是由于第一个元素的下标是0，而第一个元素的前面就是头节点，该节点就得用-1表示下标了。
        if (index < -1 || index > size - 1) {
            throw new Exception("参数错误");
        }
        // 说明是在头节点之后进行操作
        if (index == -1)
            return;
        // 通过该循环获得要操作的那个数的前一个节点
        current = head.next;
        int j = 0;// 循环变量
        // 循环链表属性
        while (current != head && j < index) {
            current = current.next;
            j++;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int index, Object obj) throws Exception {
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
        current.setNext(new Node(obj, current.next));
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
        current.setNext(current.next.next);
        // 修改前驱指针
        current.next.setPrior(current);
        size--;

    }

    public Object get(int index) throws Exception {
        if (index < -1 || index > size - 1) {
            throw new Exception("参数非法，无法查询");
        }
        // 先定位
        index(index);
        return current;
    }

}

//节点类
//这个是重点！！！！Java一样可以实现指针的跳转->使用引用
class Node {

    Object element; // 数据域
    Node next;// 后继指针域
    Node prior;// 前驱指针域

    // 头节点的构造方法
    public Node(Node nextval) {
        this.next = nextval;
    }

    // 非头节点的构造方法
    public Node(Object obj, Node nextval) {
        this.element = obj;
        this.next = nextval;
    }

    // 获得当前节点的后继结点
    public Node getNext() {
        return this.next;
    }

    // 获得当前节点的前驱结点
    public Node getPrior() {
        return this.prior;
    }

    // 获得当前节点的数据域的值
    public Object getElement() {
        return this.element;
    }

    // 设置当前节点的后继指针域
    public void setNext(Node nextval) {
        this.next = nextval;
    }

    // 设置当前节点的前驱指针域
    public void setPrior(Node priorval) {
        this.prior = priorval;
    }


    // 设置当前节点的数据域，
    public void setElement(Object obj) {
        this.element = obj;
    }

    public String toString() {
        return this.element.toString();
    }
}
