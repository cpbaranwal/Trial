package pack5;

import java.util.*;

public class MaxmElementSlidingWindow {

    /**
         program to find maximum element in a window  of an array
         max[i] denotes maximum number in max[i] to max[i+windowSize-1]
         e.g.  windowSize = 3
           3  2   12  4  8  5   9   1  25  10
    Result:
            12  12  12  8  9  9  25  25  25  25

     */
    public static void main(String[] args)
    {
      int[] arr = {3,2,12,4,8,5,9,1,25,10};
      for(int element: arr)
          System.out.print("  "+element);
      System.out.println();
      int windowSize = 3;
      int[] max = new int[arr.length];
     
      fillMaxArray(arr,max,windowSize);
     
      System.out.println("Result:");
      for(int element: max)
          System.out.print("  "+element);

    }

    private static void fillMaxArray(int[] arr, int[] max, int windowSize) //store indexes of array in max[]
    {
        LinkedList<Integer> dQueue = new LinkedList<Integer>();
        dQueue.add(0);
        for(int i=1; i<windowSize; i++)
        {
            while(!dQueue.isEmpty()   &&   arr[i] > arr[dQueue.getLast()] )
            {
                dQueue.removeLast();
            }
            dQueue.add(i);
        }   
        max[0] = arr[dQueue.getFirst()];
       
        int indxOfMaxArray =0;
        for(int i=windowSize; i<arr.length; i++)
        {
             indxOfMaxArray = i-windowSize+1;
             //System.out.println("indxOfMaxArray="+indxOfMaxArray);
            while(!dQueue.isEmpty()   &&   arr[i] > arr[dQueue.getLast()] )
            {
                dQueue.removeLast();
            }
            while(!dQueue.isEmpty()   &&  dQueue.getFirst()<indxOfMaxArray)
            {
                dQueue.removeFirst();
            }
            dQueue.add(i);
            max[indxOfMaxArray] = arr[dQueue.getFirst()];
            //System.out.println("max[indxOfMaxArray]="+max[indxOfMaxArray]);
           
        }
        while(indxOfMaxArray< arr.length)
        {
            max[indxOfMaxArray] = arr[dQueue.getFirst()];
            indxOfMaxArray++;
        }
       
    }

}