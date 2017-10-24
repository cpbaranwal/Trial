package leetcode.medium;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 * Given a root node reference of a BST and a key, 
 * delete the node with the given key in the BST. 
 * Return the root node reference (possibly updated) of the BST.
Basically, the deletion can be divided into two stages:
Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).
Example:
root = [5,3,6,2,4,null,7]
key = 3
    5
   / \
  3   6
 / \   \
2   4   7
Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
    5
   / \
  4   6
 /     \
2       7
Another valid answer is [5,2,6,null,4,null,7].
    5
   / \
  2   6
   \   \
    4   7
 * @author chandan
 *
 */
public class DeleteNodeInBST {

  public static void main(String[] args) {
    DeleteNodeInBST obj= new DeleteNodeInBST();
    //[5,3,6,2,4,null,7]
    TreeNode root= new TreeNode(5);
    root.left=  new TreeNode(3);
    root.right=  new TreeNode(6);
    root.left.left=  new TreeNode(2);
    root.left.right=  new TreeNode(4);
    root.right.right=  new TreeNode(7);
    System.out.println("before: \n");
    printNLR(root);
    obj.deleteNode(root, 3);
    System.out.println("\n after: \n");
    printNLR(root);
  }
  
  public static void printNLR(TreeNode node)
  {
    if(node==null)
    {
      System.out.print("   null");
      return;
    }
    System.out.print("   "+node.val);
    printNLR(node.left);
    printNLR(node.right); 
  }
  
  
  private TreeNode result=null;
  public TreeNode deleteNode(TreeNode root, int key) 
  {
    if(root==null || (root.val==key && root.left==null &&root.right==null) )
      return null;
    /*
    if(root.val==key)
    {
      if(root.right!=null)
      {
        TreeNode tmp=root.right;
        while(tmp.left!=null)
          tmp=tmp.left;
        root.val=tmp.val;
        deleteNodeHelper( root.right,tmp.val,root);
      }
      else if(root.left!=null)
      {
        TreeNode tmp=root.left;
        while(tmp.right!=null)
          tmp=tmp.right;
        root.val=tmp.val;
        deleteNodeHelper( root.left,tmp.val,root);
      }
      else 
        return null;
    }
    else
    */
    result=root;
    deleteNodeHelper( root,key,null);
    return result;
  }
  private void deleteNodeHelper(TreeNode node, int key, TreeNode parent) 
  {
    if(node==null)
      return;
    if(node.val > key)
    {
      deleteNodeHelper( node.left,key,node);    
    }
    else if(node.val < key)
    {
      deleteNodeHelper( node.right,key,node);    
    }
    else //node.val = key
      //will always take right child if available else will take left child as replacement
    {
     boolean isleftChild=false;
     if(parent!=null && parent.left==node)
       isleftChild= true;
     if(node.left==null && node.right==null)
     {
       if(isleftChild)
         parent.left=null;
       else
         parent.right=null;
     }      
     else if(node.right==null)
     {
       if(parent==null)
       {
         result= node.left;
         return;
       }   
       else{
         if(isleftChild)
           parent.left=node.left;
         else
           parent.right=node.left;
       }
     }
     else if(node.left==null)
     {
       if(parent==null)
       {
         result= node.right;
         return;
       }   
       else{
         if(isleftChild)
           parent.left=node.right;
         else
           parent.right=node.right;
       }
     }
     else //node has both left and right childs
     {
       TreeNode tmp=node.right;
       TreeNode tmpParent=node;
       while(tmp.left!=null)
       {
         tmpParent=tmp;
         tmp=tmp.left;
       }   
       node.val= tmp.val;
       tmp.val= key;
       deleteNodeHelper( tmp,key,tmpParent);
         
       /*
       TreeNode tmp=node.right;
       while(tmp.left!=null)
       {
         tmp=tmp.left;
       }   
       node.val= tmp.val;
       */
       deleteNodeHelper( node.right,tmp.val,node);
     }
    }
   
  }
  
  private static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

}
