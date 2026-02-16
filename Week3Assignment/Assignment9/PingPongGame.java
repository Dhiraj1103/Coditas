package Week1Evaluation.Assignment9;

class PingPong {

     boolean turn = true; 

    public synchronized void ping() {
        for (int i = 0; i < 5; i++) {

            while (!turn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Ping");
            turn = false;
            notify();
        }
    }

    public synchronized void pong() {
        for (int i = 0; i < 5; i++) {

            while (turn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Pong");
            turn = true;
            notify();
        }
    }
}

public class PingPongGame {

    public static void main(String[] args) {

        PingPong game = new PingPong();

        Thread pingThread = new Thread(() -> game.ping(), "Ping");
        Thread pongThread = new Thread(() -> game.pong(), "Pong");

        pingThread.start();
        pongThread.start();
    }
}
