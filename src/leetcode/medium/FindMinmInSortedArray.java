package leetcode.medium;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * 
 * @author chandan
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 *
 */
public class FindMinmInSortedArray {

  public static void main(String[] args) {
   //int[] nums={ 4, 5, 6, 0,1, 2, 3};
   //int[] nums={ 4, 5, 6, 7,1, 2, 3};
    int[] nums={ 4,5,6,7,8,1,2,3};
   System.out.println("res="+findMin(nums));
   int target=5;
   //System.out.println("res="+search(nums,target));
    
  }
  
  

  public static int findMin(int[] nums) 
  {
    if(nums==null ||nums.length==0)
      throw new RuntimeException("not valid arg");
    return findMinHelper(nums,0,nums.length-1);
  }
  
  private static int findMinHelper(int[] arr, int left, int right) 
  {
    System.out.println("arr["+left+"]="+arr[left]+"arr["+right+"]="+arr[right]);
    if(left==right)
      return arr[left];
    if(left+1==right)
      return Math.min(arr[left], arr[right]);
    if(arr[left]<arr[right])
    {
      return arr[left];
    }
    else//arr[left]>arr[right]
    {
      int mid= (left+right)/2;
      if(arr[left]<arr[mid])
        return findMinHelper(arr,mid+1,right) ;
      else
        return findMinHelper(arr,left,mid);
        
    }
      
  }
  
  

}
