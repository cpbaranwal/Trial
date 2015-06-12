package pack5;

public class MinmJumpsToReach {

    /**
        program to find minimum number of jumps needed from start to reach last index 'n'.
        here each jump at index i will be equal or less than value of arr[i].
        if not possible return -1.
        e.g.  int[] arr = {2,3,1,5,4,1,3};

     */
    public static void main(String[] args) {
       
        int[] arr = {3,1,1,5,4,1,3};
        int result = getMinNoJumps(arr);
        System.out.println("result== "+result);

    }
   
    /*
        approach:  the approach can be thought as
          min[i] = minimum no of jumps to reach i.
          iterate over index from j =0 to i and then check:
                  if j+arr[j] >= i   &&  min[i]> min[j]+1
                  then update min[i]
     */
   
    private static int getMinNoJumps(int[] arr)
    {
        int n =arr.length;
        int[] min = new int[n];
       
        min[0]=0;min[1]=1;
        for(int i=2; i<n; i++)
            min[i]=Integer.MAX_VALUE;
       
        for(int i=1; i<n; i++)

        {
            for(int j=0; j<i; j++)
            {
                if( (j+arr[j]) >=i   &&   min[i] > (min[j]+1)  )
                {
                    min[i] = min[j]+1;
                }
            }
        }
        for(int i=0; i<n; i++)
            System.out.print("   "+min[i]);
        System.out.println();
       
        return min[n-1];
    }

}