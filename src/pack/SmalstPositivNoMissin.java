package pack;

public class SmalstPositivNoMissin {

	/** Good program
	 *You are given an unsorted array with both positive and negative elements.
	 * You have to find the smallest positive number missing from the array in O(n) time
	 *  using constant extra space.
Eg:
Input = {2, 3, 7, 6, 8, -1, -10, 15}
Output = 1

Input = { 2, 3, -7, 6, 8, 1, -10, 15 }
Output = 4
	 */
	
	public static void main(String[] args) {


		int[] arr={2, 3, 7, 6, 8, -1, -10, 15};  //{ 2, 3, -7, 6, 8, 1, -10, 15 };		
		System.out.println("smallest +ve No:  "+getSmallestNo(arr));
	}
	public static int getSmallestNo(int[] a)
	{		if(a==null)
			return(-1);
		
		int i=0;
		int n=a.length;
		
		while(i<n)
		{
			if(a[i]==i+1)
				i++;
			else if(a[n-1]==n)
				n--;
			else if(a[i]<=0 || a[i]>n)
			{
				a[i]=a[n-1];
				n--;
			}
			else
			{
				int tmp=a[a[i]-1];
				a[a[i]-1]=a[i];
				a[i]=tmp;
			}
			System.out.println("length=="+n);
		}
		
		return i+1;
	}
	
}
