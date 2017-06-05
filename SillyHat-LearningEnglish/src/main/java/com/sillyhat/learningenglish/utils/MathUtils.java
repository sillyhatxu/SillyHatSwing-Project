package com.sillyhat.learningenglish.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * MathUtils
 *
 * @author 徐士宽
 * @date 2017/3/27 13:34
 */
public class MathUtils {


    public static int getSectionMath(int min,int max){
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    public static void main(String[] args) {
        Set<Integer> result = new HashSet<Integer>();
        while(result.size() != 17){
            result.add(MathUtils.getSectionMath(5,20));
        }
        System.out.println(result);
    }
}
