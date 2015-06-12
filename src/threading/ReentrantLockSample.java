package threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSample {

	/**
	   reentrantLock and condition object example
	 */
//TODO explore whats use of conditionObject and  do read Many write one thread case is implemented by this.


	static final int LIMIT = 10;
	//Object lock = new Object();
	static Lock lock = new ReentrantLock();
	static Condition conditionObj = lock.newCondition();
	
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		new Thread(new Producer()).start();//not a producer consumer example...just a reentrant exampe
		Thread.sleep(500);
		new Thread(new Consumer()).start();
		Thread.sleep(700);
		System.exit(0);

		
	}
	static class Producer implements Runnable
	{
		public void run()
		{
			while(true)
			{
				System.out.println("producer waiting for lock...");
				//synchronized (lock)
				lock.lock();
				try{
				System.out.println("producer obtained lock...");
				//do processing here
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conditionObj.signal();
				}
				finally{
					lock.unlock();
				}
				
					
			}
		}
	}

	static class Consumer implements Runnable
	{
		public void run()
		{
			while(true)
			{System.out.println("Consumer waiting for lock...");
			//synchronized (lock)
			lock.lock();
			try {
				conditionObj.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //like wait() method ...keeps on waiting till it gets notified
			
			try{
			System.out.println("Consumer obtained lock...");
			//do processing here
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conditionObj.signal();
			}
			finally{
				lock.unlock();
			}}
		}
	}

}
