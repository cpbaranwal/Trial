package temp;

import java.util.LinkedList;
import java.util.Stack;

public class StackWithFindMaxUtility {

	/**
	    Design a stack with findMax() (getting maximum element from stack) in O(1)
	 */
	
	public static void main(String[] args) 
	{
		StackWithFindMaxUtility stack = new StackWithFindMaxUtility();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(5);
		
		System.out.println(stack.findMax()+"   :  "+stack.pop());
		System.out.println(stack.findMax()+"   :  "+stack.pop());
		System.out.println(stack.findMax()+"   :  "+stack.pop());
		System.out.println(stack.findMax()+"   :  "+stack.pop());
		System.out.println(stack.findMax()+"   :  "+stack.pop());
		System.out.println(stack.findMax()+"   :  "+stack.pop());

	}
	
	private LinkedList<Integer> stack1 = new LinkedList<Integer>();
	private LinkedList<Integer> stackMax = new LinkedList<Integer>();
	
	public void push(int data)
	{
		int max = data;
		if(!stackMax.isEmpty() && max<stackMax.peek())
		{
			max=stackMax.peek();
		}
		stack1.push(data);
		stackMax.push(max);
	}
	
	public int  pop()
	{
		if(stack1.isEmpty())
		{
			System.out.println("No element Remaining");
			return -1;
		}
		
		stackMax.pop();
		return stack1.pop();
	}
	
	public int findMax()
	{
		if(stackMax.isEmpty())
		{
			System.out.println("No element Remaining");
			return -1;
		}
		
		return stackMax.peek();
		 
	}
	
	
	
	

}
