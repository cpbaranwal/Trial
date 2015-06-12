package temp;
import java.util.*;


public class MarkAncestorsInBinaryTree {

	/**
	There is a binary tree of size N.
	 All nodes are numbered between 1-N(inclusive).
	  There is a N*N integer matrix Arr[N][N], all elements are initialized to zero.
	   So for all the nodes A and B, put Arr[A][B] = 1 if A is an ancestor of B 
	   (NOT just the immediate ancestor).
*/

	public static final int NUM=8;
	public static void main(String[] args) {
		  int[][] arr= new int[NUM][NUM];
		  
		  System.out.println("INPUT:");
		  for(int i=0;i<NUM;i++)
		  {
			  for(int j=0;j<NUM;j++)
				  System.out.print("  "+arr[i][j]);
			  System.out.println();
		  }
		  
		  Node rt=new Node(1);
		  rt.l=new Node(2);
		  rt.r=new Node(3);
		  rt.l.l=new Node(4);
		  rt.l.r=new Node(5);
		  rt.r.l=new Node(6);
		  rt.r.r=new Node(7);
		  
		  markAncestors(rt, arr);//with extra space
		  
		  System.out.println("OUTPUT:");
		  for(int i=0;i<NUM;i++)
		  {
			  for(int j=0;j<NUM;j++)
				  System.out.print("  "+arr[i][j]);
			  System.out.println();
		  }
		  
		  
		  arr= new int[NUM][NUM];
		  markAncestorsHelperWithoutExtraSpace(rt, arr);//better solution:  extra space not needed but time complexity increased
		  System.out.println("OUTPUT    markAncestorsHelperWithoutExtraSpace:");
		  for(int i=0;i<NUM;i++)
		  {
			  for(int j=0;j<NUM;j++)
				  System.out.print("  "+arr[i][j]);
			  System.out.println();
		  }
		  
		  
		
	}
	
	public static void markAncestors(Node root, int[][]arr)
	{
		if(root==null)
			throw new IllegalArgumentException();
		
		List<Integer> listAncestors = new ArrayList<Integer>();
		markAncestorsHelper(root, arr, listAncestors);
		
		
	}
	
	public static void markAncestorsHelper(Node curr, int[][] arr, List<Integer> listAncestors)
	{
		if(curr==null)
			return;
		
		
		for(int tmpData: listAncestors)
		{
			arr[tmpData][curr.data] = 1;
		}
		listAncestors.add(curr.data);
		markAncestorsHelper(curr.l, arr, new ArrayList<Integer> (listAncestors));
		markAncestorsHelper(curr.r, arr, new ArrayList<Integer> (listAncestors));
	}
	
	
	public static void markAncestorsHelperWithoutExtraSpace(Node curr, int[][] arr)//time complexity will increase
	{//Arr[A][B] = 1 if A is an ancestor of B 
		if(curr==null)
			return;
		
		
		markAncestorsHelperWithoutExtraSpace(curr.l, arr);
		markAncestorsHelperWithoutExtraSpace(curr.r, arr);
		if(curr.l!=null)
		{
			int par=curr.data; int lChild = curr.l.data;
			arr[par][lChild]=1;
			for(int i=0;i<NUM;i++)
				if(arr[lChild][i]==1)
				arr[par][i]=1;
		}
		if(curr.r!=null)
		{
			int par=curr.data; int rChild = curr.r.data;
			arr[par][rChild]=1;
			for(int i=0;i<NUM;i++)
				if(arr[rChild][i]==1)
				arr[par][i]=1;
		}
	}
	
	private static class Node
	{
		Node l,r;
		int data;
		public Node(int data)
		{
			this.data=data; l=null; r=null;
		}
	}

}
