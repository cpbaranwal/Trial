package leetcode.medium;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 * @author chandan
 *Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:
prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
 */

//hint: will use DP, a profit array to keep track what maxm profit possible on each ith day
public class BestTimeToBuySellStockCooldown {
  public static void main(String[] args)
  {
    int[] arr= {1, 2, 3, 0, 2};
    BestTimeToBuySellStockCooldown obj = new BestTimeToBuySellStockCooldown();
    System.out.println("result= "+obj.maxProfit(arr));

  }


  //e.g. prices = [1, 2, 3, 0, 2]   profit=[0,1,2,-2,3]
  public  int maxProfit(int[] arr)
  {
    if(arr==null || arr.length<2)
      return 0;
    int len = arr.length;
    int[] profit= new int[len];//max profit possible on each ith day

    //boundary conditions
    if(len>=2)
    {
      profit[1]= (arr[1]>arr[0] ? (arr[1]-arr[0]):0);
    }
    if(len>=3)
    {
      profit[2]= (arr[2]-arr[0] > arr[2]-arr[1]) ? arr[2]-arr[0]: arr[2]-arr[1];
      profit[2] = profit[1]>profit[2] ? profit[1]: profit[2];
    }

    //normal conditions
    for(int i=3; i<len; i++)
    {

      for(int j=0; j<i; j++)
      {
        int tmp=0;
        //consider case: (difference between smaller index and current index) + (max sum in smallerindex-2)
        if(arr[i] > arr[j])
          tmp = arr[i] - arr[j];
        if(j>=2)
          tmp = tmp + profit[j-2];

        if(tmp < profit[j])
          tmp = profit[j];

        //consider if smaller index has greater profit
        if(profit[i] < tmp)
          profit[i] = tmp;

      }

    }

    for(int num: profit)
      System.out.print("  "+num);
    System.out.println("");

    return profit[len-1];
  }
}
