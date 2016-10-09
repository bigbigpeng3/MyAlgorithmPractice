package com.me.www.myalgorithmpractice.chapaterTwo;

import com.me.www.myalgorithmpractice.SortUtils;

import org.junit.Test;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-10-9
 */

public class Selection {

    Integer[] a = {9, 8, 6, 5, 7, 3, 2, 4, 1, 0};

    public void sort1(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {

            int min = i;

            for (int j = i + 1; j < a.length; j++) {

                if (SortUtils.less(a[j], a[min])) {
                    min = j;
                }
            }

            SortUtils.exch(a, i, min);
        }

    }

    @Test
    public void testSort1() {

        SortUtils.show(a);
        sort1(a);
        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + SortUtils.isSorted(a));
    }





}
