package pack6;

import java.util.Arrays;
import java.util.LinkedList;

import pack6.TreeUtil.Tnode;

public class ConvertSortedArrayToBST {

	/**
	    program to make a BST from a sorted array and return root.
	    
	 */
	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
		System.out.println("program to make a BST from a sorted array and return root: ");
		Tnode root= getBSTfromSortedArray(arr); // for sorted array, doesnt modify the array
		System.out.println("root.data ="+root.data);
		TreeUtil.inorderTraversal(root);
		System.out.println();
		
		System.out.println("program to make a BST from a sorted array and return root: ");
		root= getBSTfromSortedArrayBottomUp(arr);  // for sorted linked list, involves linkedlist elements deletion  (Good Thinking)
		System.out.println("root.data ="+root.data);
		TreeUtil.inorderTraversal(root);
		

	}
	
	//doesnt modify the array
	public static Tnode getBSTfromSortedArray(int[] arr)  //Space-O(N)  Time-O(N)  TopDown approach easy and better for array
	{
		if(arr==null)
			return null;
		return getBSTfromSortedArrayHelper(arr,0,arr.length-1);
	}

	private static Tnode getBSTfromSortedArrayHelper(int[] arr, int low, int high) 
	{
		
		if(low>high)
			return null;
		//if(low==high)   // not needed
			//return new Tnode(arr[low]);
		
		int mid = (low+high)/2;
		Tnode currentNode = new Tnode(arr[mid]);
		currentNode.l = getBSTfromSortedArrayHelper(arr, low, mid-1);
		currentNode.r = getBSTfromSortedArrayHelper(arr, mid+1, high);
		
		return currentNode;
	}
	
	//Space-O(N)  Time-O(2N)  BottomUp approach easy and better for LinkedList 
	//where we dnt want to find the middle elements every time by traversing half of the minkedList
	//cons- involves modifying the linkedlist
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
	{// approach is similar to inorder traversal
		if(low>high)
			return null;
		
		int mid = (low+high)/2;
		Tnode lChild = getBSTfromSortedArrayBottomUpHelper(linkedList, low, mid-1);
		Tnode currentNode = new Tnode(linkedList.removeFirst());//removing the first element
		Tnode rChild = getBSTfromSortedArrayBottomUpHelper(linkedList, mid+1, high);
		currentNode.l = lChild;
		currentNode.r = rChild;
		return currentNode;
	}
	
	
	
	
}
