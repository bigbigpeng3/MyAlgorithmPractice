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

        

    }

    @Test
    public void testSort1() {

        SortUtils.show(a);
        sort1(a);
        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + SortUtils.isSorted(a));
    }





}
