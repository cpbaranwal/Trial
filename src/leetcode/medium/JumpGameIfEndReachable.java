package leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game/description/
 * @author chandan
 *Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class JumpGameIfEndReachable {

  public static void main(String[] args)
  {
    //int[] arr={2,3,1,1,4};
    int[] arr={0};
    System.out.println("result= "+canJump(arr));
  }
  
  public static boolean canJump(int[] arr) 
  {
    if(arr==null || arr.length<=1)
      return true;
    int len= arr.length;
    //optimization: return true if no 0 presents
    boolean isZeroPresent=false;
    for(int i=0; i<len ; i++)
      if(arr[i]<1)
      {
        isZeroPresent= true;
        break;
      }
    if(!isZeroPresent)
      return true;
    
    boolean[] res= new boolean[len];//false
    for(int i=1; i<len; i++)
    {
      //System.out.println("res[]= "+Arrays.toString(res));
      for(int j=i-1; j>=0; j--)
      {
        if(j+arr[j] >= i)
        {
          res[i]=true;
          break;
        }
      }
      if(res[i]==false)
        return false;
    }
    return res[len-1];
  }

}
