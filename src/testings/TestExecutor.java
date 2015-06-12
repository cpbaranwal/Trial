package testings;

import java.util.concurrent.*;
import java.util.*;

public class TestExecutor {

	/**
	 	program to test executor framework.
	 */
	
	static int numThreads = 3;
	static int runnableCount =0;
	static int callableCount =0;
	public static void main(String[] args) throws InterruptedException, ExecutionException {


		
		//testExecutorServiceRunnable();
		testExecutorServiceCallable();
		

	}
	
	public static void testExecutorServiceCallable() throws InterruptedException, ExecutionException
	{
		ExecutorService exec = Executors.newFixedThreadPool(numThreads);
		try
		{
			List<Future<Integer>> futureObjList = new ArrayList<Future<Integer>>();
		for(int i =0; i<2*numThreads; i++)
		{
		    Future<Integer> futureObj = exec.submit(new Callable<Integer>()
		    {
		    	public Integer call() throws Exception {
		    		callableCount++;
		    		return callableCount;
		    	}
		    }
		   
		    
		    );
		    futureObjList.add(futureObj);
		}
		
		System.out.println("futureObjList== "+futureObjList);
		for(Future<Integer> obj : futureObjList )
		  System.out.println(obj.get());
		}
		finally{
			exec.shutdown();
		}
		
	}
	
	public static void testExecutorServiceRunnable()
	{
		
		ExecutorService exec = Executors.newFixedThreadPool(numThreads);
		try
		{
		for(int i =0; i<2*numThreads; i++)
		{
		exec.execute(new Runnable()
		{
			@Override
			public void run() {
				runnableCount++;
				System.out.println("runnableCount== "+runnableCount);
				
				
			}
		}
		);
		}
		}
		finally
		{
			exec.shutdown();
		}
	}

}
