package threading;

import java.util.Scanner;

public class VolatileSample{

	/**
	   example to show use of volatile
	 */
	

	static class Processor extends Thread
	{
	private volatile boolean running = true;

	public void run()
	{
		while(running)
		{
			System.out.println("chandan  ");
		  try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public void shutdown()
	{
		running = false;
	}
	
}
	public static void main(String[] args) 
	{
		Processor p1 = new Processor();
		p1.start();
		System.out.println("Press Enter to stop......");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		p1.shutdown();
		

	}
}