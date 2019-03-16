package threading;

public class ThreadInterruptionSample {

	/**
	 * @throws InterruptedException 
	 	
	 */
	public static void main(String[] args) throws InterruptedException
	{
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
		//Thread.sleep(1000);
		t1.interrupt();
		Thread.sleep(100);
		flag=false;
		Thread.sleep(100);
		System.out.println("main() completed");

	}
	
	static volatile boolean flag=true;
	static class MyRunnable implements Runnable
	{

		@Override
		public void run() 
		{
			while(flag)
			{
				System.out.println(Thread.currentThread().getName()+"   running.....");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//if(Thread.currentThread().isInterrupted())
					//throw new RuntimeException("Thread is interrupted");
			}
			
		}
		
	}

}
