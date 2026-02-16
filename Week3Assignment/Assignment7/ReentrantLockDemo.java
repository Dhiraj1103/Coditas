package Week1Evaluation.Assignment7;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {


     ReentrantLock lock = new ReentrantLock(true);

     int counter = 0;

    public void increment() {

        lock.lock(); // acquire lock
        try {
            System.out.println(Thread.currentThread().getName() +
                    " acquired lock");

            counter++;
            System.out.println("Counter value: " + counter);

   
            nestedMethod();

        } finally {
            lock.unlock(); 
            System.out.println(Thread.currentThread().getName() +
                    " released lock");
        }
    }


    private void nestedMethod() {

        lock.lock(); 
        try {
            System.out.println(Thread.currentThread().getName() +
                    " entered nested method (reentrant)");
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockDemo {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Runnable task = () -> {
            for (int i = 0; i < 2; i++) {
                resource.increment();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
