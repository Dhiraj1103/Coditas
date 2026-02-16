package Week1Evaluation.Assignment5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {

     int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" is processing Task " + taskId);

        try {
         
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +" completed Task " + taskId);
    }
}

public class ThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);    // 3 threads are created here

        for (int i = 1; i <= 10; i++) {
            executor.execute(new Task(i));
        }

        executor.shutdown();    

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks finished.");
    }
}





















