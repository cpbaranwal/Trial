package pack6;

import java.util.ArrayList;
import java.util.List;

import pack6.TreeUtil.Tnode;

public class LevelOrderTreeTraversal {

	
	     /**
	    Given a binary tree,print its nodes of one level per line.
	    	   
	    			  6
                    /   \
                   2     8
                  /\     /\
                 1  4   7  9
                    /\
                   3  5   
          output:  
                    6
   					2   8
   					1   4   7   9
  	 				3   5
	 
	 */
	public static void main(String[] args) 
	{
		Tnode root= new Tnode(6);
		root.l=new Tnode(2);
		root.r=new Tnode(8);
		root.l.l=new Tnode(1);
		root.l.r=new Tnode(4);
		root.r.l=new Tnode(7);
		root.r.r=new Tnode(9);
		root.l.r.l=new Tnode(3);
		root.l.r.r=new Tnode(5);
		
		printLevelOrderPerLine(root);
		

	}

		private static void printLevelOrderPerLine(Tnode root) 
		//uses a single list and maintain current line end using NULL element
		{
			if(root==null)
				System.out.println("No Data!!!");
			else
			{
				List<Tnode>  list = new ArrayList<Tnode>();
				list.add(root);
				list.add(null);
				printLevelOrderPerLineHelper(list);
			}
			
		}

		private static void printLevelOrderPerLineHelper(List<Tnode>  list) 
		{
			while(!list.isEmpty())
			{
				Tnode element = list.remove(0);
				if(element!=null)
				{
					System.out.print("   "+element.data);
					if(element.l!=null)
						list.add(element.l);
					if(element.r!=null)   
						list.add(element.r);
				}
				else if(element==null)
				{
					System.out.println();
					if(!list.isEmpty())    //add null only if list still contains some elements
						list.add(null);
				}
				
					
			}
			
		}

}
