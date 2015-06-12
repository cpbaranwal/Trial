package threading;

public class WaitNotifySample {

	/**
	   sample program for wait-notify functionality
	 */
	
	static Object lock = new Object();
	static volatile boolean running = true;
	static volatile int count = 0;
	public static void main(String[] args) throws InterruptedException 
	{
		new Thread(new Producer()).start();
		Thread.sleep(1000);
		new Thread(new Consumer()).start();
		
		Thread.sleep(5000);
		running=false;

	}
	
	static class Producer implements Runnable
	{
		public void run()
		{
			while(running)
			{
			synchronized(lock)
			{
				System.out.println("producer thread running....");
				count++;
				try {
					lock.wait();  // wait for this count to get consumed
					//System.out.println("producer thread resumed");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			}
		}
	}

	static class Consumer implements Runnable
	{
		public void run()
		{
			while(running)
			{
				
			synchronized(lock)
			{
				System.out.println("Consumer thread running....count="+count);
				try {
					Thread.sleep(500);
					lock.notify();  // wait for this count to get consumed
					//Thread.sleep(1000);  // synchronized block should end immediately after notify otherwise producer will keep waiting for lock although its notified
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
			}
			
			try {
				Thread.sleep(100);  //time given to release lock
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}

}
