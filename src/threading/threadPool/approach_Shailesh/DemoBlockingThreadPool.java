package threading.threadPool.approach_Shailesh;

public class DemoBlockingThreadPool {

	public DemoBlockingThreadPool() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BlockingQueueThreadPool pool = new BlockingQueueThreadPool(6);
		pool.enqueue(new Runnable()
		{

			@Override
			public void run() {
				System.out.println("Task 1 Started");
				
				try {
					 Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Task 1 completed");
				
			}
			
		});

		pool.enqueue(new Runnable()
		{

			@Override
			public void run() {
				System.out.println("Task 2 Started");
				
				try {
					 Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Task 2 completed");
				
			}
			
		});
		
		
		pool.enqueue(new Runnable()
		{

			@Override
			public void run() {
				System.out.println("Task 3 Started");
				
				try {
					 Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Task 3 completed");
				
			}
			
		});
		
		
		pool.enqueue(new Runnable()
		{

			@Override
			public void run() {
				System.out.println("Task 4 Started");
				
				try {
					 Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Task 4 completed");
				
			}
			
		});
		
		
		pool.enqueue(new Runnable()
		{

			@Override
			public void run() {
				System.out.println("Task 5 Started");
				
				try {
					 Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Task 5 completed");
				
			}
			
		});
		
	}

}
