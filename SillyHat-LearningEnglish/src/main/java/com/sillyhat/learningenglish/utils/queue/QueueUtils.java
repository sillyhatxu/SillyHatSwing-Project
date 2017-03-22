package com.sillyhat.learningenglish.utils.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * QueueUtils
 *
 * @author 徐士宽
 * @date 2017/3/22 17:58
 */
public class QueueUtils {

    //队列大小
    private static final BlockingQueue<String> queue = new LinkedBlockingDeque<>(500);
}
