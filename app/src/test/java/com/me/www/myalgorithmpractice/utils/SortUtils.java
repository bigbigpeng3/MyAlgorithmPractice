package com.me.www.myalgorithmpractice.utils;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-10-9
 */

public class SortUtils {

    public static boolean less(Comparable v, Comparable w) {

        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 直接交换元素，不过好像没有交换下标来的划算
     * @param a
     * @param b
     */
    public static void exch(Comparable a, Comparable b) {
        Comparable temp = a;
        a = b;
        b = temp;
    }

    public static void show(Comparable[] a) { // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) { // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++){
//            System.out.println("i = " + i);
//            System.out.println("a[i] = " + a[i]);
//            System.out.println("a[i - 1] = " + a[i -1]);
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }


}
