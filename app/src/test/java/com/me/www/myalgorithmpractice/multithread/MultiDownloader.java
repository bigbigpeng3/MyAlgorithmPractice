package com.me.www.myalgorithmpractice.multithread;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class MultiDownloader {
	// 总的线程的个数
	static int totalThreadCount = 3;
	/**
	 * 正在运行的线程的数量
	 */
	static int runningThreadCount ;
	private static final String path = "http://192.168.0.102:8080/ff.exe";

	@Test
	public  void test() throws Exception {
		// 推荐大家使用exe文件作为下载测试的文件
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		int code = conn.getResponseCode();
		if (code == 200) {
			int length = conn.getContentLength();
			System.out.println("服务器文件的长度为:" + length);
			RandomAccessFile raf = new RandomAccessFile(getDownLoadFileName(path), "rw");
			// 在本地创建一个空文件大小和服务器的文件大小保持一致
			raf.setLength(length);
			raf.close();
			int blocksize = length / totalThreadCount;// 把服务器的资源等分成3份 每一份的大小
			System.out.println("每一份:" + blocksize);
			runningThreadCount = totalThreadCount;
			for (int threadid = 0; threadid < totalThreadCount; threadid++) {
				int startPosition = threadid * blocksize;
				int endPosition = (threadid + 1) * blocksize - 1;
				if (threadid == (totalThreadCount - 1)) {
					endPosition = length - 1;
				}
				System.out.println("线程理论:" + threadid + "下载的范围:" + startPosition
						+ "~~" + endPosition);
				// 开启子线程,让每个子线程下载对应位置的数据..
				new DownloadThread(threadid, startPosition, endPosition)
						.start();
			}

		}
	}

	public static class DownloadThread extends Thread {
		/**
		 * 线程id
		 */
		private int threadid;
		/**
		 * 当前线程下载的开始位置
		 */
		private int startPosition;
		/**
		 * 当前线程下载的结束位置
		 */
		private int endPosition;

		public DownloadThread(int threadid, int startPosition, int endPosition) {
			this.threadid = threadid;
			this.startPosition = startPosition;
			this.endPosition = endPosition;
		}

		@Override
		public void run() {
			System.out.println("线程:" + threadid + "开始工作了");
			// 让当前线程下载自己对应范围的数据
			try {
				//判断是否已经下载过一部分的数据.
				File finfo = new File(totalThreadCount+getDownLoadFileName(path)+threadid+".txt");	
				if(finfo.exists()&&finfo.length()>0){
					FileInputStream fis = new FileInputStream(finfo);
					BufferedReader br = new BufferedReader(new InputStreamReader(fis));
					String lastposition = br.readLine();
					//这个线程上一次下载的大小
					int intlastposition = Integer.parseInt(lastposition);
					startPosition = intlastposition;
					fis.close();
				}
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				System.out.println("线程真实下载开始和结束:" + threadid + "下载的范围:" + startPosition
						+ "~~" + endPosition);
				conn.setRequestProperty("Range", "bytes="+startPosition+"-"+endPosition);
				//从服务器下载资源.
				int code = conn.getResponseCode(); //206 请求部分数据成功
				if(code ==206){
					InputStream is = conn.getInputStream();
					RandomAccessFile raf = new RandomAccessFile(getDownLoadFileName(path), "rw");
					//★ 非常重要指定文件写的开始位置
					raf.seek(startPosition);
					byte[] buffer = new byte[1024];
					int len = -1;
					int total = 0;//当前线程这一次下载了多少的数据
					while(( len = is.read(buffer))!=-1){
						raf.write(buffer, 0, len);
						//把当前下载的位置记录下来.
						total+=len;
						RandomAccessFile inforaf = new RandomAccessFile(totalThreadCount+getDownLoadFileName(path)+threadid+".txt", "rwd");//每一次更新 数据都被同步到底层硬盘
						//存当前线程已经下载到了哪个位置
						inforaf.write(String.valueOf(startPosition+total).getBytes());
						inforaf.close();
					}
					is.close();
					raf.close();
					System.out.println("线程:"+threadid+"下载完毕了...");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				synchronized (MultiDownloader.class) {
					runningThreadCount--;
					if(runningThreadCount<=0){
						System.out.println("多线程下载完毕.");
						for(int i = 0;i<totalThreadCount;i++){
							File f = new File(totalThreadCount+getDownLoadFileName(path)+i+".txt");
							System.out.println(f.delete());
						}
					}
				}
			}

		}
	}

	/**
	 * 根据路径获取文件名
	 * @param path
	 * @return
	 */
	public static String getDownLoadFileName(String path){
		return path.substring(path.lastIndexOf("/")+1);
	}
	
	
}
