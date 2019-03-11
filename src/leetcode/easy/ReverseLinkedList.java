package leetcode.easy;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 * @author chandan
 *
 */
public class ReverseLinkedList {

  public static void main(String[] args) {
   // 1->2->3->4
    ListNode t= new ListNode(1);
    t.next=new ListNode(2);
    t.next.next=new ListNode(3);
    t.next.next.next=new ListNode(4);
    System.out.println("before: \n ");
    printListNodes(t);
    ReverseLinkedList obj = new ReverseLinkedList();
    //ListNode t2= obj.reverseList(t);
    ListNode t2= obj.reverseListRecursion(t);
    System.out.println("\n after: \n ");
    printListNodes(t2);

  }
  
  
//using iteration
  public ListNode reverseList(ListNode head) {
	  if(head==null || head.next==null)
		  return head;
	  ListNode tmp = head;
	  
	  ListNode prev=null;
	  while(tmp!=null)
	  {
		  ListNode tmpNext=tmp.next;
		  tmp.next=prev;
		  prev=tmp;
		  tmp=tmpNext;
	  }
	  return prev;
	  
  }
  
  //using recursion
  public ListNode reverseListRecursion(ListNode head) {
	  
	  return reverseListRecursionHelper(head,null);
	  
  }
  private ListNode reverseListRecursionHelper(ListNode node, ListNode prev) {
	  ListNode tmp = node.next;
	  node.next = prev;
	  if(tmp==null)
		  return node;
	  return reverseListRecursionHelper(tmp,node);
  }
  
  
  
  
  /*
  //using recursion
  public ListNode reverseList(ListNode head) {
    if(head==null || head.next==null)
      return head;
    ListNode curr=head;
    ListNode st= reverseList(head.next);
    ListNode tmp=st;
    while(tmp.next!=null)
      tmp=tmp.next;
    tmp.next=curr;
    curr.next=null;
    return st;

  }
  

  //using iteration
  public ListNode reverseList2(ListNode head) {
    if(head==null || head.next==null)
      return head;
    ListNode t=head;
    ListNode tnext=head.next;
    ListNode tprev=null;
    while(t.next!=null)
    {
      tnext=t.next;
      //ListNode temp=t;
      t.next=tprev;
      tprev=t;
      t=tnext;
    }
    t.next=tprev;
    return t;

  }
  */
  
  public static void printListNodes(ListNode t)
  {
    while(t!=null)
    {
      System.out.print("  "+t.val);
      t=t.next;
    }
   
  }
  
  public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
