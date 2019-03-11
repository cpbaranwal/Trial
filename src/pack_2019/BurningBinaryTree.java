package pack_2019;

import pack6.TreeUtil;
import pack6.TreeUtil.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chandan on 09/03/19
 *
 * Given a binary tree and node of binary tree, suppose the given node is burnt.
 * Fire takes 1 second to reach from one node to its adjacent node.
 * Find the time taken that total tree will be burnt

        6
     /     \
    2       8
   /\      /\
  1  4    7  9
     /\
    3  5

 e.g. suppose node 2 is burnt in above case, it will take total 5 secs to burn tree.
2 seconds to reach from node to reach 3/5 and 3 seconds to reach 7/9

 */
public class BurningBinaryTree {

    public static void main(String[] args){
        System.out.println("in main");
        Tnode root= new Tnode(6);
        root.l=new TreeUtil.Tnode(2);
        root.r=new TreeUtil.Tnode(8);
        root.l.l=new TreeUtil.Tnode(1);
        root.l.r=new TreeUtil.Tnode(4);
        root.r.l=new TreeUtil.Tnode(7);
        root.r.r=new TreeUtil.Tnode(9);
        root.l.r.l=new TreeUtil.Tnode(3);
        root.l.r.r=new TreeUtil.Tnode(5);

        int maxSecs = getTimeToBurnTree(root, 2);
        System.out.println("main:  maxSecs= " + maxSecs);

    }

    static List<Tnode> parentList = null;
    static Tnode nodeToBurn = null;
    public static int getTimeToBurnTree(Tnode root, int nodeDataToBurn){
        if(root == null || (root.l==null && root.r==null))
            return 0;

        findNode(root, nodeDataToBurn);
        int lChildLongestpath = getDepth(nodeToBurn.l) ;
        System.out.println("lChildLongestpath = " + lChildLongestpath);
        int rChildLongestpath = getDepth(nodeToBurn.r);
        System.out.println("rChildLongestpath = " + rChildLongestpath);
        int parentLongestpath = getParentLongestPath(parentList, nodeToBurn);
        System.out.println("parentLongestpath = " + parentLongestpath);

        // take out the best two
        int maxTime = 0;
        if(lChildLongestpath > rChildLongestpath){
            maxTime += lChildLongestpath;
            maxTime += parentLongestpath > rChildLongestpath ? parentLongestpath : rChildLongestpath;
        }
        else{
            maxTime += rChildLongestpath;
            maxTime += parentLongestpath > lChildLongestpath ? parentLongestpath : lChildLongestpath;
        }
        return maxTime;
    }

    private static int getParentLongestPath(List<Tnode> parentList, Tnode nodeToBurn) {
        int maxCount = 0;
        int size = parentList.size();
        for(int i =0; i< size; i++){
            Tnode currNode = parentList.get(i);
            int tmpCount = size - i;
            if(i == size-1) // immediate parent of burningNode
            {
                if(currNode.l == nodeToBurn)
                    if(currNode.r != null)
                        tmpCount += getDepth(currNode.r);
                else if (currNode.r == nodeToBurn)
                    if(currNode.l != null)
                        tmpCount += getDepth(currNode.l);
            }
            else{
                Tnode nextnode = parentList.get(i+1);
                if(currNode.l == nextnode)
                    if(currNode.r != null)
                        tmpCount += getDepth(currNode.r);
                    else if (currNode.r == nextnode)
                        if(currNode.l != null)
                            tmpCount += getDepth(currNode.l);
            }
            // update if found greater one
            if(maxCount < tmpCount)
                maxCount = tmpCount;
        }
        System.out.println("getParentLongestPath: maxCount = " + maxCount);
        return maxCount;
    }

    private static void findNode(Tnode root, int nodeData){
         findNodeHelperWithParentList(root, nodeData, new ArrayList<Tnode>());
    }

    private static void findNodeHelperWithParentList(Tnode node, int nodeData, ArrayList<Tnode> tnodes) {
        if(node == null)
            return ;
        if(node.data == nodeData){
            parentList = new ArrayList(tnodes);
            nodeToBurn = node;
            System.out.println("findNodeHelperWithParentList found match , parentList.size= " + parentList.size());
            return ;
        }
        tnodes.add(node);
        findNodeHelperWithParentList(node.l, nodeData, tnodes);
        if(nodeToBurn == null)
            findNodeHelperWithParentList(node.r, nodeData, tnodes);
        tnodes.remove(node);
    }

    private static int getDepth(Tnode node){
        if(node == null)
            return 0;
        int maxLeft = getDepth(node.l);
        int maxRight = getDepth(node.r);
        return (maxLeft>maxRight? maxLeft: maxRight) + 1;
    }




}
