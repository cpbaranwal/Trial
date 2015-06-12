package pack6;

import pack6.TreeUtil.Tnode;
import pack6.TreeUtil;

public class DeleteNodeInBST {

	/**
	   Given a Binary Search Tree, write program to delete a node
	   
	    			  6
                    /   \
                   2     8
                  /\     /\
                 1  4   7  9
                    /\
                   3  5               
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
		
		int num=2;
		System.out.println("Before Deletion:");
		TreeUtil.inorderTraversal(root);//LNR
		deleteNodeInBst(root,null,num);
		System.out.println("After Deletion:");
		TreeUtil.inorderTraversal(root);//LNR

	}

	private static void deleteNodeInBst(Tnode head,Tnode parent,int num) 
	{
		if (head==null  )
			return;
		System.out.println("head.data="+head.data);
		if (num<head.data)
		{
			deleteNodeInBst(head.l,head,num);
		}
		else if (num>head.data)
		{
			deleteNodeInBst(head.r,head,num);
		}
		else  //num==head.data
		{
			//not considering case when head=parent i.e. root node
			if(head.l==null && head.r==null)  //is a leaf node
			{
				if(parent.l==head)
					parent.l=null;
				else
					parent.r=null;
			}
			else if(head.l==null)  //head.r!=null
			{
				if(parent.l==head)
					parent.l=head.r;
				else
					parent.r=head.r;
			}
			else if(head.r==null)  //head.l!=null
			{
				if(parent.l==head)
					parent.l=head.l;
				else
					parent.r=head.l;
			}
			else
			{  //replacing with maxm element on left tree....an alternative approach can be minimum element on right subtree
				Tnode tmp = head.l;
				parent=head;
				while(tmp.r!=null)
				{   parent=tmp;
					tmp=tmp.r;
				}
				swapData(head,tmp);
				deleteNodeInBst(tmp,parent,num);
			}
				
		}
		
	}
	
	private static void swapData(Tnode n1,Tnode n2)
	{
		System.out.println("swapdata:  n1.data="+n1.data+"   n2.data="+n2.data);
		int tmp=n1.data;
		n1.data=n2.data;
		n2.data=tmp;
	}

}
