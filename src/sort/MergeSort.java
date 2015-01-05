package sort;

public class MergeSort {
	
	int[] arrayOfNumber;
	int[] tempArrayOfNumbers ;
	int length ;
	public void recursiveMergeSort(int lowPtr, int highPtr  ){
		if(lowPtr<highPtr){
		int mid = (lowPtr + (highPtr-lowPtr)/2);
		
		recursiveMergeSort(lowPtr, mid);
		
		recursiveMergeSort(mid+1, highPtr);
		
		merge(lowPtr,mid,highPtr);
		}
		}
	private void merge (int lowerBound, int middle,int upperBound){
		for(int i=lowerBound; i<=upperBound; i++){
			tempArrayOfNumbers[i] = arrayOfNumber[i];
		} 
		
		int i = lowerBound ;
		 int j = middle+1;
		 int k = lowerBound;
		 
		 
		 while(i<= middle && j<= upperBound){
			 if( tempArrayOfNumbers[i]<tempArrayOfNumbers[j] )
			 {
				 arrayOfNumber[k] = tempArrayOfNumbers[i];
				 i++;
			 }
			 else{
				 arrayOfNumber[k] = tempArrayOfNumbers[j];
				 j++;
			 }
			 k++;
		 }
		 while (i <= middle) {
	            arrayOfNumber[k] = tempArrayOfNumbers[i];
	            k++;
	            i++;
	        }
	}

	public static void main(String a[]){
        
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        MergeSort mms = new MergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }
     
    public void sort(int inputArr[]) {
        this.arrayOfNumber = inputArr;
        this.length = inputArr.length;
        this.tempArrayOfNumbers = new int[length];
        recursiveMergeSort(0, length - 1);
    }
 

}
