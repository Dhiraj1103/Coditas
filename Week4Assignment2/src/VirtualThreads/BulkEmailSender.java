package VirtualThreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import PlatformThreads.EmailTasks;

public class BulkEmailSender {

	static final int USER_COUNT = 10_000; 
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(USER_COUNT);
		long start=System.currentTimeMillis();
		try(ExecutorService es= Executors.newVirtualThreadPerTaskExecutor()){
			for (int i = 1; i <=USER_COUNT; i++) {
				es.submit(new EmailTasks(i, latch));
			}
			latch.await();
		}
		
		long end=System.currentTimeMillis();
		System.out.println();
		System.out.println("Time taken for platform thread: "+(end-start)+"ms");
	}

}
