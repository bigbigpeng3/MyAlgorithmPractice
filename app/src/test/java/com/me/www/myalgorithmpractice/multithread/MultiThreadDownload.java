package com.me.www.myalgorithmpractice.multithread;

import org.junit.Test;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zp on 3/22/17.
 */

public class MultiThreadDownload {


    private int totalThreadCount = 3;

    private static final String path = "http://192.168.0.102:8080/ff.exe";

    @Test
    public void multiThreadDownload() throws Exception {

        URL url = new URL(path);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        int code = conn.getResponseCode();

        if (code == 200) {

            int length = conn.getContentLength();

            System.out.println("文件长度：" + length);


            //创建空白文件，接收每个线程对应的下载.和服务器文件大小保持一致
            RandomAccessFile raf = new RandomAccessFile("temp.exe", "rw");
            raf.setLength(length);
            raf.close();

            int blocksize = length / totalThreadCount;

            System.out.println("每一份大小:" + blocksize);

            for (int threadId = 0; threadId < totalThreadCount; threadId++) {

                int startPosition = threadId * blocksize;
                int endPostion = (threadId + 1) * blocksize - 1;//需要-1 的原因是下一个线程对应的start就是这里

                //最后一个线程需要完成整个文件的最后一份
                if (threadId == (totalThreadCount - 1)) {
                    endPostion = length - 1;
                }

                System.out.println("线程：" + threadId + "开始：" + startPosition + "结束：" + endPostion);

                //开启子线程，让每一个子线程，下载对应的等分
                new DownloadThread(threadId, startPosition, endPostion).start();
            }


        }


    }


    private static class DownloadThread extends Thread {

        private int threadId;
        private int startIndex;
        private int endIndex;

        public DownloadThread(int threadId, int startIndex, int endIndex) {
            this.endIndex = endIndex;
            this.startIndex = startIndex;
            this.threadId = threadId;
        }


        @Override
        public void run() {
//            super.run();

            try {

                System.out.println("线程" + threadId + "开始工作了");

                URL url = new URL(path);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("GET");

                conn.setRequestProperty("Range", "bytes=" + startIndex + "-" + endIndex);

                //从服务器开始下载资源 ,还需要文件对象，这样来写入文件
                int code = conn.getResponseCode();//206

                System.out.println(threadId + "code = " + code);

                if (code == 206) {

                    InputStream is = conn.getInputStream();
                    RandomAccessFile raf = new RandomAccessFile("temp.exe", "rw");
                    //非常重要，要指定文件写的开始位置
                    raf.seek(startIndex);
                    byte[] buffer = new byte[1024];
                    int len = -1;
                    while ((len = is.read(buffer)) != -1) {
                        raf.write(buffer, 0, len);
                    }
                    is.close();
                    raf.close();
                    System.out.println("线程" + threadId + "下载完毕");
                }



            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
