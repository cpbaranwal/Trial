package pack;

public class findDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("main");
		int arr[]={3,5,2,1,0,4,6};
		System.out.println("arr=="+arr);	
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]);
		}
		System.out.println("");
		findDup(arr,0);
		System.out.println("arr=="+arr);	
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]);
		}
	}
	
	public static void findDup(int[] arr,int i){
		if(i>=arr.length)
			{System.out.println("no element as such");
			return;
			
			}
		
		if(i==arr[i])
			findDup(arr, i+1);
		else 
		{
			int temp1=arr[i];
			int temp2=arr[arr[i]];
			if(temp1==temp2)
			{
				System.out.println("repeatedno=="+temp1);
				return;
			}
			
			arr[arr[i]]=temp1;
			arr[i]=temp2;
			findDup(arr, i);
		}
		
		
	}

}
