package leetcode.goodOnes;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 * 
 * @author chandan Given n non-negative integers a1, a2, ..., an, where each
 *         represents a point at coordinate (i, ai). n vertical lines are drawn
 *         such that the two endpoints of line i is at (i, ai) and (i, 0). Find
 *         two lines, which together with x-axis forms a container, such that
 *         the container contains the most water. Note: You may not slant the
 *         container and n is at least 2.
 */
public class ContainerWithMostWater {

  public static void main(String[] args) {
    // int[] height= {1,2,3,4,5,4,3};
     int[] height= {3,2,1,3};
    // int[] height= {10,14,10,4,10,2,6,1,6,12};
    //int[] height = { 2, 3, 4, 5, 18, 17, 6 };
    ContainerWithMostWater obj = new ContainerWithMostWater();
    int result = obj.maxArea(height);
    System.out.println("result= " + result);

  }
  //approach: keep 2 pointers from left and right ends. 
  //calculate area at each end to see if its maximum till now and update pointer of whichever element is smaller
  public int maxArea(int[] arr) {
    int maxArea = 0;
    if (arr == null || arr.length < 2)
      return 0;
    int left= 0;
    int right= arr.length-1;
   
    while(left<right)
    {
      maxArea= Math.max( Math.min(arr[left], arr[right])*(right-left) , maxArea);
      if(arr[left] < arr[right])
        left++;
      else
        right--;
    }
    return maxArea;
  }

  /*
  public int maxArea(int[] height) {
    int[] arr = height;
    int maxArea = 0;
    if (arr == null || arr.length < 2)
      return 0;
    LinkedList<Integer> indexStack = new LinkedList<Integer>();
    int i = 0;
    for (; i < arr.length; i++) {
      if (indexStack.isEmpty() || arr[indexStack.getFirst()] >= arr[i]) {
        indexStack.addFirst(i);
        System.out.println("0000      indexStack= " + indexStack + "  maxArea= " + maxArea);
      } else {
        int h = arr[i];
        ;
        // while(!indexStack.isEmpty() && arr[indexStack.getFirst()]>=arr[i] )
        while (!indexStack.isEmpty() && arr[indexStack.getFirst()] < arr[i]) {
          indexStack.removeFirst();
        }
        int p = indexStack.isEmpty() ? 0 : indexStack.getFirst();
        maxArea = Math.max(maxArea, h * (i - p - 1));
        System.out.println("1111  indexStack= " + indexStack + "  maxArea= " + maxArea);
      }
    }

    System.out.println("22222 indexStack= " + indexStack + "  maxArea= " + maxArea);
    if (!indexStack.isEmpty()) {
      int p = indexStack.removeFirst();
      int h = arr[p];
      int w = indexStack.isEmpty() ? 0 : p - indexStack.getFirst() - 1;
      maxArea = Math.max(maxArea, h * w);
    }
    return maxArea;
  }
  */

}
