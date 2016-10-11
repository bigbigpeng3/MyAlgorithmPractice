package com.me.www.myalgorithmpractice.chapaterTwo;

import com.me.www.myalgorithmpractice.utils.RandomArray;
import com.me.www.myalgorithmpractice.utils.SortUtils;

import org.junit.Assert;
import org.junit.Test;

import static com.me.www.myalgorithmpractice.utils.SortUtils.exch;
import static com.me.www.myalgorithmpractice.utils.SortUtils.less;
import static com.me.www.myalgorithmpractice.utils.SortUtils.show;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-10-10
 */

public class Quick {

        Integer[] a = {9, 8, 6, 5, 7, 3, 2, 4, 1, 0};
//    Integer[] a = {9, 8, 6, 5, 7, 3};

    public static void sort1(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        //print the track of sort
        System.out.println("j = " + j);
        show(a);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, a[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put v = a[j] into position
        exch(a, lo, j);
        // with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    @Test
    public void testSort1() {

        SortUtils.show(a);
        sort1(a);
        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + SortUtils.isSorted(a));
    }

    /**
     * 三分法
     */
    private static void quickSortThreeWay(Comparable[] a, int lo, int hi) {
        // See page 289 for public sort() that calls this method.
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        } // Now a[lo..lt-1] < v = a[lt..gt] <a[gt + 1..hi].
        quickSortThreeWay(a, lo, lt - 1);
        quickSortThreeWay(a, gt + 1, hi);
    }

    public static void quickSortThreeWay(Comparable[] a) {
        quickSortThreeWay(a, 0, a.length - 1);
    }

    @Test
    public void testquickSortThreeWay() {

        SortUtils.show(a);
        quickSortThreeWay(a);
        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + SortUtils.isSorted(a));
    }

    @Test
    public void testFromRandom() {
        Integer[] a = RandomArray.getRandomIntArray(40000);
//        SortUtils.show(a);
        sort1(a);
//        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + SortUtils.isSorted(a));
        Assert.assertTrue(SortUtils.isSorted(a));
    }


}
