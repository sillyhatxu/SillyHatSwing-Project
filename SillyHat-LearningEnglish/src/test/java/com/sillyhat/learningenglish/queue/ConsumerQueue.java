package com.sillyhat.learningenglish.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * ConsumerQueue
 *
 * @author 徐士宽
 * @date 2017/3/22 17:28
 */
public class ConsumerQueue {

    /** 装鸡蛋的盘子，大小为5 */
    private BlockingQueue<String> eggs = new ArrayBlockingQueue<>(5);

    /** 放鸡蛋 */
    public void putEgg(String egg) {
        try {
            eggs.put(egg);// 向盘子末尾放一个鸡蛋，如果盘子满了，当前线程阻塞  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 下面输出有时不准确，因为与put操作不是一个原子操作  
        System.out.println("放入鸡蛋:" + egg);
    }

    /** 取鸡蛋 */
    public String getEgg() {
        String egg = null;
        try {
            egg = eggs.take();// 从盘子开始取一个鸡蛋，如果盘子空了，当前线程阻塞  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 下面输出有时不准确，因为与take操作不是一个原子操作  
        System.out.println("拿到鸡蛋:" + egg);
        return egg;
    }

    /** 放鸡蛋线程 */
    static class AddThread extends Thread {
        private ConsumerQueue plate;
        private int start;
        private int end;
        private Object egg = new Object();

        public AddThread(ConsumerQueue plate,int start,int end) {
            this.plate = plate;
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i <= end; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                plate.putEgg(i+"");
            }
        }
    }

    /** 取鸡蛋线程 */
    static class GetThread extends Thread {
        private ConsumerQueue plate;

        public GetThread(ConsumerQueue plate) {
            this.plate = plate;
        }

        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            plate.getEgg();
        }
    }

    public static void main(String[] args) {
        ConsumerQueue plate = new ConsumerQueue();
        // 先启动10个放鸡蛋线程
        for(int i = 1; i <= 10; i++) {
            new Thread(new AddThread(plate,i,i * 10)).start();
        }
        // 再启动10个取鸡蛋线程
        for(int i = 0; i < 10; i++) {
            new Thread(new GetThread(plate)).start();
        }
    }
}