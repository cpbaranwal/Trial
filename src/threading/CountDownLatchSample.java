package threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchSample {

	/**
	    sample program to make 1 thread to wait for other threads to complete
	 */
	
	static CountDownLatch latch = new CountDownLatch(3);
	public static void main(String[] args)
	{
	ExecutorService exec = Executors.newFixedThreadPool(3);
	for(int i=0; i<3 ; i++)
	{	exec.execute(new Processor(latch));

	}
	try {
		System.out.println(Thread.currentThread().getName()+":   waiting for other threads to complete....");
		latch.await();
		exec.shutdown();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(Thread.currentThread().getName()+":  All threads completed....so main can work now");
	
	}
	
	static class Processor implements Runnable
	{

		CountDownLatch latch ;
		public Processor(CountDownLatch cdl)
		{
			latch = cdl;
		}
		public void run()
		{
			System.out.println(Thread.currentThread().getName()+":  started...");
			try {
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName()+":  completed...");
				latch.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
