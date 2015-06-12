package pack;

/*
   Given an integer swap
 */

public class SwapBits {

	
	public static void main(String[] args) 
	{
		int  num=28;   // 11100  -> 00111
		System.out.println("start");
		System.out.println("Number after swapping digits:  "+SwapBits.getSwappedNo(num,0,3,2));	
		
		System.out.println("end");		
	}
	
	public static int getSwappedNo(int num,int p1,int p2,int cnt)
	{
		int x=num;
		if(p1+cnt>=p2)
		{
			System.out.println("Number cant be changed,Wrong input");
		}
		else
		{
			int x1=num;int x2=num;
			for(int i=0;i<p1;i++){
				x1=x1/2;
			}
			for(int i=0;i<p2;i++){
				x2=x2/2;
			}
			while(cnt>0)
			{ if(x1%2!=x2%2)
				{
					if(x1%2==0)
					{
						x=x+(int)(Math.pow(2, p1));
						x=x-(int)(Math.pow(2, p2));
					}
					else
					{
						x=x+(int)(Math.pow(2, p2));
						x=x-(int)(Math.pow(2, p1));
					}
					
				}
				x1=x1/2;
				x2=x2/2;
				p1++;
				p2++;
				cnt--;
			}
		}
		
		return x;
	}

}
