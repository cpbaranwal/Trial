package pack6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pack6.TreeUtil.Tnode;

public class ZigzagTreeTraversal {

	/**
	    Given a binary tree,print its nodes in zigzag way.
	    	   
	    			  6
                    /   \
                   2     8
                  /\     /\
                 1  4   7  9
                    /\
                   3  5   
          output:  
                    6  8  2  1  4  7  9  5  3
	 */
	public static void main(String[] args) 
	{
		Tnode root= new Tnode(6);
		root.l=new Tnode(2);
		root.r=new Tnode(8);
		root.l.l=new Tnode(1);
		root.l.r=new Tnode(4);
		root.r.l=new Tnode(7);
		root.r.r=new Tnode(9);
		root.l.r.l=new Tnode(3);
		root.l.r.r=new Tnode(5);
		
		printTreeZigzagWay(root);

	}

	private static void printTreeZigzagWay(Tnode root)  //uses two stacks one pushing elements in stack in order: left->right and other : right->left.
	{  //space-O(n)   time-O(n)
	  if(root==null)
		  System.out.println("no data to print");
	  else
	  {
		  List<Tnode> stackLeftToRight=new ArrayList<Tnode>();
		  List<Tnode> stackRightToLeft=new ArrayList<Tnode>();
		  
		  stackRightToLeft.add(root);
		  printTreeZigzagWayHelper(stackLeftToRight,stackRightToLeft);
	  }
		
	}

	private static void printTreeZigzagWayHelper(List<Tnode> stackLeftToRight,List<Tnode> stackRightToLeft)
	{
		while(!stackLeftToRight.isEmpty() || !stackRightToLeft.isEmpty())
		{
			//if(!stackRightToLeft.isEmpty())
			{
				while(!stackRightToLeft.isEmpty())
				{
					Tnode lastElement = stackRightToLeft.remove(stackRightToLeft.size()-1);  //pops last element
					System.out.print("  "+lastElement.data);
					if(lastElement.l!=null)
					    stackLeftToRight.add(lastElement.l);
					if(lastElement.r!=null)
					    stackLeftToRight.add(lastElement.r);
				}
			}
			
			//if(!stackLeftToRight.isEmpty())
			{
				while(!stackLeftToRight.isEmpty())
				{
					Tnode lastElement = stackLeftToRight.remove(stackLeftToRight.size()-1);  //pops last element
					System.out.print("  "+lastElement.data);
					if(lastElement.r!=null)
						stackRightToLeft.add(lastElement.r);
					if(lastElement.l!=null)
						stackRightToLeft.add(lastElement.l);
					
				}
			}
		}
		
	}

}
