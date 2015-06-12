package testings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class Test implements Runnable {
int state = 0;
CountDownLatch cdl;
public void run() {
while (true)
if (state == 0) {
System.out.println("Running from Ready");
state = 1;
}
else
System.out.println("Running from Waiting");
}
public static void main(String[] args) {
	
	AtomicInteger ref;
	//List<String> list = ArrayList<String>();
	List<? extends Object> list = new ArrayList<String>();
	//List<? extends Integer> list = ArrayList<Number>();
	
Test c = new Test();
Thread t = new Thread(c);
t.run();
ReadWriteLock rwl=null;
LinkedHashMap map=null;
ConcurrentHashMap m=null;
HashMap m1=null;
Executors exec;
ReentrantLock lck=new ReentrantLock();

}


public static class Node
{
	int data;
	Node l,r;
}


public static void rearrangeTree(Node root)
{
	if(root==null || (root.r==null && root.l==null))
		return;
	Node p=root.l;
	if(p==null || ((root.r!=null) && root.r.data>p.data))
		p=root.r;
	if(root.data>p.data)   //desirable condition
		return;
	
	
	//swappig
	int tmp=root.data;
	root.data=p.data;
	p.data=tmp;
	
	rearrangeTree(p);  //calling recursively now for sub trees.
}


}