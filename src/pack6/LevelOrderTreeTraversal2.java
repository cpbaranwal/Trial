package pack6;


import java.util.LinkedList;

public class LevelOrderTreeTraversal2 {

    /**
   
        level order traversal using approach3:
        approach1- use two queues for two levels
        approach2- use single queue, use a distinguisher character at end of each level
        approach3- use single queue, use 2 int variables keeping count of nodes in current and next level

                3
               /  \
             9    20   
           /     /  \
         10      15  7

     */
    public static void main(String[] args)
    {
        Tnode root = new Tnode(3);
        root.l = new Tnode(9);
        root.l.l = new Tnode(10);
        root.r = new Tnode(20);
        root.r.l = new Tnode(15);
        root.r.r = new Tnode(7);
       
        printLevelOrderTraversalUsingSingleQueueBFS(root);//approach3:  using 2 count variables

    }
   
   
    static LinkedList<Tnode> queue = new LinkedList<Tnode>();
    static int currentLevelNodeCount =0;
    static int nextLevelNodeCount =0;
    private static void printLevelOrderTraversalUsingSingleQueueBFS(Tnode root)
    {
        if(root==null)
            return;
        queue.add(root);
        currentLevelNodeCount=1;
       
        printLevelOrderTraversalUsingSingleQueueBFSHelper();
    }



    private static void printLevelOrderTraversalUsingSingleQueueBFSHelper() //uses breadth first search
    {
        while(!queue.isEmpty())
        {
            while(currentLevelNodeCount>0)
            {
                Tnode node = queue.remove();
                System.out.print("  "+node.data);
                currentLevelNodeCount--;
                if(node.l!=null)
                {
                    queue.add(node.l);
                    nextLevelNodeCount++;
                }
                if(node.r!=null)
                {
                    queue.add(node.r);
                    nextLevelNodeCount++;
                }
            }
            System.out.println("");
            currentLevelNodeCount=nextLevelNodeCount;
            nextLevelNodeCount=0;
        }
       
    }



    static class Tnode
    {
        Tnode l,r;
        int data;
       
        Tnode(int num)
        {
            data=num;
        }
    }

}
