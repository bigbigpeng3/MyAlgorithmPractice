package com.me.www.myalgorithmpractice.multithread;

import org.junit.Test;

/**
 * Created by zp on 3/18/17.
 */

public class MultiThreadTest {



    @Test
    public void test(){

        Runner1 r = new Runner1();
        Thread t = new Thread(r);
        t.start();

//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        WeakReference

        System.out.println();

        for(int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }

}


class Runner1 implements Runnable {
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("Runner1线程:" + i);
        }
    }
}

