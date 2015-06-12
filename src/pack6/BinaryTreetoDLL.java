package pack6;
import pack6.TreeUtil.Tnode;


public class BinaryTreetoDLL {

	/**
	   program to convert a given Binary tree to  DLL
	    			 1
                    / \
                   2   3
                  /\    /\
                 4  5  6  7 
                /\
               8  9
	 
	 There's some bug in the code in approach1 ....have to look into!!
	 */
	
	public static void main(String[] args)
	{
		Tnode root= new Tnode(1);
		root.l=new Tnode(2);
		root.r=new Tnode(3);
		root.l.l=new Tnode(4);
		root.l.r=new Tnode(5);
		root.r.l=new Tnode(6);
		root.r.r=new Tnode(7);
		root.l.l.l=new Tnode(8);
		root.l.l.r=new Tnode(9);
		
		System.out.println("DLL:");
		//Tnode start = getDLLfromTree(root);   //Approach1 not working
		
		 //Approach2 bottom up working   using circular linked list, complexity goes down to O(n)
		//desc:  take current node out and make it a circular DLL of size 1. 
		//Using recursion, find circular linkedList in left and right subchild and join them .
		Tnode start = getDLLfromTreeUsingCircularLinkedList(root);   
		while(start!=null)
		{
			System.out.print("  "+start.data);
			start = start.r;
		}	
				
		
	}
	
	public static Tnode getDLLfromTreeUsingCircularLinkedList(Tnode root)  
	{
		 root = getDLLfromTree2(root);
		 root.l.r = null;
		 root.l = null;
		 return root;
	}
	public static Tnode getDLLfromTree2(Tnode root)  
	{
			if(root==null)
				return null;
			
			Tnode curr= root;
			Tnode lChild = curr.l;
			Tnode rChild = curr.r;
			
			//curr.l=null;
			//curr.r=null;
			curr.l=curr;
			curr.r=curr;
			
			lChild = getDLLfromTree2(lChild);
			curr = joinDLL2(lChild,curr);
			//curr = joinDLL(lChild,curr);
			rChild = getDLLfromTree2(rChild);
			curr = joinDLL2(curr,rChild);
			//curr = joinDLL(curr,rChild);
			
			return curr;
			
	}
	
	private static Tnode joinDLL2(Tnode head1, Tnode head2) {   //using circular doubly linked list
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;

		Tnode head1Start = head1;
		Tnode head1Last = head1.l;
		Tnode head2Start = head2;
		Tnode head2Last = head2.l;
		
		head2Start.l = head1Last;
		head1Last.r = head2Start;
		head1Start.l = head2Last;
		head2Last.l = head1Start;
		
		return head1;
	}
	
	private static Tnode joinDLL(Tnode head1, Tnode head2) {
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;

		Tnode tmp = head1;
		while(tmp.r!=null)   //need to reduce this complexity because this making overall time complexity O(n^2)....a better idea may be using circular doubly linked list
			tmp=tmp.r;
		
		tmp.r=head2;
		return head1;
	}


	public static Tnode getDLLfromTree(Tnode root)
	{
		if(root ==null)
			return root;
		
		System.out.println("root.data="+root.data);
		//if(root.l!=null)
		{
		Tnode lChildStart = getDLLfromTree(root.l);
		Tnode tmpNode = lChildStart;
		if(lChildStart!=null)
		{	
		  while(tmpNode.r!=null)
			  tmpNode = tmpNode.r;
		
		 tmpNode.r = root;
		}
		 root.l = tmpNode;
		}
		
		//if(root.r!=null)
		{
		 Tnode rChildStart = getDLLfromTree(root.r);
		 
		 root.r = rChildStart;
		 if(rChildStart!=null)
		     rChildStart.l = root;
		 }
		
		return root;
	}

}
