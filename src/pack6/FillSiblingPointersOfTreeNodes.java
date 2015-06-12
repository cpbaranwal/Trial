package pack6;

import java.util.ArrayList;
import java.util.List;


public class FillSiblingPointersOfTreeNodes {

	/**
	    Given a tree with 3 pointers:
	    left,right and nxtSibling
	    where nxtSibling=null initially for all nodes.
	    Write program to fill all sibling pointers correctly.
	    
	    	    	   
	    			  6
                    /   \
                   2     8
                  /\     /\
                 1  4   7  9
                    /\
                   3  5   
          Sibling of 2:   8
          Sibling of 8: null
	 */
	public static void main(String[] args) 
	{
		TnodeSibling root= new TnodeSibling(6);
		root.l=new TnodeSibling(2);
		root.r=new TnodeSibling(8);
		root.l.l=new TnodeSibling(1);
		root.l.r=new TnodeSibling(4);
		root.r.l=new TnodeSibling(7);
		root.r.r=new TnodeSibling(9);
		root.l.r.l=new TnodeSibling(3);
		root.l.r.r=new TnodeSibling(5);

		fillSibLingPointers1(root);  //this approach uses queue and follows level order traversing.
		fillSibLingPointersSmartApproach(root);
	}
	
	
	
	private static void fillSibLingPointersSmartApproach(TnodeSibling root)  //without using extra space, 2 times traversal.......first time link adjacent siblings.....2nd time links cousing siblings
	{  //Space-O(1)   Time-O(2n)   TODO infact we dont need double traversal ,
		if(root==null)
		   return;
		//TODO modify program to do in single trvaersal
		fillSibLingPointersSmartApproachHelper1(root);
		fillSibLingPointersSmartApproachHelper2(root);
	}



	private static void fillSibLingPointersSmartApproachHelper1(TnodeSibling root) //1st time traversal to link adjacent siblings
	{
		if(root==null)
			return;
		if(root.l!=null)
		{
			root.l.nxtSibling = root.r;
			System.out.println("Next sibling of "+root.l.data+"  is   :"+((root.r==null)?null:root.r.data));
		}
		
		/*
		if(root.nxtSibling!=null && (root.l!=null || root.r!=null))
		{
			TnodeSibling tmp = root.l;
			if(root.r!=null)
				tmp=root.r;
			tmp.nxtSibling = root.nxtSibling.l;
		}
		*/	
			
		fillSibLingPointersSmartApproachHelper1(root.l);
		fillSibLingPointersSmartApproachHelper1(root.r);
		
	}



	private static void fillSibLingPointersSmartApproachHelper2(TnodeSibling head)  //2nd time traversal to link cousin siblings
	{
		if(head==null)
		    return;
		
		if(head.nxtSibling!=null)  //link cousing siblings
		{
			TnodeSibling cousin1 = head.r;
			if(cousin1==null)  //may be left node had only left child
				cousin1=head.l;
			if(cousin1!=null)
			{
				cousin1.nxtSibling = (head.nxtSibling.l==null?head.nxtSibling.r:head.nxtSibling.l);
				System.out.println("Next sibling of "+cousin1.data+"  is   :"+((cousin1.nxtSibling==null)?null:cousin1.nxtSibling.data));
			}
					
		}
		
		fillSibLingPointersSmartApproachHelper2(head.l);
		fillSibLingPointersSmartApproachHelper2(head.r);
	}



	private static void fillSibLingPointers1(TnodeSibling root)  //this approach uses same approach as level order traversal using a queue
	{  //space- O(n) for queue   Time-O(n)
		if(root==null)
			return;
		else
		{
			List<TnodeSibling> list = new ArrayList<TnodeSibling>();
			list.add(root);
			list.add(null);
			fillSibLingPointers1Helper(list);
			
		}
					
		
	}



	private static void fillSibLingPointers1Helper(List<TnodeSibling> list)
	{
		TnodeSibling curr,next=null;
		//curr = list.remove(0);
		while(!list.isEmpty())
		{
			next = null;
			curr = list.remove(0);
			while(curr!=null )
			{
				if(curr.l!=null)
					list.add(curr.l);
				if(curr.r!=null)
					list.add(curr.r);
				
				next = list.remove(0);
				curr.nxtSibling = next;
				System.out.println("Next sibling of "+curr.data+"  is   :"+((next==null)?null:next.data));
				curr = next;
			}
			
			if(!list.isEmpty())//add null pointer to mark end of level only if list still contains elements 
				list.add(null);
			
		}
		
	}



	static class TnodeSibling
	{
		TnodeSibling l,r,nxtSibling;
		int data;
		public TnodeSibling(int data)
		{
			this.data=data;
			l=null;r=null;nxtSibling=null;
		}
		
	}

}
