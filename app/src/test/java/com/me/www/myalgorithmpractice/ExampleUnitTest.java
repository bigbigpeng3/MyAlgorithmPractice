package com.me.www.myalgorithmpractice;

import com.me.www.myalgorithmpractice.utils.RandomArray;
import com.me.www.myalgorithmpractice.utils.SortCompare;

import org.junit.Test;

import static com.me.www.myalgorithmpractice.utils.SortUtils.isSorted;
import static org.junit.Assert.assertEquals;
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
        assertEquals(0, 1 / 3);
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
    public void testFactorial(){
        System.out.println(factorial(100));
    }


}