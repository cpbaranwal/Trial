package pack2;
import java.util.*;

public class GetNodeListFromTree {

	/**
	 return list of nodes conatining all nodes of a given tree.
	 */
	static class Node
	{
		String label;
		List<Node> children;
		
		public Node(String x)
		{
			label=x;children=null;
		}
	}
	public static void main(String[] args) {
		
		Node root=new Node("1");
		root.children=new ArrayList<Node>();
		root.children.add(new Node("2"));
		root.children.add(new Node("3"));
		root.children.add(new Node("4"));
		
		root.children.get(0).children=new ArrayList<Node>();
		root.children.get(0).children.add(new Node("5"));
		
		root.children.get(2).children=new ArrayList<Node>();
		root.children.get(2).children.add(new Node("6"));
		root.children.get(2).children.add(new Node("7"));
		
		List<Node> lst=getNodeList(root);
		for(Node node:lst)
		{
			System.out.println("data:"+node.label);
		}

	}
	
	public static List<Node> getNodeList (Node root)
	{
		
		if(root==null)
			return null;
		List<Node> list=new ArrayList<Node>();
		traverseTree(root,list);
		return list;
	}
	
	private static void traverseTree(Node root,List<Node> list)   //depth first search
	{
		if(root==null)
			return;
		list.add(root);
		if(root.children!=null && !root.children.isEmpty()){
			for(Node child:root.children)
			{
				traverseTree(child,list);
			}
		}
		
		return;
	}

}
