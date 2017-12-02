package leetcode.medium;

public class FindElementInSortedArrayWithDuplicates {

  public static void main(String[] args) {
    //int[] nums={ 4, 5, 6, 0,1, 2, 3};
    //int[] nums={ 4, 5, 6, 7,1, 2, 3};
     //int[] nums={ 4,5,6,7,8,1,2,3};
    //int[] nums={1,1,3,1};
    int[] nums={0,0,1,1,2,0};
    int target=2;
    System.out.println("res="+search(nums,target));
     
   }
   
   /**
    * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
    * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
    */
   public static boolean search(int[] nums, int target) 
   {
     if(nums==null ||nums.length==0)
       return false;
     if(nums[0]==target) 
       return true;
     if(nums[nums.length-1]==target)
       return true;
     return searchHelper(target,nums,0,nums.length-1)>-1?true:false;
   }
   
   private static int searchHelper(int target, int[] arr, int left, int right) 
   {
     System.out.println("left="+left+"   right="+right);
   //handling duplicates
     while(left<right && (arr[left]==arr[right] || arr[left]==arr[left+1]) )
     {
       left++;
     }
   //handling duplicates end
     
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
     
     
     
     System.out.println("22222   left="+left+"   right="+right);  
     
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
