package leetcode.medium;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * @author chandan
 *There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5
 */
public class MedianOfSortedArrays {

  public static void main(String[] args) {
    int nums1[]= {1,2};
    int nums2[]= {3,4};
    MedianOfSortedArrays obj = new MedianOfSortedArrays();
    System.out.println("result= "+obj.findMedianSortedArrays(nums1, nums2));
    

  }
  
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1= nums1.length;
    int len2= nums2.length;
    boolean isEven=false;
    int medianIndx=-1;
    if((len1+len2)%2==0)
      {
      isEven= true;
      medianIndx= (len1+len2)/2 - 1;
      }
    else
      medianIndx= (len1+len2)/2;
    
    int i=0;int indx1=0; int indx2=0;
    while(i<medianIndx)
    {
      if(indx1<len1 && indx2<len2)
      {
        if(nums1[indx1]<nums2[indx2])
          indx1++;
        else
          indx2++;
      }
      else if(indx1<len1)
      {
        indx1++;
      }
      else if(indx2<len2)
      {
        indx2++;
      }
      i++;
    }//while ends
    int elem1=Integer.MAX_VALUE;int elem2=Integer.MAX_VALUE;
    int elem3=Integer.MAX_VALUE;int elem4=Integer.MAX_VALUE;
    if(indx1<len1)
    {
      elem1= nums1[indx1++];
    }
    if(indx1<len1)
    {
      elem2= nums1[indx1];
    }
    if(indx2<len2)
    {
      elem3= nums2[indx2++];
    }
    if(indx2<len2)
    {
      elem4= nums2[indx2];
    }
    System.out.println("  elem1= "+elem1+"  elem2= "+elem2+"  elem3= "+elem3+"  elem4= "+elem4);
    int median1= elem1<elem3? elem1:elem3;
    int median2=Integer.MAX_VALUE;
    if(median1==elem1)
      median2= elem2<elem3? elem2:elem3;
    else
      median2= elem1<elem4? elem1:elem4;
    System.out.println("  median1= "+median1+"  median2= "+median2);
    if(isEven)
      return (median1+median2)/2.0;
    else
      return median1;
  }

}
