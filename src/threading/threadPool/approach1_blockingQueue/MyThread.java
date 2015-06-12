package threading.threadPool.approach1_blockingQueue;

import java.util.concurrent.BlockingQueue;

import threading.threadPool.approach1_blockingQueue.ThreadPool;

public class MyThread extends Thread
{

	
	String name;
	BlockingQueue<Runnable> taskQueue; 
	public MyThread(String name, BlockingQueue<Runnable> taskQueue) 
	{
		this.name=name;
		this.taskQueue=taskQueue;
	}
	
	
	@Override
	public void run() 
	{
		System.out.println("Starting: "+name+".............." );
		while(!ThreadPool.isStopped)
		{
			try {
				Runnable task = taskQueue.take();
				task.run();
			} catch (InterruptedException e) {
				System.out.println("Interrupted: "+name+".............." );
				//e.printStackTrace();
			}
		}
		System.out.println("Dying: "+name+".............." );
	}
	
	public void doStop()
	{
		//if the current thread is waiting on queue for new task, give interruptedException,check isStopped boolean again and die.
		this.interrupt();
	}

}
