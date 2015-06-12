package pack6;
import pack6.TreeUtil.Tnode;

public class CheckIfBinaryTreeIsBST {

	/**
	     program to check if a given binary tree is a Binary Search Tree
	    			 6
                    / \
                   2    8
                  /\     /\
                 1 5/7  7  9 
          
                for 5 ,it should return true;
                for 7, it should return false;
               
	 */
	public static void main(String[] args) 
	{
		Tnode root= new Tnode(6);
		root.l=new Tnode(2);
		root.r=new Tnode(8);
		root.l.l=new Tnode(1);
		root.l.r=new Tnode(5);
		//root.l.r=new Tnode(7);
		root.r.l=new Tnode(7);
		root.r.r=new Tnode(9);
		
		System.out.println("isBST== "+isBST(root));  //approach - compare each node data with min and max till now
		System.out.println("isBST== "+isBSTusingInorderTraversal(root));  //approach2- follow inorder traversal which shud return sorted list,  look for any number coming is less than previous.

	}
	
	static int prev=Integer.MIN_VALUE;//keeps the account of previously visited node value
	public static boolean isBSTusingInorderTraversal(Tnode root)
	{
		if(root==null || (root.r==null && root.l==null))
			return true;
		
		//int prev = Integer.MAX_VALUE;
		return isBSTusingInorderTraversalHelper(root);
	}

	
	private static boolean isBSTusingInorderTraversalHelper(Tnode head) 
	{
		if(head==null)
			return true;
		
		boolean boolLeft = isBSTusingInorderTraversalHelper(head.l);
		if(!boolLeft)
			return false;
		
		System.out.print("   "+head.data);
		if(head.data < prev)//nice approach
		{
			System.err.println("\n Error point2:   head.data="+head.data+"  prev="+prev);
			return false;
		}	
		prev = head.data;
		
		boolean boolRight = isBSTusingInorderTraversalHelper(head.r);
		if(!boolRight)
			return false;
		
		return true;
	}


	public static boolean isBST(Tnode root)
	{
		if(root==null || (root.r==null && root.l==null))
			return true;
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		return isBSTHelper(root,min,max);
	}

	private static boolean isBSTHelper(Tnode head, int min, int max)
	{
		if(head==null)
			return true;
		
		
		if(head.data<min || head.data>max)
		{  
			System.err.println("\n  Error point:   head.data="+head.data+"  min="+min+"   max="+max);
			return false;
		}	
		
		boolean leftBool = isBSTHelper(head.l,min,head.data);
		boolean rightBool = isBSTHelper(head.r,head.data,max);
		return (leftBool && rightBool);
	}

}
