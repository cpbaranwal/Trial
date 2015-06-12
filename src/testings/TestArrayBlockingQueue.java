package testings;
import java.util.*;
import java.util.concurrent.*;

public class TestArrayBlockingQueue {

	/**
	     Sample program to test ArrayBlockingQueue or producer-cpnsumer problem
	 */
	static int cnt =0;
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Testing ArrayBlockingQueue.....");
		BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(3);
		Producer p = new Producer(q);
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
		System.out.println("Going to sleep.....");
		Thread.sleep(5*1000);
		System.exit(0);

	}
	
	static class Producer implements Runnable
	{
		private final BlockingQueue<Integer>  queue;
		
		public Producer(BlockingQueue q) {
			queue = q;
		}
		
		@Override
		public void run() {
			
			while(true)
			{
				try {
					if(cnt<=10)
					{
						Thread.sleep(200);
					queue.put(++cnt);
					System.out.println("Number inserted: "+cnt);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	static class Consumer implements Runnable
	{
		private final BlockingQueue<Integer>  queue;
		
		public Consumer(BlockingQueue q) {
			queue = q;
		}
		
		@Override
		public void run() {
			
			while(true)
			{
				try {
					Thread.sleep(500);
					System.out.println("number popped up: "+queue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
