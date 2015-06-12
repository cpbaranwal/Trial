package pack3;

public class ConstructSpclBinaryTree {

	/**
	Given Inorder Traversal of a Special Binary Tree 
	in which key of every node is greater than keys in left and right children, 
	construct the Binary Tree and return root.

Examples:
Input: inorder[] = {5, 10, 40, 30, 28}
Output: root of following tree
         40
       /   \
      10     30
     /         \
    5          28 
    
    Algorithm: buildTree()
1) Find index of the maximum element in array. The maximum element must be root of Binary Tree.
2) Create a new tree node ‘root’ with the data as the maximum value found in step 1.
3) Call buildTree for elements before the maximum element and make the built tree as left subtree of ‘root’.
5) Call buildTree for elements after the maximum element and make the built tree as right subtree of ‘root’.
6) return ‘root’.

	 */
	public static void main(String[] args) {
		
		int[] inorder = {5, 10, 40, 30, 28};
		buildTree(inorder,0,inorder.length-1);

	}
	
	
	public static Tree buildTree(int[] arr,int p,int q)
	{
		if(arr==null || p>q || p<0 || q>arr.length-1)
			return null;
		
		if(p==q)
			{
			System.out.println("leaf=="+arr[p]);
			return new Tree(arr[p]);
			
			}
		
		int maxVal=Integer.MIN_VALUE;  int maxIndx=-1;
		for(int i=p;i<=q;i++)
		{
			if(maxVal<arr[i])
			{
				maxVal=arr[i];
				maxIndx=i;
			}
		}
		
		System.out.println("maxVal=="+maxVal);
		Tree node=new Tree(maxVal);
		node.left=buildTree(arr,p,maxIndx-1);
		node.right=buildTree(arr,maxIndx+1,q);
		
		return node;
		
		
	}
	
	
	private static class Tree
	{
		int data; Tree left,right;
		 public Tree(int x)
		 {
			 left=null; right=null; data=x;
		 }
	}

}
