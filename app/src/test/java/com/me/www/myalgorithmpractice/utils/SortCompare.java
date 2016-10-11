package com.me.www.myalgorithmpractice.utils;

import com.me.www.myalgorithmpractice.chapaterTwo.Insertion;
import com.me.www.myalgorithmpractice.chapaterTwo.Quick;
import com.me.www.myalgorithmpractice.chapaterTwo.Selection;
import com.me.www.myalgorithmpractice.chapaterTwo.Shell;

/**
 * Description :
 * Email  : bigbigpeng3@gmail.com
 * Author : peng zhang
 * Date   : 2016-10-10
 */

public class SortCompare {

    public static final String INSERTION = "Insertion";
    public static final String INSERTIONX = "InsertionX";
    public static final String SELECTION = "Selection";
    public static final String SHELL = "Shell";
    public static final String QUICK = "Quick";

    public static double time(String alg, Comparable[] a) {
        Stopwatch sw = new Stopwatch();
        if      (alg.equals("Insertion"))       Insertion.sort1(a);
        else if (alg.equals("InsertionX"))      Insertion.sort4(a);
//        else if (alg.equals("BinaryInsertion")) BinaryInsertion.sort(a);
        else if (alg.equals("Selection"))       Selection.sort1(a);
//        else if (alg.equals("Bubble"))          Bubble.sort(a);
        else if (alg.equals("Shell"))           Shell.sort1(a);
//        else if (alg.equals("Merge"))           Merge.sort(a);
//        else if (alg.equals("MergeX"))          MergeX.sort(a);
//        else if (alg.equals("MergeBU"))         MergeBU.sort(a);
        else if (alg.equals("Quick"))           Quick.sort1(a);
//        else if (alg.equals("Quick3way"))       Quick3way.sort(a);
//        else if (alg.equals("QuickX"))          QuickX.sort(a);
//        else if (alg.equals("Heap"))            Heap.sort(a);
//        else if (alg.equals("System"))          Arrays.sort(a);
        else throw new IllegalArgumentException("Invalid algorithm: " + alg);
        return sw.elapsedTime();
    }

    // Use alg to sort trials random arrays of length n.
//    public static double timeRandomInput(String alg, int n, int trials)  {
//        double total = 0.0;
//        Double[] a = new Double[n];
//        // Perform one experiment (generate and sort an array).
//        for (int t = 0; t < trials; t++) {
//            for (int i = 0; i < n; i++)
//                a[i] = StdRandom.uniform(0.0, 1.0);
//            total += time(alg, a);
//        }
//        return total;
//    }

    // Use alg to sort trials random arrays of length n.
//    public static double timeSortedInput(String alg, int n, int trials) {
//        double total = 0.0;
//        Double[] a = new Double[n];
//        // Perform one experiment (generate and sort an array).
//        for (int t = 0; t < trials; t++) {
//            for (int i = 0; i < n; i++)
//                a[i] = 1.0 * i;
//            total += time(alg, a);
//        }
//        return total;
//    }


}
