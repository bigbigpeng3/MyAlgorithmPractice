package com.me.www.myalgorithmpractice.chapaterTwo;

import com.me.www.myalgorithmpractice.utils.RandomArray;
import com.me.www.myalgorithmpractice.utils.SortUtils;

import org.junit.Assert;
import org.junit.Test;

import static com.me.www.myalgorithmpractice.utils.SortUtils.exch;
import static com.me.www.myalgorithmpractice.utils.SortUtils.less;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-10-10
 */

public class Shell {

    Integer[] a = {9, 8, 6, 5, 7, 3, 2, 4, 1, 0};

    public static void sort1(Comparable[] a) {
        // 将a[]按升序排列
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        }
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]... 之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h){
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
// less()、exch()、isSorted()和main()方法见“排序算法类模板”

    @Test
    public void testSort1() {

        SortUtils.show(a);
        sort1(a);
        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + SortUtils.isSorted(a));
    }

    @Test
    public void testFromRandom(){
        Integer[] a = RandomArray.getRandomIntArray(40000);
//        SortUtils.show(a);
        sort1(a);
//        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + SortUtils.isSorted(a));
        Assert.assertTrue(SortUtils.isSorted(a));
    }


}
