package com.me.www.myalgorithmpractice.chapaterTwo;

import com.me.www.myalgorithmpractice.utils.SortUtils;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zp on 3/23/17.
 */

public class Merge {


    private static int[] aux;

    public static void sort(Integer[] a) {

        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Integer[] a, int lo, int hi) {

        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);


    }

    private static void merge(Integer[] a, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)                a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (a[j] < aux[i])     a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }

    }

    @Test
    public void test(){

        Integer[] a = {21,12,32,34,5,6,7,8,3,2,45,2,6};

        SortUtils.show(a);

        sort(a);

        SortUtils.show(a);

//        ThreadPoolExecutor
        ExecutorService MyThreadPool =
                Executors.newFixedThreadPool(5);

//        Thread

    }


}
