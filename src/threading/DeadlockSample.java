package threading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockSample {

	/**
	    Sample program for Deadlock
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException 
	{

		final Runner runner = new Runner();
		Thread t1 = new Thread(new Runnable(){
			public void run()
			{
			 runner.firstThread();
			}
		});

		Thread t2 = new Thread(new Runnable(){
			public void run()
			{
				 runner.secondThread();
			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		Thread.sleep(1000);
		runner.showAmount();
		
	}
	
	static Lock lock1 = new ReentrantLock();
	static Lock lock2 = new ReentrantLock();
	 static class Runner
	{
		 Account acc1 = new Account();
		 Account acc2 = new Account();
		
		public  void firstThread()
		{
			for(int i=0; i<500; i++)
			{
			lock1.lock();
			lock2.lock();
			try{
			Account.transfer(acc1, acc2, new Random().nextInt(100));
			}
			finally
			{
				lock1.unlock();
				lock2.unlock();
			}
			}
		}
		
		public  void secondThread()
		{
			for(int i=0; i<500; i++)
			{
			lock2.lock();
			lock1.lock();
			try{
			Account.transfer(acc2, acc1, new Random().nextInt(100));
			}
			finally
			{
				lock1.unlock();
				lock2.unlock();
			}
			}
		}
		
		 public  void showAmount()
		 {
			 System.out.println("  acc1.amt="+acc1.amt+"  acc2.amt="+acc2.amt+"    Total amt="+(acc1.amt+acc2.amt));
		 }
	}
	 
	 static class Account {
		 int amt =10000;
		 
		 public static void transfer(Account acc1,Account acc2, int amount)
		 {
			 acc1.amt -= amount;
			 acc2.amt += amount;
			 
		 }
		 
		
	 }

}
