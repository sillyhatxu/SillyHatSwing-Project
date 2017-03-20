package com.sillyhat.learningenglish.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ${XUSHIKUAN} on 2017-03-20.
 */
public class SortNumUtils {


    /**
     * 获取排序中需要的sort，乱序返回
     * @param total
     * @return
     */
    public static List<Integer> getSortList(int total){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= total; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }
}
