package pack7;

import java.util.ArrayList;

public class PrintCombinationsOfNumberAsSumOfCandidateNumbers {

    /**
         Given a target number, and a series of candidate numbers, print out all combinations,
          so that the sum of candidate numbers equals to the target.

    Here order is not important, so don’t print the duplicated combination.

    e.g. target is 7, candidate is 2,3,6,7
    output should be 7 and either of  3+2+2,  2+3+2, 2+2+3
     */
   
    static int[] candidate = {2,3,6,7};
    static int sum = 7;
    public static void main(String[] args)
    {
       
        printCombinations();
    }
   
    private static void printCombinations()
    {
        int tmpSum =0;
        int start=0;  int last=candidate.length-1;
        printCombinationsHelper(tmpSum,start,last,new ArrayList<Integer>());
    }

    static int  methodCalCount=0;
    private static void printCombinationsHelper(int tmpSum, int start, int last, ArrayList<Integer> list)
    {
    	System.out.println("methodCalCount="+(++methodCalCount));
       // if(tmpSum > sum)
         //   return;
       
        if(tmpSum==sum)
        {
            for(int x: list)
                System.out.print("   "+x);
            System.out.println();
        }
       
        int indx=start;
        while(indx <= last)
        {
        	if(tmpSum+candidate[indx] <= sum)
        	{
            ArrayList<Integer> list2 = new ArrayList<Integer>();
            list2.addAll(list);
            list2.add(candidate[indx]);
            printCombinationsHelper(tmpSum+candidate[indx], indx,last, list2);
        	}
            indx++;
        }
       
    }
   
   

}
