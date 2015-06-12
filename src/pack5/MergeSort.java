package pack5;

public class MergeSort {

	/**
	    program to sort a given array using mergeSort
	    
	 */
	public static void main(String[] args)
    {
        int[] arr = {3,2,1,4,5,6,7,1};
       
        mergeSort(arr);

        for(int x: arr)
            System.out.print("  "+x);

    }
   
    public static void mergeSort(int[] arr)
    {
        if(arr==null)
            return;
        tmpArr = new int[arr.length];
        //for(int i=0;i<arr.length;i++)
          //  tmpArr[i] = arr[i];
        mergeSortHelper(arr,0,arr.length-1);
       
    }

    static int[] tmpArr;
    private static void mergeSortHelper(int[] arr, int i, int j)
    {
        if(i>=j)
            return;
     /*   if(i+1 == j)
        {
        	System.out.println("i="+i+"   j="+j);
            if(arr[i] >arr[j])
                swapElements(arr,i,j);
        }
        else
        {
        
   */         int mid = (i+j)/2;
            System.out.println("mid="+mid);
            mergeSortHelper(arr,i,mid);
            mergeSortHelper(arr,mid+1,j);
            mergeElements(arr,i,mid,j);
    //   }
       
    }

    private static void mergeElements(int[] arr, int leftStart, int leftEnd, int rightEnd)  //uses temporary array as auxiliary space
    {
        int i = leftStart;
        int j = leftEnd+1;
        int tmpArrIndx = i;
        while(i<=leftEnd && j<=rightEnd)
        {
            if(arr[i] < arr[j])
            {
                tmpArr[tmpArrIndx]=arr[i];
                i++;
                tmpArrIndx++;
            }
            else if(arr[i] > arr[j])
            {
                tmpArr[tmpArrIndx]=arr[j];
                j++;
                tmpArrIndx++;
            }
            else
            { //arr[i]==arr[j]
            	
                tmpArr[tmpArrIndx]=arr[i];
                i++;tmpArrIndx++;
                tmpArr[tmpArrIndx]=arr[j];
                j++;tmpArrIndx++;
            }
        }
        while(i<=leftEnd)
        {
            tmpArr[tmpArrIndx++]=arr[i];
            i++;
        }
        while(j<=rightEnd)
        {
            tmpArr[tmpArrIndx++]=arr[j];
            j++;
        }
        
        for(int indx=leftStart; indx<=rightEnd; indx++)
        {
        	arr[indx] = tmpArr[indx];
        	//System.out.print("   arr["+indx+"]="+arr[indx]);
        }
        	System.out.println();
       
    }

    private static void swapElements(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }



}
