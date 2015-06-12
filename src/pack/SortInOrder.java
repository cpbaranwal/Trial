package pack;

public class SortInOrder {

	
public static void main(String[] args) {
	
	System.out.println("main");
	int arr[]={1,3,5,7,2,4,6,8};
	int n=arr.length/2;
	int k=1;
	for(int j=n;j<2*n;j++)
	{
		int temp=arr[j];
		
		System.out.println("temp=="+temp);
		for(int i=j;i>k;i--)
		{
			arr[i]=arr[i-1];
		}
		arr[k]=temp;
		k=k+2;
	}
	
	System.out.println();
	for(int x=0;x<2*n;x++)
	{
		System.out.print(arr[x]);
	}
	

	}

}
