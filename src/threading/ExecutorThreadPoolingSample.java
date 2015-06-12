package threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorThreadPoolingSample {

	/**
	   example program for Executor Thread pooling
	 */
	public static void main(String[] args) 
	{
		ExecutorService exec = Executors.newFixedThreadPool(2);
		/*  OR
	
		exec = new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
		*/
		for(int i=1; i<=5; i++)
			exec.execute(new Processor(i));

		exec.shutdown();
		System.out.println("All tasks submitted....");
		
		try {
			exec.awaitTermination(10, TimeUnit.MINUTES);  //called only after shutdown call...
			System.out.println("All tasks completed....");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	static class Processor implements Runnable
	{
		int id;
		public Processor(int id)
		{
			this.id = id;
		}
		public void run()
		{
			System.out.println("Starting: "+id);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Completed: "+id);
		}
	}

}
