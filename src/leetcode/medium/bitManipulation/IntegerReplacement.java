package leetcode.medium.bitManipulation;

/**
 * https://leetcode.com/problems/integer-replacement/description/
 * @author chandan
 *Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1

 */
public class IntegerReplacement {

  public static void main(String[] args) {
   int n=65535;
   System.out.println("result= "+integerReplacement(n));

  }
  
  public static int integerReplacement(int n) 
  {
    int steps=0;
    while(n!=1)
    {
      if(n%2==0)
      {
        n= n/2;
        steps++;
      }
      else // n is odd
      {
        if( (n & 3)==0)// n suffix is 11
        {
          if(n==3)//edge case for 11
          {
            steps= steps+2;
            n=1;
          }
          else
          {
            n++;
            steps++;
          }
        } 
        else//n suffix is 01
        {
          n--;
          steps++;
        }
      }     
    }//while loop ends
    System.out.println("n="+n+"  steps="+steps);
    return steps;
  }
}
