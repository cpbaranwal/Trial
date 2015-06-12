package pack5;

public class MinRepeatitiveCoinsForGivenSum {

    /**
       given a fixed denomination values for coins, 
       find minimum number of coins needed for a given Sum.
       Knapsack problem....each coin can be considered repeatedly...
       DP problem.

     */
    public static void main(String[] args)
    {
      int[] denominations = {1,2,5};
      int SUM = 24;
     
      int res = getMinmNumberCoins(SUM,denominations);
      System.out.println("res== "+res);
    }
       
    /*
     Approach:  this problem can be thought as:
     min[i] denotes minimum number of coins needed to achieve i
     min[i] = iterate over dominations array (j) and for :
             k+denomination[j] == i ,  find minimum denomination[i]
     */
    private static int getMinmNumberCoins(int SUM, int[] denom)
    {
        //int res=0;
        int min[] = new int[SUM+1];
        for(int i=0; i<=SUM; i++)  //initialize min array with max values
            min[i] = Integer.MAX_VALUE;
        for(int i=0; i<denom.length; i++)  //initialize min array with each denomination
            min[denom[i]] = 1;
       
        for(int i=1; i<=SUM; i++)
        {
            for(int j=0; j<denom.length; j++)
            {
                int k = i-denom[j];//find k which is a number which has already been traversed for his minimum sum
                if( k>0 &&  (min[i]>min[k]+1)  )
                {
                    min[i]=min[k]+1;
                }
            }
        }
       
       
        return min[SUM];
    }

}