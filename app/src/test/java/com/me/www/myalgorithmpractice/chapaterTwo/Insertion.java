package com.me.www.myalgorithmpractice.chapaterTwo;

import com.me.www.myalgorithmpractice.SortUtils;

import org.junit.Test;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-10-9
 */

public class Insertion {

    Integer[] a = {9, 8, 6, 5, 7, 3, 2, 4, 1, 0};

    public void sort1(Comparable[] a) {

        int N = a.length;
        for (int i = 1; i < N; i++) {

            for (int j = i; j > 0 && SortUtils.less(a[j], a[j - 1]); j--) {
                SortUtils.exch(a, j, j - 1);
            }
        }

    }

    @Test
    public void testSort1() {

        SortUtils.show(a);
        sort1(a);
        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + SortUtils.isSorted(a));
    }

    /**
     * 根据算法4 中的练习 练习 2.1.25的提示进行优化排序的速度
     * <p>
     * 自己的思考
     * <p>
     * 内循环 较大的数往右移动，而不是交换？啥意思，不交换的话 较小的数应该要保存，那就需要一个临时的变量了
     *
     * @param a
     */
    public void sort2(Comparable[] a) {

        int N = a.length;

        for (int i = 1; i < N; i++) {

            Comparable min = a[i];
            Comparable currentIndex = a[i];
            for (int j = i; j > 0 && SortUtils.less(a[j], a[j - 1]); j--) {
                a[j] = a[j - 1];
                currentIndex = a[j];
            }
            SortUtils.exch(min, currentIndex);
            SortUtils.show(a);
        }

    }

    @Test
    public void testSort2() {
        SortUtils.show(a);
        sort2(a);
        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + SortUtils.isSorted(a));
    }


}
