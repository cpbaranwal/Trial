package threading.threadPool.approach_Shailesh;

/**
 * 
 */


import java.util.LinkedList;

/**
 * @author Shailesh
 *
 */
public class SimpleThreadPool {

	private WorkerThread[] threads;
	private LinkedList<Runnable> taskQueue;
	
	
	
	

	/**
	 * Initialise Thread Pool
	 */
	public SimpleThreadPool(int poolsize) {
		threads = new WorkerThread[poolsize];
		taskQueue = new LinkedList<Runnable>();
		
		for(int i=0;i<poolsize-1; i++)
			{	
				threads[i]=new WorkerThread();
				threads[i].start();
			}
		
	}
	
	/**
	 * Prepare queue for Task 
	 * @param task
	 */
	public void enqueue(Runnable task)
	{
		synchronized(taskQueue)
		{
			taskQueue.addLast(task);
			taskQueue.notify();
		}
		
		
	}
	
	
	
	
	
	public class WorkerThread extends Thread {
		
		 public void run()
		 {
			 Runnable r;
			 
			 while(true)
			 {
				 synchronized (taskQueue) {
						 
							 while(taskQueue.isEmpty())
							 {
								 try {
									taskQueue.wait();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									//Ignore
								}
							 }//check is task queue is empty
						r = (Runnable) taskQueue.removeFirst();
							
					}//synchronized taskqueue
				 
				try { 
					r.run();
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					//Ignore
				} 
				 
				 
			 }//infinite time loo[
			 
		 }
				
			
			

	}

	

}
