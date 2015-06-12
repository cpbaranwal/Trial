package pack2;

public class MinCoinsForGivenSum {

	/**
	 You have a list of coins of some denominations(d1<d2...<dk). You have unlimited supply of these coins. Find out the how can u make a sum S using minimum number of coins.
DP solution was required as he was not satisfied with greedy approach.



	 */
	public static void main(String[] args) {

			int V[]={1,2,3,5};
			int sum=18;
			System.out.println("min no of Coins="+getMinNoCoins(V,sum));

	}
	
	public static int getMinNoCoins(int V[],int sum)  //V is array of coin denominations
	{
		int arr[]=new int[sum+1];
		for(int i=0;i<=sum;i++)
			arr[i]=Integer.MAX_VALUE;
		
		for(int i=0;i<=sum;i++)
		{
			for(int j=0;j<V.length;j++)
			{
				if(i==V[j])
					arr[i]=1;    //setting 1 for every denomination amount
			}
		}
		
		for(int i=2;i<=sum;i++)   //Dynamic Programming
		{ 
			for(int j=1;j<i;j++)
			{
				if(arr[j]+arr[i-j]<arr[i])
					arr[i]=arr[j]+arr[i-j];
			}
		}
		
		return arr[sum];
	}

}
