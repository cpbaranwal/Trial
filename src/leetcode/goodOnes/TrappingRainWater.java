package leetcode.goodOnes;

import java.util.Stack;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 * 
 * @author chandan Given n non-negative integers representing an elevation map
 *         where the width of each bar is 1, compute how much water it is able
 *         to trap after raining. For example, Given [0,1,0,2,1,0,1,3,2,1,2,1],
 *         return 6.
 *
 */
public class TrappingRainWater {

  public static void main(String[] args) {

    TrappingRainWater obj = new TrappingRainWater();
    int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println("result count = "+obj.trap(arr));
  }
  
  /*approach:
   * find the highest bars on left and right sides. Take the smaller of two heights. 
   * The difference between smaller height and height of current element is the amount of water 
   * that can be stored in this array element .
   * pre-compute highest bar on left and right of every bar in O(n) time. 
   * Then use these pre-computed values to find the amount of water in every array element.
   */
  public int trap(int[] arr) {
      if(arr==null || arr.length<3)
        return 0;
      int maxCount=0;
      int[] lmaxArr= new int[arr.length];
      int[] rmaxArr= new int[arr.length];
      
      //initialisation
      lmaxArr[0]=arr[0];
      for(int i=1;i<arr.length;i++)
        lmaxArr[i]= Math.max(lmaxArr[i-1], arr[i]);
      
      rmaxArr[arr.length-1]=arr[arr.length-1];
      for(int i=arr.length-2;i>=0;i--)
        rmaxArr[i]=Math.max(rmaxArr[i+1], arr[i]);
      
      for(int i=0; i<arr.length; i++)
      {
        if(arr[i]<lmaxArr[i] && arr[i]<rmaxArr[i])
          maxCount += (Math.min(lmaxArr[i], rmaxArr[i]) - arr[i]);
      }
  
    return maxCount;
  }

  /*
  //TODO
  public int trap(int[] arr) {
    int count = 0;
    if (arr == null)
      return 0;
    int l = 0;
    int r = arr.length - 1;
    while (l < arr.length && arr[l] == 0)
      l++;
    while (r >= 0 && arr[r] == 0)
      r--;
    if (r - l < 2)
      return 0;
    
    int i =l; //boolean upMove = false; 
    boolean downMove = false;
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    while(i <= r)
    {
      
      int elem = arr[i];
      System.out.println("000000   elem="+elem+"  stack1="+stack1+"   stack2="+stack2+"  count="+count);
      if(stack1.isEmpty() || stack1.peek() >= elem )
      {
        downMove=true;
        stack1.push(elem);
      }
      else if(downMove)
      {
        //upMove=true;
        int intermediate=stack1.peek();
        while(stack1.size()>1 && stack1.peek() < elem)
        {
          if(stack1.peek()>intermediate)
            intermediate=stack1.peek();
          stack2.push(stack1.pop());
        }
        int min = Math.min(Math.max(intermediate,stack1.peek()), elem);
        System.out.println("11111   elem="+elem+"  stack1="+stack1+"   stack2="+stack2+"  min="+min+"  count="+count);
        while(!stack2.isEmpty())
        {
          count = count + (min - stack2.pop());
          stack1.push(min);
        }
        stack1.push(elem);
        System.out.println("2222   elem="+elem+"  stack1="+stack1+"   stack2="+stack2+"  min="+min+"  count="+count);
      }
      i++;
    }
    
    return count;
  }
  */

}
