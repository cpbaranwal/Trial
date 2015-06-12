package testings;
import java.util.concurrent.*;
import java.util.*;

public class TestCountDownLatch  {

	/**
	 Sample program to test CountDownLatch
	 */
	
	public static int counter =0;
	public static CountDownLatch cdl = null;
	
	public static void main(String[] args) {
		
		testCountDownLatchSingle();

	}
	
	public static void testCountDownLatchSingle()
	{
		System.out.println("function to test countdownlatch as on/off switch");
		 cdl = new CountDownLatch(1);
		for(int i =0; i<5; i++)
		{
			new Thread(new SingleLatchRunnable()).start();
		}
		
		try {
			System.out.println("main thread is giving time to other threads to initialize");
			Thread.sleep(5*1000);
			System.out.println("Other threads!!....b ready now.....");
			Thread.sleep(2*1000);
			cdl.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static class SingleLatchRunnable implements Runnable
	{
		@Override
		public void run() {
			try {
				cdl.await();
				counter++;
				System.out.println("counter== "+counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
