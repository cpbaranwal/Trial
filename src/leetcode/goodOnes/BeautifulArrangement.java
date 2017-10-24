package leetcode.goodOnes;

/**
 * https://leetcode.com/problems/beautiful-arrangement/description/
 * @author chandan
 *Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?

Example 1:
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
Note:
N is a positive integer and will not exceed 15.

 */
public class BeautifulArrangement {

  public static void main(String[] args) {
    BeautifulArrangement obj= new BeautifulArrangement();
    int N=3;
    System.out.println("result= "+obj.countArrangement(N));

  }
  
  //1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
  //approach, for each number starting from 1 to N, check where it can fit in array one by one 
  //and subsequently if array can be filled properly
  private  int count=0;
  public int countArrangement(int N) {
    if(N<1)
      return 0;
    int visited[]= new int[N+1];
    int pos=1;
    countArrangementHelper(visited,pos,N);
    
    return count;
  }

  private void countArrangementHelper(int[] visited, int pos, int N) 
  {
    if(pos >N)
    {
      count++;
      return;
    }
    for(int i=1;i<=N;i++)
    {
      if(visited[i]==0 & (pos%i==0 || i%pos==0) )
      {
        visited[i]=1;
        countArrangementHelper(visited,pos+1,N);
        visited[i]=0;
      }
    }
    
  }

}
