package com.me.www.myalgorithmpractice.chapaterTwo;

import com.me.www.myalgorithmpractice.utils.RandomArray;
import com.me.www.myalgorithmpractice.utils.SortCompare;
import com.me.www.myalgorithmpractice.utils.SortUtils;

import org.junit.Assert;
import org.junit.Test;

import static com.me.www.myalgorithmpractice.utils.SortUtils.exch;
import static com.me.www.myalgorithmpractice.utils.SortUtils.isSorted;
import static com.me.www.myalgorithmpractice.utils.SortUtils.less;
import static com.me.www.myalgorithmpractice.utils.SortUtils.show;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-10-9
 */

public class Insertion {

    Integer[] a = {9, 8, 6, 5, 7, 3, 2, 4, 1, 0};
    Integer[] b = {9, 8, 6, 5, 7, 3, 2, 4, 1, 0};

    public static void sort1(Comparable[] a) {

        int N = a.length;
        for (int i = 1; i < N; i++) {

            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }

    }

    @Test
    public void testSort1() {

        SortUtils.show(a);
        sort1(a);
        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + isSorted(a));
    }

    /**
     * 根据算法4 中的练习 练习 2.1.25的提示进行优化排序的速度
     * <p>
     * 自己的思考
     * <p>
     * 1 内循环 较大的数往右移动，而不是交换？啥意思，不交换的话 较小的数应该要保存，那就需要一个临时的变量了
     * <p>
     * 2 按照上面的思路是没有错的，但是有一些小细节需要处理一下，比如一开始用的是SortUtils.less(a[j],a[j-1])
     * 这样就会出现问题，每次没有替换，只是保存了当前index的值（因为只有它才有可能是最小的）。
     * 但是在比较大的数在往后移的过程中，并没有替换掉之前的index。所以就不能和前一个数进行比较了，
     * 只有用开始保存的数来做比较才能够实现  在完成了 index = i 时 和index = j -1 替换后的和 index = i -1 ....i之间的比较了
     * <p>
     * 3 现在还是不是很清楚这是不是书上的解法，可能在内存，时间方面还有优化的空间
     *
     * @param a
     */
    public void sort2(Comparable[] a) {

        int N = a.length;

        for (int i = 1; i < N; i++) {

            Comparable min = a[i];
            int currentIndex = i;
            for (int j = i; j > 0 && less(min, a[j - 1]); j--) {
                currentIndex = j;
                System.out.println("currentIndex = " + currentIndex);
                System.out.println("j = " + j);
                System.out.println("a[j] = " + a[j]);
                a[j] = a[j - 1];
                System.out.println("a[j] = " + a[j]);
            }

            a[currentIndex - 1] = min;
            System.out.println("a[currentIndex]  = " + a[currentIndex]);
            SortUtils.show(a);
        }

    }

    @Test
    public void testSort2() {
        SortUtils.show(a);
        sort2(a);
        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + isSorted(a));
    }


    /**
     * 基于sort2的空间优化版
     * 1 将 int currentIndex 在内循环中解决了
     * 2 暂时没有觉得能够优化空间的方案了
     * 3 时间上的优化能够进行吗？
     * 4 有没有可能，我没有理解什么是真正的“右移”？a[j] = a[j-1]这样的右移方式是错的呢？
     * @param a
     */
    public void sort3(Comparable[] a) {

        int N = a.length;

        for (int i = 1; i < N; i++) {

            Comparable min = a[i];
            for (int j = i; j > 0 && less(min, a[j - 1]); j--) {

                System.out.println("j = " + j);
                System.out.println("a[j] = " + a[j]);
                a[j] = a[j - 1];
                System.out.println("a[j] = " + a[j]);

                if (j == 1) {
                    a[j - 1] = min;
                    System.out.println("a[j-1]  = " + a[j - 1]);
                }
            }
            SortUtils.show(a);
        }

    }

    @Test
    public void testSort3() {
        SortUtils.show(a);
        sort3(a);
        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + isSorted(a));
    }


    /**
     * 这是官方给的例子，好好看看
     *
     * 1 理解，和自己的代码有什么不同 优化了当没有数据可以排序的时候，就直接返回，不需要排序了。需要排序的时候已经将最小的数放到了最前面。
     * （这里，我有点疑惑，为什么要这么做呢？如果有exchange直接break，然后进行所有数据的排序不就行了？为什么要将最小的数放到前面，后面只是减少了一个数的比较而已）
     *
     * 2 空间上的优势  使用的是while 更加简洁，同时，达到了和我优化的版本一致的体验
     *
     * 3 时间上的优势 for和while性能一致
     *
     *
     */
    public static void sort4(Comparable[] a) {

        int n = a.length;
        // put smallest element in position to serve as sentinel,检查需不需要进行排序，同时，将最小的数放到了数组的第一位，假设是升序排序
        int exchanges = 0;
        for (int i = n-1; i > 0; i--) {
            if (less(a[i], a[i-1])) {
                exch(a, i, i-1);
                exchanges++;
            }
        }
        if (exchanges == 0) return;

        // insertion sort with half-exchanges
        for (int i = 2; i < n; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j-1])) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }

        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void testSort4() {
        SortUtils.show(a);
        sort4(a);
        SortUtils.show(a);
        System.out.println("SortUtils.isSorted(a) = " + isSorted(a));
    }


    /**
     * 测试和选择排序的时间比较
     */
    @Test
    public void compareWithSelction(){

        Integer[] a = RandomArray.getRandomIntArray(10000);
        Integer[] b = RandomArray.getOhterRandomIntArray(10000);
//        show(a);
        System.out.println("SortCompare.time(SortCompare.INSERTION,a) = " +  SortCompare.time(SortCompare.INSERTIONX,b));
        System.out.println("SortCompare.time(SortCompare.SELECTION,b) = " +   SortCompare.time(SortCompare.SELECTION,a));
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
