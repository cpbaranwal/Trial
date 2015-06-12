package threading;

public class SynchronizedKeywordSample {

	/**
	  sample program to show use case of synchronized keyword
	 */
	
	
	//private volatile int count = 0;   //no use of volatile
	private int count = 0;
	 
	public static void main(String[] args) {
		SynchronizedKeywordSample sample = new SynchronizedKeywordSample();
		sample.doWork();
		System.out.println("value of count :"  + sample.count);
	}
	
	public synchronized void  incrementCount()
	{
		count++;
	}

	private void doWork()
	{
		Thread t1 = new Thread( new Runnable(){
			public void run()
			{
				for(int i=0; i<5000; i++)
				{
					//count++;
					incrementCount();
				}	
			}
		});
		Thread t2 = new Thread( new Runnable(){
			public void run()
			{
				for(int i=0; i<5000; i++)
				{
					//count++;
					incrementCount();
				}	
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
