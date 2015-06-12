package pack;

public class MinJump {

	
	public static void main(String[] args) {
		System.out.println("in main");
		int arr[]={2,3,4,3,2,3,1,2,3,2,1,0};
		
		int len=arr.length;
		int cnt=0;
		int i=0;
		for( i=0;i<len-1;i++)
		{
			int k=i;
			for(int j=i;j<len && j<(i+arr[i]);j++)
			{
				if((arr[j]+j)>(arr[k]+k))
				{
					k=j;
				}
				i=k;
			}
			cnt++;
		}
		System.out.println("i=="+i);
		System.out.println("cnt=="+cnt);
		
		

	}

}
