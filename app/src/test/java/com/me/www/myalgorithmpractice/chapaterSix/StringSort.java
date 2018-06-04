package com.me.www.myalgorithmpractice.chapaterSix;

import org.junit.Test;

/**
 * Created by zp on 2/23/17.
 */

public class StringSort {


    public static void sort(String[] a, int w) {


        int N = a.length;

        int R = 256;

        String[] aux = new String[N];

        for (int d = w - 1; d >= 0; d--) {

            int[] count = new int[R + 1];


            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }

        }


    }

    @Test
    public void test() {

//        String a = "abcde";
//        System.out.println(a.charAt(3) + 1);


        String[] a = {
                "4PGC938",
                "2IYE230",
                "3CI0720",
                "1ICK750",
                "1ICK750",
                "10HV845",
                "10HV845",
                "3CI0720",
                "10HV845",
                "2RLA629",
                "2RLA629",
                "3ATW723"
        };

        System.out.println("排序前：");
        print(a);

        sort(a,7);

        System.out.println("排序后：");
        print(a);

    }

    public void print(String[] a){

        for (String s : a) {
            System.out.println(s);
        }
    }


}
