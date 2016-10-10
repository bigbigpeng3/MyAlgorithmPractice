package com.me.www.myalgorithmpractice;

import com.me.www.myalgorithmpractice.utils.RandomArray;
import com.me.www.myalgorithmpractice.utils.SortCompare;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(0, 1/3);
    }

    @Test
    public void testAllSortTime(){

        Integer[] a = RandomArray.getRandomIntArray(40000);
        Integer[] b = RandomArray.getOhterRandomIntArray(40000);
        Integer[] c = RandomArray.getOhterRandomIntArray(40000);

        System.out.println("SortCompare.time(SortCompare.SELECTION,1) = " +   SortCompare.time(SortCompare.SELECTION,a));
        System.out.println("SortCompare.time(SortCompare.INSERTION,b) = " +  SortCompare.time(SortCompare.INSERTIONX,b));
        System.out.println("SortCompare.time(SortCompare.SHELL,b) = " +   SortCompare.time(SortCompare.SHELL,c));

    }



}