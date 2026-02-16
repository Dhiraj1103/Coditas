package Week3Assignment.Assignment2;

 class SharedCounter  {

	    int count = 0;
	    int max;
	    boolean incrementTurn = true; 

	    public SharedCounter (int max) {
	        this.max = max;
	    }

	    public synchronized void increment() {
	        while (count < max) {

	            while (!incrementTurn) {
	                try {
	                    wait();  
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }

	            count++;
	            System.out.println("Incremented: " + count);

	            incrementTurn = false; 
	            notify();
	        }
	    }

	    public synchronized void print() {
	        while (count < max) {

	            while (incrementTurn) {
	                try {
	                    wait();  
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }

	            System.out.println("Printed: " + count);

	            incrementTurn = true;
	            notify();
	        }
	    }
	}

 
 class Thread1 extends Thread{
	 
	 public void run( SharedCounter counter) {
		 
		 counter.increment();
		 counter.print();
		 
	 }
 }
	public class InterThreadCommunicationDemo {

	    public static void main(String[] args) {

	   	 SharedCounter  counter = new SharedCounter (5);


	        Thread t1 = new Thread(() -> counter.increment());
	   
	        Thread t2 = new Thread(() -> counter.print());
	    	

	        t1.start();
	        t2.start();
	    }
	}
