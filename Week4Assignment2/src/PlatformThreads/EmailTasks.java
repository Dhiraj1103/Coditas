package PlatformThreads;

import java.util.concurrent.CountDownLatch;

public class EmailTasks implements Runnable {

   private int userID;
   private CountDownLatch latch;

	 public EmailTasks(int userID, CountDownLatch latch) {
    	super();
		this.userID = userID;
		this.latch = latch;
	}

	  public void run() {
   	  try {
			Thread.sleep(1000);
			System.out.println("Email sent to user "+userID);
		  } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
   	  finally {
			latch.countDown();
		}
     }
}
