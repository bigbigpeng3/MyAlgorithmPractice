package com.me.www.myalgorithmpractice.utils;

import java.util.Random;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-10-10
 */

public class RandomArray {


    public static Integer[] getRandomIntArray (int range){

        Integer[] a = new Integer[range];

        Random randomInt = new Random();
        for (int i = 0; i < range ; i++) {
            a[i] = randomInt.nextInt();
        }
        return a;
    }


    public static Integer[] getOhterRandomIntArray (int range){

        Integer[] a = new Integer[range];

        Random randomInt = new Random();
        for (int i = 0; i < range ; i++) {
            a[i] = randomInt.nextInt();
        }
        return a;
    }


    public static Integer[] copyArray(Integer[] data){

        if (! (data.length > 0)){
            throw new IllegalArgumentException("copyArray你没有数据啊......");
        }

        Integer[] returnData = new Integer[data.length];

        for (int i = 0; i < data.length; i++) {
            returnData[i] = data[i];
        }

        return returnData;
    }


}
