package threading;
import java.util.*;

public class MultipleLocksSynchronizedBlockSample {

	/**
	  use of multiple object/monitor/intrinsic lock
	 */
	
	List<Integer>  list1 = new ArrayList<Integer>();
	List<Integer>  list2 = new ArrayList<Integer>();
	Random random = new Random();
	
	Object lock1 = new Object();
	Object lock2 = new Object();
	
	//public synchronized void stage1()
	public  void stage1()
	{
		synchronized(lock1)
		{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list1.add(random.nextInt(100));
		}
	}
	
	//public synchronized void stage2()
	public  void stage2()
	{
		synchronized(lock2)
		{
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list2.add(random.nextInt(100));
		}
	}
	public void process()
	{
		for(int i=0; i<1000; i++)
		{
			stage1();
			stage2();
		}
	}
	
	public void mainMethod()
	{
		Thread t1 = new Thread( new Runnable()
		{

			@Override
			public void run() {
				process();
				
			}
			
		});
		
		Thread t2 = new Thread( new Runnable()
		{

			@Override
			public void run() {
				process();
				
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
	
	public static void main(String[] args) 
	{
		System.out.println("Starting......");
		
		long start = System.currentTimeMillis();
		MultipleLocksSynchronizedBlockSample sample = new MultipleLocksSynchronizedBlockSample();
		sample.mainMethod();
		long end = System.currentTimeMillis();
		
		System.out.println("sample.list1.size()= "+sample.list1.size());
		System.out.println("sample.list2.size()= "+sample.list2.size());
		System.out.println("time taken: "+(end-start));
		

	}

}
