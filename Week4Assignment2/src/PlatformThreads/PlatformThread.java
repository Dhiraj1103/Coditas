package PlatformThreads;

import java.util.concurrent.CountDownLatch;


 
 public class PlatformThread {
		
		static final int USER_COUNT = 10_000; 

		public static void main(String[] args) throws InterruptedException {
			 
			CountDownLatch latch = new CountDownLatch(USER_COUNT);
			long start=System.currentTimeMillis();

			for (int i = 1; i <=USER_COUNT; i++) {
	           Thread t= new Thread(new EmailTasks(i, latch));
	           t.start();
			}
			latch.await();
			long end= System.currentTimeMillis();
			System.out.println();
			System.out.println("Time taken for platform thread: "+(end-start)+"ms");
		}
 	
 }