package leetcode.medium;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.
Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 * @author chandan
 *
 */
public class ReverseLinkedList2 {

  public static void main(String[] args) {
   // 1->2->3->4->5
    ListNode t= new ListNode(1);
    t.next=new ListNode(2);
    t.next.next=new ListNode(3);
    t.next.next.next=new ListNode(4);
    t.next.next.next.next=new ListNode(5);
    System.out.println("before: \n ");
    printListNodes(t);
    ReverseLinkedList2 obj = new ReverseLinkedList2();
    ListNode t2= obj.reverseBetween(t,2,4);
    System.out.println("\n after: \n ");
    printListNodes(t2);

  }
  
  //TODO
//using iteration
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode t=head;
    int pos=1;
    ListNode prev=null;
    while(pos<m)
    {
      prev=t;
      t=t.next;
      pos++;
    }
    ListNode t1=t;
    ListNode prev1=null;
    while(pos<n)
    {
      ListNode tmp=t;
      t=t.next;
      tmp.next=prev1;
      prev1=tmp;
      pos++;
    }
    t.next=prev1;
    t1.next=t;
    return head;
    
  }
  
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
