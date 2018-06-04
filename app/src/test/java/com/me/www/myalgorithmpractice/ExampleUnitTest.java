package com.me.www.myalgorithmpractice;

import com.me.www.myalgorithmpractice.utils.RandomArray;
import com.me.www.myalgorithmpractice.utils.SortCompare;
import com.me.www.myalgorithmpractice.utils.SortUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.me.www.myalgorithmpractice.utils.SortUtils.isSorted;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    public static final int TIMES = 50000;

    @Test
    public void addition_isCorrect() throws Exception {
//        assertEquals(0, 1 / 3);

//        LruCache

        List mlist = new ArrayList<>();
        mlist.add("123");
        mlist.add("123");
        mlist.add("123");
        mlist.add("123");
        sleep(1);


//        LinkedHashMap

        System.out.println(mlist);
    }

    @Test
    public void testAllSortTime() {

        Integer[] a = RandomArray.getRandomIntArray(TIMES);
//        Integer[] b = RandomArray.copyArray(a);
        Integer[] b = RandomArray.getRandomIntArray(TIMES);
        Integer[] c = RandomArray.getRandomIntArray(TIMES);
        Integer[] d = RandomArray.getRandomIntArray(TIMES);

        System.out.println("SortCompare.time(SortCompare.SELECTION,1) = " + SortCompare.time(SortCompare.SELECTION, a));
        assertTrue(isSorted(a));
        System.out.println("SortCompare.time(SortCompare.INSERTION,b) = " + SortCompare.time(SortCompare.INSERTIONX, b));
        assertTrue(isSorted(b));
        System.out.println("SortCompare.time(SortCompare.SHELL,b) = " + SortCompare.time(SortCompare.SHELL, c));
        assertTrue(isSorted(c));
        System.out.println("SortCompare.time(SortCompare.QUICK,d) = " + SortCompare.time(SortCompare.QUICK, d));
        assertTrue(isSorted(d));

    }

    /**
     * 计算阶乘
     */
    public double factorial(double n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    @Test
    public void testFactorial() {
        System.out.println(factorial(100));
    }


    @Test
    public void test() {

        Integer[] a = {8, 7, 2, 1, 6, 3, 0, 5, 4, 9, 10, 10, 10, 31, 321, 13123, 212312, 12312, 414343};

//        HJSort(a);

        System.out.println(SortUtils.isSorted(a));

    }


    public void HJSort(Integer[] a) {


        int k = 0;

        for (int i = 0; i < a.length - 1; i++) {

            for (int j = i + 1; j < a.length; j++) {

                if (a[i] > a[j]) {
                    k = a[i];
                    a[i] = a[j];
                    a[j] = k;
                }
                SortUtils.show(a);
            }

        }
    }


    public void HJbublleSort(Integer[] a) {


    }



    class A {
        String s ;
    }

    @Test
    public void testClass(){

        A a1 = new A();
        A a2 = new A();
        a1.s = "a1";
        a2.s = "a2";
        System.out.println( "a1 = " + a1 +"," + "a2 = " + a2);
//        System.out.println( "a1 = " + a1 +"," + "a2 = " + a2);
        swap(a1,a2);
//        System.out.println(a1.s);
        System.out.println( "a1 = " + a1 +"," + "a2 = " + a2);

    }

    private void swap(A a1, A a2) {
        A b = a1;
        a1 = a2;
        a2 = b;
    }


}