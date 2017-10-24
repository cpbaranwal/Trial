package temp;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

	
	public static void main(String[] args)
	{
		HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
		map.entrySet();
		ThreadLocal tl;
		ArrayBlockingQueue abq;
		
		String s="c";
		System.out.println("==="+s.substring(2));
		Executors.newCachedThreadPool();
		Executors.newFixedThreadPool(5);
		Semaphore sm;
		CountDownLatch cdl;
		AtomicInteger ai;
	}

}
