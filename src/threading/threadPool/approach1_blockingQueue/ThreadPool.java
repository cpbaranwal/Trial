package threading.threadPool.approach1_blockingQueue;

import java.util.*;
import java.util.concurrent.*;

public class ThreadPool {

	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("main() starts............." );
		ThreadPool pool = new ThreadPool(25,4);
		List<Runnable> workList = new ArrayList<Runnable>();
		workList.add(new RunnableSample("chandan"));
		workList.add(new RunnableSample("shailesh"));
		workList.add(new RunnableSample("ravi"));
		workList.add(new RunnableSample("anand"));
		workList.add(new RunnableSample("koustav"));
		workList.add(new RunnableSample("shashank"));
		workList.add(new RunnableSample("yashas"));
		workList.add(new RunnableSample("hina"));
		workList.add(new RunnableSample("sanjana"));
		
		for(Runnable work: workList)
			pool.submit(work);
		
		Thread.sleep(20);//sleep time is key will decide which thread gets interrupted from wait,which just dies after completion
		pool.shutDown();
		
		System.out.println("main() ends............." );
		
		//pool.submit(new RunnableSample("pappu"));
		

	}
	
		
	


	BlockingQueue<Runnable> taskQueue = null;
	List<MyThread>  threadList =null;//can take an array also
	public static volatile boolean isStopped=false;
	
	public ThreadPool(int maxTasks,int numThreads) {
		super();
		this.taskQueue = new LinkedBlockingQueue<Runnable>(maxTasks);
		this.threadList = new ArrayList<MyThread>(numThreads);
		for(int i=0; i<numThreads; i++)
		{
			threadList.add(new MyThread("Thread Number "+i, taskQueue));
		}
		for(MyThread thread: threadList)
			thread.start();  //every thread will start spinning forever and look for work from the queue all the time when free
	}
	
	public void submit(Runnable work) 
	{
		if(isStopped)
		{
			System.out.println(" throw new IllegalArgumentException(' Thread Pool has been shutDown,cant submit new Task!' )"+((RunnableSample)work).str);
			throw new IllegalArgumentException("Thread Pool has been shutDown,cant submit new Task!");
		}
			
		this.taskQueue.offer(work);//shud be put instead : blocking call
		
	}
	
	public void shutDown()
	{
		isStopped= true;
		for(MyThread thread: threadList)
			thread.doStop(); //thread allowed to finish current work,interrupts every blocked thread waiting for task on queue
	}
	
	
	
	
	
	
	

}
