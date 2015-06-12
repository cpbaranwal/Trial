package threading;

import java.util.LinkedList;

public class ProducerConsumerUsingWaitNotifySample {

	/**
	    producer-consumer problem using wait-notify
	    Imp - here we should use notifyAll in place of notify and while check on list size 
	    after waking up from wait call.
	    This is necessary if there are more than one producer/consumer otherwise will lead to deadlock.
	 */
	
	static final int LIMIT = 10;
	static Object lock = new Object();
	static LinkedList<Integer> list = new LinkedList<Integer>();
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		new Thread(new Producer()).start();
		Thread.sleep(500);
		new Thread(new Consumer()).start();
		Thread.sleep(1000);
		System.exit(0);

		
	}
	static class Producer implements Runnable
	{
		public void run()
		{
			while(true)
			{
				synchronized (lock)
				{
					while(list.size() >= LIMIT)
					{
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					list.add(1);//adding same number again and again
					System.out.println("Added:  list.size()="+list.size());
					lock.notifyAll();//notifyAll should be called instead
				}
				
					
			}
		}
	}

	static class Consumer implements Runnable
	{
		public void run()
		{
			while(true)
			{
				synchronized (lock)
				{
					while(list.size() == 0)
					{
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					list.removeFirst();  //adding same number again and again
					System.out.println("Removed:  list.size()="+list.size());
					lock.notifyAll();//notifyAll should be called instead
				}
				
					
			}
		}
	}
	
}
