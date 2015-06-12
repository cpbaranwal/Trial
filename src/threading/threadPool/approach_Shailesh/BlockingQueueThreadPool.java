package threading.threadPool.approach_Shailesh;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueThreadPool {

	private WorkerThread[] threads;
	private BlockingQueue<Runnable> taskQueue;

	/**
	 * Initialise Thread Pool
	 */
	public BlockingQueueThreadPool(int poolsize) {
		threads = new WorkerThread[poolsize];
		taskQueue = new ArrayBlockingQueue<Runnable>(2);

		for (int i = 0; i < poolsize - 1; i++) {
			threads[i] = new WorkerThread();
			threads[i].start();
		}

	}

	/**
	 * Prepare queue for Task
	 * 
	 * @param task
	 */
	public void enqueue(Runnable task) {
		try {
			taskQueue.put(task);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public class WorkerThread extends Thread {

		public void run() {
			Runnable r = null;

			while (true) {

				try {
					r = (Runnable) taskQueue.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					r.run();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// Ignore
				}

			}// infinite time loo[

		}

	}

}
