package leetcode.goodOnes;

public class PalindromeLinkedList {

  public static void main(String[] args) {
    // 1->2->3->3->2->1
    ListNode t = new ListNode(1);
    t.next = new ListNode(2);
    t.next.next  = new ListNode(3);
    t.next.next.next  = new ListNode(3);
    t.next.next.next.next  = new ListNode(2);
    t.next.next.next.next.next  = new ListNode(1);
    //printListNodes(t);
    PalindromeLinkedList obj = new PalindromeLinkedList();
    System.out.println("result= "+obj.isPalindrome(t));

  }
  
  //using recursion
  ListNode left;
  public boolean isPalindrome(ListNode head) 
  {
    if(head==null || head.next==null)
      return true;
    left=head;
    //right=head;
    return isPalindromeHelper(head);
    
  }
  private boolean isPalindromeHelper(ListNode right) 
  {
    if(right==null)
      return true;
    boolean bool= isPalindromeHelper(right.next);
    if(!bool)
      return false;
    if(left.val==right.val)
    {
      left=left.next;
      return true;
    }
    else
      return false;
  }


  //using iteration
  public boolean isPalindrome2(ListNode head) {
    if(head==null || head.next==null)
      return true;
    ListNode t1=head;ListNode slow=head;ListNode fast=head;
    //int cnt=1;
    ListNode slow_prev=null;
    while(fast!=null && fast.next!=null)
    {
      //System.out.println(" before slow.val="+slow.val+"    fast.val="+fast.val);
      fast=fast.next.next;
      slow_prev=slow;
      slow=slow.next;   
      //System.out.println(" after slow.val="+slow.val+"    fast.val="+fast.val+"   slow_prev.val="+slow_prev.val);
      //cnt++;
    }
    if(fast!=null)//odd
      slow=slow.next;
    slow_prev.next=null;  
    
    ListNode t2= reverse(slow);
    while(t1!=null && t2!=null && t1.val==t2.val)
    {
      //System.out.println("t1.val="+t1.val+"    t2.val="+t2.val);
      t1=t1.next;
      t2=t2.next;
    }
    if(t1==null && t2==null)
      return true;
    return false;
    
    
    
  }
  
  private ListNode reverse(ListNode head) {
    ListNode t1=head;
    ListNode prev=null;
    while(t1.next!=null)
    {
      ListNode tmp=t1;
      t1=t1.next;
      tmp.next=prev;
      prev=tmp;
    }
    t1.next=prev;
    return t1;
    
  }
  
  public static void printListNodes(ListNode t)
  {
    while(t!=null)
    {
      System.out.print("  "+t.val);
      t=t.next;
    }
   
  }

  static public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

}
