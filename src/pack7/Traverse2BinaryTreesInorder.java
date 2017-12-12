package pack7;

import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import pack6.TreeUtil.Tnode;

public class Traverse2BinaryTreesInorder {

	/**
	    Given two binary trees, traverse them in Inorder one by one.
	    e.g.
	   				 1
                    / \
                   2   3
                  /\    
                 4  5  
               
	   				 11
                    /   \
                   22    33
                   \      
                    55    
               
               LNR1 - 4,2,5,1,3
               LNR2 - 22,55,11,33
               output -4,22,2,55,5,11,1,33,3
	    
	 */
	
	static Tnode root1;
	static Tnode root2;
	static Lock lock1 = new ReentrantLock();
	static Lock lock2 = new ReentrantLock();
	static volatile int volatileFlag = 0;
	public static void main(String[] args) throws InterruptedException 
	{
		root1= new Tnode(1);
		root1.l=new Tnode(2);
		root1.r=new Tnode(3);
		root1.l.l=new Tnode(4);
		root1.l.r=new Tnode(5);
		
		root2= new Tnode(11);
		root2.l=new Tnode(22);
		root2.r=new Tnode(33);
		root2.l.r=new Tnode(55);
		
		inorderTraversalTogether(root1,root2);   //traverses both trees using iteration
		inorderTraversalUsingThreads(); // traverses both trees using threading
		

	}
	
	
	static Stack<Tnode> stack1 = new Stack<Tnode>();
	static Stack<Tnode> stack2 = new Stack<Tnode>();
	public static void inorderTraversalTogether(Tnode r1, Tnode r2)
	{
		if(r1==null && r2==null)
			return;
		Tnode current1 = r1;
		Tnode current2 = r2;
		System.out.println("using iteration:");
		while(true)
		{
			while(current1!=null)
			{
				stack1.push(current1);
				current1 = current1.l;
			}
			if(!stack1.isEmpty())
			{
				Tnode tmp = stack1.pop();
				System.out.print("  "+tmp.data);
				current1 = tmp.r;
			}
			
			while(current2!=null)
			{
				stack2.push(current2);
				current2 = current2.l;
			}
			if(!stack2.isEmpty())
			{
				Tnode tmp = stack2.pop();
				System.out.print("  "+tmp.data);
				current2 = tmp.r;
			}
			
			if(stack1.isEmpty() && current1==null && stack2.isEmpty()  && current2==null)
				break;
		}
		System.out.println();
		 System.out.println("Finished........using iteration");	
		
	}
	
	
	public static void inorderTraversalUsingThreads() throws InterruptedException 
	{
		System.out.println("using threads:");
		Thread t1 = new Thread( new Runnable(){
			
			public void run()
			{
				try {
					inorderTraversal(root1,lock1,lock2);   //approach1 using synchronization
					//inorderTraversal(root1,0,1);     //approach2 using volatile...no synchronization
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
         Thread t2 = new Thread( new Runnable(){
			
			public void run()
			{
				try {
					inorderTraversal(root2,lock2,lock1);   //approach1
					//inorderTraversal(root2,1,0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
         
         t1.start();
         Thread.sleep(200);
         t2.start();
         t1.join();
         t2.join();
         System.out.println();
         System.out.println("Finished........using threads");
	}
	
	public static void inorderTraversal(Tnode root, int volatileValueForThisThread,int volatileValueForOtherThread) throws InterruptedException//using volatile variable...not using synchronization/lock
	{
		if(root==null)
			return;
		
		inorderTraversal(root.l,volatileValueForThisThread,volatileValueForOtherThread);
		
		/*
		while(volatileFlag != volatileValueForThisThread)
		{
			//doing nothing....eating CPU cycles as wastage...not recommended....thread sleep should be preferred
		}
		*/
		while(volatileFlag != volatileValueForThisThread)
			Thread.sleep(300);
		
		System.out.print("  "+root.data);
		volatileFlag = volatileValueForOtherThread;
		inorderTraversal(root.r,volatileValueForThisThread,volatileValueForOtherThread);
	}

	
	
	
	public static void inorderTraversal(Tnode root, Lock lock1, Lock lock2) throws InterruptedException// approach using two locks, each thread using one lock to proceed and other to block
	{
		if(root==null)
			return;
		
		inorderTraversal(root.l,lock1,lock2);
		synchronized(lock1)
		{	
			System.out.print("  "+root.data);
			synchronized(lock2)
			{
				lock2.notify();
			}
			lock1.wait(5000);
		}
		inorderTraversal(root.r,lock1,lock2);
	}

	
	public static void inorderTraversal(Tnode root)//LNR
	{
		if(root==null)
			return;
		inorderTraversal(root.l);
		System.out.print("  "+root.data);
		inorderTraversal(root.r);
	}

}

