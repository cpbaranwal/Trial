package leetcode.medium;
/**
 * https://leetcode.com/problems/partition-list/description/
 * @author chandan
 *Given a linked list and a value x, partition it such that all nodes less than x come
 * before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PartitionLinkedList {

  public static void main(String[] args) {
    ListNode st= new ListNode(10);
    st.next=new ListNode(4); 
    st.next.next=new ListNode(3); 
    st.next.next.next=new ListNode(2); 
    st.next.next.next.next=new ListNode(5); 
    st.next.next.next.next.next=new ListNode(2);
    PartitionLinkedList obj= new PartitionLinkedList();
    System.out.println("before....");
    ListNode t=st;
    while(t!=null)
      {System.out.print("   "+t.val);t=t.next;}
    st= obj.partition(st, 3);
    System.out.println("\nafter....");
    t=st;
    while(t!=null)
      {System.out.print("   "+t.val);t=t.next;}
  }
  
  // 1->4->3->2->5->2
  public ListNode partition(ListNode head, int x) {
  try{
    ListNode t1= head;ListNode t1prev=null;
    while(t1!=null && t1.val<x)
      {
        t1prev=t1;
        t1= t1.next;
      }
   
   ListNode t2= t1;
   while(t1.next != null)
   {
     if(t1.next.val<x)
     {
       if(t1prev==null)
       {
         t1prev= t1.next;
         head= t1prev;
       }
       else
       {
         t1prev.next= t1.next;
         t1prev= t1prev.next;
       }      
       t1.next= t1.next.next;
     }
     else
       t1=t1.next;
   }
   if(t1prev!=null)
     t1prev.next= t2;
   return head;
  }
  catch(Exception ex)
  {
    System.out.println(" modification not possible exception ex="+ex);
    return head;
  }
    
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
}
