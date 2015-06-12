package abceligopq;

public class PrintSpecificTreeLevel {

	/**
	Given a binary tree and a number,
	print the all the nodes in the level that contains the node with the given number, 
	except the number and it's sibling.
	 */
	public static void main(String[] args) {
		
		Tree rt=new Tree(1);
		rt.l=new Tree(2);
		rt.r=new Tree(3);
		rt.l.l=new Tree(4);
		rt.l.r=new Tree(5);
		rt.r.l=new Tree(6);
		rt.r.r=new Tree(7);
		rt.l.l.l=new Tree(8);
		
		int x=8;
		int level=findLevel(rt,x,0);
		System.out.println("Level is ==="+level);
		System.out.println("Results:  ");
		printDataOfSpecificLevel(rt,level,x);
		

	}
	
	public static void printDataOfSpecificLevel(Tree rt,int level,int x)
	{
		if(rt==null)
			return;
		if (level<=0)
			System.out.println("one of them:"+rt.data);
		else
		if(level==1)
		{
			if((rt.l!=null && rt.l.data==x) || (rt.r!=null && rt.r.data==x))
				return;
			
			
		}
		
		printDataOfSpecificLevel(rt.l,level-1,x);
		printDataOfSpecificLevel(rt.r,level-1,x);
		
		return;
	}
	
	
	
	public static int findLevel(Tree root,int x,int level)
	{
		if(root==null)
			return -1;
		if(root.data==x)
			return level;
		
		int left=findLevel(root.l,x,level+1);
		int right=findLevel(root.r,x,level+1);
		
		return( left>right? left:right);
	}
	
	private static class Tree
	{
		Tree l,r;
		int data;
		
		public Tree(int x)
		{
			data=x;
		}
	}

}
