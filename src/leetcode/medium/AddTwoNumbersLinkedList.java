package leetcode.medium;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 * @author chandan
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 *
 */
public class AddTwoNumbersLinkedList {

  public static void main(String[] args) {
    ListNode l1= new ListNode(2);
    l1.next= new ListNode(4);
    l1.next.next= new ListNode(3);
    ListNode l2= new ListNode(5);
    l2.next= new ListNode(6);
    l2.next.next= new ListNode(4);
    AddTwoNumbersLinkedList obj = new AddTwoNumbersLinkedList();
    ListNode l3= obj.addTwoNumbers(l1,l2);
    obj.printNodes(l3);

  }
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1==null)
      return l2;
    if(l2== null)
      return l1;
    ListNode l3=null;
    int carry=0;
    
    while(l1!=null || l2!=null || carry>0)
    {
      int tmpSum=carry;
      if(l1!=null)
      {
        tmpSum +=l1.val;
        l1= l1.next;
      }
      if(l2!=null)
      {
        tmpSum +=l2.val;
        l2= l2.next;
      }
      carry= tmpSum/10;
      l3= addNode(l3, tmpSum%10);     
    }
    return l3;  
  }
  
  public ListNode addNode(ListNode l, int num)
  {
    ListNode node= new ListNode(num);
    ListNode tmp=l;
    if(tmp==null)
      return node;
    while(tmp.next!=null)
    {
      tmp=tmp.next;
    }
    tmp.next=node;
    return l;
  }
  
  public void printNodes(ListNode l)
  {
    System.out.println("printing nodes.....");
    while(l!=null)
    {
      System.out.print("   "+l.val);
      l=l.next;
    }
    System.out.println();
  }
  
  public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

}
