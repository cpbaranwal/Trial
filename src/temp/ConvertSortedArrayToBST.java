package temp;

import java.util.Arrays;
import java.util.LinkedList;

import pack6.TreeUtil;
import pack6.TreeUtil.Tnode;

public class ConvertSortedArrayToBST {

	/**
	    program to make a BST from a sorted array and return root.
	    
	 */
	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
		System.out.println("program to make a BST from a sorted array and return root: ");
		Tnode root= getBSTfromSortedArray(arr); // for sorted array
		System.out.println("root.data ="+root.data);
		TreeUtil.inorderTraversal(root);
		System.out.println();
		
		System.out.println("program to make a BST from a sorted array and return root: ");
		root= getBSTfromSortedArrayBottomUp(arr);  // for sorted linked list
		System.out.println("root.data ="+root.data);
		TreeUtil.inorderTraversal(root);
		

	}
	
	public static Tnode getBSTfromSortedArray(int[] arr)  //Space-O(N)  Time-O(N)  TopDown approach easy and better for array
	{
		if(arr==null)
			return null;
		return getBSTfromSortedArrayHelper(arr,0,arr.length-1);
	}

	private static Tnode getBSTfromSortedArrayHelper(int[] arr, int low, int high) 
	{//top down approach
		if(low>high)
			return null;
		//if(low == high)
			//return new Tnode(arr[low]);
		
		int mid = (low+high)/2;
		Tnode currentNode = new Tnode(arr[mid]);
		currentNode.l = getBSTfromSortedArrayHelper(arr,low,mid-1);
		currentNode.r = getBSTfromSortedArrayHelper(arr,mid+1,high);
		
		return currentNode;
	}
	
	//Space-O(N)  Time-O(2N)  BottomUp approach easy and better for LinkedList where we dnt want to find every time by traversing
	public static Tnode getBSTfromSortedArrayBottomUp(int[] arr)  
	{
		if(arr==null)
			return null;
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for(int x: arr)
			linkedList.add(x);
			
		return getBSTfromSortedArrayBottomUpHelper(linkedList,0,arr.length-1);
	}

	private static Tnode getBSTfromSortedArrayBottomUpHelper(LinkedList<Integer> linkedList,int low,int high) 
	{//similar to inorder traversal
		//bottom up approach
		if(low > high)
			return null;
		if(low==high)
		{
			return new Tnode(linkedList.removeFirst());
		}
		
		int mid = (low+high)/2;
		Tnode leftChild = getBSTfromSortedArrayBottomUpHelper(linkedList,low,mid-1);
		Tnode currentNode = new Tnode(linkedList.removeFirst());
		Tnode rightChild = getBSTfromSortedArrayBottomUpHelper(linkedList,mid+1,high);
		
		currentNode.l = leftChild;
		currentNode.r = rightChild;
		return currentNode;
	}
	
	
	
	
}
