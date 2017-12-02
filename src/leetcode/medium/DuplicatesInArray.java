package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 * @author chandan
 *Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */
public class DuplicatesInArray {

  public static void main(String[] args) 
  {
    //int[] arr= {4,3,2,7,8,2,3,1};
    int[] arr= {2,2};
    System.out.println("result= "+findDuplicates(arr));
  }
  
  //approach: when you find 1st time, negate it...when you find 2nd time,make +ve and add n to it...
  //result: numbers greater than n
  public static List<Integer> findDuplicates(int[] arr) 
  {
    System.out.println("1111  arr= "+Arrays.toString(arr));
    List<Integer> list= new ArrayList<Integer>();
    if(arr==null || arr.length<2)
      return list;
    int n= arr.length;
    for(int num: arr)
    {
      int tmp=num;
      while(tmp>n)
        tmp= tmp-n;
      arr[tmp-1]= arr[tmp-1]+n;  
    }
    System.out.println("2222  arr= "+Arrays.toString(arr));
    //iterate again
    for(int i=0; i<n; i++)
    {
      if(arr[i]>2*n)
        list.add(i+1);
    }
    System.out.println("list= "+list);
    return list;
  }

}
