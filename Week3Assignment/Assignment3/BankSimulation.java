package Week1Evaluation.Assignment3;

	class BankAccount {

	    int balance;

	    public BankAccount(int initialBalance) {
	        this.balance = initialBalance;
	    }


	    public synchronized void deposit(int amount) {
	        System.out.println(Thread.currentThread().getName() +" is depositing: " + amount);

	        balance += amount;

	        System.out.println("Updated Balance after depositing: " + balance);
	           System.out.println();

	    }

	    
	    public synchronized void withdraw(int amount) {

	        System.out.println(Thread.currentThread().getName() + " withdrawing: " + amount);

	        if (balance >= amount) {
	            balance -= amount;
	            System.out.println("Updated Balance after withdrawal: " + balance);
	        } else {
	            System.out.println("Insufficient balance!!! Current balance: " + balance);
	        }
	           System.out.println();

	    }

	}
	public class BankSimulation {

	    public static void main(String[] args) {

	        BankAccount account = new BankAccount(1000);

	        Thread t1 = new Thread(() -> {
	            account.deposit(500);
	        }, "Thread 1 Deposit");
	        Thread t2 = new Thread(() -> {
	            account.deposit(300);
	        }, "Thread 2 Deposit");

	        Thread t3 = new Thread(() -> {
	            account.withdraw(700);
	        }, "Thread 1 withdraw");

	        Thread t4 = new Thread(() -> {
	            account.withdraw(800);
	        }, "Thread 2 withdraw");

	        t1.start();
	        t2.start();
	        t3.start();
	        t4.start();
	    }
	}


