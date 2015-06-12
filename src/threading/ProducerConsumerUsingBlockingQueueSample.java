package threading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueueSample {

	/**
	   BlockingQueue example for producer-consumer problem
	 */
	
	static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	static Random random = new Random();
	static volatile boolean running = true;
	public static void main(String[] args) 
	{
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
		new Thread(new Consumer(queue)).start();
		
		try {
			Thread.sleep(2000);
			running = false;
			//System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	static class Producer implements Runnable
	{
		private BlockingQueue<Integer> queue;
		public Producer(BlockingQueue<Integer> queue)
		{
			this.queue = queue;
		}
		public void run()
		{
			try {
				while(running)
				//while(true)
				{
				queue.put(random.nextInt(100));//no need of synchronized block
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static class Consumer implements Runnable
	{
		private BlockingQueue<Integer> queue;
		public Consumer(BlockingQueue<Integer> queue)
		{
			this.queue = queue;
		}
		public void run()
		{
			try {
				while(running)
					//while(true)
				{
				//Thread.sleep(500);
				int num = queue.take();
				System.out.println("Number taken="+num+"    queue.size()="+queue.size());
			}
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
