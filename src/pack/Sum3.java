package pack;
import java.util.*;


public class Sum3 {
	
	public static void main(String[] args) {
		Sum3 obj=new Sum3();
		int[] num={-1, 0, 1, 2, -1, -4};
		List l=obj.threeSum(num);
		System.out.println("obj.length"+l.size());

	}
	
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(num==null || num.length<3)
        return null;
        
        ArrayList<ArrayList<Integer>> l1=new ArrayList<ArrayList<Integer>>();
        int len=num.length;
        
        for(int i=0;i<len-2;i++)
        {
            for(int j=i+1;j<len-1;j++)
            {
                for(int k=j+1;k<len;k++)
                {
                    if(num[i] + num[j] + num[k]== 0)
                    {
                    	System.out.println("    num["+i+"]: "+num[i]+"    num["+j+"]: "+num[j]+"    num["+k+"]: "+num[k]);
                        ArrayList<Integer> temp=new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        Collections.sort(temp);
                        if(l1.contains(temp))
                        	System.out.println("above list already added");
                        else
                        l1.add(temp);
                    }
                }
            }
        }
        
        return l1;
    }
}