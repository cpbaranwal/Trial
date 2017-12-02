package leetcode.medium;

public class FindElementInSortedArray {

  public static void main(String[] args) {
    //int[] nums={ 4, 5, 6, 0,1, 2, 3};
    //int[] nums={ 4, 5, 6, 7,1, 2, 3};
     int[] nums={ 4,5,6,7,8,1,2,3};
    //System.out.println("res="+findMin(nums));
    int target=5;
    System.out.println("res="+search(nums,target));
     
   }
   
   /**
    * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
    */
   public static int search(int[] nums, int target) 
   {
     if(nums==null ||nums.length==0)
       return -1;
     if(nums[0]==target) 
       return 0;
     if(nums[nums.length-1]==target)
       return nums.length-1;
     return searchHelper(target,nums,0,nums.length-1);
   }
   
   private static int searchHelper(int target, int[] arr, int left, int right) 
   {
     System.out.println("left="+left+"   right="+right);
     if(left>=right)
       return -1;
     if(target==arr[left])
       return left;
     if(target==arr[right])
       return right;
     int mid=(left+right)/2;
     System.out.println("mid="+mid);
     if(target==arr[mid])
       return mid;
     //return searchHelper(target,arr,left,mid);
     if(arr[left]<arr[mid])
     {
       if(target>arr[left] && target<arr[mid])
         return searchHelper(target,arr,left,mid-1);
       else
         return searchHelper(target,arr,mid+1,right);
     }
     else//arr[left]>arr[mid]
     {
       if(target>arr[mid] && target<arr[right])
         return searchHelper(target,arr,mid+1,right);
       else
         return searchHelper(target,arr,left,mid-1);
     }

   }

}
