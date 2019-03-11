package pack4;
import java.util.*;

/**
	There is a binary tree of size N.
	 All nodes are numbered between 1-N(inclusive).
	  There is a N*N integer matrix Arr[N][N], all elements are initialized to zero.
	   So for all the nodes A and B, put Arr[A][B] = 1 if A is an ancestor of B 
	   (NOT just the immediate ancestor).
*/



public class MarkAncestorsInBinaryTree {

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
		  
		  findAncestors2(rt, arr);
		  
		  System.out.println("OUTPUT:");
		  for(int i=0;i<NUM;i++)
		  {
			  for(int j=0;j<NUM;j++)
				  System.out.print("  "+arr[i][j]);
			  System.out.println();
		  }
		  
		  
		
	}

	// smarter and shorter
	public static void findAncestors2(Node root, int[][] arr){
		if(root==null )
			return;
		findAncestors2Helper(root,arr);
	}
	private static List<Integer> findAncestors2Helper(Node node, int[][] arr) {
		if(node == null)
			return new ArrayList<Integer>();

		List<Integer> list1 = findAncestors2Helper(node.l, arr);
		List<Integer> list2 = findAncestors2Helper(node.r, arr);
		list1.addAll(list2);
		for(Integer num: list1)
			arr[node.data][num]=1;
		list1.add(node.data);
		return list1;
	}


	public static void findAncestors(Node rt,int[][] arr)
	{
		if(rt==null )
			return;
		List<Integer> list=new ArrayList<Integer>();
		list.add(rt.data);
		
		helperMethod(rt.l,arr,list);
		helperMethod(rt.r,arr,list);
		
	}
	
	public static void helperMethod(Node node,int[][] arr,List<Integer> list)
	{
		if(node==null)
			return;
		
		int child=node.data;
		for(Integer ances:list)
		{
			arr[ances][child]=1;
		}
		
		List<Integer> lst1=new ArrayList<Integer>(list);
		lst1.add(child);
		List<Integer> lst2=new ArrayList<Integer>(list);
		lst2.add(child);
		
		helperMethod(node.l,arr,lst1);
		helperMethod(node.r,arr,lst2);
		
	}
	
	
	
	private static class Node
	{
		Node l,r;
		int data;
		
		public Node(int x)
		{
			data=x;
		}
	}

}
