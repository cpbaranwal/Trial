package leetcode.medium;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * @author chandan
 * Given a linked list, remove the nth node from the end of list and return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 *
 */
public class RemoveNthNodeLinkedList {

  public static void main(String[] args) {
    ListNode st= new ListNode(1);
    st.next=new ListNode(2); 
    st.next.next=new ListNode(3); 
    st.next.next.next=new ListNode(4); 
    st.next.next.next.next=new ListNode(5); 
    RemoveNthNodeLinkedList obj= new RemoveNthNodeLinkedList();
    System.out.println("before....");
    ListNode t=st;
    while(t!=null)
      {System.out.print("   "+t.val);t=t.next;}
    st= obj.removeNthFromEnd(st, 5);
    System.out.println("\nafter....");
    t=st;
    while(t!=null)
      {System.out.print("   "+t.val);t=t.next;}
  }
  
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode t1=head;ListNode t2=head;
    int i=n;
    while(i>1)
    {
      i--;
      t2=t2.next;
    }
    ListNode prev=null;
    while(t2.next!=null)
    {
      t2=t2.next;
      prev= t1;
      t1= t1.next;
    }
    if(prev==null)
      return head.next;
    prev.next= t1.next;
    return head;
  }
  
   public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
   

}
