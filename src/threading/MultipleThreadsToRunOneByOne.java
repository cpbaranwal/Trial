package threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MultipleThreadsToRunOneByOne {

	/**
	  Say there are 3 threads...run them one by one in proper sequence
	  Good program...uses 2 atomic integers to keep track of count and thereadId.
	  
	  
	  alternate solution:  you can use multiple object locks.
	  //TODO have to write program
	  Hint:  public void run()
{
    while(true) {
    synchronized (thisLock) {
        synchronized (nextLock) {
            nextLock.notify();
            printIncrement(threadName);
        }
        try {
            thisLock.wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }
	 */
	
	final static AtomicInteger count = new AtomicInteger(1);//here AtomicInteger need not be volatile as reference itself is not updated only the value is updated 
	final static AtomicInteger countHelper = new AtomicInteger(1);
	static Object lock = new Object();
	static final int numThreads = 3;
	public static void main(String[] args) throws InterruptedException
	{
	
		Thread t1 = new Thread(new Runner(1));
		Thread t2 = new Thread(new Runner(2));
		Thread t3 = new Thread(new Runner(3));
		
		t1.start();
		t2.start();
		t3.start();
		
		Thread.sleep(1000);
		System.exit(0);
		
	}
	
	

	static class Runner implements Runnable
	{
		int id ;
		public Runner(int id)
		{
			this.id = id;
		}
		public void run()
		{
			while(true)
			{
			synchronized (lock) 
			{
				while(countHelper.get() != id)
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Thread id:"+id+"   count.get()="+count.get());
				count.incrementAndGet();//keeps state of count
				countHelper.incrementAndGet();//keeps track of threadId which has to be run
				if(countHelper.get() > numThreads)
				{
					countHelper.set(countHelper.get() - numThreads);
				}
				lock.notifyAll();//Here notify cannot be used in place of notifyAll as all threads are similar but  only a  particular thread needs to be awakened
			}
			try {
				Thread.sleep(500);//added just to see values in slow motion
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
	}
	
	

}
