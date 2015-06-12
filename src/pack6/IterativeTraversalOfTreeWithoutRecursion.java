package pack6;
import java.util.Stack;
import java.util.Vector;

import pack6.TreeUtil.Tnode;

public class IterativeTraversalOfTreeWithoutRecursion {

	/**
	 Given a Binary Tree, write an iterative function to print 
	 Preorder traversal and 
	 inorder traversal of the given binary tree.

	    			 6
                    / \
                   2    8
                  /\     /\
                 1  5   7  9 
                     \
                      10
                                
	 */
	public static void main(String[] args) 
	{
		Tnode root= new Tnode(6);
		root.l=new Tnode(2);
		root.r=new Tnode(8);
		root.l.l=new Tnode(1);
		root.l.r=new Tnode(5);
		root.l.r.r = new Tnode(10);
		root.r.l=new Tnode(7);
		root.r.r=new Tnode(9);
		
		System.out.println("Preorder without recursion:");
		preorderWithoutRecursion(root);
		System.out.println();
		
		System.out.println("Inorder without recursion:");
		inorderWithoutRecursion(root);
		System.out.println();
		
		System.out.println("Postorder without recursion:");
		postorderWithoutRecursion(root);//LRN
		System.out.println();
		

	}

	static Stack<Tnode> stack = new Stack<Tnode>();
	private static void preorderWithoutRecursion(Tnode root) //NLR
	{
		if(root==null)
			return;
		stack.push(root);
		while(!stack.isEmpty())
		{
			Tnode topElement = stack.pop();
			System.out.print("   "+topElement.data);
			if(topElement.r != null)
				stack.push(topElement.r);
			if(topElement.l != null)
				stack.push(topElement.l);
		}
	}

	
	private static void inorderWithoutRecursion(Tnode root)  
	//LNR  ....maintaining a current pointer and a stack....good algorithm
	{
		if(root==null)
			return;
		//stack.push(root);
		Tnode current = root;
		while(true)
		{
			//Tnode topElement = stack.peek();
			if(current!=null )
			{
				//
				stack.push(current);
				current = current.l;
			}
			else
			{
				if(stack.isEmpty())
				{
					return ;
				}
				current = stack.pop();
				System.out.print("   "+current.data);
				current = current.r;
			}
		}
	}
	
	static Stack<Tnode> outputStack = new Stack<Tnode>();
	private static void postorderWithoutRecursion(Tnode root)  
	//LRN  ....maintaining 2 stacks....good algorithm
	{
		if(root==null)
			return;
		stack.push(root);
		while(!stack.isEmpty())
		{
			Tnode topElement = stack.pop();
			outputStack.push(topElement);
			
			if(topElement.l !=null)//tricky
				stack.push(topElement.l);
			
			if(topElement.r !=null)
				stack.push(topElement.r);
			
		}
		
		while(!outputStack.isEmpty())
		{
			System.out.print("   "+outputStack.pop().data);
		}
	}
	
}
