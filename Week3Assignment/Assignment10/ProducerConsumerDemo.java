package Week1Evaluation.Assignment10;

import java.util.LinkedList;
import java.util.Queue;

class Buffer {

      Queue<Integer> q = new LinkedList<>();
      int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {

        while (q.size() == capacity) {
            wait(); 
        }

        q.add(value);
        System.out.println("Produced: " + value);

        notify(); // wake consumer
    }

    public synchronized int consume() throws InterruptedException {

        while (q.isEmpty()) {
            wait(); // wait if buffer is empty
        }

        int value = q.poll();
        System.out.println("Consumed: " + value);

        notify(); // wake producer
        return value;
    }
}

public class ProducerConsumerDemo {

    public static void main(String[] args) {

        Buffer buffer = new Buffer(3); // buffer capacity = 3

        Thread producer = new Thread(() -> {
            int value = 1;
            try {
                while (true) {
                    buffer.produce(value++);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    buffer.consume();
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}

