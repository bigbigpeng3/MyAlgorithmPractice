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


}
