package leetcode.medium.bitManipulation;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/counting-bits/description/
 * @author chandan
 *Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 */
public class CountingBits {

  public static void main(String[] args) {
    int num=5;
    System.out.println(Arrays.toString(countBits(num)));

  }
  
  public static int[] countBits(int num) 
  {
    int[] arr= new int[num+1];
    arr[0]=0;
    if(num>0)
      arr[1]=1;
    if(num>1)
      arr[2]=1;
    
    for(int i=3; i<=num; i++)
    {
      if(i%2 == 0)//even
      {
        arr[i]= arr[i/2];
      }
      else //odd
      {
        arr[i]= arr[i-1]+1;
      }
    }
    
    return arr;
  }

}
